<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 21.10.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account details</title>
</head>
<body>
    <h3><a href="<c:url value="/app"/>">Back to dashboard</a></h3>
    <h2>Template ${user.id == null ? "add" : "edit"} form</h2>
    <form:form method="post" action="${pageContext.request.contextPath}/user/save" modelAttribute="user">
        <form:hidden path="id" />
        <form:label path="username">Username: </form:label>
        <form:input path="username" disabled="{isDisabled}" />
        <form:errors path="username"/>

        <form:label path="email">E-mail: </form:label>
        <form:input path="email" />
        <form:errors path="email"/>

        <form:label path="password">New password: </form:label>
        <form:password path="password" />
        <form:errors path="password"/>

        <label for="rePassword">Retype password: </label>
        <input type="password" id="rePassword" />
        <span id="passwordValidity"></span>

        <button type="submit" id="formSubmit">Save</button>
    </form:form>

    <c:if test="${not empty result}">
        <p>${result}</p>
    </c:if>

    <script>
        let passwordEl = document.getElementById("password");
        let rePasswordEl = document.getElementById("rePassword");
        let errorEl = document.getElementById("passwordValidity");

        const validatePassword = function (event) {
            if(passwordEl.value !== rePasswordEl.value) {
                errorEl.innerText = "Passwords don't match!";
                document.getElementById("formSubmit").setAttribute("disabled", "true");
            }
            else {
                errorEl.innerText = "";
                document.getElementById("formSubmit").removeAttribute("disabled");
            }
        }
        rePasswordEl.addEventListener("keyup", validatePassword);
    </script>
</body>
</html>
