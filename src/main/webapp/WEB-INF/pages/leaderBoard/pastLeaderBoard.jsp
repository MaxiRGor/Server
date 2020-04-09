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
</head>
<body>
<br>
<div>Past Leader Board</div>

<h1>

</h1>

<c:if test="${pastLeaderBoardCount>0}">
    <table>
        <tr>
            <th>Id</th>
            <th>Place</th>
            <th>Nickname</th>
            <th>Saved score</th>
            <th>Is reward taken</th>
        </tr>
        <c:forEach var="leader" items="${pastLeaders}">
            <tr>
                <td>${leader.id}</td>
                <td>${leader.place}</td>
                <td>${leader.user.nickname}</td>
                <td>${leader.savedScore}</td>
                <td>${leader.rewardTaken}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <div>Pages: </div>

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


<c:url value="/leader-board/past/top" var="json"/>
<h3>
    <a href="${json}">Get past leaders json</a>
</h3>

<c:url value="/leader-board/active" var="json"/>
<h3>
    <a href="${json}">Get active leaders</a>
</h3>

<c:url value="/" var="mainPage"/>
<h3>
    <a href="${mainPage}">Main Page</a>
</h3>

</body>
</html>
