package com.example.demo1.Dao;

import com.example.demo1.Model.ProductDropDown;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ProductDropDownDAOI {
    ProductDropDown createProductDropDown(ProductDropDown productDropDown);
    boolean updateProductDropDown(ProductDropDown productDropDown);
    void deleteProductDropDown(ProductDropDown productDropDown);
    List<ProductDropDown> getAllProductDropDown();
    ProductDropDown getProductDropDownbyId(String id);
    List<ProductDropDown> getAllProductDropDownbyProductId (String productId);
}
