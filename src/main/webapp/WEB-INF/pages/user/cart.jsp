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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/> ">
</head>
<body>
<jsp:include page="../header.jsp"/>
<center>
    <div id="table">
        <table border="1" cellpadding="5">
            <tr>
                <th>Название</th>
                <th>Цвет</th>
                <th>Размер</th>
                <th>Карегория</th>
                <th>Цена</th>
                <th>Удалить</th>
            </tr>

            <c:forEach items="${sessionScope.cartList}" var="entry">

                <tr>
                    <td>${entry.value.name} </td>

                    <td>${entry.value.color}</td>

                    <td> ${entry.value.size}</td>

                    <td>${entry.value.category}</td>

                    <td>${entry.value.price}</td>
                    <td><a href="deleteFromCart?id=${entry.value.id}">
                        Удалить
                    </a></td>
                </tr>

            </c:forEach>


        </table>
    </div>

    <a></a>
    <form class="center" action="cart" method="post">
        <button type="submit">Оплатить</button>
    </form>
    <br>
    <c:if test="${error}">
        <span class="error">cart is empty</span>
    </c:if><br>
    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        Назад </a>
</center>
</body>
</html>
