package com.example.demo1.Service;

import com.example.demo1.Model.Input.ReviewInput;
import com.example.demo1.Model.Input.ReviewMessageInput;
import com.example.demo1.Model.UpdateInput.ReviewMessageUpdate;
import com.example.demo1.Model.UpdateInput.ReviewUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface ReviewBLI {
    Response createReview (ReviewInput input);
    Response updateReview(ReviewUpdate input);
    Response getReviewsByProductId (String productId);
    Response createReviewMessage (ReviewMessageInput input);
    Response updateReviewMessage(ReviewMessageUpdate input);
}
