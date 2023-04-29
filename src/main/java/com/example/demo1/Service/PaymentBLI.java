package com.example.demo1.Service;

import com.example.demo1.Model.Input.PaymentInput;
import com.example.demo1.Model.UpdateInput.PaymentUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface PaymentBLI {
    Response createPayment(PaymentInput input);
    Response makePayment(PaymentUpdate update);
}
