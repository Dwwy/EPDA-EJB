package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Product;
import com.example.demo1.Util.StaticVariable;

import java.io.InputStream;

public class ProductUpdate {
    private String productId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private InputStream productImg;

    public Product toProduct(Product product){
        product.setProductCategory(productCategory);
        product.setDescription(description);
        product.setName(name);
        product.setImageURL(imageURL);
        return product;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public InputStream getProductImg() {
        return productImg;
    }

    public void setProductImg(InputStream productImg) {
        this.productImg = productImg;
    }
}
