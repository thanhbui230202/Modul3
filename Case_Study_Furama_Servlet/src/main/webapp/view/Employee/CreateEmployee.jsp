<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Product</h1>
<form action="/employee" method="post">
    <table>
        <tr>
            <td>Id</td>
            <td>
                <input type="text" name="id"/>
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td>
                <input type="date" name="date"/>
            </td>
        </tr>
        <tr>
            <td>ID Card</td>
            <td>
                <input type="text" name="idcard"/>
            </td>
            <td>
                <c:if test="${errIdCard != null}">
                    ${errIdCard}
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Salary</td>
            <td><label>
                <input type="text" name="salary"/>
            </label></td>
        </tr>
        <tr>
            <td>Phone number</td>
            <td>
                <input type="text" name="phone"/>
            </td>
            <td>
                <c:if test="${errorPhone != null}"  >
                    ${errorPhone}
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" name="email"/>
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" name="address"/>
            </td>
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
            <td>Education Degree</td>
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
                <input type="submit" value="Add">
            </td>
        </tr>
    </table>
    <input  type="hidden" name="action" value="create_employee">
</form>
</body>
</html>
