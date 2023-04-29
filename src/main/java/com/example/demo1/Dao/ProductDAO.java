package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Product;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductDAO extends GenericDAO<Product> implements ProductDAOI{

    public ProductDAO(){
        super(Product.class);
    }
    public Product createProduct(Product product){
        try {
            Product product1 = this.create(product);
            return product1;
        }
        catch (Exception e){
            return null;
        }
    }
    public boolean updateProduct(Product product){
        try {
            this.update(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteProduct(Product product){
        this.delete(product);
    }
    public List<Product> getAllProduct() {
        return this.findAll();
    }
    public Product getProductbyId(String id) {
        return this.findById(id);
    }
//    public List<Product> getAllProductbyId (List<String> id) {
//        List<GenericQuery> queries = new ArrayList<>();
//        GenericQuery query = new GenericQuery();
//        query.setWhereColumn("id");
//        query.setValue(id);
//        query.setWhereCondition(GenericQuery.Where.id);
//        queries.add(query);
//        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
//    }
    public List<Product> searchProductbyName(String name){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("name");
        query.setValue("%" + name + "%");
        query.setWhereCondition(GenericQuery.Where.like);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public List<Product> searchProductbySellerId (String sellerId){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("SellerId");
        query.setValue(sellerId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
