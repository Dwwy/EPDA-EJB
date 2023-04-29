package com.example.demo1.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class Cart implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String productId;
    private String customerId;
    private int quantity;
    private Double price;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
