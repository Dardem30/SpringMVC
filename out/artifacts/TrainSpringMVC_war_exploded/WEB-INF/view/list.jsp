<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 20.05.2017
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>lastname</th>
    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td>${list.employeeId}</td>
            <td>${list.firstname}</td>
            <td>${list.lastname}</td>
            <td><image src="/drow?employeeId=${list.employeeId}"/></td>
            <td><a href="/deleteEmployee?employeeId=${list.employeeId}">delete</a></td>
            <td><a href="/onUpdate?employeeId=<c:out value="${list.employeeId}"/>">update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
