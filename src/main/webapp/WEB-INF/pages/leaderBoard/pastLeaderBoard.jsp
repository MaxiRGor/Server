<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 08.04.2020
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Past Leader Board</title>
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
    Past Leader Board
</h1>

<c:url value="/leader-board/active" var="var"/>
<h3>
    <a href="${var}">Active leaders page</a>
</h3>

<c:if test="${pastLeaderBoardCount>0}">
    <table>
        <tr>
            <th>Id</th>
            <th>Place</th>
            <th>Nickname</th>
            <th>Saved score</th>
            <th>Is rewardData taken</th>
            <th>Action</th>
        </tr>
        <c:forEach var="leader" items="${pastLeaders}">
            <tr>
                <td>${leader.id}</td>
                <td>${leader.place}</td>
                <td>${leader.user.nickname}</td>
                <td>${leader.savedScore}</td>
                <td>${leader.rewardTaken}</td>
                <td>
                    <c:if test="${!leader.rewardTaken}">
                        <c:url value="/users/admin-perform-reward/${leader.id}" var="var"/>
                        <form action="${var}" method="POST">
                            <input type="submit" value="Reward">
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <div>Pages:</div>

    <c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
        <c:url value="/leader-board/past" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href="${url}">${i.index}</a>
    </c:forEach>

</c:if>

<c:if test="${pastLeaderBoardCount==0}">
    <br>
    <div>The list is empty</div>
</c:if>

<hr>

<c:url value="/leader-board/past/top" var="json"/>
<h3>
    <a href="${json}">Get json top ${amountOfLeadersToShow}</a>
</h3>

<c:url value="/leader-board/clear-past-leader-board" var="var"/>
<form action="${var}" method="POST">
    <input type="submit" value="TEST Clear past leader board">
</form>

</body>
</html>
