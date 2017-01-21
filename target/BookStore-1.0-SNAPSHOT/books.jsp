<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<b>Список книг по выбраному автору:</b>
<table border="2">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Авторы</th>
    </tr>
    <c:forEach var="book" items="${bookList}">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.name}"/></td>
            <td>
                <c:forEach var="author" items="${book.authors}">
                    <c:out value="${author.name}, "/>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
