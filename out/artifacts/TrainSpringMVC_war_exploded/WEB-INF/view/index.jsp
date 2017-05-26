<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 20.05.2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form method="get" modelAttribute="newEmployee" action="/saveEmployee">
    <spring:input path="employeeId"/>
    <spring:input path="firstname"/>
    <spring:input path="lastname"/>
    <spring:input path="image"/>
    <spring:button>add</spring:button>
</spring:form>
<form action="/listEmployee">
    <input type="submit" value="showAll">
</form>
<form action="/exit">
    <input type="submit" value="exit">
</form>
<%=request.getCookies()%>
</body>
</html>
