package com.example.demo1.Model.Output;


import com.example.demo1.Model.Customer;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.User;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomerProfile {
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String telNo;
    private String imageURL;
    private String lastUpdated;
    private List<GeoLocation> geoLocation;
    private String email;
    public CustomerProfile (User user, Customer customer, GeoLocation geoLocation){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id = customer.getId();
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.telNo = customer.getTelNo();
        this.imageURL = customer.getImageURL();
        this.lastUpdated = formatter.format(customer.getLastUpdated());
        this.geoLocation = new ArrayList<GeoLocation>(){{add(geoLocation);}};
        this.email = user.getEmail();
    }
    public CustomerProfile (User user, Customer customer, List<GeoLocation> geoLocation){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
        this.id = customer.getId();
        this.userId = customer.getUserId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.telNo = customer.getTelNo();
        this.imageURL = customer.getImageURL();
        this.lastUpdated = formatter.format(customer.getLastUpdated());
        this.geoLocation = geoLocation;
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

    public List<GeoLocation> getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(List<GeoLocation> geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
