
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<h2>${creation.id == null ? "Add new" : "Edit existing"}</h2>
<form:form method="post" action="${pageContext.request.contextPath}/app/creations/save" modelAttribute="creation">
    <div id="creationHeader">
        <form:hidden path="id" />

        <form:hidden path="updatedAt" />

        <form:label path="name" class="field-name">Creation name: </form:label>
        <form:input path="name" />
        <form:errors path="name"/>

        <form:label path="description" class="field-name">Creation description: </form:label>
        <form:input path="description" />
        <form:errors path="description"/>

        <button type="submit" class="btn btn-primary text text-white d-inline">Save creation</button>
        <br />

        <div id="dataFields">
<%--        <c:forEach items="${fields}" var="field">--%>
<%--            <label for="${field.key}" class="field-name">${field.key}</label>--%>
<%--            <input type="text" id="${field.key}" value="${field.value}" path="inputFields"><br />--%>
<%--        </c:forEach>--%>
            <hr>
        <c:forEach items="${creation.inputFields}" var="field" varStatus="status">
            <label for="${field.value}" class="field-name">${field.name}</label>
            <input type="hidden" id="${field.name}_${status.index}" value="${field.name}" name="fieldList${[status.index]}.key" path="creation.inputFields">
            <input type="text" id="${field.value}_${status.index}" value="${field.value}" name="fieldList${[status.index]}.value" path="creation.inputFields">
        </c:forEach>
            <hr>
<%--        <c:forEach items="${inputFields}" var="field">--%>
<%--            <label for="${field.value}" class="field-name">${field.name}</label>--%>
<%--            <input type="hidden" id="${field.name}" value="${field.name}" name="name" path="inputFields"><br />--%>
<%--            <input type="text" id="${field.value}" value="${field.value}" name="value" path="inputFields"><br />--%>
<%--        </c:forEach>--%>

<%--        <form:form modelAttribute="inputFields" action="/">--%>
<%--        <c:forEach var="field" items="${inputFields}" varStatus="status">--%>
<%--            <form:input path="field[${status.index}].name" name="FName" id="FName" value="" />--%>
<%--            <form:input path="field[${status.index}].value" name="LName" id="LName" value="" />--%>
<%--        </c:forEach>--%>
<%--        </form:form>--%>
        </div>

    </div>

</form:form>

<form:form method="post" action="${pageContext.request.contextPath}/app/creations/${creation.id}/templates/save" modelAttribute="creationTemplates">
    <table id="templatesTable">
        <tbody id="templatesBody">
            <c:forEach items="${creationTemplates}" var="template" varStatus="status">
            <tr id="templateRow${status.index}">
                <td>
                    <span class="field-name"> </span><span>${template.name}</span>
                </td>
                <td class="templateControls">
<%--                    <c:if test="${not status.first}">--%>
                        <button class="btn btn-facebook btn-icon-split p-1" type="button" id="moveUp${status.index}" onclick="const e = $(this).parent().parent();e.prev().insertAfter(e);">↑</button>
<%--                    </c:if>--%>
<%--                    <c:if test="${not status.last}">--%>
                        <button class="btn btn-facebook btn-icon-split p-1" type="button" id="moveDown${status.index}" onclick="const e = $(this).parent().parent();e.next().insertBefore(e);">↓</button>
<%--                    </c:if>--%>
                </td>
                <td>
                    <textarea class="template-content" cols="80" oninput="auto_grow(this);" onkeyup="update_fields(this);">${template.content}</textarea>
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
        </tbody>
        <tfoot>
                <tr>
                    <td>
                    </td>
                    <td>
                    </td>
                    <td colspan="2">
                        <select>
                            <option value="-1">Select template</option>
                            <c:forEach items="${allTemplates}" var="template">
                                <option value="${template.id}">${template.name}</option>
                            </c:forEach>
<%--                            <form:options value="" itemLabel="name" itemValue="id" />--%>
                        </select>
                        <button class="btn btn-primary text text-white">Add template</button>
                    </td>
                </tr>
            </c:if>
            </c:forEach>
        </tfoot>
    </table>
    <button type="submit" class="btn btn-primary text text-white text-right">Save assigned templates</button>
</form:form>

<script>

    //set last updated datetime
    window.addEventListener("DOMContentLoaded", function () {
        console.log("event fired");
        let currentTime = new Date().toISOString().slice(0, 19).replace('T', ' ');;
        document.getElementById("updatedAt").value = currentTime;
    });

    //create new input fields based on textarea content
    const dataFieldsEl = document.getElementById("dataFields");

    function update_fields(element) {
        // console.log("update_fields");
        // console.log(element.value);

        const matches = element.value.match(/(?:\{([\w ]+)\})/g);
        console.log("matches below:")
        console.log(matches);

        matches.forEach(match => {
            let exists = false;
            console.log("match: " + match);
            match = match.replace(/[\{\}]/g,"");
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

    //textarea grow with input
    function auto_grow(element) {
        element.style.height = "5px";
        element.style.height = (element.scrollHeight)+"px";
    }

    //resize textareas based on data loaded from database
    const setTextareaStartingHeight = function() {
        const templateContentElems = document.querySelectorAll(".template-content");
        templateContentElems.forEach(element => auto_grow(element));
    }

    document.addEventListener("DOMContentLoaded", function () {
        setTextareaStartingHeight();
        const templateContentElems = document.querySelectorAll(".template-content");
        templateContentElems.forEach(element => {update_fields(this)});
    });

</script>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />