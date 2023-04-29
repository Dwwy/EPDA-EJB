package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Util.StaticVariable;

import java.time.LocalDateTime;

public class Cart_OrderUpdate {
    private String cartOrderId;
    private LocalDateTime acceptedDate;
    private LocalDateTime estimatedDeliveryDate;
    private LocalDateTime deliveredDate;
    private StaticVariable.orderStat status ;

    public Cart_Order toCartOrder (Cart_Order cart){
        cart.setAcceptedDate(acceptedDate);
        cart.setEstimatedDeliveryDate(estimatedDeliveryDate);
        cart.setDeliveredDate(deliveredDate);
        cart.setStatus(status);
        cart.setLastUpdated(LocalDateTime.now());
        return cart;
    }

    public String getCartOrderId() {
        return cartOrderId;
    }

    public void setCartOrderId(String cartOrderId) {
        this.cartOrderId = cartOrderId;
    }

    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public LocalDateTime getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(LocalDateTime deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public StaticVariable.orderStat getStatus() {
        return status;
    }

    public void setStatus(StaticVariable.orderStat status) {
        this.status = status;
    }
}
