package com.example.demo1.Dao;

import com.example.demo1.Model.Cart;
import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class CartDAO extends GenericDAO<Cart> implements CartDAOI{

    private EntityManagerFactory emf;
    public CartDAO(){
        super(Cart.class);
    }
    public boolean createCart(Cart cart){
        try{
            this.create(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCart(Cart cart){
        try {
            this.update(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCart(Cart cart){
        this.delete(cart);
    }
    public List<Cart> getAllCart() {
        return this.findAll();
    }
    public Cart getCartbyId(String id) {
        return this.findById(id);
    }
    public List<Cart> getAllCartbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }

}
