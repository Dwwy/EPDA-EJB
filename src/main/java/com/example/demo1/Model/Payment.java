package com.example.demo1.Model;

import com.example.demo1.Util.StaticVariable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class Payment implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String orderId;
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    private LocalDateTime lastUpdated ;
    public Payment (){
        lastUpdated = LocalDateTime.now();
    }
    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public StaticVariable.Payment_Type getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(StaticVariable.Payment_Type paymentType) {
        this.paymentType = paymentType;
    }

    public StaticVariable.Payment_Status getStatus() {
        return status;
    }

    public void setStatus(StaticVariable.Payment_Status status) {
        this.status = status;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
