<%--
  Created by IntelliJ IDEA.
  User: claes
  Date: 16-03-2020
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h1>Hej ${sessionScope.email} </h1>
<br>
<h2>Velkommen til den interne administrations side, vælg funktion nedenfor.</h2>
<br>
<h3>Indsæt penge på en kundes konto:</h3>
<form name="balance" action="FrontController" method="POST">
    <label for="userID">KundeID:</label>
    <input type="hidden" name="target" value="balance">
    <input id="userID" type="text" name="userID" value="" align="left">
    <label for="beloebTilIndsaettelse">Beløb til indsættelse:</label>
    <input id="beloebTilIndsaettelse" type="text" name="beloebTilIndsaettelse" value="" align="left">
    <input type="submit" value="Indsæt beløb">
</form>

<h3>Se eksisterende kunder</h3>
<form name="showAllCustomers" method="post" action="FrontController">
    <input type="hidden" name="target" value="showAllCustomers">
    <input id="showAllCustomers" type="submit" name="showAllCustomers" value="Vis kunder">
</form>
<br>
<h3>Forum:</h3>
<form name="showAllPosts" method="post" action="FrontController">
    <input type="hidden" name="target" value="showAllPosts">
    <input id="showAllPosts" type="submit" name="showAllOrders" value="Vis indlæg">
</form>

<div class="text-center">
    <a href="FrontController?target=redirect&destination=index">Til forsiden</a>
</div>





<%@include file="../includes/footer.inc"%>