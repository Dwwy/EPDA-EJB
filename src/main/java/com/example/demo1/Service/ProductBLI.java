package com.example.demo1.Service;

import com.example.demo1.Model.Input.ProductInput;
import com.example.demo1.Model.Output.ProductListOutput;
import com.example.demo1.Model.Output.ProductOutput;
import com.example.demo1.Model.Product;
import com.example.demo1.Model.UpdateInput.ProductUpdate;
import com.example.demo1.response.Response;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ProductBLI {
    Response createProduct(ProductInput input);
    Response searchProduct(String criteria);
    Response updateProduct(ProductUpdate input);
    ProductListOutput getProductList (Product product);
    List<ProductListOutput> getProductBySellerId (String sellerId);
    ProductOutput getFullProduct (String productId);
}
