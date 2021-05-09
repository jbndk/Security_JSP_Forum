<%@ page import="DBAccess.UserMapper" %>
<%@ page import="FunctionLayer.LoginSampleException" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>


<h2>Hej ${sessionScope.email}</h2>
<br>
<h3>Her er en oversigt over alle medlemmer:</h3>
<br>

<div class="row">
    <div class="col-sm">
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Email</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="member" items="${requestScope.memberList}">
                <td>${member.email}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>

    <%@include file="../includes/footer.inc"%>
