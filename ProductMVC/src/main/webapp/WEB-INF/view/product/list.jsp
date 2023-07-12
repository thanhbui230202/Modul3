<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
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
    </style>
</head>
<body>
    <h1>List product</h1>
    <a href="/product?action=create">Add new product</a>
    <table class="styled-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Date Release</th>
        <th>Description</th>
        <th>Category</th>
        <th>Function</th>
    </tr>
    <c:forEach items="${products}" var="p">
    <tr>

            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.quantity}</td>
            <td>${p.price}</td>
            <td>${p.dateRelease}</td>
            <td>${p.description}</td>
            <td>${p.category}</td>
            <td>
            <a href="/product?action=view&id=${p.id}">View </a>
            <a href="/product?action=update&id=${p.id}">Update</a>
            <a href="/product?action=delete&id=${p.id}">Delete </a>
            </td>
    </tr>
    </c:forEach>
    </thead>
    </table>
</body>
</html>
