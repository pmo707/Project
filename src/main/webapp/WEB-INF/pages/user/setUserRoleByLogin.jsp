<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 11.03.2019
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit role</title>
</head>
<body>

<form action="setUserRoleByLogin" method="post">
    <h1>Edit role</h1>
    <p>user login:
        <input type="text" name="login"></p>
    <select size="2" name="role">
        <option value="blocked user">ban user</option>
        <option selected value="user">unban user</option>
    </select>
    <p><input type="submit" value="Ok"></p>
</form>
<a href="${pageContext.servletContext.contextPath}/listAllGoods">
    Вернуться </a>
</body>
</html>
