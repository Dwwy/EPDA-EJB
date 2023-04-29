package com.example.demo1.Model.Output;

import com.example.demo1.Model.Staff;
import com.example.demo1.Model.User;

import java.time.format.DateTimeFormatter;

public class StaffProfile {
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private String lastUpdated;
    private String email;
    public StaffProfile (Staff staff, User user){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id = staff.getId();
        this.userId = staff.getUserId();
        this.firstName = staff.getFirstName();
        this.lastName = staff.getLastName();
        this.telNo = staff.getTelNo();
        this.imageURL = staff.getImageURL();
        this.lastUpdated = formatter.format(staff.getLastUpdated());
        this.email = user.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
