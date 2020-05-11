<%--
  Created by IntelliJ IDEA.
  User: Jozroker
  Date: 01.05.2020
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personal Cabinet</title>
</head>
<body>
    <p>First name: ${fname}</p><br>
    <p>Last name: ${lname}</p><br>
    <p>Email: ${email}</p><br>
    <form action="/product_list" method="get">
        <input type="submit" value="Menu">
    </form>
</body>
</html>
