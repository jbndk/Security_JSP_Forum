<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<head>
    <title>Indlæg tilføjet</title>
</head>

<h1>Hej ${sessionScope.email} </h1>

<h1>Dit indlæg er nu tilføjet vores forum!</h1>

<div class="text-center">
    <a href="FrontController?target=redirect&destination=customerpage">Lav nyt indlæg</a>
</div>
<br>
<form name="memberpage" method="post" action="FrontController">
    <input type="hidden" name="target" value="memberpage">
    <input id="memberpage" type="submit" name="memberpage" value="Til forsiden">
</form>

<%@include file="../includes/footer.inc"%>