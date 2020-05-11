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
    <title>Log in</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <script>
        $(document).ready(function () {

                $('#exampleInputEmail1').on('keyup', function() {
                    let thisEmpty = false;
                    let otherEmpty = $("#exampleInputPassword1").val().length === 0;

                    $('#exampleInputEmail1').each(function() {
                        thisEmpty = $(this).val().length === 0;

                    });

                    if (thisEmpty || otherEmpty)
                        $('#btn').attr('disabled', 'disabled');
                    else
                        $('#btn').attr('disabled', false);
                });

            $('#exampleInputPassword1').on('keyup', function() {
                let thisEmpty = false;
                let otherEmpty = $("#exampleInputEmail1").val().length === 0;

                $('#exampleInputPassword1').each(function() {
                    thisEmpty = $(this).val().length === 0;

                });

                if (thisEmpty || otherEmpty)
                    $('#btn').attr('disabled', 'disabled');
                else
                    $('#btn').attr('disabled', false);
            });

            $('#exampleInputEmail1').blur(function () {
                if (!checkFields) {
                    $('#btn').attr('disabled', 'disabled');
                }
            });

            $('#exampleInputPassword1').blur(function () {
                if (!checkFields) {
                    $('#btn').attr('disabled', 'disabled');
                }
            });

            function checkFields() {
                let thisEmpty = $('#exampleInputEmail1').val().length !== 0;
                let otherEmpty = $('#exampleInputPassword1').val().length !== 0;
                return thisEmpty & otherEmpty;
            }
                // $("#exampleInputEmail2").on('input keyup', function () {
                //     if ($("#exampleInputEmail2").val() !== "") {
                //         if ($("#exampleInputEmail1").val() !== "") {
                //             $("#btn").removeAttr("disabled");
                //         }
                //     }
                // });

                $("#btn").click(function () {
                    if ($("#exampleInputEmail1").val() === '') {
                        $("#exampleInputEmail1").style.borderColor = 'red';
                    } else {
                        let email = $("#exampleInputEmail1").val();
                        sessionStorage.setItem("email", email);
                    }
                })
            }
        );
    </script>
<%--    <script type="application/javascript" src="resources/javascript/createProductScript.js"></script>--%>
    <style type="text/css">
        #loginFormDiv {
            margin-left: 40%;
            margin-top: 5%;
        }
        .form-control {
            width: 30%;
        }
        #buttons {
            width: 30%;
            text-align: center;
        }
    </style>
</head>
<body>
<%--    <form id="loginForm" action="/shop/login" method="post"></form>--%>

<%--    <form id="registerForm" action="/shop/registration" method="get">&ndash;%&gt;--%>

<%--        &lt;%&ndash;            <button type="submit" class="btn btn-primary">Register</button>&ndash;%&gt;--%>
<%--    </form>--%>

<%--    <label for="email">Email:</label><br>--%>
<%--    <input form="loginForm" type="text" id="email" name="email"><br>--%>
<%--    <label for="password">Password:</label><br>--%>
<%--    <input form="loginForm" type="password" id="password" name="password"><br><br>--%>
<%--    <input form="loginForm" id="btn" type="submit" value="Log in" >--%>

<%--    <input form="registerForm" type="submit" value="Register">--%>
<%--action="/shop/login"--%>
    <form id="loginForm" action="/login" method="post"></form>
    <form id="registerForm" action="/registration" method="get"></form>
    <div id="loginFormDiv">
        <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input form="loginForm" type="email" class="form-control" id="exampleInputEmail1" name="email" aria-describedby="emailHelp">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input form="loginForm" type="password" class="form-control" id="exampleInputPassword1" name="password">
        </div>
        <div id="buttons">
            <button form="loginForm" type="submit" class="btn btn-primary" id="btn" disabled="disabled">Log in</button>
            <button form="registerForm" type="submit" class="btn btn-primary">Register</button>
        </div>
    </div>

    <%--                        <input type="submit" value="Register">--%>



</body>
</html>
