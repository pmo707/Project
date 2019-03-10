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
                <th>Карегория</th>
                <th>В корзину</th>
            </tr>
            <c:forEach var="good" items="${sessionScope.goodsList}">
                <tr>
                    <td>${good.name} </td>

                    <td>${good.color}</td>

                    <td> ${good.size}</td>

                    <td>${good.price}</td>

                    <td>${good.category}</td>
                    <td>
                        <c:choose>
                            <c:when test="${sessionScope.role=='admin'}">
                                <a href="editGoods?id=${good.id}">
                                    Edit
                                </a>
                                <a href="deleteGoods?id=${good.id}">
                                    Delete
                                </a>
                            </c:when>

                            <c:when test="${sessionScope.role=='user'}">
                                <a href="../add-to-basket?id=${good.id}">
                                    Добавить <br> в корзину(doesnt work)
                                </a>
                            </c:when>

                            <c:when test="${sessionScope.role=='blocked user'}">
                                <a>Baned</a>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</form>
</body>
</html>
