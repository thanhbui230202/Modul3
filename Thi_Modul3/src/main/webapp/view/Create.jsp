<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Product</h1>
<form action="/book" method="post">
    <table>
        <tr>
            <td>Ma bệnh án</td>
            <td>
                <input type="text" name="id" value="${


                }"/>
            </td>
        </tr>
        <tr>
            <td>Mã bệnh nhân</td>
            <td>
                <input type="text" name="id1"/>
            </td>
        </tr>
        <tr>
            <td>Tên bệnh nhân</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>

        <tr>
            <td>Ngày nhập viện</td>
            <td>
                <input type="date" name="date1"/>
            </td>
        </tr>
        <tr>
            <td>Ngày ra viện</td>
            <td>
                <input type="date" name="date2"/>
            </td>
        </tr>
        <tr>
            <td>Lý do</td>
            <td>
                <input type="text" name="lydo"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
