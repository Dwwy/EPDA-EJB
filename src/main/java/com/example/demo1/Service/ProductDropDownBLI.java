package com.example.demo1.Service;

import com.example.demo1.Model.Input.ProductDropDownInput;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Model.UpdateInput.ProductDropDownUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ProductDropDownBLI {
    Response createProductDropDown(ProductDropDownInput input);
    List<ProductDropDown> getProductDropDownbyProductId (String productId);
    Response update(ProductDropDownUpdate input);
}
