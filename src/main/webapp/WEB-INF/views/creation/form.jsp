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
    <link rel="stylesheet" href="/css/styles.css">
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

        <div id="dataFields">
        <c:forEach items="${fields}" var="field">
            <label for="${field.key}" class="field-name">${field.key}</label>
            <input type="text" id="${field.key}" value="${field.value}"><br />
        </c:forEach>
        </div>

        <button type="submit">Save</button>
    </div>

    <table id="templatesTable">
        <tbody>
            <c:forEach items="${creation.templates}" var="template" varStatus="status">
            <tr>
                <td></td>
                <td>
                    <span class="field-name">Template name: </span><span>${template.name}</span>
                </td>
                <td>
                    <textarea class="template-content" cols="100" oninput="auto_grow(this);" onkeyup="update_fields(this);">${template.content}</textarea>
                </td>
                <td>
                    <c:if test="${not empty template.description}">
                    <span class="field-name">Description: </span><span>${template.description}</span><br/>
                    </c:if>
                    <span class="field-name">Created: </span><span>${template.createdAt}</span><br/>
                    <c:if test="${template.createdAt != template.updatedAt}">
                    <span class="field-name">Updated: </span><span>${template.updatedAt}</span><br/>
                    </c:if>
                </td>
            </tr>
            <c:if test="${status.last}">
                <tr>
                    <td colspan="3">
                        <select>
                            <option value="-1">Select template</option>
                            <c:forEach items="${allTemplates}" var="template">
                                <option value="${template.id}">${template.name}</option>
                            </c:forEach>
<%--                            <form:options value="" itemLabel="name" itemValue="id" />--%>
                        </select>
                        <button>Add template</button>
                    </td>
                </tr>
            </c:if>
            </c:forEach>
        </tbody>
    </table>
</form:form>

<script>
    const dataFieldsEl = document.getElementById("dataFields");

    function update_fields(element) {
        // console.log("update_fields");
        // console.log(element.value);

        const matches = element.value.match(/(?:\{([\w]+)\})/g);
        console.log("matches below:")
        console.log(matches);

        matches.forEach(match => {
            let exists = false;
            console.log("match: " + match);
            match = match.replace("{","");
            match = match.replace("}","");
            let input_fields = dataFieldsEl.querySelectorAll("input");

            input_fields.forEach(element => {
                // console.log(element);

                if(match === element.id) {
                    exists = true;
                }
            });

            if(exists === false) {
                let new_input = document.createElement("input");
                let new_label = document.createElement("label");
                new_input.setAttribute("id", match);
                new_label.className = "field-name";
                new_label.setAttribute("for", match);
                new_label.innerText = match + " ";
                dataFieldsEl.appendChild(new_label);
                dataFieldsEl.appendChild(new_input);
            }
        });
    }

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
