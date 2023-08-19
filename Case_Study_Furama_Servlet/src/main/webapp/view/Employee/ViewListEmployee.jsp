<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Details</title>
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
        <td>Birthday</td>
        <td>ID Card</td>
        <td>Salary</td>
        <td>Phone Number</td>
        <td>Email</td>
        <td>Address</td>
        <td>Position</td>
        <td>Education Degree</td>
        <td>Division</td>
    </tr>
    <tr>
        <td>${employee.employee_id}</td>
        <td>${employee.employee_name}</td>
        <td>${employee.employee_birthday}</td>
        <td>${employee.employee_id_card}</td>
        <td>${employee.employee_salary}</td>
        <td>${employee.employee_phone}</td>
        <td>${employee.employee_email}</td>
        <td>${employee.employee_address}</td>
        <td>${employee.position.position_name}</td>
        <td>${employee.educationDegree.education_name}</td>
        <td>${employee.division.division_name}</td>
</table>
</body>
</html>
