package com.example.demo1.Model.Input;


import com.example.demo1.Model.Customer;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.User;
import com.example.demo1.Util.StaticVariable;

import java.io.InputStream;

public class CustomerInput {
    private String firstName;
    private String lastName;
    private String telNo;
    private StaticVariable.accountType accountType = StaticVariable.accountType.Customer;
    private String userId;
    private String email;
    private String password;
    private InputStream profile;
    private boolean primary;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    private String imageUrl;

    public Customer toCustomer(){
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setFirstName(firstName);
        customer.setTelNo(telNo);
        customer.setImageURL(imageUrl);
        customer.setUserId(userId);
        return customer;
    }
    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setAccountType(accountType);
        user.setPassword(password);
        return user;
    }
    public GeoLocation toGeoLocation(){
        GeoLocation location = new GeoLocation();
        location.setName("Default");
        location.setCity(city);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(primary);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
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

    public StaticVariable.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(StaticVariable.accountType accountType) {
        this.accountType = accountType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
