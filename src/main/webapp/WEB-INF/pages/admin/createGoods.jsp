<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create Goods</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/goods.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/index.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/body.css"/> ">

</head>
<body>
<center>
    <h1>Добавление новой позиции товара</h1> <br>
    <c:if test="${error}">
        <span class="error">Invalid input category</span>
    </c:if>

    <form action="${pageContext.servletContext.contextPath}/createGoods" method="POST">
        <div id="table">
            <table>
                <tr>
                    <td align="right"> Введите наименование :</td>
                    <td>
                        <input type="text" name="goodsName" value="test" required>
                    </td>
                </tr>
                <tr>
                    <td align="right"> Введите категорию :</td>
                    <td>
                        <input type="text" name="categoryName" value="car" required>
                    </td>
                </tr>

                <tr>
                    <td align="right"> Введите цену :</td>
                    <td>
                        <input type="number" min="0"  name="price" value="111" required>
                    </td>

                </tr>
                <tr>
                    <td align="right"> Введите цвет :</td>
                    <td>
                        <input type="text" name="color" value="test" required>
                    </td>
                </tr>
                <tr>
                    <td align="right"> Введите размер :</td>
                    <td>
                        <input type="number" min="0"  name="size" value="123" required>
                    </td>
                </tr>
                <tr>
                    <td align="right"> Введите доступное количество на складе :</td>
                    <td>
                        <input type="number" min="0"  name="available" value="111" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" align="center" value="Добавить" required>
                    </td>
                </tr>
            </table>
        </div>
    </form>

    <a href="${pageContext.servletContext.contextPath}/listAllGoods">
        Вернуться </a>
</center>
</body>
</html>
