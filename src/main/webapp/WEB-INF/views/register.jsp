<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Registration Form</title>--%>
<%--&lt;%&ndash;    <link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}"/>&ndash;%&gt;--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="/login" method="get">--%>
<%--    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>--%>
<%--</form>--%>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-6 col-md-offset-3">--%>
<%--            <form:form autocomplete="off" action="${pageContext.request.contextPath}/register"--%>
<%--                       modelAttribute="user" method="post" class="form-horizontal"--%>
<%--                  role="form">--%>
<%--                <h2>Registration Form</h2>--%>
<%--                <div class="form-group">--%>
<%--                    <div class="col-sm-9">--%>
<%--                        <form:input path="username" placeholder="Name" class="form-control"/>--%>
<%--                        <form:errors path="username"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <div class="col-sm-9">--%>
<%--                        <form:input path="email" placeholder="E-mail" class="form-control"/>--%>
<%--                        <form:errors path="email"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <div class="col-sm-9">--%>
<%--                        <form:password path="password" placeholder="Password" class="form-control"/>--%>
<%--                        <form:errors path="password"/>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="form-group">--%>
<%--                    <div class="col-sm-9">--%>
<%--                        <button type="submit" class="btn btn-primary btn-block">Register User</button>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <h2><span class="text-success">${successMessage}</span></h2>--%>

<%--            </form:form>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>

<html lang="en"><head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SalesManager - Register</title>

    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-my-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form:form autocomplete="off" action="${pageContext.request.contextPath}/register"
                                   modelAttribute="user" method="post" class="user" role="form">
                            <div class="form-group">
                                <form:input path="username" placeholder="Username" class="form-control form-control-user"/>
                                <form:errors path="username" cssClass="text-danger ml-3"/>
                            </div>
                            <div class="form-group">
                                <form:input path="email" placeholder="E-mail Address" class="form-control form-control-user"/>
                                <form:errors path="email" cssClass="text-danger ml-3"/>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <form:password path="password" placeholder="Password" class="form-control form-control-user" autocomplete="new-password"/>
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user" id="repeatPassword" placeholder="Repeat Password">
                                </div>
                                <span id="passwordValidity" class="text-danger ml-4"></span>
                                <form:errors path="password" cssClass="text-danger ml-4"/>
                            </div>
                            <button type="submit" class="btn btn-primary btn-user btn-block" id="formSubmit" disabled>Register Account</button>
                        </form:form>

                        <c:if test="${not empty successMessage}">
                            <h3><span class="text-success">${successMessage}</span></h3>
                            <h5 class="text-center" id="redirectText">Redirecting</h5>
                            <script>
                                const redirectTextEl = document.getElementById("redirectText");
                                setInterval(function (){
                                    redirectTextEl.innerText += ".";
                                }, 1000);

                                setTimeout(function (){
                                    window.location.replace("${pageContext.request.contextPath}/login");
                                }, 4000);
                            </script>
                        </c:if>

                        <hr>
                        <div class="text-center">
                            <a class="small" href="${pageContext.request.contextPath}/login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="${pageContext.request.contextPath}/js/validate-passwords.js"></script>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/js/sb-admin-2.min.js"></script>


</body></html>