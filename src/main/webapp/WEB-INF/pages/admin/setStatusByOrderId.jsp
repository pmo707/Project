<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 18.03.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>
<html>
<head>
    <title>Edit role</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>
<center>
    <form action="setStatusByOrderId" method="post">
        <h1>Edit order status</h1>
        <p>order id:
            <input type="number" min="1" name="orderId" required></p>
        <select size="3" name="orderStatus">
            <option value="canceled">canceled</option>
            <option value="book">book</option>
            <option value="paid">paid</option>
        </select>
        <p><input type="submit" value="Ok"></p>
    </form>
    <c:if test="${error}">
        <span class="error">Doesn't find order/already has this status</span>
    </c:if><br>
    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        Вернуться </a>
</center>
</body>
</html>
