<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 19.10.2020
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Templates</title>
    <link rel="stylesheet" href="/static/css/styles.css">
</head>
<body>
<h3><a href="<c:url value="/app/templates/add"/>">Add</a></h3>

<c:if test="${not empty param.del}"><h3>${param.del} removed successfully</h3></c:if>
    <table class="entityList">
        <thead>
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
        <c:forEach items="${templates}" var="template">
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
