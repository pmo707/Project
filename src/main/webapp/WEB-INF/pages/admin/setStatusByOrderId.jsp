<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 18.03.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${param.lang}"/>
<fmt:setBundle basename="resources"/>
<jsp:include page="../header.jsp"/>
<html lang="${param.lang}">
<head>
    <title><fmt:message key="label.edit.role" /></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>

<center>
    <form action="setStatusByOrderId" method="post">
        <h1><fmt:message key="label.edit.status" /></h1>
        <p><fmt:message key="label.order.id" />:
            <input type="number" min="1" name="orderId" required></p>
        <select size="3" name="orderStatus">
            <option value="canceled"><fmt:message key="label.canceled" /></option>
            <option value="book"><fmt:message key="label.book" /></option>
            <option value="paid"><fmt:message key="label.paid" /></option>
        </select>
        <p><input type="submit" value="Ok"></p>
    </form>
    <c:if test="${error}">
        <span class="error"><fmt:message key="set_status_by_order_jsp_error" /></span>
    </c:if><br>
    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        <fmt:message key="label.back"/> </a>
</center>
</body>
</html>
