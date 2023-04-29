package com.example.demo1.Model.Input;

import com.example.demo1.Model.Staff;
import com.example.demo1.Model.User;
import com.example.demo1.Util.StaticVariable;

import java.io.InputStream;

public class StaffInput {
    private String firstName;
    private String lastName;
    private String telNo;
    private InputStream profile;
    private String imageUrl;
    private String email;
    private String password;
    private StaticVariable.accountType accountType = StaticVariable.accountType.Staff;
    private String userId;
    public User toUser(){
        User user = new User();
        user.setEmail(email);
        user.setAccountType(accountType);
        user.setPassword(password);
        return user;
    }
    public Staff toStaff() {
        Staff staff = new Staff();
        staff.setImageURL(imageUrl);
        staff.setUserId(userId);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setTelNo(telNo);
        return staff;
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
}
