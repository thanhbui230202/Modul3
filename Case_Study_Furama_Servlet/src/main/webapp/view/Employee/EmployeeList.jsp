<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1>List Employee</h1>
<a href="/employee?action=create_employee">Add new employee</a>
<form action="/employee" method="get">
    <div>
        <label> Search name</label>
        <input type="text" name="kw_name">
    </div>
    <input type="submit" value="Search">
    <input type="hidden" name="action" value="search_employee">
</form>
<table class="styled-table">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>ID Card</th>
        <th>Salary</th>
        <th>Phone number</th>
        <th>Email</th>
        <th>Address</th>
        <th>Position</th>
        <th>Education Degree</th>
        <th>Division</th>
        <th>FUNTION</th>
    </tr>
    <c:forEach items="${employees}" var="e">
        <tr>
            <td>${e.employee_id}</td>
            <td>${e.employee_name}</td>
            <td>${e.employee_birthday}</td>
            <td>${e.employee_id_card}</td>
            <td>${e.employee_salary}</td>
            <td>${e.employee_phone}</td>
            <td>${e.employee_email}</td>
            <td>${e.employee_address}</td>
            <td>${e.position.position_name}</td>
            <td>${e.educationDegree.education_name}</td>
            <td>${e.division.division_name}</td>
<%--            <td>${e.username.username}</td>--%>
            <td>
                <a href="/employee?action=view_employee&id=${e.employee_id}">View </a>
                <a href="/employee?action=update_employee&id=${e.employee_id}">Update</a>
                <a href="/employee?action=delete_employee&id=${e.employee_id}">Delete </a>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>
