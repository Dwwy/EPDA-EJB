package com.example.demo1.Model.Input;

import com.example.demo1.Model.WalletHistory;

public class WalletHistoryInput {
    private Double amount;
    private String sellerId;
    public WalletHistory toWalletHistory (){
        WalletHistory walletHistory = new WalletHistory();
        walletHistory.setAmount(amount);
        walletHistory.setSellerId(sellerId);
        return walletHistory;
    }
    public WalletHistoryInput (Double amount, String sellerId){
        this.amount = amount;
        this.sellerId = sellerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }
}
