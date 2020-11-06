<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="/WEB-INF/fragments/header.jsp" />

<!-- 404 Error Text -->
<div class="text-center">
    <div class="error mx-auto" data-text="403">403</div>
    <p class="lead text-gray-800 mb-5">Page Not Found</p>
    <p class="text-gray-500 mb-0">It looks like you found a glitch in the matrix...</p>
    <a href="${pageContext.request.contextPath}/app">&larr; Back to Dashboard</a>
</div>

<jsp:include page="/WEB-INF/fragments/footer.jsp" />