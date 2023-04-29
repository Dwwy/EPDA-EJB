package com.example.demo1.Service;

import com.example.demo1.Dao.*;
import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.Input.PaymentInput;
import com.example.demo1.Model.Payment;
import com.example.demo1.Model.UpdateInput.PaymentUpdate;
import com.example.demo1.Util.StaticVariable;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class PaymentBL implements  PaymentBLI{
    @EJB
    SellerDAOI sellerDAO;
    @EJB
    ProductDAOI productDAO;
    @EJB
    Cart_OrderDAOI cartOrderDAO;
    @EJB
    ProductDropDownDAOI productDropDownDAO;
    @EJB
    PaymentDAOI paymentDAO;

    @EJB
    CartBLI cartBL;
    private boolean updateCartOrderStatus (List<Cart_Order> cartOrders, StaticVariable.orderStat status){
        if (cartOrderDAO.updateCartOrdersStatus(cartOrders,status)){
            return true;
        }
        else {
            return false;
        }
    }
    public Response createPayment(PaymentInput input){
        Payment payment = paymentDAO.createPayment(input.toPayment());
        if (payment!= null){
            List<Cart_Order> cartOrders = cartBL.getCartOrdersbyOrderId(input.getOrderId());
            if (updateCartOrderStatus(cartOrders, StaticVariable.orderStat.Awaiting_Payment)){
                return new Response(true);
            }
            else {
                paymentDAO.deletePayment(payment);
                return new Response(false, "Error occurred while updating order");
            }
        }
        else {
            return new Response(false, "Error occurred while creating payment");
        }
    }
    public Response makePayment(PaymentUpdate update){
        Payment payment = paymentDAO.getPaymentbyId(update.getPaymentId());
        if (payment == null){
            return new Response(false, "Payment not found");
        }
        else {
            if (paymentDAO.updatePayment(update.toPayment(payment))){
                List<Cart_Order> cartOrders = cartBL.getCartOrdersbyOrderId(payment.getOrderId());
                if (updateCartOrderStatus(cartOrders, StaticVariable.orderStat.Awaiting_Acceptance)){
                    return new Response(true);
                }
                else {
                    return new Response(false, "Error occurred while updating cart order");
                }
            }
            else {
                return new Response(false, "Error occurred while updating payment");
            }

        }
    }

}
