package com.example.demo1.Dao;

import com.example.demo1.Model.WalletHistory;

import javax.ejb.Local;
import java.util.List;
@Local
public interface WalletHistoryDAOI {
    boolean createWalletHistory(WalletHistory WalletHistory);
    boolean updateWalletHistory(WalletHistory cust);
    void deleteWalletHistory(WalletHistory cust);
    WalletHistory getWalletHistorybyId(String id);
    List<WalletHistory> getWalletHistorybySellerId(String sellerId);
}
