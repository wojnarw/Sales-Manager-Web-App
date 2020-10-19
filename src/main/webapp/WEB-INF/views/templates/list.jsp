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
    <style>
        table {
            margin: 50px;
            padding-bottom: 15px;
        }
        th {
            text-align: center;
            font-weight: bold;
            padding: 15px;
            background: #a55d5d;
        }
        td {
            background: #e2e2d2;
        }
        .title {
            font-weight: bold;
            font-size: large;
        }
    </style>
</head>
<body>

    <table>
        <thead>
            <tr>
                <th>
                    #
                </th>
                <th>
                    Template name
                </th>
                <th>
                    Last updated
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
                    ${template.name}
                </td>
                <td>
<%--                    ${template.updatedAt}--%>
                </td>
            </tr>
        <c:set var="i" value="${i + 1}" />
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
