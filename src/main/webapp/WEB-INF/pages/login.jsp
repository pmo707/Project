<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}WEB-INF/css/main.css">
</head>
<body>
<h1 class="centered">Login Here</h1>
<div class="centered">
    <form action="login" method="post">
UserName: <input type="text" name="login">
Password: <input type="text" name="password">
    <input type="submit" value="Login">
    </form>
</div>
</body>
</html>