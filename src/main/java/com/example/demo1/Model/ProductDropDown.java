package com.example.demo1.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class ProductDropDown implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String productId;
    private String name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight_g() {
        return weight_g;
    }

    public void setWeight_g(Double weight_g) {
        this.weight_g = weight_g;
    }

    public Double getLength_cm() {
        return length_cm;
    }

    public void setLength_cm(Double length_cm) {
        this.length_cm = length_cm;
    }

    public Double getHeight_cm() {
        return height_cm;
    }

    public void setHeight_cm(Double height_cm) {
        this.height_cm = height_cm;
    }

    public Double getWidth_cm() {
        return width_cm;
    }

    public void setWidth_cm(Double width_cm) {
        this.width_cm = width_cm;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
