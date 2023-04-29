package com.example.demo1.Model.Input;

import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.Order;
import com.example.demo1.Model.Payment;
import com.example.demo1.Util.StaticVariable;

import java.util.List;

public class PaymentInput {
    private StaticVariable.Payment_Type paymentType;
    private StaticVariable.Payment_Status status;
    private Double Price;
    private String orderId;
    public Payment toPayment(){
        Payment payment = new Payment();
        payment.setPaymentType(paymentType);
        payment.setStatus(status);
        payment.setPrice(Price);
        payment.setOrderId(orderId);
        return payment;
    }
    public PaymentInput (List<Cart_Order> cartOrders, Order order, StaticVariable.Payment_Type paymentType, StaticVariable.Payment_Status status){
        this.Price = cartOrders
                .stream()
                .map(Cart_Order::getPrice)
                .mapToDouble(Double::doubleValue)
                .sum() + order.getFreightCost();
        this.orderId = order.getId();
        this.paymentType = paymentType;
        this.status = status;
    }
    public PaymentInput(){}

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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
