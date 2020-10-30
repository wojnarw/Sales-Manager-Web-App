
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

    <c:if test="${delete}">
        <h2 class="m-4">Are you sure you want to delete this template?
            <form:form method="post" action="/app/templates/delete/${template.id}" cssClass="d-inline">
                <button type="submit" class="btn btn-danger btn-icon-split">
                    <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
                    <span class="text text-white">Delete</span>
                </button>
                <a href="${pageContext.request.contextPath}/app/templates" class="btn btn-info text text-white">Cancel</a>
            </form:form>
        </h2>
    </c:if>
    <c:if test="${empty delete}">
        <h3 class="m-4">Details
            <a href="${pageContext.request.contextPath}/app/templates/delete/${template.id}" class="btn btn-danger btn-icon-split">
            <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
            <span class="text text-white">Delete</span>
            </a>
        </h3>
    </c:if>

    <div class="row">
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">Name</h6></div>
                <div class="card-body">${template.name}</div>
            </div>
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">Created by</h6></div>
                <div class="card-body">${template.user.username}</div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">Created on</h6></div>
                <div class="card-body">${template.createdAt}</div>
            </div>
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">Updated on</h6></div>
                <div class="card-body">${template.updatedAt}</div>
            </div>
        </div>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-primary">Content</h6></div>
        <div class="card-body">${template.content}</div>
    </div>


<jsp:include page="/WEB-INF/fragments/footer.jsp" />