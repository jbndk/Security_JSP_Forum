<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc" %>
<%@page import="java.text.DecimalFormat" %>
<%
    String uID = request.getParameter("email");
    out.print("Welcome " + uID);
    session.setAttribute("userID", uID);
%>


<h1>Hej ${sessionScope.email} </h1>
<br>
<br>
<br>
<h2>Velkommen til upload funktionen</h2>
<br>
<div class="form-group">
    <div>Apache FileUpload</div>
    <form method="post" action="FrontController" enctype="multipart/form-data">
        <input type="hidden" name="target" value="uploadServlet2">
        Choose a file: <input type="file" name="uploadFile"/><input type="submit" value="Upload"/>
    </form>

    <br>
    <br>
    <div class="text-center">
        <a href="FrontController?target=redirect&destination=memberpage">Lav nyt indlæg</a>
    </div>
    <br>
    <br>
    <br>
    <br>
    <form name="logout" method="post" action="FrontController">
        <input type="hidden" name="target" value="logout">
        <input id="logout" type="submit" name="logout" value="Log ud">
    </form>
    <p>"${requestScope.message}"</p>
</div>

<%@include file="../includes/footer.inc" %>