package com.example.demo1.Service;

import com.example.demo1.Model.Input.SellerInput;
import com.example.demo1.Model.Output.SellerProfile;
import com.example.demo1.Model.UpdateInput.SellerUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SellerBLI {
    Response register(SellerInput input);

    SellerProfile getSellerProfilebySellerId(String sellerId);
    SellerProfile getSellerProfilebyUserId(String id);
    Response update(SellerUpdate input);
    Response collectPaymentFromWallet (String sellerId, Double amount);
    List<SellerProfile> getAllSellerProfile();
}
