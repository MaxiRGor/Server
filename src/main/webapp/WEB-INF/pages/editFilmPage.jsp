<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit Film</title>
</head>
<body>
<c:url value="/editFilm" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${film.id}">
    <label for="title">Title</label>
    <input type="text" name="title" id="title" value="${film.title}">
    <label for="year">Year</label>
    <input type="text" name="year" id="year" value="${film.year}">
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre" value="${film.genre}">
    <label for="watched">Watched</label>
    <input type="checkbox" name="watched" id="watched"  <c:if test="${film.watched}">  checked="checked" </c:if>  " >
    <input type="submit" value="Edit film">
</form>
</body>
</html>