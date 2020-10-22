<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 22.10.2020
  Time: 02:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>app</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/styles.css">
</head>
<body>
<a href="${pageContext.request.contextPath}/fixtures">fixtures</a>
<a href="${pageContext.request.contextPath}/admin">admin</a>
<a href="${pageContext.request.contextPath}/user/account">user account</a>
<a href="${pageContext.request.contextPath}/app/templates">templates</a>

<table class="entityList">
    <thead>
    <tr>
        <td colspan="4">
            Last created templates
        </td>
        <td>
            <a href="<c:url value="/app/templates" />">Show all</a>
        </td>
    </tr>
    <tr>
        <th>
            #
        </th>
        <th>
            Template name
        </th>
        <th>
            Description
        </th>
        <th>
            Last updated
        </th>
        <th>

        </th>
    </tr>
    </thead>
    <tbody>
    <c:set var="i" value="1" />
    <c:forEach items="${lastFiveTemplates}" var="template">
        <tr>
            <td>
                    ${i}
            </td>
            <td>
                <a href="<c:url value="/app/templates/${template.id}" />">${template.name}</a>
            </td>
            <td>
                    ${template.description}
            </td>
            <td>
                    ${template.updatedAt}
            </td>
            <td>
                <a href="<c:url value="/app/templates/edit/${template.id}" />">Edit</a>
                <a href="<c:url value="/app/templates/delete/${template.id}" />">Delete</a>
            </td>
        </tr>
        <c:set var="i" value="${i + 1}" />
    </c:forEach>
    </tbody>
</table>
</body>
</html>
