package com.example.demo1.Dao;

import com.example.demo1.Model.Customer;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CustomerDAOI {
    boolean createCustomer(Customer cust);
    boolean updateCustomer(Customer cust);
    void deleteCustomer(Customer cust);
    List<Customer> getAllCustomers();
    Customer getCustomerbyId(String id);
    Customer getCustomerbyUserID(String id);
}
