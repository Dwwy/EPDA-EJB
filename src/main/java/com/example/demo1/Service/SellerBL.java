package com.example.demo1.Service;

import com.example.demo1.Dao.*;
import com.example.demo1.Model.GeoLocation;
import com.example.demo1.Model.Input.SellerInput;
import com.example.demo1.Model.Input.WalletHistoryInput;
import com.example.demo1.Model.Output.SellerProfile;
import com.example.demo1.Model.Seller;
import com.example.demo1.Model.UpdateInput.SellerUpdate;
import com.example.demo1.Model.User;
import com.example.demo1.Util.ImgUp_Down;
import com.example.demo1.Util.StaticVariable;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Stateless
public class SellerBL implements SellerBLI {
    @EJB
    UserDAOI userDAO = new UserDAO();
    @EJB
    GeoLocationDAOI geoLocationDAO = new GeoLocationDAO();
    @EJB
    SellerDAOI sellerDAO =  new SellerDAO();
    @EJB
    UserBLI userBL = new UserBL();
    @EJB
    WalletHistoryDAOI walletHistoryDAO = new WalletHistoryDAO();
    public Response register(SellerInput input){
        if (userDAO.createUser(input.toUser())){
            User user = userDAO.getUserbyEmail(input.getEmail());
            String url;
            try {
                url = ImgUp_Down.uploadImage(input.getCompanyImage()).get().getResponseData().getImageUrl();
            } catch (Exception e) {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while uploading image");
            }
            input.setImageUrl(url);
            input.setUserId(user.getId());
            if (sellerDAO.createSeller(input.toSeller())){
                Seller seller = sellerDAO.getSellerbyUserID(user.getId());
                if (geoLocationDAO.createGeoLocation(input.toGeoLocation())){
                    GeoLocation geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId()).get(0);
                    return new Response(new SellerProfile(seller,user,geoLocation));
                }
                else {
                    sellerDAO.deleteSeller(seller);
                    userDAO.deleteUser(user);
                    return new Response(false, "Error occurred while creating address");
                }
            }
            else {
                userDAO.deleteUser(user);
                return new Response(false, "Error occurred while creating seller");
            }
        }
        else {
            return new Response(false, "Error occurred while creating user");
        }
    }
    public Response update(SellerUpdate input){
        if (input.getCompanyImage()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getCompanyImage()).get().getResponseData().getImageUrl();
                input.setImageUrl(url);
            } catch (Exception e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Seller seller = sellerDAO.getSellerbyId(input.getSellerId());
        if (seller == null){
            return new Response(false, "Customer not found");
        }
        else {
            if (input.getPassword() != null || input.getEmail() != null){
                userBL.update(input.toUserUpdate(seller.getUserId()));
            }
            sellerDAO.updateSeller(input.toSeller(seller));
            return new Response(true);
        }
    }
    public SellerProfile getSellerProfilebySellerId(String sellerId){
        Seller seller = sellerDAO.getSellerbyId(sellerId);
        User user = userDAO.getUserbyId(seller.getUserId());
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new SellerProfile(seller,user,geoLocation.get(0));
    }
    public SellerProfile getSellerProfilebyUserId(String id){
        User user = userDAO.getUserbyId(id);
        Seller seller = sellerDAO.getSellerbyUserID(id);
        List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
        return new SellerProfile(seller,user,geoLocation.get(0));
    }
    public List<SellerProfile> getAllSellerProfile(){
        List<Seller> sellers = sellerDAO.getAllSeller();
        List<SellerProfile> sellerProfiles = new ArrayList<>();
        sellers.forEach(x->{
            sellerProfiles.add(getSellerProfilebySellerId(x.getId()));
        });
//        synchronized(sellers) {
//            for(Seller seller : sellers) {
//                User user = userDAO.getUserbyId(seller.getUserId());
//                List<GeoLocation> geoLocation = geoLocationDAO.getAllGeoLocationbyUserId(user.getId());
//                sellerProfiles.add(new SellerProfile(seller, user, geoLocation.get(0)));
//            }
//        }
        return sellerProfiles;
    }
    public Response collectPaymentFromWallet (String sellerId, Double amount) {
        WalletHistoryInput walletHistoryInput = new WalletHistoryInput(amount, sellerId);
        if (walletHistoryDAO.createWalletHistory(walletHistoryInput.toWalletHistory())){
            Seller seller = sellerDAO.getSellerbyId(sellerId);
            if (amount > 0) {
                seller.setWalletBalance(seller.getWalletBalance()+ amount);
            }
            else {
                if (amount > seller.getWalletBalance()){
                    return new Response(false, "Seller is trying to retrieve more than what he has");
                }
                else {
                    seller.setWalletBalance(seller.getWalletBalance() - amount);
                }
            }
            sellerDAO.updateSeller(seller);
            return new Response(true);
        }
        else {
            return new Response(false, "Error occurred while creating wallet history");
        }
    }
}
