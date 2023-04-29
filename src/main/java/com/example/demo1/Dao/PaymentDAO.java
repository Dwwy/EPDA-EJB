package com.example.demo1.Dao;

import com.example.demo1.Model.GenericQuery;
import com.example.demo1.Model.Payment;
import com.example.demo1.Util.StaticVariable;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PaymentDAO extends GenericDAO<Payment> implements PaymentDAOI{
    public PaymentDAO(){
        super(Payment.class);
    }
    public Payment createPayment(Payment payment){
        try {
            return this.create(payment);
        }
        catch (Exception e){
            return null;
        }
    }
    public boolean updatePayment(Payment payment){
        try {
            this.update(payment);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void deletePayment(Payment payment){
        this.delete(payment);
    }
    public List<Payment> getAllPayment() {
        return this.findAll();
    }
    public Payment getPaymentbyId(String id) {
        return this.findById(id);
    }
    public Payment getPaymentbyOrderId (String orderId) {
        List<GenericQuery> queries = new ArrayList<>();
        GenericQuery query = new GenericQuery();
        query.setWhereColumn("orderId");
        query.setValue(orderId);
        query.setWhereCondition(GenericQuery.Where.equal);
        queries.add(query);
        return this.findListByWhereCondition(queries, StaticVariable.Condition.and).get(0);
    }


}
