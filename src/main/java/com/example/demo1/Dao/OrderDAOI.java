package com.example.demo1.Dao;

import com.example.demo1.Model.Order;

import javax.ejb.Local;
import java.util.List;
@Local
public interface OrderDAOI {
    Order createOrder(Order order);
    boolean updateOrder(Order cust);
    void deleteOrder(Order cust);
    List<Order> getAllOrder();
    Order getOrderbyId(String id);
    List<Order> getAllOrderbyCustomerId (String customerId);
}
