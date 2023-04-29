package com.example.demo1.Model.Output;

import com.example.demo1.Model.Product;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Util.StaticVariable;

import java.util.ArrayList;
import java.util.List;

public class ProductListOutput {
    private String id;
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private Double price;
    private List<ProductDropDown> productDropDowns;
    public ProductListOutput(Product product, List<ProductDropDown> productDropDowns, Double price){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = productDropDowns;
    }
    public ProductListOutput(Product product, ProductDropDown productDropDown, Double price){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = new ArrayList<ProductDropDown>(){{add(productDropDown);}};
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ProductDropDown> getProductDropDowns() {
        return productDropDowns;
    }

    public void setProductDropDowns(List<ProductDropDown> productDropDowns) {
        this.productDropDowns = productDropDowns;
    }
}
