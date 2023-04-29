package com.example.demo1.Model.Input;


import com.example.demo1.Model.ReviewMessage;

import java.time.LocalDateTime;

public class ReviewMessageInput {
    private String reviewMessageId;
    private String reviewId;
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private String userId;
    private String message;

    public ReviewMessage toReviewMessage (){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setReviewId(reviewId);
        reviewMessage.setMessage(message);
        reviewMessage.setUserId(userId);
        reviewMessage.setUpdated(false);
        reviewMessage.setLastUpdated(lastUpdated);
        return reviewMessage;
    }

    public String getReviewMessageId() {
        return reviewMessageId;
    }

    public void setReviewMessageId(String reviewMessageId) {
        this.reviewMessageId = reviewMessageId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
