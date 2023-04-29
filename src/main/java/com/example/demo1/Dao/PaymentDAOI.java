package com.example.demo1.Dao;

import com.example.demo1.Model.Payment;

import javax.ejb.Local;
import java.util.List;
@Local
public interface PaymentDAOI {
    Payment createPayment(Payment payment);
    boolean updatePayment(Payment payment);
    void deletePayment(Payment payment);
    List<Payment> getAllPayment();
    Payment getPaymentbyId(String id);
    Payment getPaymentbyOrderId (String orderId);
}
