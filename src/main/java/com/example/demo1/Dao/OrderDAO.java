package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Order;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class OrderDAO extends GenericDAO<Order> implements OrderDAOI{

    public OrderDAO(){
        super(Order.class);
    }
    public Order createOrder(Order order){
        try{
            return this.create(order);
        }
        catch (Exception e){
            return null;
        }
    }
    public boolean updateOrder(Order order){
        try {
            this.update(order);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteOrder(Order order){
        this.delete(order);
    }
    public List<Order> getAllOrder() {
        return this.findAll();
    }
    public Order getOrderbyId(String id) {
        return this.findById(id);
    }
    public List<Order> getAllOrderbyCustomerId (String customerId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("customerId");
        query.setValue(customerId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
