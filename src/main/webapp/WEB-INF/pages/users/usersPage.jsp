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
            padding: 2px 10px;
        }

        input {
            display: inline;
            padding: 3px 10px;
            margin: 3px 5px;
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
            <th>Is Facebook Data added</th>
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
                <td>${user.facebookData.facebookId!=null}</td>
                <td>
                    <c:url value="/users/admin-edit/${user.id}" var="edit"/>
                    <c:url value="/users/admin-delete/${user.id}" var="delete"/>
                    <c:url value="/users/admin-get/${user.id}" var="getJson"/>
                    <c:url value="/users/users/admin-add-facebook-data/${user.id}" var="addFacebookData"/>
                    <form>
                        <input formaction="${getJson}" formmethod="post" type="submit" value="Get Json">
                        <input formaction="${edit}" formmethod="get" type="submit" value="Edit">
                        <input formaction="${delete}" formmethod="get" type="submit" value="Delete">
                        <c:if test="${user.facebookData.facebookId==null}">
                            <input formaction="${addFacebookData}" formmethod="get" type="submit" value="Add Facebook Data">
                        </c:if>
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
<h2>
    Create users
</h2>
<form>
    <c:url value="/users/admin-create" var="create"/>
    <c:url value="/users/admin-create-with-facebook-data" var="createWithFacebookData"/>
    <input formaction="${create}" formmethod="get" type="submit" value="Create new user">
    <input formaction="${createWithFacebookData}" formmethod="get" type="submit"
           value="Create new user with facebook data">
</form>

<hr>
<h3>
    Test functions
</h3>

<form>
    <c:url value="/users/admin-create-initials" var="createInitials"/>
    <c:url value="/users/admin-set-random-score" var="setScore"/>
    <input formaction="${createInitials}" formmethod="get" type="submit" value="Create 1000 new users">
    <input formaction="${setScore}" formmethod="get" type="submit" value="Set all users random score">
</form>

</body>
</html>
