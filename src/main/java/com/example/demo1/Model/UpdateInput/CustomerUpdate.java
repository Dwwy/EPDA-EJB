package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Customer;

import java.io.InputStream;
import java.time.LocalDateTime;

public class CustomerUpdate {
    private String customerId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String password;
    private InputStream profile;
    private String imageUrl;
    public Customer toCustomer(Customer customer){
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setTelNo(telNo);
        customer.setImageURL(imageUrl);
        customer.setLastUpdated(LocalDateTime.now());
        return customer;
    }
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InputStream getProfile() {
        return profile;
    }

    public void setProfile(InputStream profile) {
        this.profile = profile;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
