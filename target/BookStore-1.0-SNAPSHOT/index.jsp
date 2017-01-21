<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body bgcolor="teal">
<form action="/main"  method="post">
    <table>
        <tr>
            <td><b>Узнать книги по автору:</b></td>
        </tr>
        <tr>
            <td>Введите автора: <input type="text" name="author" value="" size="30"><input type="submit" name="getBooks"
                                                                                           value="Найти"></td>
        </tr>
        <tr>
            <td><b>Узнать авторов по книге:</b></td>
        </tr>
        <tr>
            <td>Введите книгу: <input type="text" name="book" value="" size="30"><input type="submit" name="getAuthors"
                                                                                        value="Найти"></td>
        </tr>
    </table>
</form>
</body>
</html>
