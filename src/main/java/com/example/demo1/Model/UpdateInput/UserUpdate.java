package com.example.demo1.Model.UpdateInput;


import com.example.demo1.Model.User;

public class UserUpdate {
    private String userId;
    private String email;
    private String password;

    public User toUser(User user){
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
