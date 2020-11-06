<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<h2>Account details</h2>
<hr>

    <form:form method="post" action="${pageContext.request.contextPath}/app/user/save" modelAttribute="user">
        <form:hidden path="id" />
        <div>
            <form:label path="username" cssClass="w-25 text-right">Username: </form:label>
            <form:input path="username" cssClass="w-25"/>
            <form:errors path="username" cssClass="text-danger" />
        </div>
        <div>
            <form:label path="email" cssClass="w-25 text-right">E-mail: </form:label>
            <form:input path="email" cssClass="w-25"/>
            <form:errors path="email" cssClass="text-danger" />
        </div>
        <div>
            <form:label path="password" cssClass="w-25 text-right">New password: </form:label>
            <form:password path="password" cssClass="w-25" autocomplete="false"/>
            <form:errors path="password" cssClass="text-danger" />
        </div>
        <div>
            <label for="rePassword" class="w-25 text-right">Retype password: </label>
            <input type="password" id="rePassword" class="w-25" autocomplete="false"/>
            <span id="passwordValidity" class="text-danger"></span>
        </div>
        <div>
            <label for="formSubmit" class="w-25 text-right">&nbsp;</label>
            <input type="submit" id="formSubmit"class="w-25 btn btn-info" value="Save" disabled="true"/>
        </div>

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

<jsp:include page="/WEB-INF/fragments/footer.jsp" />