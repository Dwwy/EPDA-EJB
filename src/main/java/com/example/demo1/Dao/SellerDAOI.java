package com.example.demo1.Dao;

import com.example.demo1.Model.Seller;

import javax.ejb.Local;
import java.util.List;
@Local
public interface SellerDAOI {
    boolean createSeller(Seller seller);
    boolean updateSeller(Seller seller);
    void deleteSeller(Seller seller);
    List<Seller> getAllSeller();
    Seller getSellerbyId(String id);
    Seller getSellerbyUserID(String id);
}
