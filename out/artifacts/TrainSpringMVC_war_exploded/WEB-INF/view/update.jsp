<%--
  Created by IntelliJ IDEA.
  User: УВД
  Date: 21.05.2017
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form method="get" action="/update" modelAttribute="employers">
    <spring:input path="employeeId"/>
    <spring:input path="firstname"/>
    <spring:input path="lastname"/>
    <spring:button>list</spring:button>
</spring:form>
</body>
</html>
