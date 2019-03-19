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
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>

<form action="listAllGoods" class="maksym">

    <p>Сортировать:<br>
        <select size="1" name="sortType">\
            <option selected value="default" disabled>Sort by</option>
            <option value="nameAZ">Name (az)</option>
            <option value="nameZA">Name (za)</option>
            <option value="priceLowToHigh">price(low-high)</option>
            <option value="priceHighToLow">price (high-low)</option>
            <option value="newToOld">new-old</option>
            <option value="oldToNew">old-new</option>
        </select><input type="submit" value="Сортировать"></p>


</form>
<form action="listAllGoods">
    <div>
        Цена:<br>
        <input type="number" min="0" name="varPrice1" placeholder="От"><br>
        <input type="number" min="" name="varPrice2" placeholder="До">
        <input type="submit" value="Ok">
    </div>
</form>
<form action="listAllGoods">
    <div>
        Категория:<br>
        <input type="text" name="varCategory">
        <input type="submit" value="Ok">
    </div>
</form>
<form action="listAllGoods">
    <div>
        Color:<br>
        <input type="text" name="varColor">
        <input type="submit" value="Ok">
    </div>
</form>
<form action="listAllGoods">
    <div>
        Цена:<br>
        <input type="number" min="0" name="varSize1" placeholder="От"><br>
        <input type="number" min="" name="varSize2" placeholder="До">
        <input type="submit" value="Ok">
    </div>
</form>

<form>
    <div id="table">
        <table border="1" cellpadding="5">
            <tr>
                <th>Название</th>
                <th>Цвет</th>
                <th>Размер</th>
                <th>Карегория</th>
                <th>Цена</th>
                <th>В корзину</th>
            </tr>
            <c:forEach var="good" items="${goodsList}">
                <tr>
                    <td>${good.name} </td>

                    <td>${good.color}</td>

                    <td> ${good.size}</td>

                    <td>${good.category}</td>

                    <td>${good.price}</td>
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
                                <a href="addToCart?id=${good.id}">
                                    Добавить <br> в корзину
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
