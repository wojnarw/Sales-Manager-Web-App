<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 20.10.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Template details</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <h3><a href="<c:url value="/app/templates"/>">Back to list</a></h3>

    <c:if test="${delete}">
        <h2>Are you sure you want to delete this template?</h2>
        <form:form method="post" action="/app/templates/delete/${template.id}">
            <button type="submit">Delete</button>
            <a href="<c:url value="/app/templates" />">Cancel</a>
        </form:form>
    </c:if>
    <h3>Template details</h3>
    <div>Name: ${template.name}</div>
    <div>Created by: ${template.user.username}</div>
    <div>Created: ${template.createdAt}</div>
    <div>Updated:${template.updatedAt}</div>
    <div>Content: ${template.content}</div>
</body>
</html>
