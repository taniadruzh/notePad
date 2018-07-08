<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>phone</th>
    </tr>
<c:forEach var="person" items="${notepadList}">
<tr>
    <td>${person.name}</td>
    <td>${person.surname}</td>
    <td>${person.phone}</td>
</tr>
</c:forEach>
</table>
<br>
<form action="/modify" method="get" modelAttribute="person">
    <br>
    Name:
    <input type="text" name="name">
    <br>
    Surname:
    <input type="text" name="surname">
    <br>
    Phone:
    <input type="text" name="phone">
    </br>
    <input type="submit" name="add" value="add">
    <input type="submit" name="del" value="del">
</form>
<br>
<h3>${errorPhone}</h3>
</body>
</html>
