<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 01.04.2020
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<h1>
    Create user
</h1>
<c:url value="/users/create" var="var"/>
<form action="${var}" method="POST">

    <label for="nickname">Nickname</label>
    <input type="text" name="nickname" id="nickname" >

    <label for="deviceId">Device Id</label>
    <input type="text" name="deviceId" id="deviceId" >

    <input type="submit" value="Add user">
</form>
</body>
</html>
