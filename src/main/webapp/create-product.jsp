<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/resources/javascript/createProductScript.js"></script>
    <style type="text/css">
        .registrationFormDiv {
            margin-left: 40%;
            margin-top: 5%;
        }
        .form-control {
            width: 30%;
        }
        .btn {
            width: 30%;
            text-align: center;
        }
        #create {
            margin-top: 0;
        }
    </style>
</head>
<body>

    <form id="create_product" action="/admin/create_products" method="post">
    <div class="registrationFormDiv">
        <h3>Create new product</h3>
        <div class="form-group">
            <label id="nameLabel" for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label id="descriptionLabel" for="description">Description</label>
            <input type="text" class="form-control" id="description" name="description">
        </div>
        <div class="form-group">
            <label id="priceLabel" for="price">Price</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <button class="btn btn-primary" id="create" class="btn">Create</button>

    </div>
    </form>

</body>
</html>
