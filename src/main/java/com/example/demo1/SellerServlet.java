package com.example.demo1;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

import com.example.demo1.Model.Input.SellerInput;
import com.example.demo1.Model.Output.SellerProfile;
import com.example.demo1.Model.Seller;
import com.example.demo1.Service.SellerBL;
import com.example.demo1.Service.SellerBLI;
import com.example.demo1.Service.UserBLI;
import com.example.demo1.Util.ImgUp_Down;
import com.example.demo1.Util.StaticVariable;
import com.example.demo1.response.OptionalResponse;
import com.example.demo1.response.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@MultipartConfig
@WebServlet(name = "SellerServlet", value = "/seller/*")
public class SellerServlet extends HttpServlet {
    private SellerBL sellerBL;

    public void init(){
        sellerBL = new SellerBL();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id= request.getPathInfo();

        if (id ==null){
            RequestDispatcher rd =  getServletContext().getRequestDispatcher("/WEB-INF/sellerInfoPage.jsp");
            rd.forward(request,response);
            return;
        }

        if (id.equals("/all")){
            request.getRequestDispatcher("/WEB-INF/allSellerPage.jsp").forward(request,response);
            return;
        }

        if (id.equals("/register")){
            request.getRequestDispatcher("/WEB-INF/sellerRegisterPage.jsp").forward(request,response);
            return;
        }

        if (id.equals("/")) {
            List<SellerProfile> data = sellerBL.getAllSellerProfile();
            ObjectMapper mapper = new ObjectMapper();
            String jsonData  =mapper.writeValueAsString(data);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonData);
            return;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get seller details from request parameters
//        SellerInput newSeller = new SellerInput();
//
//        newSeller.setCompanyName(request.getParameter("companyName"));
//        newSeller.setContactFName(request.getParameter("contactFName"));
//        newSeller.setContactLName(request.getParameter("contactLName"));
//        newSeller.setCompanyEmail(request.getParameter("companyEmail"));
//        newSeller.setCompanyNumber(request.getParameter("companyNumber"));
//        newSeller.setUserId(request.getParameter("userId"));
//        newSeller.setImageURL(request.getParameter("imageURL"));
//        newSeller.setEmail(request.getParameter("email"));
//        newSeller.setPassword(request.getParameter("password"));
//        newSeller.setCompanyImage(new InputStream() {
//            @Override
//            public int read() throws IOException {
//                return 0;
//            }
//        });
//        newSeller.setZipCode(request.getParameter("zipCode"));
//        newSeller.setUnit(request.getParameter("unit"));
//        newSeller.setStreet(request.getParameter("street"));
//        newSeller.setCity(request.getParameter("city"));
//        newSeller.setState(request.getParameter("state"));
//        newSeller.setCountry(request.getParameter("country"));
//
//        Response res =  sellerBL.register(newSeller);
//        response.sendRedirect(request.getContextPath() + "/seller/"+newSeller.getUserId());
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        String url = ImgUp_Down.uploadImage(fileContent).get().getResponseData().getImageUrl();
        System.out.println("Image URL: " + url);
        request.getRequestDispatcher(url).forward(request,response);
    }
}
