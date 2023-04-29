package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Review;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ReviewDAO extends GenericDAO<Review> implements ReviewDAOI{

    public ReviewDAO(){
        super(Review.class);
    }
    public boolean createReview(Review review){
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }    }
    public boolean updateReview(Review review){
        try {
            this.update(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteReview(Review review){
        this.delete(review);
    }
    public List<Review> getAllReview() {
        return this.findAll();
    }
    public Review getReviewbyId(String id) {
        return this.findById(id);
    }
    public List<Review> getAllReviewbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
