<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Maxim
  Date: 09.04.2020
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Game Variables</title>
</head>
<body>
<br>
<div>Amount Of Items On Page = ${gameVariables.amountOfItemsOnPage}</div>
<br>
<div>Amount Of Leaders To Show = ${gameVariables.amountOfLeadersToShow}</div>
<br>
<div>Rewards</div>
<table>
    <tr>
        <th>Type</th>
        <th>Amount</th>
    </tr>
    <c:forEach var="reward" items="${gameVariables.rewardsForFirstPlaces}">
        <tr>
            <td>${reward.rewardType}</td>
            <td>${reward.rewardAmount}</td>
        </tr>

    </c:forEach>
</table>
<c:url value="/" var="mainPage"/>
<h3>
    <a href="${mainPage}">Main Page</a>
</h3>
</body>
</html>
