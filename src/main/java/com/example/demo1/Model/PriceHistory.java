package com.example.demo1.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class PriceHistory implements Serializable{
    @Id
    @GeneratedValue
    private String id;
    private String productDropDownId;
    private LocalDateTime creationDate = LocalDateTime.now();
    private Double price;
    private boolean isActive;
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

    public String getProductDropDownId() {
        return productDropDownId;
    }

    public void setProductDropDownId(String productDropDownId) {
        this.productDropDownId = productDropDownId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
