<%@ page import="com.example.demo1.Model.Output.SellerProfile" %>
<%@ page import="static com.example.demo1.Util.StaticVariable.getRequestObject" %>
<%@ page import="java.util.Dictionary" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Map<String, String> sellerData = getRequestObject(request,SellerProfile.class.getName());
%>
<button>
    <h5>Seller ID:</h5><br>
    <h6><%=sellerData.get("id")%></h6><br><br>

    <h5>Seller Email:</h5><br>
    <h6><%=sellerData.get("email")%></h6><br><br>

    <h5>Company Name:</h5><br>
    <h6><%=sellerData.get("companyName")%></h6><br><br>

    <h5>Company First Name:</h5><br>
    <h6><%=sellerData.get("contactFName")%></h6><br><br>

    <h5>Company Last Name:</h5><br>
    <h6><%=sellerData.get("contactLName")%></h6><br><br>

    <h5>Company Email:</h5><br>
    <h6><%=sellerData.get("companyEmail")%></h6><br><br>

    <img src="<%=sellerData.get("imageURL")%>">
</button>
