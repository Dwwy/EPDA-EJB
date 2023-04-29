package com.example.demo1.Service;

import com.example.demo1.Model.Input.ApproveRejectOrderInput;
import com.example.demo1.Model.Input.OrderInput;
import com.example.demo1.Model.Output.OrderOutput;
import com.example.demo1.Model.UpdateInput.OrderUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;
import java.util.List;
@Local
public interface OrderBLI {
    Response createOrder(OrderInput input);
    Response updateOrder(OrderUpdate input);
    Response getAllOrderByCustomerId (String customerId);
    OrderOutput getFullOrderByOrderId (String orderId);
    List<OrderOutput> getAllOrderBySellerId (String sellerId);
    Response ApproveRejectOrder (ApproveRejectOrderInput input);
}
