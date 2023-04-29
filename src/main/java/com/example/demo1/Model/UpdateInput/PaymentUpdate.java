package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Payment;
import com.example.demo1.Util.StaticVariable;

import java.time.LocalDateTime;

public class PaymentUpdate {
    private String paymentId;
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    public Payment toPayment(Payment payment){
        payment.setPaymentType(paymentType);
        payment.setStatus(status);
        payment.setPrice(Price);
        payment.setLastUpdated(LocalDateTime.now());
        return payment;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public StaticVariable.Payment_Type getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(StaticVariable.Payment_Type paymentType) {
        this.paymentType = paymentType;
    }

    public StaticVariable.Payment_Status getStatus() {
        return status;
    }

    public void setStatus(StaticVariable.Payment_Status status) {
        this.status = status;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
