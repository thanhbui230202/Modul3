<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    <table class="styled-table">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Date Release</td>
            <td>Description</td>
            <td>Category</td>
        </tr>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.quantity}</td>
            <td>${product.price}</td>
            <td>${product.dateRelease}</td>
            <td>${product.description}</td>
            <td>${product.category}</td>
        </tr>
    </table>
</body>
</html>
