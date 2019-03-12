<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 09.03.2019
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<jsp:include page="../header.jsp"/>



<c:forEach items="${sessionScope.cartList}" var="entry">
    Key = ${entry.key}, value = ${entry.value.name}<br>

</c:forEach>
<form action="ДОБАВИТЬ В ТАБЛИЦУ ЗАКАЗЫ">
<input type="button" value="Оплатить">
</body>
</html>
