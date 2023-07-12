<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer List - JSTL</h1>
<table>
    <tr>
        <th>Name</th>
        <th>Date</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach items="${customerList}" var="c">
    <tr>
        <td>${c.name}</td>
        <td>${c.date}</td>
        <td>${c.address}</td>
        <td><img src="${c.image}" style="max-width: 50px"></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
