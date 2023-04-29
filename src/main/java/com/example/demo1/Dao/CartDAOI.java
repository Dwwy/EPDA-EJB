package com.example.demo1.Dao;

import com.example.demo1.Model.Cart;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CartDAOI {
    boolean createCart(Cart cart);
    boolean updateCart(Cart cart);
    void deleteCart(Cart cart);
    List<Cart> getAllCart();
    Cart getCartbyId(String id);
    List<Cart> getAllCartbyProductId (String productId);
}
