<%--
  Created by IntelliJ IDEA.
  User: Jozroker
  Date: 30.04.2020
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%--    <script>--%>
<%--        $(document).ready(function () {--%>
<%--            $("#btn").click(function () {--%>
<%--                let fname = $("#fname").val();--%>
<%--                let lname = $("#lname").val();--%>
<%--                let email = $("#email").val();--%>
<%--                let pass = $("#password").val();--%>
<%--                if (fname === "" || lname === "" || email === "" || pass === "") {--%>
<%--                    alert("Empty fields");--%>
<%--                }--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
<%--    <style type="text/css">--%>
<%--        .registrationFormDiv {--%>
<%--            margin-left: 40%;--%>
<%--            margin-top: 5%;--%>
<%--        }--%>
<%--        .form-control {--%>
<%--            width: 30%;--%>
<%--        }--%>
<%--        .btn {--%>
<%--            width: 30%;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--        #logInButton {--%>
<%--            margin-top: 0;--%>
<%--        }--%>
<%--    </style>--%>
</head>
<body>


        <table>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <c:forEach items="${products}" var="products">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </table>


</body>
</html>
