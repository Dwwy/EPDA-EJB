package com.example.demo1.Dao;

import com.example.demo1.Model.PriceHistory;

import javax.ejb.Local;
import java.util.List;
@Local
public interface PriceHistoryDAOI {
    void createPriceHistory(PriceHistory priceHistory);
    boolean updatePriceHistory(PriceHistory priceHistory);
    void deletePriceHistory(PriceHistory priceHistory);
    List<PriceHistory> getAllPriceHistory();
    PriceHistory getPriceHistorybyId(String id);
}
