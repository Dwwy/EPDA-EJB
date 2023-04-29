package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.ReviewMessage;

import java.time.LocalDateTime;

public class ReviewMessageUpdate {
    private String reviewMessageId;
    private String message;
    public ReviewMessage toReviewMessage(ReviewMessage review){
        review.setMessage(message);
        review.setLastUpdated(LocalDateTime.now());
        review.setUpdated(true);
        return review;
    }

    public String getReviewMessageId() {
        return reviewMessageId;
    }

    public void setReviewMessageId(String reviewMessageId) {
        this.reviewMessageId = reviewMessageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
