<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 10.04.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add facebook data</title>
</head>
<body>
<h1>
    Add facebook data
</h1>
<c:url value="/users/users/admin-add-facebook-data/" var="var"/>
<form action="${var}" method="POST">

    <input type="hidden" name="userId" value="${userId}">

    <label for="facebookId">Facebook Id </label>
    <input type="text" name="facebookId" id="facebookId" >

    <label for="email">Email</label>
    <input type="text" name="email" id="email" >

    <label for="realName">Real Name</label>
    <input type="text" name="realName" id="realName" >

    <label for="iconUrl">Icon Url</label>
    <input type="text" name="iconUrl" id="iconUrl" >

    <input type="submit" value="Add facebook data">
</form>

</body>
</html>
