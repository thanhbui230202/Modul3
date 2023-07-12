<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update Product</h1>
    <form method="post">
    <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${product.name}"/></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity" value="${product.quantity}"/></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price"value="${product.price}" /></td>
            </tr>
            <tr>
                <td>Date</td>
                <td><input type="date" name="dateRelease" value="${product.dateRelease}"/></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="${product.description}"/></td>
            </tr>
            <tr>
                <td>Category</td>
                <td><input type="text" name="category" value="${product.category}"/></td>
            </tr>
         </table>
    <input type="submit"  value="update"/>
    </form>
</body>
</html>
