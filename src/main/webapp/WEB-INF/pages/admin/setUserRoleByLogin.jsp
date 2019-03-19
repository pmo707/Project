<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 11.03.2019
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../header.jsp"/>
<html>
<head>
    <title>Edit role</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/> ">

</head>
<body>
<center>
    <form action="setUserRoleByLogin" method="post">
        <h1>Edit role</h1>
        <p>user login:
            <input type="text" name="login" required></p>

        <select size="2" name="role">
            <option value="blocked user">ban user</option>
            <option selected value="user">unban user</option>
        </select>
        <p><input type="submit" value="Ok"></p>
    </form>
    <c:if test="${error}">
        <span class="error">Doesn't find user/already banned/unbanned</span>
    </c:if><br>
    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        Вернуться </a>
</center>
</body>
</html>
