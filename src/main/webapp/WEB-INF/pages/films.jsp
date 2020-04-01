<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>FILMS</title>
</head>
<body>
<h2>Films</h2>

<c:if test="${filmsCount>0}">
    <table>
        <tr>
            <th>id</th>
            <th>title</th>
            <th>year</th>
            <th>genre</th>
            <th>watched</th>
            <th>action</th>
        </tr>
        <c:forEach var="film" items="${filmsList}">
            <tr>
                <td>${film.id}</td>
                <td>${film.title}</td>
                <td>${film.year}</td>
                <td>${film.genre}</td>
                <td>${film.watched}</td>
                <td>
                    <a href="/editFilm/${film.id}">edit</a>
                    <a href="/deleteFilm/${film.id}">delete</a>
                </td>
            </tr>

        </c:forEach>


    </table>

</c:if>
<c:if test="${filmsCount==0}">
    <br>
    <div>The list is empty but you can add a new film</div>
</c:if>

<c:forEach begin="${1}" end="${pagesCount}" step="1" varStatus="i">
    <c:url value="/films" var="url">
        <c:param name="page" value="${i.index}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<c:url value="/addFilm" var="add"/>
<h4>
    <a href="${add}">Add new film</a>
</h4>
</body>
</html>