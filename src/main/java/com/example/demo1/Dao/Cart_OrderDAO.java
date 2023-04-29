package com.example.demo1.Dao;

import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class Cart_OrderDAO extends GenericDAO<Cart_Order> implements Cart_OrderDAOI{

    public Cart_OrderDAO(){
        super(Cart_Order.class);
    }

    public boolean createCart_Order(Cart_Order cartOrder){
        try{
            this.create(cartOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCart_Order(Cart_Order cartOrder){
        try {
            this.update(cartOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCart_Order(Cart_Order cartOrder){
        this.delete(cartOrder);
    }
    public List<Cart_Order> getAllCart_Order() {
        return this.findAll();
    }
    public Cart_Order getCart_OrderbyId(String id) {
        return this.findById(id);
    }
    public List<Cart_Order> getAllCartOrderbyOrderId (String orderId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("orderId");
        query.setValue(orderId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public List<Cart_Order> getAllCartOrderbyCartId (String cartId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("cartId");
        query.setValue(cartId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public boolean updateCartOrdersStatus (List<Cart_Order> update, StaticVariable.orderStat status){
        return this.bulkUpdate(update, "status", status);
    }

}
