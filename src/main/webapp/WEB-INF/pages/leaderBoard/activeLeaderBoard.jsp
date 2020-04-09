<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 04.04.2020
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Active Leader Board</title>
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
    Active Leader Board
</h1>

<c:url value="/leader-board/past" var="var"/>
<h3>
    <a href="${var}">Past leaders page</a>
</h3>

<c:if test="${activeLeaderBoardCount>0}">
    <table>
        <tr>
            <th>id</th>
            <th>place</th>
            <th>userName</th>
            <th>highScore</th>
        </tr>
        <c:forEach var="leader" items="${activeLeaders}">
            <tr>
                <td>${leader.id}</td>
                <td>${leader.place}</td>
                <td>${leader.user.nickname}</td>
                <td>${leader.user.highScore}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <div>Pages: </div>

    <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/leader-board/active" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:forEach>

</c:if>

<c:if test="${activeLeaderBoardCount==0}">
    <br>
    <div>The list is empty</div>
</c:if>

<hr>


<c:url value="/leader-board/active/top" var="var"/>
<h3>
    <a href="${var}">Get json top ${amountOfLeadersToShow}</a>
</h3>

<c:url value="/leader-board/update-active-leader-board" var="var"/>
<form action="${var}" method="POST">
    <input type="submit" value="TEST Update active leader board">
</form>

<c:url value="/leader-board/save-data-to-past-leader-board-and-clear-active-leader-board" var="var"/>
<form action="${var}" method="POST">
    <input type="submit" value="TEST Save data to past leader board and clear active leader board">
</form>

</body>
</html>
