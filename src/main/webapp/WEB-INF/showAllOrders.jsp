<%@ page import="DBAccess.OrderMapper" %>
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>

<br>
<h3>Forum</h3>
<br>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Kategori</th>
                <th scope="col">Indlæg</th>
                <th scope="col">Forfatter</th>
                <th scope="col">Oprettet</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach var="posts" items="${requestScope.posts}">
                <tr>

                    <td>${posts.postID}</td>
                    <td>${posts.category}</td>
                    <td>${posts.content}</td>
                    <td>${posts.author}</td>
                    <td>${posts.created}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


        <div class="text-center">
            <a href="FrontController?target=redirect&destination=customerpage">Lav indlæg</a>
        </div>
    </div>
    <%@include file="../includes/footer.inc"%>

