<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<div class="card shadow mb-4">

    <div class="card-header py-3">
        <h2 class="m-0 font-weight-bold text-gray-700">
            User list
        </h2>
    </div>

    <div class="card-body">

    <table class="table table-bordered dataTable" id="dataTable">
        <thead>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Username
                </th>
                <th>
                    E-mail
                </th>
                <th>
                    Registered on
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                    <a <c:if test="${not user.enabled}">class="banned"</c:if> href="<c:url value="/admin/user/${user.id}" />">${user.username}</a>
                </td>
                <td>
                        ${user.email}
                </td>
                <td>
                        ${user.registeredOn}
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


    <script>
        // Call the dataTables jQuery plugin
        $(document).ready(function() {
            $('#dataTable').DataTable( {
                "order": [[3, "desc" ]]
            });
        });
    </script>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />