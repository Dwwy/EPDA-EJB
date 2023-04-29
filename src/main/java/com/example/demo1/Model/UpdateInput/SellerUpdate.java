package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Seller;

import java.io.InputStream;
import java.time.LocalDateTime;

public class SellerUpdate {
    private String sellerId;
    private String companyName;
    private String contactFName;
    private String contactLName;
    private String companyEmail;
    private String companyNumber;

    private String imageURL;
    private String email;
    private String password;
    private InputStream companyImage;
    private String imageUrl;
    public void setImageUrl(String url){
        this.imageUrl = url;
    }
    public Seller toSeller(Seller seller){
        seller.setCompanyName(companyName);
        seller.setContactFName(contactFName);
        seller.setContactLName(contactLName);
        seller.setCompanyEmail(companyEmail);
        seller.setCompanyNumber(companyNumber);
        seller.setImageURL(imageUrl);
        seller.setLastUpdated(LocalDateTime.now());
        return seller;
    }
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
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

    public String getImageUrl() {
        return imageUrl;
    }
}
