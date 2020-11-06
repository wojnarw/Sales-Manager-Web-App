<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 20.10.2020
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin dashboard</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/menu.jsp" />


<table class="entityList">
        <thead>
            <tr>
                <td colspan="4">
                    Last registered users
                </td>
                <td>
                    <a href="<c:url value="/admin/users" />">Show all</a>
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
        <c:forEach items="${lastFiveUsers}" var="user">
            <tr>
                <td>
                    ${user.id}
                </td>
                <td>
                    <a <c:if test="${not user.enabled}">class="banned"</c:if> href="<c:url value="/admin/user/${user.id}" />">${user.username}</a>
                </td>
                <td>
                    ${user.email}
                </td>
                <td>
                    ${user.registeredOn}
                </td>
                <td>
                    <a href="<c:url value="/admin/user/ban/${user.id}" />">
                        <c:if test="${user.enabled}">
                            Ban this user
                        </c:if>
                        <c:if test="${not user.enabled}">
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
