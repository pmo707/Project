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
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="center" id="center">
    <form action="pages/cart1" method="post">
        <input type="hidden" name="id" value="${subject.id}">
        <span class="label">Subject name</span>
        <input type="text" name="subject_name" class="inputText" pattern="[a-zA-Z]{2-15}" title="only word, length from 2 to 15" value="${subject.subjectName}" required>

        <span class="label">Teach login</span>
        <select name="teach_login" class="select">
            <c:forEach var="value" items="${teachers}">
                <option value="${value.login}"
                        <c:if test="${value.login == subject.lecturer.login}">selected</c:if>>${value.login}</option>
            </c:forEach>
        </select>
        <span class="label">Semester number</span>
        <select name="semester" class="select">
            <c:forEach var="value" items="${semesters}">
                <option value="${value.semesterNumber}"
                        <c:if test="${value.semesterNumber == subject.semester.semesterNumber}">selected</c:if>>${value.semesterNumber}</option>
            </c:forEach>
        </select>

        <input type="submit" class="okayButton" value="Okay">
    </form>
</div>
</body>
</html>
