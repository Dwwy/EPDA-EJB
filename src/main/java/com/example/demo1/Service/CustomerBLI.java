package com.example.demo1.Service;

import com.example.demo1.Model.Input.CustomerInput;
import com.example.demo1.Model.Output.CustomerProfile;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface CustomerBLI {
    Response register(CustomerInput input);
    CustomerProfile getCustomerProfilebyCustomerId(String customerId);
    CustomerProfile getCustomerProfilebyUserId(String id);
}
