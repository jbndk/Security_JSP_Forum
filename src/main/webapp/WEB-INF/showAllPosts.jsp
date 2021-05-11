<%@ page import="DBAccess.PostMapper" %>
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.inc"%>

<div class="container">
    <div class="row">
        <div class="col-5">

            <nav class="navbar navbar-light bg-light">

                <form class="form-inline" name="memberpage" method="post" action="FrontController">
                    <input type="hidden" name="target" value="memberpage">
                    <button class="btn btn-primary" type="submit" name="memberpage">Forsiden</button>
                </form>

                <form class="form-inline" name="newPost" method="post" action="FrontController">
                    <input type="hidden" name="target" value="newPost">
                    <button class="btn btn-primary" type="submit" name="newPost">Nyt indlæg</button>
                </form>

                <form class="form-inline" name="logout" method="post" action="FrontController">
                    <input type="hidden" name="target" value="logout">
                    <button class="btn btn-danger" type="submit" name="logout">Log ud</button>
                </form>
            </nav>
        </div>
    </div>


<br>
<h3>Forum</h3>
<br>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col" style="width: 5%">ID</th>
                <th scope="col" style="width: 15%">Kategori</th>
                <th scope="col" style="width: 45%">Indlæg</th>
                <th scope="col" style="width: 15%">Forfatter</th>
                <th scope="col" style="width: 10%">Fil</th>
                <th scope="col" style="width: 10%">Oprettet</th>

            </tr>
            </thead>

            <tbody>
            <c:forEach var="posts" items="${requestScope.posts}">
                <tr>

                    <td>${posts.postID}</td>
                    <td>${posts.category}</td>
                    <td>${posts.content}</td>
                    <td>${posts.author}</td>
                    <td><a href="${posts.filePath}">Link</a></td>
                    <td>${posts.created}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        
    </div>
</div>
    <%@include file="../includes/footer.inc"%>

