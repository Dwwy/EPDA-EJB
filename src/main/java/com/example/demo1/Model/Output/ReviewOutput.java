package com.example.demo1.Model.Output;


import com.example.demo1.Model.Review;
import com.example.demo1.Model.ReviewMessage;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewOutput {
    private String id;
    private String productId;
    private String userId;
    private int score;
    private String title;
    private String description;
    private LocalDateTime lastUpdated ;
    private LocalDateTime creationDate;
    private List<ReviewMessageOutput> messages;

    public ReviewOutput (Review review, List<ReviewMessage> messages){
        this.id = review.getId();
        this.productId = review.getProductId();
        this.userId = review.getUserId();
        this.score = review.getScore();
        this.title = review.getTitle();
        this.description = review.getDescription();
        this.lastUpdated = review.getLastUpdated();
        this.creationDate = review.getCreationDate();
        this.messages = messages.stream().map(x-> {
            ReviewMessageOutput output = new ReviewMessageOutput();
            output.setReviewId(x.getReviewId());
            output.setId(x.getId());
            output.setCreationDate(x.getCreationDate());
            output.setMessage(x.getMessage());
            output.setUpdated(x.isUpdated());
            output.setLastUpdated(x.getLastUpdated());
            output.setUserId(x.getUserId());
            return output;
        }).collect(Collectors.toList());
        this.messages.sort(Comparator.comparing(ReviewMessageOutput::getCreationDate));
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<ReviewMessageOutput> getMessages() {
        return messages;
    }

    public void setMessages(List<ReviewMessageOutput> messages) {
        this.messages = messages;
    }
}
