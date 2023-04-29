package com.example.demo1.Service;

import com.example.demo1.Model.Cart_Order;
import com.example.demo1.Model.Input.CartInput;
import com.example.demo1.Model.UpdateInput.CartUpdate;
import com.example.demo1.Model.UpdateInput.Cart_OrderUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CartBLI {
    Response createCart(CartInput input);
    Response createCartOrder(Cart_Order input);
    Response updateCart(CartUpdate input);
    Response updateCartOrder(Cart_OrderUpdate input);
    List<Cart_Order> getCartOrdersbyOrderId (String orderId);
}
