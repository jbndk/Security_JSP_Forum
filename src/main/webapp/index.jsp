<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/header.inc"%>
    <h1 class="mt-4 text-center">Velkommen til Olsker Cupcakes</h1>
<h3 class="text-left">Log ind:</h3>

<form name="login" action="FrontController" method="POST">


    <input type="hidden" name="target" value="login">

    <label for="email">Email:</label>
    <input id="email" type="text" name="email" value="" align="left">


    <label for="password">Password:</label>
    <input id="password" type="text" name="password" value="" align="left">
    </tr>

    <input type="submit" value="Log ind">

</form>


    <br>
    <h3 class="text-left">Opret bruger:</h3>
    <form name="register" action="FrontController" method="POST">
        <input type="hidden" name="target" value="newcustomer">
        Email: <input type="text" name="email" value="">
        Kodeord: <input type="password" name="password1" value="">
        Gentag kodeord:
        <input type="password" name="password2" value="">
        <input type="submit" value="Opret bruger">
    </form>
</div>
<%@include file="includes/footer.inc"%>
