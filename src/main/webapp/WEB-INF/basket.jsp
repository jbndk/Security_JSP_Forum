<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>
<head>
    <title>Basket</title>
</head>


<h1>Hej ${sessionScope.email} </h1>
<div class="container">
<div class="row">
    <div class="col-sm-2">
        <table class="table">
            <thead>
            <tr>
                <th scope="col"></th>
                <th scope="col">Topping</th>
                <th scope="col">Bottom</th>
                <th scope="col">Antal</th>
                <th scope="col">Pris</th>
                <th scope="col">Slet</th>
                <th></th>


            </tr>
            </thead>
            <tbody>
            <c:forEach var="basket" items="${basket}" varStatus="counter">


            <tr>
                <td><li></li></td>
                    <td>${basket.topping}</td>
                    <td>${basket.bottom}</td>
                    <td>${basket.quantity}</td>
                    <td>${basket.itemPrice}</td>
            <td>

                <form name="delete" action="FrontController" method="POST">
                    <input type="hidden" name="target" value="delete">
                    <input type="hidden" name="counter" value="${counter.index}">

                    <input type="submit" value="Slet vare">
                </form>
            </td>
            </c:forEach>
            </tr>
            </tbody>
        </table>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>
            <div class="mt-4"><h4>Samlet pris:</h4></div>
        </td>

        <td>
            <div class="mt-4"><h4>${sessionScope.total} kr.</div>
        </td>
        <form class="mt-4" name="makeOrder" action="FrontController" method="POST">
            <input type="hidden" name="target" value="makeOrder">
            <input type="hidden" name="userID" value="${sessionScope.userID}">

            <input type="submit" value="Bestil">
        </form>
    </tr>
    </div>


        <%@include file="../includes/footer.inc"%>
