<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<c:url value="/addUser" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" >
    <label for="role">Role</label>
    <input type="text" name="role" id="role">
    <label for="nickName">Nickname</label>
    <input type="text" name="nickName" id="nickName" >
    <label for="deviceId">Device Id</label>
    <input type="text" name="deviceId" id="deviceId" >
    <label for="levelNumber">Level Number</label>
    <input type="text" name="levelNumber" id="levelNumber" >
    <label for="highScore">High Score</label>
    <input type="text" name="highScore" id="highScore">

    <input type="submit" value="Add user">
</form>
</body>
</html>
