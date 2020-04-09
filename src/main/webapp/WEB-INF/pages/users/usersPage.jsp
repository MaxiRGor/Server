
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Users</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 15px;
        }
    </style>
</head>
<body>
<c:url value="/" var="mainPage"/>
<h3>
    <a href="${mainPage}">Main Page</a>
</h3>
<h1>
    Users
</h1>
<c:if test="${usersCount>0}">
    <table>
        <tr>
            <th>Id</th>
            <th>Nickname</th>
            <th>Device Id</th>
            <th>Active Leader Board Id</th>
            <th>Past Leader Board Id</th>
            <th>High Score</th>
            <th>Coins Amount</th>
            <th>Crystals Amount</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.nickname}</td>
                <td>${user.deviceId}</td>
                <td>${user.activeLeaderBoard.id}</td>
                <td>${user.pastLeaderBoard.id}</td>
                <td>${user.highScore}</td>
                <td>${user.coinsAmount}</td>
                <td>${user.crystalsAmount}</td>
                <td>
                    <c:url value="/users/edit/${user.id}" var="edit"/>
                    <c:url value="/users/delete/${user.id}" var="delete"/>
                    <c:url value="/users/get/${user.id}" var="getJson"/>
                    <form action="${getJson}" method="GET">
                        <input type="submit" value="Get Json">
                    </form>
                    <form action="${edit}" method="GET">
                        <input type="submit" value="Edit">
                    </form>
                    <form action="${delete}" method="GET">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

</c:if>
<c:if test="${usersCount==0}">
    <br>
    <div>The list is empty but you can add a new user</div>
</c:if>

<br>
<div>Pages:</div>

<c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/users/" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<br>
<hr>

<c:url value="/users/create" var="create"/>
<form action="${create}" method="GET">
    <input type="submit" value="Create new user">
</form>

<c:url value="/users/create-initials" var="createInitials"/>
<form action="${createInitials}" method="GET">
    <input type="submit" value="TEST CREATE 1000 NEW USERS">
</form>

<c:url value="/users/set-random-score" var="setScore"/>
<form action="${setScore}" method="GET">
    <input type="submit" value="TEST SET ALL USERS RANDOM SCORE">
</form>



</body>
</html>
