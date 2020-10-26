<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 25.10.2020
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>

<h3><a href="/app/creation">Back to list</a></h3>
<h2>Creation ${creation.id == null ? "add" : "edit"} form</h2>
<form:form method="post" action="${pageContext.request.contextPath}/app/creation/save" modelAttribute="creation">
    <div id="creationHeader">
        <form:hidden path="id" />

        <form:hidden path="updatedAt" />

        <form:label path="name" class="field-name">Creation name: </form:label>
        <form:input path="name" />
        <form:errors path="name"/>

        <form:label path="description" class="field-name">Creation description: </form:label>
        <form:input path="description" />
        <form:errors path="description"/>
        <br />

        <c:forEach items="${fields}" var="field">
            <label for="${field.key}" class="field-name">${field.key}</label>
            <input type="text" id="${field.key}" value="${field.value}"><br />
        </c:forEach>

        <button type="submit">Save</button>
    </div>

    <table id="templatesTable">
        <tbody>
            <c:forEach items="${creation.templates}" var="template">
            <tr>
                <td><span class="field-name">Template name: </span>${template.name}</td>
                <td>
                    <textarea class="template-content" cols="100" oninput="auto_grow(this)">${template.content}</textarea>
                </td>
                <td>
                    <span class="field-name">Description: </span><span>${template.description}</span><br/>
                    <span class="field-name">Created: </span><span>${template.createdAt}</span><br/>
                    <c:if test="${template.createdAt != template.updatedAt}">
                    <span class="field-name">Updated: </span><span>${template.updatedAt}</span><br/>
                    </c:if>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</form:form>

<script>
    function auto_grow(element) {
        element.style.height = "5px";
        element.style.height = (element.scrollHeight)+"px";
    }

    const setTextareaStartingHeight = function() {
        const templateContentElems = document.querySelectorAll(".template-content");
        templateContentElems.forEach(element => auto_grow(element));
    }

    document.addEventListener("DOMContentLoaded", setTextareaStartingHeight);

</script>
</body>
</html>
