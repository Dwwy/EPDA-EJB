package com.example.demo1.Model.Input;

import com.example.demo1.Dao.CartDAOI;
import com.example.demo1.Model.Cart;
import com.example.demo1.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderInput {
    private List<String> cartId;
    private String customerId;
    public Order toOrder(Double freight){
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setFreightCost(freight);
        return order;
    }
    public List<CartInput> toCartOrder(String orderId, CartDAOI cartDAO){
        List<CartInput> input = new ArrayList<>();
        cartId.forEach(x->{
            Cart cart = cartDAO.getCartbyId(x);
            input.add(new CartInput(){{
                setOrderId(orderId);
                setPrice(cart.getPrice());
                setQuantity(cart.getQuantity());
                setCustomerId(cart.getCustomerId());
                setProductId(cart.getProductId());
                setCartId(cart.getId());
            }});
        });
        return input;
    }

    public List<String> getCartId() {
        return cartId;
    }

    public void setCartId(List<String> cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
