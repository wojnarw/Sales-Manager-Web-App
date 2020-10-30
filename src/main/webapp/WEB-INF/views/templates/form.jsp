<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

    <h2>${template.id == null ? "Add new" : "Edit existing"}</h2>
    <form:form cssClass="w-75" method="post" action="${pageContext.request.contextPath}/app/templates/save" modelAttribute="template">
        <form:hidden path="id" />
        <form:hidden path="updatedAt" />

        <form:label path="name" cssClass="w-25">Name: </form:label>
        <form:input path="name" cssClass="w-75" />
        <br>
        <form:errors path="name" cssClass="text-danger" />
        <br>
        <form:label path="description" cssClass="w-25">Description: </form:label>
        <form:input path="description" cssClass="w-75" />
        <br>
        <form:errors path="description" cssClass="text-danger"/>
        <br>
        <form:label path="content" cssClass="w-25">Content: </form:label>
        <form:textarea path="content" cssClass="w-100" rows="10" />
        <br>
        <form:errors path="content" cssClass="text-danger" />
        <button type="submit" class="btn btn-block btn-info text-white">Save</button>
    </form:form>

    <script type="text/javascript">
        console.log("script loaded");
        window.addEventListener("DOMContentLoaded", function () {
            console.log("event fired");
            let currentTime = new Date().toISOString().slice(0, 19).replace('T', ' ');;
            document.getElementById("updatedAt").value = currentTime;
        });

    </script>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />