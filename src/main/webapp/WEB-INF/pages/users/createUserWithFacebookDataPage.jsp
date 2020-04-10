<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 10.04.2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create user with facebook data</title>
</head>
<body>
<h1>
    Create user with facebook data
</h1>
<c:url value="/users/admin-create-with-facebook-data" var="var"/>
<form action="${var}" method="POST">

    <input type="hidden" name="id" value="">
    <label for="nickname">Nickname</label>
    <input type="text" name="nickname" id="nickname" >

    <label for="deviceId">Device Id</label>
    <input type="text" name="deviceId" id="deviceId" >

    <label for="facebookId">Facebook Id </label>
    <input type="text" name="facebookId" id="facebookId" >

    <label for="email">Email</label>
    <input type="text" name="email" id="email" >

    <label for="realName">Real Name</label>
    <input type="text" name="realName" id="realName" >

    <label for="iconUrl">Icon Url</label>
    <input type="text" name="iconUrl" id="iconUrl" >


    <input type="submit" value="Add user">
</form>
</body>
</html>