package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Util.ConfigureDataSource;
import com.example.demo1.Util.StaticVariable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;


import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDAO<T> {

//    protected EntityManagerFactory emf = ConfigureDataSource.getEntityManager();
    protected ThreadLocal<EntityManager> emt;

    protected EntityManager em = ConfigureDataSource.getEntityManager().createEntityManager();
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    public GenericDAO(){

    }
    public T create(T entity) {
        preMethodHook();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        postMethodHook();
        Field field = null;
        try {
            field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true); // to access private fields
            Object value = field.get(entity);
            return findById(value);
        } catch (NoSuchFieldException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public T update(T entity) {
        preMethodHook();
        em.getTransaction().begin();
        T mergedEntity = em.merge(entity);
        em.getTransaction().commit();
        postMethodHook();
        return mergedEntity;
    }
    public boolean bulkUpdate (List<T> entities, String field, Object value){
        preMethodHook();
        try {
            em.getTransaction().begin();
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaUpdate<T> update = criteriaBuilder.createCriteriaUpdate(entityClass);
            Root<T> root = update.from(entityClass);
            update.set(root.get(field), value);
            em.createQuery(update).executeUpdate();
            em.getTransaction().commit();
            postMethodHook();
            return true;
        }
        catch (Exception e){
            em.getTransaction().rollback();
            postMethodHook();
            return false;
        }
    }

    public void delete(T entity) {
        preMethodHook();
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        postMethodHook();
    }

    public T findById(Object id) {
        preMethodHook();
        T result = em.find(entityClass, id);
        postMethodHook();
        return result;
    }

    public List<T> findAll() {
        preMethodHook();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        CriteriaQuery<T> all = cq.select(rootEntry);
        List<T> resultlist = em.createQuery(all).getResultList();
        postMethodHook();
        return resultlist;
    }
    public List<T> findListByWhereCondition (List<GenericQuery> query, StaticVariable.Condition condition){
        preMethodHook();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> rootEntry = cq.from(entityClass);
        List<Predicate> predicateList = new ArrayList<>();
        query.forEach(x->{
            switch (x.getWhereCondition()){
                case id: {
                    predicateList.add(rootEntry.get("id").in(x.getValue()));
                    break;
                }
                case like: {
                    predicateList.add(cb.like(rootEntry.get(x.getWhereColumn()),x.getValue().toString()));
                    break;
                }
                case equal:{
                    predicateList.add(cb.equal(rootEntry.get(x.getWhereColumn()),x.getValue()));
                    break;
                }
                case between:{
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.between(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString()),
                                    sdf.parse(x.getValue2().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.between(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString()),
                                Integer.parseInt(x.getValue2().toString())));
                    }
                    break;
                }
                case lesserOrEqual: {
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.lessThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.lessThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString())));
                    }
                    break;
                }
                case greaterOrEqual:{
                    if (x.getType() == GenericQuery.type.timestamp){
                        String dateFormat = "yyyy-MM-dd HH:mm:ss"; // the format of the date string in the object
                        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                        try {
                            predicateList.add(cb.greaterThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                    sdf.parse(x.getValue().toString())));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    if (x.getType() == GenericQuery.type.integer){
                        predicateList.add(cb.greaterThanOrEqualTo(rootEntry.get(x.getWhereColumn()),
                                Integer.parseInt(x.getValue().toString())));
                    }
                    break;
                }
            }

        });
        if (predicateList.size() == 1){
            cq.where(predicateList.get(0));
            List<T> resultlist = em.createQuery(cq).getResultList();
            postMethodHook();
            return resultlist;
        }
        Predicate predicate;
        if (condition == StaticVariable.Condition.or){
            predicate = cb.or(predicateList.toArray(new Predicate[0]));
        }
        else {
            predicate = cb.and(predicateList.toArray(new Predicate[0]));
        }
        cq.where(predicate);
        List<T> resultlist = em.createQuery(cq).getResultList();
        postMethodHook();
        return resultlist;

    }
    protected void postMethodHook() {
//        if (em != null && em.isOpen()) {
//            em.close();
//        }
    }
    protected void preMethodHook(){
//        em = ConfigureDataSource.getEntityManager().createEntityManager();
    }
}