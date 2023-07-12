<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Create new Product</h1>
    <form  method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="text" name="quantity"/></td>
            </tr>
            <tr>
               <td>Price</td>
                <td><input type="text" name="price"/></td>
            </tr>
            <tr>
               <td>Date</td>
                <td><input type="date" name="dateRelease"/></td>
<%--                placeholder="dd/MM/yyyy"--%>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description"/></td>
            </tr>
            <tr>
             <td>Category</td>
                <td><input type="text" name="category"/></td>
            </tr>
        </table>
        <input type="submit"  value="create">
    </form>
</body>
</html>
