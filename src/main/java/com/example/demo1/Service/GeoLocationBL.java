package com.example.demo1.Service;

import com.example.demo1.Dao.GeoLocationDAOI;
import com.example.demo1.Dao.UserDAOI;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.Input.GeoLocationInput;
import com.example.demo1.Model.UpdateInput.GeoLocationUpdate;
import com.example.demo1.response.Response;

import javax.ejb.EJB;

public class GeoLocationBL implements GeoLocationBLI {
    @EJB
    UserDAOI userDAO;
    @EJB
    GeoLocationDAOI geoLocationDAO;
    public Response createGeolocation (GeoLocationInput input){
        if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating address");
        }
    }
    public Response update(GeoLocationUpdate input){
        GeoLocation location = geoLocationDAO.getGeoLocationbyId(input.getGeoLocationId());
        if (location == null){
            return new Response(false, "Address not found");
        }
        else {
            geoLocationDAO.updateGeoLocation(input.toGeoLocation(location));
            return new Response(true);
        }
    }
}
