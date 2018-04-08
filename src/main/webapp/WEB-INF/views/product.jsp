<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" pageEncoding="UTF-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src="/webstore/resources/js/controllers.js"></script>
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Product Detail</h1>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${product.productId}.jpg"> </c:url>" alt="image" style="width:100%"/>
        </div>
        <div class="col-md-5">
            </span>
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>Item Code : </strong><span
                    class="label label warning">${product.productId}
            </p>
            <p>
                <strong>category</strong> :
                ${product.category}
            </p>
            <h4>${product.unitPrice}</h4>
            <p ng-controller="cartCtrl">
                <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    Order Now
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span>
                    View Cart
                </a>
            </p>
    </div>
</section>
</body>
</html>