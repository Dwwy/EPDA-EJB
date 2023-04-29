package com.example.demo1.Dao;

import com.example.demo1.Model.Product;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ProductDAOI {
    Product createProduct(Product product);
    boolean updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> getAllProduct();
    Product getProductbyId(String id);
    List<Product> searchProductbyName(String name);
    List<Product> searchProductbySellerId (String sellerId);
}
