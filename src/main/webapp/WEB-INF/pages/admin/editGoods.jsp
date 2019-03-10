<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 10.03.2019
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Page</title>
</head>
<body>
<h1>Редактирование данных о товаре</h1>
<br>


<form action="${pageContext.servletContext.contextPath}/editGoods" method="POST">
    <table>
        <tr style="display:none;">
            <td  align="right"> id :</td>
            <td>
                <input type="text" name="goodsId" value=${requestScope.goods.id}>
            </td>
        </tr>
        <tr>
            <td align="right"> Введите наименование :</td>
            <td>
                <input type="text" name="goodsName" value=${requestScope.goods.name}>
            </td>
        </tr>
        <tr>
            <td align="right"> Введите категорию :</td>
            <td>
                <input type="text" name="categoryName" value=${requestScope.goods.category}>
            </td>
        </tr>

        <tr>
            <td align="right"> Введите цену :</td>
            <td>
                <input type="text" name="price" value=${requestScope.goods.price}>
            </td>
            <td align="right"> Данное поле не может быть меньше 0</td>
        </tr>
        <tr>
            <td align="right"> Введите дату изготовления :</td>
            <td>
                <input type="text" name="createdAt" value=${requestScope.goods.createdAt}>
            </td>
            <td align="right"> Формат даты - yyyy.MM.dd</td>
        </tr>
        <tr>
            <td align="right"> Введите цвет :</td>
            <td>
                <input type="text" name="color" value=${requestScope.goods.color}>
            </td>
        </tr>
        <tr>
            <td align="right"> Введите размер :</td>
            <td>
                <input type="text" name="size" value=${requestScope.goods.size}>
            </td>
        </tr>
        <tr>
            <td align="right"> Введите доступное количество на складе :</td>
            <td>
                <input type="text" name="available" value=${requestScope.goods.available}>
            </td>
            <td align="right"> Данное поле не может быть меньше 0</td>
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
</body>
</html>
