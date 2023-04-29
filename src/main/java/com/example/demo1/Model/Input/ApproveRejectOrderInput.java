package com.example.demo1.Model.Input;


import com.example.demo1.Util.StaticVariable;

public class ApproveRejectOrderInput {
    private String sellerId;
    private String cartOrderId;
    private StaticVariable.orderStat status;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCartOrderId() {
        return cartOrderId;
    }

    public void setCartOrderId(String cartOrderId) {
        this.cartOrderId = cartOrderId;
    }

    public StaticVariable.orderStat getStatus() {
        return status;
    }

    public void setStatus(StaticVariable.orderStat status) {
        this.status = status;
    }
}
