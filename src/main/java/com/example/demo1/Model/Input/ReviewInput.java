package com.example.demo1.Model.Input;


import com.example.demo1.Model.Review;

import java.time.LocalDateTime;

public class ReviewInput {
    private int score;
    private String title;
    private String description;
    private String productId;
    private String userId;
    public Review toReview(){
        Review review = new Review();
        review.setScore(score);
        review.setDescription(description);
        review.setTitle(title);
        review.setUserId(userId);
        review.setProductId(productId);
        review.setLastUpdated(LocalDateTime.now());
        return review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
