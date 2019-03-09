<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 06.03.2019
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>
<html>
<head>
    <title>List all goods</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/main.css">
</head>
<body>
<form>
    <div class="centered">
        <table border="1" cellpadding="5">
            <tr>
                <th>Название</th>
                <th>Цвет</th>
                <th>Размер</th>
                <th>Цена</th>
                <th>В корзину</th>
            </tr>
            <c:forEach var="good" items="${sessionScope.goodsList}">
                <tr>
                    <td>${good.getName()} </td>

                    <td>${good.getColor()}</td>

                    <td> ${good.getSize()}</td>

                    <td>${good.getPrice()}</td>
                    <td><a href="../add-to-basket?productId=${good.getId()}">
                        Добавить <br> в корзину
                    </a></td>
                </tr>

            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
