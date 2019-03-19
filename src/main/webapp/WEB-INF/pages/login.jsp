<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <input type="text"  class="inputText" name="login" placeholder="Login" required>
        <input type="password" class="inputText" name="password" placeholder="Password" required>
        <input type="submit" class="buttonSubmit" value="Sign In">
    </form>

</div>
<center>
    <c:if test="${error}">
        <span class="error">Invalid login or password!</span>
    </c:if>
</center>

</body>
</html>