package com.example.demo1.Service;
import com.example.demo1.Dao.*;
import com.example.demo1.Model.Input.ProductDropDownInput;
import com.example.demo1.Model.Input.ProductInput;
import com.example.demo1.Model.Output.ProductListOutput;
import com.example.demo1.Model.Output.ProductOutput;
import com.example.demo1.Model.Product;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Model.Review;
import com.example.demo1.Model.ReviewMessage;
import com.example.demo1.Model.UpdateInput.ProductUpdate;
import com.example.demo1.Util.ImgUp_Down;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Stateless
public class ProductBL implements ProductBLI{
    @EJB
    SellerDAOI sellerDAO;
    @EJB
    ProductDAOI productDAO;
    @EJB
    ProductDropDownDAOI productDropDownDAO;
    @EJB
    ProductDropDownBLI productDropDownBL;
    @EJB
    ReviewDAOI reviewDAO;
    @EJB
    ReviewMessageDAOI reviewMessageDAO;
    private static double calculateAverage(List<Double> list) {
        double sum = 0;
        for (double d : list) {
            sum += d;
        }
        return sum / list.size();
    }
    private Double getPrice (Product product) {
        List<ProductDropDown> dropDowns = productDropDownBL.getProductDropDownbyProductId(product.getId());
        return calculateAverage(dropDowns.stream().map(ProductDropDown::getPrice).collect(Collectors.toList()));
    }
    public Response createProduct(ProductInput input){
        try {
            String url = ImgUp_Down.uploadImage(input.getProductImg()).get().getResponseData().getImageUrl();
            input.setImageURL(url);
        } catch (Exception e) {
            return new Response(false, "Error occurred while uploading image");
        }
        Product product = productDAO.createProduct(input.toProduct());

        if (product!= null){
            ProductDropDownInput dropDown = input.toProductDropDownInput(product.getId());
            if (productDropDownBL.createProductDropDown(dropDown).isStatus()){
                return new Response(true);
            }
            else {
                productDAO.deleteProduct(product);
                return new Response(false, "Error occurred while creating product subcategory");
            }
        }
        else {
            return new Response(false, "Error occurred while creating product");
        }
    }
    public ProductListOutput getProductList (Product product){
        List<ProductDropDown> drop = productDropDownBL.getProductDropDownbyProductId(product.getId());
        ProductListOutput output = new ProductListOutput(product,drop,getPrice(product));
        return output;
    }
    public ProductOutput getFullProduct (String productId){
        Product product = productDAO.getProductbyId(productId);
        List<ProductDropDown> drop = productDropDownBL.getProductDropDownbyProductId(productId);
        List<Review> reviews = reviewDAO.getAllReviewbyProductId(productId);
        List<ReviewMessage> messages = reviewMessageDAO.getAllReviewMessagebyMultipleReviewId(reviews.stream().map(Review::getId).collect(Collectors.toList()));
        return new ProductOutput(product, drop ,getPrice(product), reviews, messages);
    }
    public List<ProductListOutput> getProductBySellerId (String sellerId){
        List<ProductListOutput> output = new ArrayList<>();
        List<Product> products = productDAO.searchProductbySellerId(sellerId);
        products.forEach(x->{
            List<ProductDropDown> drop = productDropDownBL.getProductDropDownbyProductId(x.getId());
            ProductListOutput productListOutput = new ProductListOutput(x,drop,getPrice(x));
            output.add(getProductList(x));
        });
        return output;
    }
    public Response searchProduct(String criteria){
        List<ProductListOutput> output = new ArrayList<>();
        List<Product> products = productDAO.searchProductbyName(criteria);
        products.forEach(x->{
            output.add(getProductList(x));
        });
        return new Response(output);
    }
    public Response updateProduct(ProductUpdate input){
        if (input.getProductImg()!= null){
            try {
                String url = ImgUp_Down.uploadImage(input.getProductImg()).get().getResponseData().getImageUrl();
                input.setImageURL(url);
            } catch (Exception e) {
                return new Response(false, "Error occurred while uploading image");
            }
        }
        Product product = productDAO.getProductbyId(input.getProductId());
        if (product == null){
            return new Response(false, "Product not found");
        }
        else {
            productDAO.updateProduct(input.toProduct(product));
            return new Response(true);
        }
    }

}
