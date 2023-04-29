<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%
    String companyName = request.getParameter("companyName");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Seller Register</title>
</head>
<body>
    <form action="" method="post" enctype="multipart/form-data">

<%--        <label for="companyName">Company Name:</label>--%>
<%--        <input type="text" id="companyName" name="companyName"><br><br>--%>

<%--        <label for="contactFName">Contact First Name:</label>--%>
<%--        <input type="text" id="contactFName" name="contactFName"><br><br>--%>

<%--        <label for="contactLName">Contact Last Name:</label>--%>
<%--        <input type="text" id="contactLName" name="contactLName"><br><br>--%>

<%--        <label for="companyEmail">Company Email:</label>--%>
<%--        <input type="text" id="companyEmail" name="companyEmail"><br><br>--%>

<%--        <label for="companyNumber">Company Number:</label>--%>
<%--        <input type="text" id="companyNumber" name="companyNumber"><br><br>--%>

<%--        <label for="userId">User ID:</label>--%>
<%--        <input type="text" id="userId" name="userId"><br><br>--%>

<%--        <label for="imageURL">Image URL:</label>--%>
<%--        <input type="text" id="imageURL" name="imageURL"><br><br>--%>

<%--        <label for="email">Email:</label>--%>
<%--        <input type="text" id="email" name="email"><br><br>--%>

<%--        <label for="password">Password:</label>--%>
<%--        <input type="password" id="password" name="password"><br><br>--%>

<%--        <label for="zipCode">Zip Code:</label>--%>
<%--        <input type="text" id="zipCode" name="zipCode"><br><br>--%>

<%--        <label for="unit">Unit:</label>--%>
<%--        <input type="text" id="unit" name="unit"><br><br>--%>

<%--        <label for="street">Street:</label>--%>
<%--        <input type="text" id="street" name="street"><br><br>--%>

<%--        <label for="city">City:</label>--%>
<%--        <input type="text" id="city" name="city"><br><br>--%>

<%--        <label for="state">State:</label>--%>
<%--        <input type="text" id="state" name="state"><br><br>--%>

<%--        <label for="country">Country:</label>--%>
<%--        <input type="text" id="country" name="country"><br><br>--%>

        <input type="file" name="file" id="file">

        <input type="submit" value="Submit">
    </form>
<br/>
</body>
</html>