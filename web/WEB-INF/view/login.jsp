<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 23.05.2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form action="/lp" method="get">
    <input name="login">
    <input name="password">
    <input type="submit" value="ok">
</spring:form>
</body>
</html>
