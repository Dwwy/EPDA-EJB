package com.example.demo1.Dao;

import com.example.demo1.Model.User;

import javax.ejb.Local;
import java.util.List;
@Local
public interface UserDAOI {
    boolean createUser(User user);
    boolean updateUser(User cust);
    void deleteUser(User cust);
    List<User> getAllUser();
    User getUserbyId(String id);
    User getUserbyEmail(String email);
}
