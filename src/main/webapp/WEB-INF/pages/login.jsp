<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resources"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>

<div class="main">
    <form action="login" method="post">
        <input type="text"  class="inputText" name="login" placeholder=<fmt:message key="login_jsp.login" /> required>
        <input type="password" class="inputText" name="password" placeholder=<fmt:message key="login_jsp.password" /> required>
        <input type="submit" class="buttonSubmit" value=<fmt:message key="login_jsp.signIn" />>
    </form>

</div>
<center>
    <c:if test="${error}">
        <span class="error"><fmt:message key="login_jsp.Invalid.login.or.password"/> </span>
    </c:if>
</center>

</body>
</html>