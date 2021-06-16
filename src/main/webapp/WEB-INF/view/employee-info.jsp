<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags' %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>Info</title>
</head>
<body>
<h2> Информация о работнике</h2>

<br>


<form:form action="/saveEmployee" modelAttribute="personsss">

    <table>
        <tr>
            <th></th>
            <th></th>

        </tr>
        <br>
        <tbody>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
            <td>

            </td>
        </tr>
        <tr>
            <td>Имя</td>
            <td >
                <form:input path="name"/>
            </td>
            <td>

                <c:if test="${validateName}">
                    <p> Введите коректное имя,например: Aleksey, Ivan </p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td>
                <form:input path="surname"/>
            </td>
            <td>
                <c:if test="${personsss.validateSurname}">
                    <p> Введите коректную фамилию,например: Ivanov </p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td>
                <form:input path="age"/>
            </td>
            <td>
                <c:if test="${personsss.validateAge}">
                    <p> Введите коректный возраст: от 1 до 129 </p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Почта</td>
            <td>
                <form:input path="mail"/>
            </td>
            <td>
                <c:if test="${personsss.validateMail}">
                    <p> Проверьте ваш mail, например: ivanov@gmail.com </p>
                </c:if>
            </td>
        </tr>

        </tbody>
    </table>
    <input type="submit" value="Добавить">
</form:form>

</body>
</html>
