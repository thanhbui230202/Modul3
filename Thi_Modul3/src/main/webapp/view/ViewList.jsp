<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View List</title>
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
<h1>Danh sách bệnh án</h1>
<table class="styled-table">
    <thead>
    <tr>
        <td>Mã bệnh án</td>
        <td>Mã bệnh nhân</td>
        <td>Tên bệnh nhân</td>
        <td>Ngày nhập viện</td>
        <td>Ngày ra viện</td>
        <td>Lý do nhập viện</td>
        <td>Tác vụ</td>
    </tr>
    <c:forEach items="${bang}" var="b">
        <tr>
            <td>${b.maBenhNhan}</td>
            <td>${b.maBenhAn.tenBenhAn}</td>
            <td>${b.tenBenhNhan}</td>
            <td>${b.dateBegin}</td>
            <td>${b.dateEnd}</td>
            <td>${b.lyDo}</td>
            <td>
                <a href="/book?action=update_benh&id=${b.maBenhNhan}">Sửa </a>
                <a href="/book?action=delete_benh&id=${b.maBenhNhan}">Xóa </a>
            </td>
        </tr>
    </c:forEach>
    </thead>
</table>
</body>
</html>

