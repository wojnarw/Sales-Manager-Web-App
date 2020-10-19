<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 19.10.2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Template creator</title>
</head>
<body>
    <h2>Template ${template.id == null ? "add" : "edit"} form</h2>
    <form:form method="post" action="${pageContext.request.contextPath}/template/save" modelAttribute="template">
        <form:hidden path="id" />
<%--        <form:label path="name">--%>
            Template name:
<%--        </form:label>--%>
        <form:input path="name" />
        <form:errors path="name"/>

        <form:textarea path="content"  />
        <form:errors path="content" />

        <button type="submit">Save</button>
    </form:form>
</body>
</html>
