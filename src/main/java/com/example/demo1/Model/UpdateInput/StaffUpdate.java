package com.example.demo1.Model.UpdateInput;

import com.example.demo1.Model.Staff;

import java.io.InputStream;
import java.time.LocalDateTime;

public class StaffUpdate {
    private String staffId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String email;
    private String password;
    private InputStream profile;
    private String imageUrl;
    public UserUpdate toUserUpdate(String userId){
        UserUpdate input = new UserUpdate();
        input.setPassword(password);
        input.setUserId(userId);
        input.setEmail(email);
        return input;
    }
    public Staff toStaff(Staff staff) {
        staff.setImageURL(imageUrl);
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setTelNo(telNo);
        staff.setLastUpdated(LocalDateTime.now());
        return staff;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
