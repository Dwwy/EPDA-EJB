package com.example.demo1.Service;

import com.example.demo1.Dao.ProductDAOI;
import com.example.demo1.Dao.ProductDropDownDAOI;
import com.example.demo1.Dao.SellerDAOI;
import com.example.demo1.Model.Input.ProductDropDownInput;
import com.example.demo1.Model.ProductDropDown;
import com.example.demo1.Model.UpdateInput.ProductDropDownUpdate;
import com.example.demo1.response.Response;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
@Stateless
public class ProductDropDownBL implements ProductDropDownBLI{
    @EJB
    SellerDAOI sellerDAO;
    @EJB
    ProductDAOI productDAO;
    @EJB
    ProductDropDownDAOI productDropDownDAO;
    public Response createProductDropDown(ProductDropDownInput input){
        ProductDropDown productDropDown = productDropDownDAO.createProductDropDown(input.toProductDropDown());
        if (productDropDown != null){
            return new Response(productDropDown);
        }
        else {
            return new Response(false, "Error occurred while creating product subcategory");
        }
    }

    public List<ProductDropDown> getProductDropDownbyProductId (String productId){
        return productDropDownDAO.getAllProductDropDownbyProductId(productId);
    }
    public Response update(ProductDropDownUpdate input){
        ProductDropDown productDropDown = productDropDownDAO.getProductDropDownbyId(input.getProductDropDownId());
        if (productDropDown == null){
            return new Response(false, "Address not found");
        }
        else {
            productDropDownDAO.updateProductDropDown(input.toProductDropDown(productDropDown));
            return new Response(true);
        }
    }

}
