<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>
<h1>Hej ${sessionScope.email} </h1>


${requestScope.besked}

<div class="text-center">
    <a href="FrontController?target=redirect&destination=employeepage">Til medarbejdersiden</a>
</div>

<%@include file="../includes/footer.inc"%>