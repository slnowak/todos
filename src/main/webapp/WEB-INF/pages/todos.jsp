<%--
  Created by IntelliJ IDEA.
  User: novy
  Date: 31.10.14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <p>List of all todos:</p>
    <table border="1">
        <thead>
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Priority</td>
            <td>Status</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${todos}">
            <tr>
                <td>${todo.name}</td>
                <td>${todo.description}</td>
                <td>${todo.priority}</td>
                <td>${todo.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    </ul>

</div>


</body>
</html>
