<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 10.03.2019
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Page</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">
</head>
<body>
<center>
    <h1>Редактирование данных о товаре</h1>
    <br>
    <c:if test="${error}">
        <span class="error">Invalid input category</span>
    </c:if>

    <form action="${pageContext.servletContext.contextPath}/editGoods" method="POST">
        <table>
            <tr style="display:none;">
                <td align="right"> id :</td>
                <td>
                    <input type="text" required name="goodsId" value=${requestScope.goods.id}>
                </td>
            </tr>
            <tr>
                <td align="right"> Введите наименование :</td>
                <td>
                    <input type="text" required name="goodsName" value=${requestScope.goods.name}>
                </td>
            </tr>
            <tr>
                <td align="right"> Введите категорию :</td>
                <td>
                    <input type="text" required name="categoryName" value=${requestScope.goods.category}>
                </td>
            </tr>

            <tr>
                <td align="right"> Введите цену :</td>
                <td>
                    <input type="number" min="0" required name="price" value=${requestScope.goods.price}>
                </td>
            </tr>

            <tr>
                <td align="right"> Введите цвет :</td>
                <td>
                    <input type="text" required name="color" value=${requestScope.goods.color}>
                </td>
            </tr>
            <tr>
                <td align="right"> Введите размер :</td>
                <td>
                    <input type="number" min="0" required name="size" value=${requestScope.goods.size}>
                </td>
            </tr>
            <tr>
                <td align="right"> Введите доступное количество на складе :</td>
                <td>
                    <input type="number" min="0" required name="available" value=${requestScope.goods.available}>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" align="center" value="Edit">
                </td>
            </tr>
        </table>
    </form>

    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        Вернуться </a>
</center>

</body>
</html>
