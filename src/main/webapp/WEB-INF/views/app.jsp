<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<div class="card shadow mb-4">

    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Last templates
            <a class="btn btn-info text-white" href="${pageContext.request.contextPath}/app/templates/add">Add new</a>
            <a class="btn btn-facebook text-white" href="${pageContext.request.contextPath}/app/templates">Show all</a>
        </h6>
    </div>

    <div class="card-body">

        <table id="templateTable" class="table table-bordered dataTable">
            <thead>
                <tr>
                    <th>
                        Template name
                    </th>
                    <th>
                        Description
                    </th>
                    <th>
                        Last updated
                    </th>
                    <th>
                    </th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lastFiveTemplates}" var="template">
                <tr>
                    <td>
                        <a href="<c:url value="/app/templates/${template.id}" />">${template.name}</a>
                    </td>
                    <td>
                            ${template.description}
                    </td>
                    <td>
                            ${template.updatedAt}
                    </td>
                    <td>
                        <a class="btn btn-info text-white" href="<c:url value="/app/templates/edit/${template.id}" />">Edit</a>
                        <a class="btn btn-warning text-white" href="<c:url value="/app/templates/delete/${template.id}" />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Last creations
            <a class="btn btn-info text-white" href="${pageContext.request.contextPath}/app/creations/add">Add new</a>
            <a class="btn btn-facebook text-white" href="${pageContext.request.contextPath}/app/creations">Show all</a>
        </h6>
    </div>


    <div class="card-body">

        <table id="creationTable" class="table table-bordered dataTable">
            <thead>
                <tr>
                    <th>
                        Creation name
                    </th>
                    <th>
                        Description
                    </th>
                    <th>
                        Last updated
                    </th>
                    <th>
                    </th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${lastFiveCreations}" var="creation">
                <tr>
                    <td>
                        <a href="<c:url value="/app/creations/${creation.id}" />">${creation.name}</a>
                    </td>
                    <td>
                            ${creation.description}
                    </td>
                    <td>
                            ${creation.updatedAt}
                    </td>
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
        $('#templateTable').DataTable( {
            "order": [[2, "desc" ]],
            "columnDefs": [ { "orderable": false, "targets": 3 } ],
            "paging": false,
            "searching": false,
            "info": false
        });

        $('#creationTable').DataTable( {
            "order": [[2, "desc" ]],
            "columnDefs": [ { "orderable": false, "targets": 3 } ],
            "paging": false,
            "searching": false,
            "info": false
        });
    });
</script>


<jsp:include page="/WEB-INF/fragments/footer.jsp" />