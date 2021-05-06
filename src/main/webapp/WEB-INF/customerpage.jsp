<%@ page import="CupcakeUtil.Initializer" %><%--
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>
<%@page import="java.text.DecimalFormat" %>

<%
        if (request.getServletContext().getAttribute("categories") == null) {
                request.getServletContext().setAttribute("categories", Initializer.getCategories());
        }
%>

<div class="container">
        <div class="row">
        <div class="col-5">

        <nav class="navbar navbar-light bg-light">
                <form class="form-inline" name="newPost" method="post" action="FrontController">
                        <input type="hidden" name="target" value="newPost">
                        <button class="btn btn-primary" type="submit" name="newPost">Nyt indlæg</button>
                        <p>  </p>
                </form>
                <form class="form-inline" name="showAllPosts" method="post" action="FrontController">
                        <input type="hidden" name="target" value="showAllPosts">
                        <button class="btn btn-primary" type="submit" name="showAllPosts">Alle indlæg</button>
                </form>

                <form class="form-inline" name="logout" method="post" action="FrontController">
                        <input type="hidden" name="target" value="logout">
                        <button class="btn btn-danger" type="submit" name="logout">Log ud</button>
                </form>
        </nav>
        </div>
        </div>

                <br>
                <br>
<h3>Du er logget ind som:  ${sessionScope.email} </h3>
<br>
<div class="container"> ${requestScope.selection}</div>
</div>
<%@include file="../includes/footer.inc"%>