package com.example.demo1.Dao;

import com.example.demo1.Model.PriceHistory;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PriceHistoryDAO extends GenericDAO<PriceHistory> implements PriceHistoryDAOI{

    public PriceHistoryDAO(){
        super(PriceHistory.class);
    }
    public void createPriceHistory(PriceHistory priceHistory){
        this.create(priceHistory);
    }
    public boolean updatePriceHistory(PriceHistory priceHistory){
        try {
            this.update(priceHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deletePriceHistory(PriceHistory priceHistory){
        this.delete(priceHistory);
    }
    public List<PriceHistory> getAllPriceHistory() {
        return this.findAll();
    }
    public PriceHistory getPriceHistorybyId(String id) {
        return this.findById(id);
    }



}
