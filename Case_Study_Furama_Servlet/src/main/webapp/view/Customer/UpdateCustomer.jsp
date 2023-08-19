<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/customer" method="post" >
    <table>
        <tr>
            <td>Customer Type</td>
            <td>
                <select name="typeID">
                    <c:forEach items="${customerTypes}" var="c">
                        <option value="${c.customer_type_id}">${c.customer_type_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="date" name="name" value="${customer.customer_name}"/></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday" value="${customer.customer_birthday}"/></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="text" name="gender" value="${customer.customer_gender}"/></td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td><input type="text" name="idCard" value="${customer.customer_id_card}"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${customer.customer_phone}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${customer.customer_email}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${customer.customer_address}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
        <input  type="hidden" name="action" value="update_customer">
    </form>
</body>
</html>
