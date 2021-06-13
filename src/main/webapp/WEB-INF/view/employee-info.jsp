<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

    <form:hidden path="id"/>

    Имя <form:input path="name"/>
    <br>
    Фамилия <form:input path="family"/>
    <br>
    Возраст <form:input path="age"/>
    <br>

    <input type="submit" value="Добавить">
</form:form>

</body>
</html>
