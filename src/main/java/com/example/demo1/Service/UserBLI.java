package com.example.demo1.Service;

import com.example.demo1.Model.Input.LoginInput;
import com.example.demo1.Model.UpdateInput.UserUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;

@Local
public interface UserBLI {
    Response getQR2FA (String userId);
    Response authenticate2FACode(String code);
    Response login (LoginInput input);
    Response update(UserUpdate input);
}
