package com.example.demo1.Model.Input;

import com.example.demo1.Model.Cart;
import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.ProductDropDown;

public class CartInput {
    private String cartId;
    private String customerId;
    private String orderId;
    private String productId;
    private int quantity;
    private Double price;
    public void setQuantity (int quantity, ProductDropDown dropDown){
        this.quantity = quantity;
        this.price = Double.valueOf(quantity* dropDown.getPrice());
    }
    public void setQuantity (int quantity){
        this.quantity = quantity;
    }
    public Cart toCart(){
        Cart cart = new Cart();
        cart.setCustomerId(customerId);
        cart.setProductId(productId);
        cart.setPrice(price *  Double.valueOf(quantity));
        cart.setQuantity(quantity);
        return cart;
    }
    public Cart_Order toCart_Order(){
        if (orderId == null){
            return null;
        }
        else {
            Cart_Order cartOrder = new Cart_Order();
            cartOrder.setOrderId(orderId);
            cartOrder.setCartId(cartId);
            cartOrder.setPrice(price * Double.valueOf(quantity));
            return cartOrder;
        }
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
