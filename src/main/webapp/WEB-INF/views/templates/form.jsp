<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 19.10.2020
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Template creator</title>
    <link rel="stylesheet" href="/css/styles.css">

</head>
<body>
<jsp:include page="/WEB-INF/fragments/menu.jsp" />

<h3><a href="<c:url value="/app/templates"/>">Back to list</a></h3>
    <h2>Template ${template.id == null ? "add" : "edit"} form</h2>
    <form:form method="post" action="${pageContext.request.contextPath}/app/templates/save" modelAttribute="template">
        <form:hidden path="id" />
        <form:hidden path="updatedAt" />

        <form:label path="name">Template name: </form:label>
        <form:input path="name" />
        <form:errors path="name"/>

        <form:label path="description">Template description: </form:label>
        <form:input path="description" />
        <form:errors path="description"/>

        <form:textarea path="content"  />
        <form:errors path="content" />

        <button type="submit">Save</button>
    </form:form>

    <script type="text/javascript">
        console.log("script loaded");
        window.addEventListener("DOMContentLoaded", function () {
            console.log("event fired");
            let currentTime = new Date().toISOString().slice(0, 19).replace('T', ' ');;
            document.getElementById("updatedAt").value = currentTime;
        });

    </script>
</body>
</html>
