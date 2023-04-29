package com.example.demo1.Model.Input;


import com.example.demo1.Model.PriceHistory;

public class PriceHistoryInput {
    private String productDropDownId;
    private Double price;
    private boolean isActive;
    public PriceHistory toPriceHistory(){
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setProductDropDownId(productDropDownId);
        priceHistory.setPrice(price);
        priceHistory.setActive(isActive);
        return priceHistory;
    }

    public String getProductDropDownId() {
        return productDropDownId;
    }

    public void setProductDropDownId(String productDropDownId) {
        this.productDropDownId = productDropDownId;
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
