package com.example.demo1.Service;

import com.example.demo1.Model.Input.GeoLocationInput;
import com.example.demo1.Model.UpdateInput.GeoLocationUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface GeoLocationBLI {
    Response createGeolocation (GeoLocationInput input);
    Response update(GeoLocationUpdate input);
}
