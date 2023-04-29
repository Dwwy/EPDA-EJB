package com.example.demo1.Model.Output;


import com.example.demo1.Model.Order;
import com.example.demo1.Model.Payment;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderOutput {
    private String orderId;
    public String sellerId;
    private String customerId;
    private String creationDate;
    private Double freightCost;
    private List<Cart_OrderOutput> items;
    private Payment payment;
    public OrderOutput (Order order, Payment payment, List<Cart_OrderOutput> items){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.orderId = order.getId();
        this.customerId = order.getCustomerId();
        this.creationDate = formatter.format(order.getCreationDate());
        this.items = items;
        this.payment = payment;
        this.freightCost = order.getFreightCost();
        this.sellerId = null;
    }
    public OrderOutput (Order order, Payment payment, List<Cart_OrderOutput> items, String sellerId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.orderId = order.getId();
        this.customerId = order.getCustomerId();
        this.creationDate = formatter.format(order.getCreationDate());
        this.items = items;
        this.payment = payment;
        this.sellerId = sellerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(Double freightCost) {
        this.freightCost = freightCost;
    }

    public List<Cart_OrderOutput> getItems() {
        return items;
    }

    public void setItems(List<Cart_OrderOutput> items) {
        this.items = items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
