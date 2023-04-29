package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Seller;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class SellerDAO extends GenericDAO<Seller> implements SellerDAOI{

    public SellerDAO(){
        super(Seller.class);
    }
    public boolean createSeller(Seller seller){
        try {
            this.create(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateSeller(Seller seller){
        try {
            this.update(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteSeller(Seller seller){
        this.delete(seller);
    }
    public List<Seller> getAllSeller() {
        return this.findAll();
    }
    public Seller getSellerbyId(String id) {
        return this.findById(id);
    }

    public Seller getSellerbyUserID(String id){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(id);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<Seller> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }
    }

}
