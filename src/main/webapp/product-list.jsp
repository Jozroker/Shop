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
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            role = "<%= session.getAttribute("role")%>"
            if (role === "ADMIN") {
                $('.adminTools').show()
            } else {
                $('.adminTools').hide()
            }
        });
    </script>
    <style type="text/css">
        #nav-bar-droplist{
            /*position: relative;*/
            /*left: 60%;*/
            position: absolute;
            right: 10px;
        }
    </style>
</head>
<body>

    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="#">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link adminTools" href="#">Create product</a>
        </li>
        <li class="nav-item">
            <a class="nav-link adminTools" href="#">Update product</a>
        </li>
        <div id="nav-bar-droplist">
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
        </li>
        </div>
    </ul>

        <table>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Count</th>
            <c:forEach items="${products}" var="products">
                <tr>
                    <td>${products.id}</td>
                    <td>${products.name}</td>
                    <td>${products.description}</td>
                    <td>${products.price}</td>
                    <td>${products.count}</td>
                </tr>
            </c:forEach>
        </table>


</body>
</html>
