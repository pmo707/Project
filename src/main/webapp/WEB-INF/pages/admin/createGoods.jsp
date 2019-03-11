<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Goods</title>
</head>
<body>

<h1>Добавление новой позиции товара</h1> <br>
<p align="center" style="color: red;"> ${ERROR_PRODUCT_CREATE} </p>

<form action="${pageContext.servletContext.contextPath}/createGoods" method="POST">
    <table>
        <tr>
            <td align="right"> Введите наименование :</td>
            <td>
                <input type="text" name="goodsName" value="test">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите категорию :</td>
            <td>
                <input type="text" name="categoryName" value="car">
            </td>
        </tr>

        <tr>
            <td align="right"> Введите цену :</td>
            <td>
                <input type="text" name="price" value="111">
            </td>
            <td align="right"> Данное поле не может быть меньше 0</td>
        </tr>
        <tr>
            <td align="right"> Введите цвет :</td>
            <td>
                <input type="text" name="color" value="test">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите размер :</td>
            <td>
                <input type="text" name="size" value="123">
            </td>
        </tr>
        <tr>
            <td align="right"> Введите доступное количество на складе :</td>
            <td>
                <input type="text" name="available" value="111">
            </td>
            <td align="right"> Данное поле не может быть меньше 0</td>
        </tr>
        <tr>
            <td>
                <input type="submit" align="center" value="Добавить">
            </td>
        </tr>
    </table>
</form>

<a href="${pageContext.servletContext.contextPath}/listAllGoods">
    Вернуться </a>

</body>
</html>
