package com.example.demo1.Model.UpdateInput;


import com.example.demo1.Model.Order;

public class OrderUpdate {
    private String orderId;
    private Double freightCost;

    public Order toOrder(Order order){
        order.setFreightCost(freightCost);
        return order;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(Double freightCost) {
        this.freightCost = freightCost;
    }
}
