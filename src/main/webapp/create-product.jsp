<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/resources/javascript/createProductScript.js"></script>
    <style type="text/css">
        .registrationFormDiv {
            margin-left: 30%;
            margin-top: 5%;
            margin-bottom: 5%;
            width: 40%;
        }
        .btn {
            position: absolute;
            left: 40%;
            width: 20%;
            text-align: center;
            /*margin: auto;*/

        }
        h3 {
            text-align: center;
        }
        #name, #price, #count {
            width: 50%;
        }
        #create {
            margin-top: 0;
        }

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
            <a class="nav-link adminTools active" href="/admin/create_products">Create product</a>
        </li>
        <li class="nav-item">
            <a class="nav-link adminTools" href="/admin/update_product">Update product</a>
        </li>
        <div id="nav-bar-droplist">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/personal_cabinet" id="navbarDropdown" role="button">
                    ${name}
                </a>
                <div id="navbarDropdownMenu" class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/bucket">Bucket (${productsInBucket})</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Log out</a>
                </div>
            </li>
        </div>
    </ul>

    <form id="create_product" action="/admin/create_products" method="post"></form>
    <div class="registrationFormDiv">
        <h3>Create new product</h3>
        <div class="form-group">
            <label id="nameLabel" for="name">Name</label>
            <input form="create_product" type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea form="create_product" class="form-control" id="description" rows="3" name="description"></textarea>
        </div>
        <div class="form-group">
            <label id="priceLabel" for="price">Price</label>
            <input form="create_product" type="text" class="form-control" id="price" name="price">
        </div>
        <div class="form-group">
            <label id="countLabel" for="count">Count</label>
            <input form="create_product" type="text" class="form-control" id="count" name="count">
        </div>
        <button form="create_product" class="btn btn-primary" id="create" class="btn">Create</button>
    </div>

<jsp:include page="footer.jsp"/>
</body>
</html>
