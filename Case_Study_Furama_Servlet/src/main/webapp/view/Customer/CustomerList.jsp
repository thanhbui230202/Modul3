<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <style>
        .styled-table {
            width: 100%;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
            color: #333;
        }

        .styled-table thead th {
            background-color: #00bfff; /* Màu xanh */
            color: #fff; /* Màu chữ trắng */
            border: 1px solid #ddd;
            padding: 8px;
            font-weight: bold;
            text-align: center; /* Canh giữa nội dung trong tiêu đề cột */
        }

        .styled-table tbody td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center; /* Canh giữa nội dung trong ô dữ liệu */
        }

        .styled-table tbody tr:nth-child(even) {
            background-color: #f2f2f2; /* Màu xám */
        }

        .styled-table tbody tr:nth-child(odd) {
            background-color: #fff; /* Màu trắng */
        }

        .styled-table tbody tr:hover {
            background-color: #f5f5f5;
        }
        th,td{
            text-align: center;
        }
        h1{
            text-align: center;
            color: orangered;
        }
    </style>
</head>
<body>
<h1>List Customer</h1>
<a href="/customer?action=create_customer">Add new customer</a>
<table class="styled-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Customer Type</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Gender</th>
        <th>ID Card</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Address</th>
        <th>FUNTION</th>
    </tr>
    <c:forEach items="${customers}" var="c">
        <tr>

            <td>${c.customer_id}</td>
            <td>${c.customer_type.customer_type_name}</td>
            <td>${c.customer_name}</td>
            <td>${c.customer_birthday}</td>
            <td>
                <c:if test="${c.customer_gender == true}">Male</c:if>
                <c:if test="${c.customer_gender == false}">Female</c:if>
            </td>
            <td>${c.customer_id_card}</td>
            <td>${c.customer_phone}</td>
            <td>${c.customer_email}</td>
            <td>${c.customer_address}</td>
            <td>
                <a href="/customer?action=view_customer&id=${c.customer_id}">View </a>
                <a href="/customer?action=update_customer&id=${c.customer_id}">Update</a>
                <a href="/customer?action=delete_customer&id=${c.customer_id}">Delete </a>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
