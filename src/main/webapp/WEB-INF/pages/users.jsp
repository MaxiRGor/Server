<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<c:if test="${usersCount>0}">
    <table>
        <tr>
            <th>id</th>
            <th>role</th>
            <th>nickName</th>
            <th>deviceId</th>
            <th>levelNumber</th>
            <th>highScore</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.role}</td>
                <td>${user.nickName}</td>
                <td>${user.deviceId}</td>
                <td>${user.levelNumber}</td>
                <td>${user.highScore}</td>
                <td>${user.deviceId}</td>
                <td>
                    <a href="/editUser/${user.id}">edit</a>
                    <a href="/deleteUser/${user.id}">delete</a>
                </td>
            </tr>

        </c:forEach>


    </table>

</c:if>
<c:if test="${usersCount==0}">
    <br>
    <div>The list is empty but you can add a new film</div>
</c:if>

<c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/users" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<c:url value="/addUser" var="add"/>
<h4>
    <a href="${add}">Add new user</a>
</h4>
</body>
</html>
