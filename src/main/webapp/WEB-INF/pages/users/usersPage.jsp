
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
</head>
<body>
<c:if test="${usersCount>0}">
    <table>
        <tr>
            <th>id</th>
            <th>nickname</th>
            <th>deviceId</th>
            <th>activeLeaderBoardId</th>
            <th>pastLeaderBoardId</th>
            <th>highScore</th>
            <th>coinsAmount</th>
            <th>crystalsAmount</th>

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
                <td>${user.coinsAmount}</td>
                <td>${user.crystalsAmount}</td>
                <td>
                    <a href="/users/edit/${user.id}">Edit</a>
                    <a href="/users/delete/${user.id}">Delete</a>
                    <a href="/users/get/${user.id}">Get json</a>
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

<c:url value="/users/create" var="create"/>
<h4>
    <a href="${create}">Create new user</a>
</h4>

<c:url value="/users/create-initials" var="createInitials"/>
<h4>
    <a href="${createInitials}">TEST CREATE 1000 NEW USERS</a>
</h4>

<c:url value="/users/set-random-score" var="setScore"/>
<h4>
    <a href="${setScore}">TEST SET ALL USERS RANDOM SCORE</a>
</h4>

<c:url value="/" var="mainPage"/>
<h3>
    <a href="${mainPage}">Main Page</a>
</h3>
</body>
</html>
