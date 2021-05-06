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

                <form class="form-inline" name="customerpage" method="post" action="FrontController">
                    <input type="hidden" name="target" value="customerpage">
                    <button class="btn btn-primary" type="submit" name="customerpage">Forsiden</button>
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
<h2>Opret nyt indlæg:</h2>
<br>

<div class="form-group">
    <form name="uploadServlet" action="FrontController" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="target" value="uploadServlet">

        <label for="exampleFormControlSelect1">Vælg kategori:</label>
        <select class="form-control" name="category" id="exampleFormControlSelect1" style="width: 350px">
            <c:forEach var="categories" items="${applicationScope.categories}">
                <option value="${categories.category}">${categories.category}</option>
            </c:forEach>

        </select>


        <div class="form-group">
            <label for="content">Indlæg:</label>
            <br>
            <textarea id="content" name="content" rows="8" cols="50">
        </textarea>
        </div>

        <div class="form-group">
            <input type = "file" name = "file" size = "50" />
        </div>


        </th>
        <br>

        <th>
            <div class="container">
                <input class="btn btn-primary" type="submit" name="submit" value="Send"/>
            </div>

        <th>
    </form>
    <br>
    <h3>Forum:</h3>
    <form name="showAllPosts" method="post" action="FrontController">
        <input type="hidden" name="target" value="showAllPosts">
        <input id="showAllPosts" type="submit" name="showAllOrders" value="Vis indlæg">
    </form>
    <br>
    <br>
    <br>
    <br>
    <form name="logout" method="post" action="FrontController">
        <input type="hidden" name="target" value="logout">
        <input id="logout" type="submit" name="logout" value="Log ud">
    </form>
    </th>
    </th>

<%@include file="../includes/footer.inc"%>