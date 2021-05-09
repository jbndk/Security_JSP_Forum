
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<h2>Hej ${sessionScope.email} </h2>
<br>
<h2>Velkommen til admin siden!</h2>
<br>

<h3>Se eksisterende medlemmer</h3>
<form name="showAllMembers" method="post" action="FrontController">
    <input type="hidden" name="target" value="showAllMembers">
    <input id="showAllMembers" type="submit" name="showAllMembers" value="Vis medlemmer">
</form>
<br>

<%@include file="../includes/footer.inc"%>