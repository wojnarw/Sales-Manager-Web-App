<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<div class="card shadow mb-4 mt-4">

    <div class="card-header py-3">
        <h2 class="m-0 font-weight-bold text-gray-700">Last templates
            <a href="${pageContext.request.contextPath}/app/templates/add" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-plus"></i>
                    </span>
                <span class="text text-white">Add new</span>
            </a>
            <a href="${pageContext.request.contextPath}/app/templates" class="btn btn-info btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-list"></i>
                    </span>
                <span class="text text-white">Show all</span>
            </a>
        </h2>
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
                        <a href="${pageContext.request.contextPath}/app/templates/edit/${template.id}" class="btn btn-info btn-icon-split">
                            <span class="icon text-white-50"><i class="fas fa-flag"></i></span>
                            <span class="text text-white">Edit</span>
                        </a>

                        <a href="${pageContext.request.contextPath}/app/templates/delete/${template.id}" class="btn btn-danger btn-icon-split">
                            <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
                            <span class="text text-white">Delete</span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="card-header py-3">
        <h2 class="m-0 font-weight-bold text-gray-700">Last creations
            <a href="${pageContext.request.contextPath}/app/creations/add" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-plus"></i>
                    </span>
                <span class="text text-white">Add new</span>
            </a>
            <a href="${pageContext.request.contextPath}/app/creations" class="btn btn-info btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-list"></i>
                    </span>
                <span class="text text-white">Show all</span>
            </a>
        </h2>
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
                        <a href="${pageContext.request.contextPath}/app/creations/edit/${template.id}" class="btn btn-info btn-icon-split">
                            <span class="icon text-white-50"><i class="fas fa-flag"></i></span>
                            <span class="text text-white">Edit</span>
                        </a>

                        <a href="${pageContext.request.contextPath}/app/creations/delete/${template.id}" class="btn btn-danger btn-icon-split">
                            <span class="icon text-white-50"><i class="fas fa-trash"></i></span>
                            <span class="text text-white">Delete</span>
                        </a>
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