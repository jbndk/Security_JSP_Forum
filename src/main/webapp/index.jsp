<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/header.inc"%>
    <h1 class="mt-4 text-left">Velkommen!</h1>
<br>
<h4 class="text-left">Log ind:</h4>
<script src="https://www.google.com/recaptcha/api.js"></script>

<form name="login" action="FrontController" method="POST">


    <input type="hidden" name="target" value="login">

    <label for="email">Email:</label>
    <input id="email" type="text" name="email" value="" align="left">


    <label for="password">Password:</label>
    <input id="password" type="password" name="password" value="" align="left">
    <div class="g-recaptcha"
         data-sitekey="6LfGwsUaAAAAAEN3odtofvdC0EdjCPddtvnkCNlY"></div>

    <input type="submit" value="Log ind">
    <br>
    <br>
    <hr>
</form>

    <h4 class="text-left">Opret bruger:</h4>
    <form name="register" action="FrontController" method="POST">
        <input type="hidden" name="target" value="newuser">
        Email: <input type="email" name="email" value="">
        Kodeord: <input type="password" name="password1" value="">
        Gentag kodeord:
        <input type="password" name="password2" value="">
        <br><br>
        <input type="submit" value="Opret bruger">
    </form>
<br>
<p>${requestScope.message}</p>
<br>
<h5>Regler for passwords:</h5>
<i>
- Password must be less than 20 and more than 8 characters in length.<br>
- Password must have at least one uppercase character<br>
- Password must have at least one number<br>
    - Password must have at least one special character among @#$%!<br>
</i>
<br>
<%@include file="includes/footer.inc"%>
