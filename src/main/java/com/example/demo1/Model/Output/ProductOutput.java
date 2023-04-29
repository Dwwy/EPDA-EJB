package com.example.demo1.Model.Output;

import com.example.demo1.Model.Product;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Model.Review;
import com.example.demo1.Model.ReviewMessage;
import com.example.demo1.Util.StaticVariable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductOutput {
    private String id;
    private String SellerId;
    private StaticVariable.prodCat productCategory;
    private String name;
    private String description;
    private String imageURL;
    private Double price;
    private List<ProductDropDown> productDropDowns;
    private List<ReviewOutput> reviews;
    public ProductOutput(Product product, List<ProductDropDown> productDropDowns, Double price, List<Review> reviews, List<ReviewMessage> messages){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = productDropDowns;
        this.reviews = reviews.stream().map(x-> {
            List<ReviewMessage> messages1 = new ArrayList<>();
            messages.forEach(y->{
                if (y.getReviewId().equals(x.getProductId())){
                    messages1.add(y);
                    messages.remove(y);
                }
            });
            return new ReviewOutput(x,messages1);
        }).collect(Collectors.toList());
        this.reviews.sort(Comparator.comparing(ReviewOutput::getCreationDate));
    }
    public ProductOutput(Product product, ProductDropDown productDropDown, Double price, List<Review> reviews, List<ReviewMessage> messages){
        this.id = product.getId();
        this.SellerId = product.getSellerId();
        this.productCategory = product.getProductCategory();
        this.name = product.getName();
        this.description = product.getDescription();
        this.imageURL = product.getImageURL();
        this.price = price;
        this.productDropDowns = new ArrayList<ProductDropDown>(){{add(productDropDown);}};
        this.reviews = reviews.stream().map(x-> {
            List<ReviewMessage> messages1 = new ArrayList<>();
            messages.forEach(y->{
                if (y.getReviewId().equals(x.getProductId())){
                    messages1.add(y);
                    messages.remove(y);
                }
            });
            return new ReviewOutput(x,messages1);
        }).collect(Collectors.toList());
        this.reviews.sort(Comparator.comparing(ReviewOutput::getCreationDate));
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

    public List<ReviewOutput> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewOutput> reviews) {
        this.reviews = reviews;
    }
}
