<%--
  Created by IntelliJ IDEA.
  User: Jozroker
  Date: 30.04.2020
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
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
    <style type="text/css">
        #nav-bar-droplist{
            position: absolute;
            right: 10px;
        }

        .dropdown:hover #navbarDropdownMenu {
            display: block;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="/product_list">Products</a>
        </li>
        <%--        <li class="nav-item">--%>
        <%--            <a class="nav-link" href="#">Products</a>--%>
        <%--        </li>--%>
        <li class="nav-item">
            <a class="nav-link adminTools" href="/admin/create_products">Create product</a>
        </li>
        <li class="nav-item">
            <a class="nav-link adminTools active" href="/admin/update_product">Update product</a>
        </li>
        <div id="nav-bar-droplist">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/personal_cabinet" id="navbarDropdown" role="button">
                    ${name}
                </a>
                <div id="navbarDropdownMenu" class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">View bucket</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Log out</a>
                </div>
            </li>
        </div>
    </ul>

    <form id="update" action="/admin/update_product" method="post">
    <div class="registrationFormDiv">
        <h3>Update product</h3>
        <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id" name="id">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>

        <button type="submit" class="btn btn-primary" id="create" class="btn">Update</button>
    </div>
    </form>
    <form action="/login" method="get">
        <div id="logInButton" class="registrationFormDiv">
            <button type="submit" class="btn btn-primary" class="btn">Log in</button>
        </div>
    </form>
    <jsp:include page="footer.jsp"/>
</body>
</html>
