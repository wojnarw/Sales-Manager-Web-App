<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />


<c:if test="${not empty param.del}"><h3>${param.del} removed successfully</h3></c:if>

<div class="card shadow mb-4">

    <div class="card-header py-3">
        <h2 class="m-0 font-weight-bold text-info">
            <a href="${pageContext.request.contextPath}/app/templates/add" class="btn btn-success btn-icon-split">
                    <span class="icon text-white-50">
                      <i class="fas fa-plus"></i>
                    </span>
                <span class="text text-white">Add new</span>
            </a>
        </h2>
    </div>

    <div class="card-body">

        <table class="table table-bordered dataTable" id="dataTable">
            <thead>
                <tr role="row">
                    <th>Name</th>
                    <th>Description</th>
                    <th>Last updated</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${templates}" var="template">
                    <tr>
                        <td>
                            <a href="<c:url value="/app/templates/${template.id}" />">${template.name}</a>
                        </td>
                        <td>${template.description}</td>
                        <td>${template.createdAt}</td>
                        <td class="p-1 pl-3">
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
