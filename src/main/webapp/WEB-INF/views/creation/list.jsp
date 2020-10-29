<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />


<c:if test="${not empty param.del}"><h3>${param.del} removed successfully</h3></c:if>

<div class="card shadow mb-4">

    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Creations <a class="btn btn-info text-white" href="<c:url value="/app/creations/add"/>">Add new</a></h6>
    </div>

    <div class="card-body">

        <table class="table table-bordered dataTable" id="dataTable">
            <thead>
            <tr role="row">
                <th>Name</th>
                <th>Description</th>
                <th>Last updated</th>
                <th></th>
            </thead>

            <tbody>
            <c:forEach items="${creations}" var="creation">
                <tr>
                    <td>
                        <a href="<c:url value="/app/creations/${creation.id}" />">${creation.name}</a>
                    </td>
                    <td>${creation.description}</td>
                    <td>${creation.createdAt}</td>
                    <td>
                        <a class="btn btn-info text-white" href="<c:url value="/app/creations/edit/${creation.id}" />">Edit</a>
                        <a class="btn btn-warning text-white" href="<c:url value="/app/creations/delete/${creation.id}" />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script>
    // Call the dataTables jQuery plugin
    $(document).ready(function() {
        $('#dataTable').DataTable( {
            "order": [[2, "desc" ]],
            "columnDefs": [ { "orderable": false, "targets": 3 } ]
        });
    });
</script>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />
