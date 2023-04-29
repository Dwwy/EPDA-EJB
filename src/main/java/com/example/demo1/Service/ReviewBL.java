package com.example.demo1.Service;

import com.example.demo1.Dao.ReviewDAOI;
import com.example.demo1.Dao.ReviewMessageDAOI;
import com.example.demo1.Model.Input.ReviewInput;
import com.example.demo1.Model.Input.ReviewMessageInput;
import com.example.demo1.Model.Review;
import com.example.demo1.Model.ReviewMessage;
import com.example.demo1.Model.UpdateInput.ReviewMessageUpdate;
import com.example.demo1.Model.UpdateInput.ReviewUpdate;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ReviewBL implements ReviewBLI{
    @EJB
    ReviewDAOI reviewDAO;
    @EJB
    ReviewMessageDAOI reviewMessageDAO;
    public Response createReview (ReviewInput input){
        if (reviewDAO.createReview(input.toReview())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating review");
        }
    }
    public Response updateReview(ReviewUpdate input){
        Review review = reviewDAO.getReviewbyId(input.getReviewId());
        if (review == null){
            return new Response(false, "Review not found");
        }
        else {
            reviewDAO.updateReview(input.toReview(review));
            return new Response(true);
        }
    }
    public Response getReviewsByProductId (String productId){
        return new Response(reviewDAO.getAllReviewbyProductId(productId));
    }
    public Response createReviewMessage (ReviewMessageInput input) {
        if (reviewMessageDAO.createReviewMessage(input.toReviewMessage())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating review message");
        }
    }
    public Response updateReviewMessage(ReviewMessageUpdate input){
        ReviewMessage review = reviewMessageDAO.getReviewMessagebyId(input.getReviewMessageId());
        if (review == null){
            return new Response(false, "Review message not found");
        }
        else {
            reviewMessageDAO.updateReviewMessage(input.toReviewMessage(review));
            return new Response(true);
        }
    }
}
