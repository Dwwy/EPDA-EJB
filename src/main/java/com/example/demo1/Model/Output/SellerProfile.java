package com.example.demo1.Model.Output;

import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.Seller;
import com.example.demo1.Model.User;

import java.time.format.DateTimeFormatter;

public class SellerProfile {
    private String id;
    private String email;
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;
    private String userId;
    private String imageURL;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    private Double walletBalance;
    private String lastUpdated;
    public SellerProfile (Seller seller, User user, GeoLocation geoLocation){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id  = seller.getId();
        this.email = user.getEmail();
        this.companyName = seller.getCompanyName();
        this.contactFName = seller.getContactFName();
        this.contactLName = seller.getContactLName();
        this.companyEmail = seller.getCompanyEmail();
        this.companyNumber = seller.getCompanyNumber();
        this.userId = user.getId();
        this.imageURL = seller.getImageURL();
        this.zipCode = geoLocation.getZipCode();
        this.unit = geoLocation.getUnit();
        this.street = geoLocation.getStreet();
        this.city = geoLocation.getCity();
        this.state = geoLocation.getState();
        this.country = geoLocation.getCountry();
        this.walletBalance = seller.getWalletBalance();
    }

    public SellerProfile(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactFName() {
        return contactFName;
    }

    public void setContactFName(String contactFName) {
        this.contactFName = contactFName;
    }

    public String getContactLName() {
        return contactLName;
    }

    public void setContactLName(String contactLName) {
        this.contactLName = contactLName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
