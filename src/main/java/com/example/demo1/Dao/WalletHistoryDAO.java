package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.WalletHistory;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class WalletHistoryDAO extends GenericDAO<WalletHistory> implements WalletHistoryDAOI{

    public WalletHistoryDAO(){
        super(WalletHistory.class);
    }
    public boolean createWalletHistory(WalletHistory walletHistory){
        try {
            this.create(walletHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateWalletHistory(WalletHistory walletHistory){
        try {
            this.update(walletHistory);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteWalletHistory(WalletHistory walletHistory){
        this.delete(walletHistory);
    }
    public WalletHistory getWalletHistorybyId(String id) {
        return this.findById(id);
    }
    public List<WalletHistory> getWalletHistorybySellerId(String sellerId){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("sellerId");
        query.setValue(sellerId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<WalletHistory> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output;
        }
    }

}
