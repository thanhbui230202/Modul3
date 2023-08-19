<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{
            text-align: center;
            color: orangered;
        }
    </style>
</head>
<body>
<h1>Create new Customer</h1>
<form  action="/customer" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <input type="text" name="id"/>
            </td>
        </tr>
        <tr>
            <td>Customer Type</td>
            <td>
                <select name="customerTypeID">
                    <c:forEach items="${customerTypes}" var="c">
                        <option value="${c.customer_type_id}">${c.customer_type_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>
                <input type="date" name="date"/>
            </td>
        </tr>
        <tr>
            <td>Gender</td>
            <td>
                <input type="radio" name="gender" value="male" checked/>Male
                <input type="radio" name="gender" value="female"/>Female
            </td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td><label>
                <input type="text" name="idcard"/>
            </label></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td><label>
                <input type="text" name="phone"/>
            </label></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><label>
                <input type="text" name="email"/>
            </label></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><label>
                <input type="text" name="address"/>
            </label></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add">
            </td>
        </tr>
    </table>
    <input  type="hidden" name="action" value="create_customer">
</form>
</body>
</html>
