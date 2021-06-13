<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Люди</title>
</head>
<body>

<h2> Все люди</h2>
<br>

<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Возраст</th>
    </tr>
    <br>

    <c:forEach var="emp" items="${allPeop}"> <%-- allEmps - название ключа model--%>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}">
            </c:param>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">

            <c:param name="empId" value="${emp.id}">
            </c:param>
        </c:url>
        <tr>
            <td>
                    ${emp.name}
            </td>
            <td>
                    ${emp.family}
            </td>
            <td>
                    ${emp.age}
            </td>

            <td>
                <input type="button" value="Обновить" onclick="window.location.href = '${updateButton}'">
<%--                <input type="button" value="Удалить" onclick="window.location.href = '${deleteButton}'">--%>
            </td>

        </tr>
    </c:forEach>
    </tr>
</table>
<br>
<br>
<input type="button" value="ADD" onclick="window.location.href = '/addNewEmployee'">


</body>
</html>
