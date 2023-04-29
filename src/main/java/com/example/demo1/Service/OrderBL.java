package com.example.demo1.Service;

import com.example.demo1.Dao.*;
import com.example.demo1.Model.*;
import com.example.demo1.Model.Input.ApproveRejectOrderInput;
import com.example.demo1.Model.Input.OrderInput;
import com.example.demo1.Model.Input.PaymentInput;
import com.example.demo1.Model.Input.WalletHistoryInput;
import com.example.demo1.Model.Output.Cart_OrderOutput;
import com.example.demo1.Model.Output.OrderOutput;
import com.example.demo1.Model.Output.ProductListOutput;
import com.example.demo1.Model.UpdateInput.OrderUpdate;
import com.example.demo1.Util.StaticVariable;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Stateless
public class OrderBL implements OrderBLI{
    @EJB
    SellerDAOI sellerDAO;
    @EJB
    ProductDAOI productDAO;
    @EJB
    ProductDropDownDAOI productDropDownDAO;
    @EJB
    OrderDAOI orderDAO;
    @EJB
    Cart_OrderDAOI cartOrderDAO;
    @EJB
    CartDAOI cartDAO;
    @EJB
    CartBLI cartBL;
    @EJB
    PaymentDAOI paymentDAO;
    @EJB
    ProductBLI productBL;
    @EJB
    WalletHistoryDAOI walletHistoryDAO;
    @EJB
    PaymentBLI paymentBL;
    public Double calculateFreight (OrderInput input){
        List<Cart> carts = input.getCartId().stream().map(x-> cartDAO.getCartbyId(x)).collect(Collectors.toList());
        List<String> seller = carts.stream().map(x-> productDAO.getProductbyId(x.getProductId())).map(x-> x.getSellerId()).collect(Collectors.toSet())
                .stream().collect(Collectors.toList());
        Double size = Double.valueOf(seller.size());
        return  size * StaticVariable.freightCost;
    }
    public Response createOrder(OrderInput input){
        Order order = orderDAO.createOrder(input.toOrder(calculateFreight(input)));
        if (order != null){
            List<Cart_Order> cartOrders = input.toCartOrder(order.getId(),cartDAO).stream()
                    .map(x -> x.toCart_Order())
                    .collect(Collectors.toList());
            List<Cart_Order> cartOrders1 = new ArrayList<>();
            List<Response> responses = new ArrayList<>();
            cartOrders.forEach(x->{
                Response response = cartBL.createCartOrder(x);
                responses.add(response);
                cartOrders1.add((Cart_Order) response.getData());
            });
            if (responses.stream().anyMatch(x-> !x.isStatus())){
                orderDAO.deleteOrder(order);
                cartOrders1.forEach(x-> {
                    cartOrderDAO.deleteCart_Order(x);
                });
                return new Response(false, "Error occurred while creating cart order items");
            }
            else {
                PaymentInput paymentInput = new PaymentInput(cartBL.getCartOrdersbyOrderId(order.getId()), order, StaticVariable.Payment_Type.Default, StaticVariable.Payment_Status.Pending );
                if (paymentBL.createPayment(paymentInput).isStatus())
                {
                    return new Response(true);
                }
                else {
                    orderDAO.deleteOrder(order);
                    cartOrders1.forEach(x-> {
                        cartOrderDAO.deleteCart_Order(x);
                    });
                    return new Response(false, "Error occurred while creating payment");
                }

            }
        }
        else {
            return new Response(false, "Error occurred while creating order");
        }
    }
    public Response updateOrder(OrderUpdate input){
        Order order = orderDAO.getOrderbyId(input.getOrderId());
        if (order == null){
            return new Response(false, "Order not found");
        }
        else {
            orderDAO.updateOrder(input.toOrder(order));
            return new Response(true);
        }
    }

    public Response getAllOrderByCustomerId (String customerId){
        List<Order> orderList = orderDAO.getAllOrderbyCustomerId(customerId);
        List<OrderOutput> outputList = new ArrayList<>();
        orderList.forEach(x-> {
            outputList.add(getFullOrderByOrderId(x.getId()));
        });
        return new Response(outputList);
    }
    public OrderOutput getFullOrderByOrderId (String orderId){
        Order order = orderDAO.getOrderbyId(orderId);
        List<Cart_OrderOutput> items = cartBL.getCartOrdersbyOrderId(orderId).stream().map(x-> {
            Cart cart = cartDAO.getCartbyId(x.getCartId());
            return new Cart_OrderOutput(x, productDAO.getProductbyId(cart.getProductId()));
        }).collect(Collectors.toList());
        Payment payment = paymentDAO.getPaymentbyOrderId(orderId);
        return new OrderOutput(order,payment,items);
    }
    public List<OrderOutput> getAllOrderBySellerId (String sellerId) {
        List<ProductListOutput> products = productBL.getProductBySellerId(sellerId);
        List<Cart> carts = new ArrayList<>();
        products.forEach(x->{
            carts.addAll(cartDAO.getAllCartbyProductId(x.getId()));
        });
        List<Cart_Order> cartOrders = new ArrayList<>();
        carts.forEach(x->{
            cartOrderDAO.getAllCartOrderbyCartId(x.getId());
        });
        List<OrderOutput> output = new ArrayList<>();
        cartOrders.forEach(x->{
            output.add(getFullOrderByOrderId(x.getOrderId()));
        });
        return output;
    }
    public Response ApproveRejectOrder (ApproveRejectOrderInput input){
        Cart_Order cartOrder = cartOrderDAO.getCart_OrderbyId(input.getCartOrderId());
        cartOrder.setStatus(input.getStatus());
        cartOrder.setLastUpdated(LocalDateTime.now());
        if (cartOrder.getStatus() == StaticVariable.orderStat.Awaiting_Shipment){
            cartOrder.setAcceptedDate(LocalDateTime.now());
            cartOrder.setEstimatedDeliveryDate(LocalDateTime.now().plusDays(7));
            WalletHistory walletHistory = new WalletHistoryInput(cartOrder.getPrice(),input.getSellerId()).toWalletHistory();

            if (walletHistoryDAO.createWalletHistory(walletHistory)){
                Seller seller = sellerDAO.getSellerbyId(input.getSellerId());
                seller.setWalletBalance(seller.getWalletBalance()+cartOrder.getPrice());
                sellerDAO.updateSeller(seller);
                cartOrderDAO.updateCart_Order(cartOrder);
                return new Response(true);
            }
            else {
                return new Response(false, "Error occurred while creating wallet history");
            }

        }
        else {
            cartOrderDAO.updateCart_Order(cartOrder);
            return  new Response(true);
        }
    }
}
