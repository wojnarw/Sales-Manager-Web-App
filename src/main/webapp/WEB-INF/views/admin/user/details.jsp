<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h3><a href="<c:url value="/admin/users"/>">Back to list</a></h3>

    <h3>User details</h3>
    <div>ID: ${user.id}</div>
    <div>Username: ${user.username}</div>
    <div>E-mail: ${user.email}</div>
    <div>Registered on: ${user.registeredOn}</div>
    <div>Enabled:
        <span <c:if test="${not user.enabled}">class="banned"</c:if>>${user.enabled}</span>
    </div>
    <div>Roles:
        <c:forEach items="${user.roles}" var="role" varStatus="status">
            <span>${role.name}</span><c:if test="${not status.last}">, </c:if>
        </c:forEach>

    </div>
    <div>Templates created: ${numOfTemplates}</div>
    <div>
        Templates:
        <ol>
            <c:forEach items="${user.templates}" var="template">
            <li>
                ${template.name}
            </li>
            </c:forEach>
        </ol>
    </div>
</body>
</html>
