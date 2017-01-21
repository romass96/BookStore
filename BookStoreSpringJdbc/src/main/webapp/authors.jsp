<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<b>Список авторов по выбраной книге:</b>
<table border="2">
    <tr>
        <th>ID</th>
        <th>Имя</th>
        <th>Книги</th>
    </tr>
    <c:forEach var="author" items="${authorList}">
        <tr>
            <td><c:out value="${author.id}"/></td>
            <td><c:out value="${author.name}"/></td>
            <td>
                <c:forEach var="book" items="${author.books}">
                    <c:out value="${book.name}, "/>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
