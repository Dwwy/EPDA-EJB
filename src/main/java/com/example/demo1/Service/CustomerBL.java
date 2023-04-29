package com.example.demo1.Service;

import com.example.demo1.Dao.CustomerDAOI;
import com.example.demo1.Dao.GeoLocationDAOI;
import com.example.demo1.Dao.UserDAOI;
import com.example.demo1.Model.Customer;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.Input.CustomerInput;
import com.example.demo1.Model.Output.CustomerProfile;
import com.example.demo1.Model.UpdateInput.CustomerUpdate;
import com.example.demo1.Model.User;
import com.example.demo1.Util.ImgUp_Down;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CustomerBL implements CustomerBLI{
    @EJB
    CustomerDAOI customerDAO;
    @EJB
    UserDAOI userDAO;
    @EJB
    GeoLocationDAOI geoLocationDAO;
    @EJB
    UserBLI userBL;
    public Response register(CustomerInput input){
        if (userDAO.createUser(input.toUser())){
            User user = userDAO.getUserbyEmail(input.getEmail());
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (Exception e) {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while uploading image");
            }
            input.setUserId(user.getId());
            if (customerDAO.createCustomer(input.toCustomer())){
                Customer customer = customerDAO.getCustomerbyUserID(user.getId());
                if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
                    GeoLocation geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId()).get(0);
                    return new Response(new CustomerProfile(user,customer,geoLocation));
                }
                else {
                    customerDAO.deleteCustomer(customer);
                    userDAO.deleteUser(user);
                    return new Response(false, "Error occurred while creating address");
                }
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating customer");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
    public Response update(CustomerUpdate input){
        if (input.getProfile()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getProfile()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (Exception e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Customer customer = customerDAO.getCustomerbyId(input.getCustomerId());
        if (customer == null){
            return new Response(false, "Customer not found");
        }
        else {
            if (input.getPassword() != null || input.getEmail() != null){
                userBL.update(input.toUserUpdate(customer.getUserId()));
            }
            customerDAO.updateCustomer(input.toCustomer(customer));
            return new Response(true);
        }
    }
    public CustomerProfile getCustomerProfilebyCustomerId(String customerId){
        Customer customer = customerDAO.getCustomerbyId(customerId);
        User user = userDAO.getUserbyId(customer.getUserId());
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new CustomerProfile(user,customer,geoLocation);
    }
    public CustomerProfile getCustomerProfilebyUserId(String id){
        User user = userDAO.getUserbyId(id);
        Customer customer = customerDAO.getCustomerbyUserID(id);
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new CustomerProfile(user,customer,geoLocation);
    }
}
