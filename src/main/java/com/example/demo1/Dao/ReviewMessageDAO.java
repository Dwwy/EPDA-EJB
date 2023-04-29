package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.ReviewMessage;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ReviewMessageDAO extends GenericDAO<ReviewMessage> implements ReviewMessageDAOI{

    public ReviewMessageDAO(){
        super(ReviewMessage.class);
    }
    public boolean createReviewMessage(ReviewMessage review){
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }    }
    public boolean updateReviewMessage(ReviewMessage review){
        try {
            this.update(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteReviewMessage(ReviewMessage review){
        this.delete(review);
    }
    public List<ReviewMessage> getAllReviewMessage() {
        return this.findAll();
    }
    public ReviewMessage getReviewMessagebyId(String id) {
        return this.findById(id);
    }
    public List<ReviewMessage> getAllReviewMessagebyReviewId (String reviewId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("reviewId");
        query.setValue(reviewId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }
    public List<ReviewMessage> getAllReviewMessagebyMultipleReviewId (List<String> reviewId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("reviewId");
        query.setValue(reviewId);
        query.setWhereCondition(GenericQuery.Where.like);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
