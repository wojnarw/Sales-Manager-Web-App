<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 29.10.2020
  Time: 02:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>creations</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<jsp:include page="/WEB-INF/fragments/menu.jsp" />

<h3><a href="<c:url value="/app/creations/add"/>">Add</a></h3>

<c:if test="${not empty param.del}"><h3>${param.del} removed successfully</h3></c:if>
<table class="entityList">
    <thead>
    <tr>
        <th>
            #
        </th>
        <th>
            Creation name
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
    <c:forEach items="${creations}" var="creation">
        <tr>
            <td>
                    ${i}
            </td>
            <td>
                <a href="<c:url value="/app/creations/${creation.id}" />">${creation.name}</a>
            </td>
            <td>
                    ${creation.description}
            </td>
            <td>
                    ${creation.updatedAt}
            </td>
            <td>
                <a href="<c:url value="/app/creations/edit/${creation.id}" />">Edit</a>
                <a href="<c:url value="/app/creations/delete/${creation.id}" />">Delete</a>
            </td>
        </tr>
        <c:set var="i" value="${i + 1}" />
    </c:forEach>
    </tbody>
</table>
</body>
</html>
