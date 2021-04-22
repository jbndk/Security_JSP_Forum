<%@ page import="CupcakeUtil.Initializer" %><%--
  Created by IntelliJ IDEA.
  User: claes
  Date: 16-03-2020
  Time: 10:00
  To change this template use File | Settings | File Templates.
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
<%
        String uID = request.getParameter("email");
        out.print("Welcome "+ uID);
        session.setAttribute("userID",uID);
%>


        <h1>Hej ${sessionScope.email} </h1>
        <br>
        <div class="container"> ${requestScope.selection}</div>
        <br>
        <br>
        <h2>Velkommen til vores forum!</h2>
<br>

<div class="form-group">
        <form name="addpost" action="FrontController" method="POST">
                <input type="hidden" name="target" value="addpost">

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
        <br />
        <input type = "submit" value = "Upload fil" />
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
</th>
</th>


<%@include file="../includes/footer.inc"%>
