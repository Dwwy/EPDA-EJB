package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Cart;

public class CartUpdate {
    private String cartId;
    private int quantity;
    private Double price;
    public Cart toCart(Cart cart){
        cart.setQuantity(quantity);
        cart.setPrice(price *  Double.valueOf(quantity));
        return cart;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
