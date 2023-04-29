package com.example.demo1.Dao;
import com.example.demo1.Model.ReviewMessage;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ReviewMessageDAOI {
    boolean createReviewMessage(ReviewMessage review);
    boolean updateReviewMessage(ReviewMessage review);
    void deleteReviewMessage(ReviewMessage review);
    List<ReviewMessage> getAllReviewMessage();
    ReviewMessage getReviewMessagebyId(String id);
    List<ReviewMessage> getAllReviewMessagebyReviewId (String reviewId);
    List<ReviewMessage> getAllReviewMessagebyMultipleReviewId (List<String> reviewId);
}
