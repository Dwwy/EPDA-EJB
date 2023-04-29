package com.example.demo1.Service;

import com.example.demo1.Dao.CartDAOI;
import com.example.demo1.Dao.Cart_OrderDAOI;
import com.example.demo1.Model.Cart;
import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.Input.CartInput;
import com.example.demo1.Model.UpdateInput.CartUpdate;
import com.example.demo1.Model.UpdateInput.Cart_OrderUpdate;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CartBL implements  CartBLI{
    @EJB
    CartDAOI cartDAO;
    @EJB
    Cart_OrderDAOI cartOrderDAO;
    public Response createCart(CartInput input){
        if (cartDAO.createCart(input.toCart())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating cart");
        }
    }
    public List<Cart_Order> getCartOrdersbyOrderId (String orderId){
        return cartOrderDAO.getAllCartOrderbyOrderId(orderId);
    }
    public Response createCartOrder(Cart_Order input){
        if (cartOrderDAO.createCart_Order(input)){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating cart");
        }
    }
    public Response updateCart(CartUpdate input){
        Cart cart = cartDAO.getCartbyId(input.getCartId());
        if (cart == null){
            return new Response(false, "Cart not found");
        }
        else {
            cartDAO.updateCart(input.toCart(cart));
            return new Response(true);
        }
    }
    public Response updateCartOrder(Cart_OrderUpdate input){
        Cart_Order cart = cartOrderDAO.getCart_OrderbyId(input.getCartOrderId());
        if (cart == null){
            return new Response(false, "Cart Order not found");
        }
        else {
            cartOrderDAO.updateCart_Order(input.toCartOrder(cart));
            return new Response(true);
        }
    }
}
