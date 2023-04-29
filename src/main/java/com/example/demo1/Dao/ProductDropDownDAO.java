package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductDropDownDAO extends GenericDAO<ProductDropDown> implements ProductDropDownDAOI{

    public ProductDropDownDAO(){
        super(ProductDropDown.class);
    }
    public ProductDropDown createProductDropDown(ProductDropDown productDropDown){
        try {
            return this.create(productDropDown);
        }
        catch (Exception e){
            return null;
        }
    }
    public boolean updateProductDropDown(ProductDropDown productDropDown){
        try {
            this.update(productDropDown);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteProductDropDown(ProductDropDown productDropDown){
        this.delete(productDropDown);
    }
    public List<ProductDropDown> getAllProductDropDown() {
        return this.findAll();
    }
    public ProductDropDown getProductDropDownbyId(String id) {
        return this.findById(id);
    }
    public List<ProductDropDown> getAllProductDropDownbyProductId (String productId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("productId");
        query.setValue(productId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and);
    }


}
