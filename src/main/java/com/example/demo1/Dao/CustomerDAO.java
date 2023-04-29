package com.example.demo1.Dao;

import com.example.demo1.Model.Customer;
import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerDAO extends GenericDAO<Customer> implements CustomerDAOI{
    public CustomerDAO (){
        super(Customer.class);
    }
    public boolean createCustomer(Customer cust){
        try{
            this.create(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean updateCustomer(Customer cust){
        try {
            this.update(cust);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deleteCustomer(Customer cust){
        this.delete(cust);
    }
    public List<Customer> getAllCustomers() {
        return this.findAll();
    }
    public Customer getCustomerbyId(String id) {
        return this.findById(id);
    }
    public Customer getCustomerbyUserID(String id){
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("userId");
        query.setValue(id);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        List<Customer> output = this.findListByWhereCondition(queries, StaticVariable.Condition.and);
        if (output == null || output.isEmpty()){
            return null;
        }
        else {
            return output.get(0);
        }    }

}
