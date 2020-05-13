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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            <%--role = "<%= session.getAttribute("role")%>";--%>
            role = "${role}";
            if (role === "ADMIN") {
                $('.adminTools').show()
            } else {
                $('.adminTools').hide()
            }
        });
    </script>
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
            <a class="nav-link adminTools" href="/admin/update_product">Update product</a>
        </li>
        <div id="nav-bar-droplist">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="/personal_cabinet" id="navbarDropdown" role="button">
                    ${name}
                </a>
                <div id="navbarDropdownMenu" class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Bucket (${productsInBucket})</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/logout">Log out</a>
                </div>
            </li>
        </div>
    </ul>

    <p>First name: ${fname}</p><br>
    <p>Last name: ${lname}</p><br>
    <p>Email: ${email}</p><br>
    <form action="/product_list" method="get">
        <input type="submit" value="Menu">
    </form>
<jsp:include page="footer.jsp"/>
</body>
</html>
