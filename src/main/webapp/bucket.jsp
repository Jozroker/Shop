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
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="resources/javascript/bucketChangeCount.js"></script>
    <script>
        $(document).ready(function () {
            <%--role = "<%= session.getAttribute("role")%>";--%>
            <%--sessionStorage.setItem('productsInBucket', ${productsInBucket});--%>

            role = "${role}";
            if (role === "ADMIN") {
                $('.adminTools').show()
            } else {
                $('.adminTools').hide()
            }

            if ($('#empty').show()) {
                $('#empty').change(function () {
                    this.style.textAlign = 'center';
                }).trigger('change');
                $('.mb-3').change(function () {
                    this.style.maxWidth = '100%';
                }).trigger('change');
                // $('#empty').style.textAlign = 'center';
                // $('.mb-3').style.width = '100%';
            }

            // $('#test').change(function () {
                //             this.style.display = "block"
                //         }).trigger('change');

            // $('#navbarDropdown').on('focus', function () {
            //     $('#test').show();
            // })
            // $('#navbarDropdown').hover(function () {
            //     if ($('#test').is(':visible')) {
            //         alert('1')
            //     } else {
            //         $('#test').change(function () {
            //             this.style.display = "block"
            //         }).trigger('change');
            //         $('#test').show()
            //     }
            // })
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

        #close {
            position: absolute;
            right: 10px;
        }

        .mb-3 .row {
            margin: 20px;
        }



        /*.card {*/
        /*    margin: 5px;*/
        /*}*/

    </style>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="/product_list">Products</a>
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
                <a id="bucket-count" class="dropdown-item" href="/bucket">Bucket (${productsInBucket})</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/logout">Log out</a>
            </div>
        </li>
        </div>
    </ul>

<%--    <div id="card-deck" class="row">--%>
<%--        <c:forEach items="${products}" var="products">--%>
<%--            <div class="col-sm-3">--%>
<%--                <div class="card mb-3">--%>
<%--                    <img src="/resources/image/no-image.png" class="card-img-top" alt="product image">--%>
<%--                    <div class="card-body">--%>
<%--                        <h5 class="card-title">${products.name}</h5>--%>
<%--                        <p class="card-text">${products.description}</p>--%>
<%--                        <p id="price" class="card-text">${products.price} $</p>--%>
<%--                        <img id="basket${products.id}" class="float-right" width="30px" height="30px"--%>
<%--                             src="/resources/image/basket.png" alt="basket icon" onclick="buyNow(${products.id}, ${productsInBucket})"/>--%>
<%--&lt;%&ndash;                            ${productsInBucket} = sessionStorage.getItem('productsInBucket')&ndash;%&gt;--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
        <div class="card mb-3" style="max-width: 90%;">
            <c:if test="${empty products}">
                <h2 id="empty">Bucket is empty</h2>
            </c:if>
            <c:forEach items="${products}" var="entry">
                <div class="row no-gutters">
                    <div class="col-md-3">
                        <img src="/resources/image/no-image.png" class="card-img" alt="product image">
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <h5 class="card-title">${entry.key.name}</h5>
                            <p class="card-text">${entry.key.description}</p>
                            <p class="card-text"><small class="text-muted">Price: ${entry.key.price}</small></p>
                            <p class="card-text"><small class="text-muted">Count:
                                <button id="minus" type="button" class="btn btn-primary" onclick="subtract(${bucketId}, ${entry.key.id})">-</button>
                                <span id="count${entry.key.id}">${entry.value}</span>
                                <button id="plus" type="button" class="btn btn-primary" onclick="add(${bucketId}, ${entry.key.id})">+</button>
                            </small></p>
                        </div>
                    </div>
                    <button type="button" id="close" class="close" aria-label="Close" onclick="remove(${bucketId}, ${entry.key.id})">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:forEach>
        </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
