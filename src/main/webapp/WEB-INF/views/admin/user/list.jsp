<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 20.10.2020
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
<a href="<c:url value="/admin"/>">Back to admin dashboard</a>
    <table class="entityList">
        <thead>
        <tr>
            <td colspan="5">
                User list
            </td>
        </tr>
        <tr>
            <th>
                ID
            </th>
            <th>
                Username
            </th>
            <th>
                E-mail
            </th>
            <th>
                Registered on
            </th>
            <th>

            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                    <a <c:if test="${user.role == 'banned'}">class="banned"</c:if> href="<c:url value="/admin/user/${user.id}" />">${user.username}</a>
                </td>
                <td>
                        ${user.email}
                </td>
                <td>
                        ${user.registeredOn}
                </td>
                <td>
                    <a href="<c:url value="/admin/user/ban/${user.id}" />">
                        <c:if test="${user.role == 'user'}">
                            Ban this user
                        </c:if>
                        <c:if test="${user.role == 'banned'}">
                            Unban
                        </c:if>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
