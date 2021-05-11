<%@ page import="Util.Initializer" %><%--
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

                <form class="form-inline" name="memberpage" method="post" action="FrontController">
                    <input type="hidden" name="target" value="memberpage">
                    <button class="btn btn-primary" type="submit" name="memberpage">Forsiden</button>
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
    <form action="FrontController" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="target" value="uploadServlet2">

        <label for="exampleFormControlSelect1">Vælg kategori:</label>
        <select class="form-control" name="category" id="exampleFormControlSelect1" style="width: 350px">
            <c:forEach var="categories" items="${applicationScope.categories}">
                <option value="${categories.category}">${categories.category}</option>
            </c:forEach>

        </select>


        <br>
        <label for="content">Indlæg:</label>
        <br>
        <textarea id="content" name="content" rows="8" cols="50"></textarea>
        <br>
        <br>
        <h5>Upload et billede</h5>
        <i>Tilladte formater: .jpg, .jpeg og .png</i>
        <br>
        <input type="file" name="uploadFile"/>
        <br>
        <br>
        <input class="btn btn-primary" type="submit" name="submit" value="Send"/>


    </form>
</div>
</div>

<%@include file="../includes/footer.inc"%>