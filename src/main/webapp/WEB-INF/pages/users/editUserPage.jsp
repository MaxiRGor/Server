<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<h1>
    Edit user
</h1>
<c:url value="/users/edit" var="var"/>
<form action="${var}" method="POST">

    <input type="hidden" name="id"  value="${user.id}" >

    <label for="nickname">Nickname</label>
    <input type="text" name="nickname" id="nickname" value="${user.nickname}">

    <label for="highScore">High Score</label>
    <input type="text" name="highScore" id="highScore" value="${user.highScore}">

    <label for="coinsAmount">Coins Amount</label>
    <input type="text" name="coinsAmount" id="coinsAmount" value="${user.coinsAmount}" >

    <label for="crystalsAmount">Crystals Amount</label>
    <input type="text" name="crystalsAmount" id="crystalsAmount" value="${user.crystalsAmount}">

    <input type="submit" value="Edit user">
</form>
</body>
</html>
