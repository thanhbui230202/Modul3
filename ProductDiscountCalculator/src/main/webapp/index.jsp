<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Discount Calculator</title>
</head>
<body>
<form action="/DiscountCalculator" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="DES"><br/>
    <label>List Price: </label><br/>
    <input type="text" name="price" placeholder="List Price" value="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="percent" placeholder="Discount Percent" value="0"/><br/>
    <input type = "submit" id = "submit" value = "calculator"/>
</form>
</body>
</html>