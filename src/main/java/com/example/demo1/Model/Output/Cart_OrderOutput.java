package com.example.demo1.Model.Output;


import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.Product;

import java.time.format.DateTimeFormatter;

public class Cart_OrderOutput {
    private String id;
    private Product product;
    private Double price;
    private String status;
    private String acceptedDate;
    private String estimatedDeliveryDate;
    private String deliveredDate;
    private String lastUpdated;

    public Cart_OrderOutput (Cart_Order input, Product product) {
        this.id = input.getId();
        this.product = product;
        this.price = input.getPrice();
        this.status = input.getStatus().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        if (input.getAcceptedDate() != null){
            this.acceptedDate = formatter.format(input.getAcceptedDate());
        }
        if (input.getEstimatedDeliveryDate() != null){
            this.estimatedDeliveryDate = formatter.format(input.getEstimatedDeliveryDate());
        }
        if (input.getDeliveredDate() != null) {
            this.deliveredDate = formatter.format(input.getDeliveredDate());
        }
        this.lastUpdated = formatter.format(input.getLastUpdated());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptedDate() {
        return acceptedDate;
    }

    public void setAcceptedDate(String acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
