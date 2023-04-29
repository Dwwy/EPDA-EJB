package com.example.demo1.Dao;

import com.example.demo1.Model.GeoLocation;

import javax.ejb.Local;
import java.util.List;
@Local
public interface GeoLocationDAOI {
    boolean createGeoLocation(GeoLocation geoLocation);
    boolean updateGeoLocation(GeoLocation cust);
    void deleteGeoLocation(GeoLocation cust);
    List<GeoLocation> getAllGeoLocation();
    GeoLocation getGeoLocationbyId(String id);
    List<GeoLocation> getAllGeoLocationbyUserId (String id);
}
