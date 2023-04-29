package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Review;

import java.time.LocalDateTime;

public class ReviewUpdate {
    private String reviewId;
    private int score;
    private String title;
    private String description;

    public Review toReview(Review review){
        review.setScore(score);
        review.setTitle(title);
        review.setDescription(description);
        review.setLastUpdated(LocalDateTime.now());
        return review;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
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
}
