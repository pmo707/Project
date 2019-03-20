<%--
  Created by IntelliJ IDEA.
  User: bohdan
  Date: 3/4/19
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>

<div class="header">
    <h2>Hello, ${sessionScope.login}</h2>
    <form style="margin: 0; padding: 0; float: right;" action="${contextPath}/logout">
        <button id="logoutButton" type="submit">LogOut</button>
    </form>

    <div class="centered">

        <c:choose>
            <c:when test="${sessionScope.role=='admin'}">
                <a href="${contextPath}/listAllGoods" class="active">Home page|</a>
                <a href="${contextPath}/createGoods" class="active">Create goods|</a>
                <a href="${contextPath}/setUserRoleByLogin" class="active">Ban / unban users|</a>
                <a href="${contextPath}/setStatusByOrderId" class="active">Change status in order |</a>

            </c:when>
            <c:when test="${sessionScope.role=='user'}">
                <a href="${contextPath}/listAllGoods" class="homePage">Home page</a>
                <a href="${contextPath}/listOldOrders" class="homePage">Previous orders</a>
                <form style="margin: 0; padding: 0; float: right;" action="${contextPath}/cart">
                    <button id="cartButton" type="submit">Cart</button>
                </form>
            </c:when>
            <c:when test="${sessionScope.role=='blocked user'}">
                <a href="${contextPath}/listAllGoods" class="homePage">Home page</a>
                <a href="${contextPath}/listOldOrders" class="homePage">Personal area</a>

            </c:when>
        </c:choose>
    </div>
    <div style="margin: 0; padding: 0; float: right;">
        <select id="sel_id" name="sel_name"  onchange="this.form.submit();">
            <option value="ru">ru</option>
            <option value="us">us </option>
        </select>
    </div>
</div>
<hr>

</body>
</html>
