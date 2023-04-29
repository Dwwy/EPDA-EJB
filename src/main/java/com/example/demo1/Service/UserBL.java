package com.example.demo1.Service;

import com.example.demo1.Dao.CustomerDAOI;
import com.example.demo1.Dao.SellerDAOI;
import com.example.demo1.Dao.UserDAOI;
import com.example.demo1.Model.Input.LoginInput;
import com.example.demo1.Model.UpdateInput.UserUpdate;
import com.example.demo1.Model.User;
import com.example.demo1.Util.Authenticator;
import com.example.demo1.Util.StaticVariable;
import com.example.demo1.response.Response;
import com.google.zxing.WriterException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class UserBL implements UserBLI{
    @EJB
    UserDAOI userDAO;
    @EJB
    CustomerDAOI customerDAO;
    @EJB
    SellerDAOI sellerDAO;
    private String getName (User user){
        if (user.getAccountType() == StaticVariable.accountType.Customer){
            return customerDAO.getCustomerbyUserID(user.getId()).getFirstName();
        }
        else {
            return sellerDAO.getSellerbyUserID(user.getId()).getCompanyName();
        }
    }

    public Response getQR2FA (String userId){
        User user = userDAO.getUserbyId(userId);
        String email = user.getEmail();
        String name = getName(user);
        String barCodeUrl = Authenticator.getGoogleAuthenticatorBarCode(StaticVariable.authenticator_secret(), email, name);
        try {
            Authenticator.createQRCode(barCodeUrl, "QRCode.png", 400, 400);
            return new Response(true);
        } catch (WriterException e) {
            return new Response(false, "A writerException occurred while executing.");
        } catch (IOException e) {
            return new Response(false, "An IOException occurred while executing.");
        }
    }
    public Response authenticate2FACode(String code){
        if (code.equals(Authenticator.getTOTPCode(StaticVariable.authenticator_secret()))) {
            return new Response(true, "Successfully executed.");
        } else {
            return new Response(false, "Invalid code.");
        }
    }
    public Response login (LoginInput input){
        User user = userDAO.getUserbyEmail(input.getEmail());
        if (user == null){
            return new Response(false, "Incorrect email.");
        }
        else {
            if (input.getPassword().equals(user.getPassword())){
                return new Response(user.getId());
            }
            else {
                return new Response(false, "Incorrect password.");
            }
        }
    }
    public Response update(UserUpdate input){
        User user = userDAO.getUserbyId(input.getUserId());
        if (user == null){
            return new Response(false, "User not found");
        }
        else {
            userDAO.updateUser(input.toUser(user));
            return new Response(true);
        }
    }
}
