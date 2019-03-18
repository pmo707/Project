<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 18.03.2019
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit role</title>
</head>
<body>

<form action="setStatusByOrderId" method="post">
    <h1>Edit order status</h1>
    <p>order id:
        <input type="text" name="orderId"></p>
    <select size="3" name="orderStatus">
        <option value="canceled">canceled</option>
        <option value="book">book</option>
        <option value="paid">paid</option>
    </select>
    <p><input type="submit" value="Ok"></p>
</form>
<a href="${pageContext.servletContext.contextPath}/listAllGoods">
    Вернуться </a>
</body>
</html>
