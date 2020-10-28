<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wojtek
  Date: 27.10.2020
  Time: 05:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
<%--    <link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}"/>--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/login" method="get">
    <button class="btn btn-md btn-warning btn-block" type="Submit">Go To Login Page</button>
</form>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form:form autocomplete="off" action="${pageContext.request.contextPath}/register"
                       modelAttribute="user" method="post" class="form-horizontal"
                  role="form">
                <h2>Registration Form</h2>
                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input path="username" placeholder="Name" class="form-control"/>
                        <form:errors path="username"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <form:input path="email" placeholder="E-mail" class="form-control"/>
                        <form:errors path="email"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <form:password path="password" placeholder="Password" class="form-control"/>
                        <form:errors path="password"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary btn-block">Register User</button>
                    </div>
                </div>

                <h2><span class="text-success">${successMessage}</span></h2>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>