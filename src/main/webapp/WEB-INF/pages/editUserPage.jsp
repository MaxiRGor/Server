<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<c:url value="/editUser" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${user.id}">
    <label for="id">Id</label>
    <input type="text" name="id" id="id" value="${user.id}">
    <label for="role">Role</label>
    <input type="text" name="role" id="role" value="${user.role}">
    <label for="nickName">Nickname</label>
    <input type="text" name="nickName" id="nickName" value="${user.nickName}">
    <label for="deviceId">Device Id</label>
    <input type="text" name="deviceId" id="deviceId" value="${user.deviceId}">
    <label for="levelNumber">Level Number</label>
    <input type="text" name="levelNumber" id="levelNumber" value="${user.levelNumber}">
    <label for="highScore">High Score</label>
    <input type="text" name="highScore" id="highScore" value="${user.highScore}">

    <input type="submit" value="Edit user">
</form>
</body>
</html>
