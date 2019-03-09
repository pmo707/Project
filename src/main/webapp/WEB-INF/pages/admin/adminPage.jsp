<%--
  Created by IntelliJ IDEA.
  User: pmo70
  Date: 08.03.2019
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/WEB-INF/css/main.css">
    <title>Admin Page</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.role=='admin'}">
        <a href="${contextPath}/admin/page" class="active">Home page</a>

    </c:when>
</c:choose>
</body>
</html>
