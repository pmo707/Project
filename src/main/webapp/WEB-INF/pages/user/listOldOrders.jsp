<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 18.03.2019
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"/>
<html>
<head>
    <title>My orders</title>
</head>
<body>
<br>

<c:forEach var="order" items="${requestScope.ordersUser}">

    <div><h2>Order№${order.key}</h2></div>
    <table border="1" cellpadding="5">
        <tr>
            <th>Название</th>
            <th>Цвет</th>
            <th>Размер</th>
            <th>Карегория</th>
            <th>Цена</th>
        </tr>
        <c:forEach items="${order.value}" var="good">
            <tr>
                <td>${good.name} </td>

                <td>${good.color}</td>

                <td> ${good.size}</td>

                <td>${good.category}</td>

                <td>${good.price}</td>
            </tr>
        </c:forEach>
    </table>
</c:forEach>

</body>
</html>
