package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.User;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserDAO extends GenericDAO<User> implements UserDAOI{

    public UserDAO(){
        super(User.class);
    }
    public boolean createUser(User user){
        try {
            this.create(user);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateUser(User cust){
        try {
            this.update(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteUser(User cust){
        this.delete(cust);
    }
    public List<User> getAllUser() {
        return this.findAll();
    }
    public User getUserbyId(String id) {
        System.out.println("Finding");
        return this.findById(id);
    }
    public User getUserbyEmail(String email){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("email");
        query.setValue(email);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<User> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }
    }

}
