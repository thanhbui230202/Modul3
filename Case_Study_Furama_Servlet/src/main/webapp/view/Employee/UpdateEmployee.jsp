<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
    <form action="/employee" method="post" >
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${employee.employee_name}"/></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="date" name="date" value="${employee.employee_birthday}"/></td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td><input type="text" name="idCard" value="${employee.employee_id_card}"/></td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><input type="text" name="salary" value="${employee.employee_salary}"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="${employee.employee_phone}"/></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${employee.employee_email}"/></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><input type="text" name="address" value="${employee.employee_address}"/></td>
        </tr>
        <tr>
            <td>Position</td>
            <td>
                <select name="positionId">
                    <c:forEach items="${positions}" var="p">
                        <option value="${p.position_id}">${p.position_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Education</td>
            <td>
                <select name="educationId">
                    <c:forEach items="${educations}" var="e">
                    <option value="${e.education_id}">${e.education_name}</option>
                    </c:forEach>
            </td>
        </tr>
        <tr>
            <td>Division</td>
            <td>
                <select name="divisionId">
                    <c:forEach items="${divisions}" var="d">
                        <option value="${d.division_id}">${d.division_name}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update">
            </td>
        </tr>
    </table>
        <input  type="hidden" name="action" value="update_employee">
    </form>
</body>
</html>
