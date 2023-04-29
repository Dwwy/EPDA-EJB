package com.example.demo1.Model.Input;

import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.Seller;
import com.example.demo1.Model.User;
import com.example.demo1.Util.StaticVariable;

import java.io.InputStream;

public class SellerInput {
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;
    private String userId;

    private String imageURL;
    private String email;
    private String password;
    private InputStream companyImage;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    private String imageUrl;
    private StaticVariable.accountType accountType = StaticVariable.accountType.Seller;
    public void setImageUrl(String url){
        this.imageUrl = url;
    }
    public Seller toSeller(){
        Seller seller = new Seller();
        seller.setCompanyName(companyName);
        seller.setContactFName(contactFName);
        seller.setContactLName(contactLName);
        seller.setCompanyEmail(companyEmail);
        seller.setCompanyNumber(companyNumber);
        seller.setImageURL(imageUrl);
        seller.setUserId(userId);
        seller.setWalletBalance(0.0);
        return seller;
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
        location.setCity(city);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(true);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
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

    public InputStream getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(InputStream companyImage) {
        this.companyImage = companyImage;
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

    public StaticVariable.accountType getAccountType() {
        return accountType;
    }

    public void setAccountType(StaticVariable.accountType accountType) {
        this.accountType = accountType;
    }
}
