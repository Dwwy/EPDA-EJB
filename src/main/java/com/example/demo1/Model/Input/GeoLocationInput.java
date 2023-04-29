package com.example.demo1.Model.Input;

import com.example.demo1.Model.GeoLocation;

public class GeoLocationInput {
    private boolean primary;
    private String name;
    private String userId;
    private String zipCode;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String country;
    public GeoLocation toGeoLocation(){
        GeoLocation location = new GeoLocation();
        location.setCity(city);
        location.setName(name);
        location.setUnit(unit);
        location.setCountry(country);
        location.setState(state);
        location.setPrimary(primary);
        location.setZipCode(zipCode);
        location.setUserId(userId);
        location.setStreet(street);
        return location;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
