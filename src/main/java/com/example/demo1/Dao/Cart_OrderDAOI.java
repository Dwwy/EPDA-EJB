package com.example.demo1.Dao;


import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Local;
import java.util.List;
@Local
public interface Cart_OrderDAOI {
    boolean createCart_Order(Cart_Order cartOrder);
    boolean updateCart_Order(Cart_Order cartOrder);
    void deleteCart_Order(Cart_Order cartOrder);
    List<Cart_Order> getAllCart_Order();
    Cart_Order getCart_OrderbyId(String id);
    List<Cart_Order> getAllCartOrderbyOrderId (String orderId);
    List<Cart_Order> getAllCartOrderbyCartId (String cartId);
    boolean updateCartOrdersStatus (List<Cart_Order> update, StaticVariable.orderStat status);
}
