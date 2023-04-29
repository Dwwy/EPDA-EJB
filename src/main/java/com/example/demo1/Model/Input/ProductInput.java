package com.example.demo1.Model.Input;


import com.example.demo1.Model.Product;
import com.example.demo1.Util.StaticVariable;

import java.io.InputStream;

public class ProductInput {
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private InputStream productImg;
    private String subCategory_name;
    private Double weight_g;
    private Double length_cm;
    private Double height_cm;
    private Double width_cm;
    private Double price;
    public Product toProduct(){
        Product product = new Product();
        product.setSellerId(SellerId);
        product.setProductCategory(productCategory);
        product.setName(name);
        product.setImageURL(imageURL);
        product.setDescription(description);
        return product;
    }
    public ProductDropDownInput toProductDropDownInput(String productId){
        ProductDropDownInput input = new ProductDropDownInput();
        input.setProductId(productId);
        input.setWeight_g(weight_g);
        input.setHeight_cm(height_cm);
        input.setWidth_cm(width_cm);
        input.setLength_cm(length_cm);
        input.setName(subCategory_name);
        input.setPrice(price);
        return input;
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

    public InputStream getProductImg() {
        return productImg;
    }

    public void setProductImg(InputStream productImg) {
        this.productImg = productImg;
    }

    public String getSubCategory_name() {
        return subCategory_name;
    }

    public void setSubCategory_name(String subCategory_name) {
        this.subCategory_name = subCategory_name;
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
