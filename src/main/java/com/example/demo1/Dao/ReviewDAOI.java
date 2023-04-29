package com.example.demo1.Dao;

import com.example.demo1.Model.Review;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ReviewDAOI {
    boolean createReview(Review review);
    boolean updateReview(Review review);
    void deleteReview(Review review);
    List<Review> getAllReview();
    Review getReviewbyId(String id);
    List<Review> getAllReviewbyProductId (String productId);
}
