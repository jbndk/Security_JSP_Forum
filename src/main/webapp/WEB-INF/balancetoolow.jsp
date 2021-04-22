<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<head>
    <title>Betaling fejlede!</title>
</head>

<h2>Hej ${sessionScope.email} </h2>
<br>
<br>
<br>

<h2> Der er ikke penge nok på din konto.</h2>
<br>
<h2>Henvend dig til personalet for at betale.</h2>
<br>
<br>

<div class="text-center">
    <a href="FrontController?target=redirect&destination=customerpage">Lav ny bestilling</a>
</div>


<%@include file="../includes/footer.inc"%>