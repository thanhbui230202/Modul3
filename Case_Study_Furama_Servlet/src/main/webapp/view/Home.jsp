<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web Layout Example</title>
    <style>
        /* Basic styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
        }
        nav {
            background-color: #f1f1f1;
            padding: 10px;
            text-align: center;
        }
        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        nav ul li {
            margin-right: 10px;
        }
        nav ul li a {
            text-decoration: none;
            color: #333;
            padding: 5px;
        }
        footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        .left-nav {
            background-color: #f1f1f1;
            padding: 10px;
            text-align: center;
        }
        .left-nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
        .left-nav ul li {
            margin-bottom: 10px;
        }
        .left-nav ul li a {
            text-decoration: none;
            color: #333;
            padding: 5px;
        }
        .search-container {
            display: flex;
            align-items: center;
        }
        .search-input {
            width: 200px;
            padding: 5px;
        }
        .search-icon {
            margin-left: 10px;
            color: #333;
            cursor: pointer;
        }
    </style>
</head>
<body>
<header>
    <div class="container">
        <h1>Website Header</h1>
    </div>
</header>

<div class="container">
    <nav>
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="/employee?action=list_employee">Employee</a></li>
            <li><a href="/customer?action=list_customer">Customer</a></li>
            <li><a href="#">Service</a></li>
            <li><a href="#">Contract</a></li>
            <li class="search-container">
                <input type="text" class="search-input" placeholder="Search...">
                <span class="search-icon">&#128269;</span>
            </li>
        </ul>
    </nav>
    <!-- Content area goes here -->

</div>

<footer>
    <div class="container">
        <p>&copy; 2023 Your Company. All rights reserved.</p>
    </div>
</footer>
</body>
</html>
