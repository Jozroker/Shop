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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#btn").click(function () {
                let fname = $("#fname").val();
                let lname = $("#lname").val();
                let email = $("#email").val();
                let pass = $("#password").val();
                if (fname === "" || lname === "" || email === "" || pass === "") {
                    alert("Empty fields");
                }
            })
        })
    </script>
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
        #logInButton {
            margin-top: 0;
        }
    </style>
</head>
<body>

    <form id="registrationForm" action="/shop/registration" method="post">
    <div class="registrationFormDiv">
        <div class="form-group">
            <label for="fname">First Name</label>
            <input type="text" class="form-control" id="fname" name="fname">
        </div>
        <div class="form-group">
            <label for="lname">Last Name</label>
            <input type="text" class="form-control" id="lname" name="lname">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="text" class="form-control" id="password" name="password">
        </div>

        <button type="submit" class="btn btn-primary" id="btn" class="btn">Register</button>
    </div>
    </form>
    <form action="/shop/login" method="get">
        <div id="logInButton" class="registrationFormDiv">
            <button type="submit" class="btn btn-primary" class="btn">Log in</button>
        </div>
    </form>
</body>
</html>
