<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

    <h3 class="m-4">User
        <a href="${pageContext.request.contextPath}/admin/user/ban/${user.id}" class="btn btn-danger btn-icon-split ml-2">
            <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
            <span class="text text-white">
                <c:if test="${user.enabled}">
                    Ban
                </c:if>
                <c:if test="${not user.enabled}">
                    Unban
                </c:if>
            </span>
        </a>
    </h3>

    <div class="row">
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-info">Details</h6></div>
                <div class="card-body">
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Username</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 pb-2">${user.username}</div>
                        </div>
                    </div>
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">E-mail</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 pb-2">${user.email}</div>
                        </div>
                    </div>
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Registered</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 pb-2">${user.registeredOn}</div>
                        </div>
                    </div>
                    <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Enabled</div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800 pb-2"><span <c:if test="${not user.enabled}">class="banned"</c:if>>${user.enabled}</span></div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-info">Roles</h6></div>
                <div class="card-body">
                    <div>
                        <c:forEach items="${user.roles}" var="role" varStatus="status">
                            <span>${role.name}</span><c:if test="${not status.last}">, </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-info">Templates</h6></div>
                <div class="card-body">
                    <div>Templates created: ${numOfTemplates}</div>
                    <div>
                        <ol>
                            <c:forEach items="${user.templates}" var="template">
                                <li>
                                        ${template.name}
                                </li>
                            </c:forEach>
                        </ol>
                    </div>
                </div>
            </div>

            <div class="card shadow mb-4">
                <div class="card-header py-3"><h6 class="m-0 font-weight-bold text-info">Creations</h6></div>
                <div class="card-body">
                    <div>Creations constructed: ${numOfCreations}</div>
                    <div>
                        <ol>
                            <c:forEach items="${user.creations}" var="creation">
                                <li>
                                        ${creation.name}
                                </li>
                            </c:forEach>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>


<jsp:include page="/WEB-INF/fragments/footer.jsp" />