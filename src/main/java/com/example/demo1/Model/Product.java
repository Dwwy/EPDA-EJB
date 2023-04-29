package com.example.demo1.Model;

import com.example.demo1.Util.StaticVariable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(schema = "User")
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private String id;
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    @Column(length = 32600)
    private String description;
    private String imageURL;
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

    public String getSellerId() {
        return SellerId;
    }

    public void setSellerId(String sellerId) {
        SellerId = sellerId;
    }

    public StaticVariable.prodCat getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(StaticVariable.prodCat productCategory) {
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
