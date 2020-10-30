<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SalesManager</title>
    <!-- Custom fonts for this template-->
    <link href="${pageContext.request.contextPath}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${pageContext.request.contextPath}/css/sb-admin-2.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-dark">

<nav class="navbar navbar-expand navbar-light bg-white topbar mb-3 static-top shadow">

    <!-- Sidebar Toggle (Topbar) -->
    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
        <i class="fa fa-bars"></i>
    </button>

    <h1 class="m-4 font-weight-bold d-inline" style="color:black">
        <div class="sidebar-brand-icon"><i class="fas fa-dollar-sign rotate-n-15"></i>
            SalesManager
        </div>
    </h1>
    <div class="navbar-nav ml-auto">
        <h2 class="m-4 font-weight-bold d-inline">
            <a class="text-gray-800" href="${pageContext.request.contextPath}/login">Login</a>
        </h2>
        <h2 class="m-4 font-weight-bold d-inline">
            <a class="text-gray-800" href="${pageContext.request.contextPath}/register">Registration</a>
        </h2>
    </div>

</nav>
<!-- End of Topbar -->
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6 mb-4">

            <!-- Illustrations -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Features</h6>
                </div>
                <div class="card-body">
                    <div class="text-center">
                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;" src="${pageContext.request.contextPath}/img/offers.png" alt="">
                    </div>
                    <p>Add some quality, svg illustrations to your project courtesy of <a target="_blank" rel="nofollow" href="https://undraw.co/">unDraw</a>, a constantly updated collection of beautiful svg images that you can use completely free and without attribution! a constantly updated collection of beautiful svg images that you can use completely free and without attribution!</p>
                    <a target="_blank" rel="nofollow" href="https://undraw.co/">Browse Illustrations on unDraw →</a>
                </div>
            </div>
        </div>

        <div class="col-lg-6 mb-4">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Target</h6>
                </div>
                <div class="card-body">
                    <div class="text-center">
                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 15rem;" src="${pageContext.request.contextPath}/img/graph.png" alt="">
                        <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 15rem;" src="${pageContext.request.contextPath}/img/forms.png" alt="">
                    </div>
                </div>
            </div>

            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Development Approach</h6>
                </div>
                <div class="card-body">
                    <p>SB Admin 2 makes extensive use of Bootstrap 4 utility classes in order to reduce CSS bloat and poor page performance. Custom CSS classes are used to create custom components and custom utility classes.</p>
                    <p class="mb-0">Before working with this theme, you should become familiar with the Bootstrap framework, especially the utility classes. Before working with this theme, you should become familiar with the Bootstrap framework, especially the utility classes.</p>
                </div>
            </div>

        </div>

    </div>
</div>

<footer class="sticky-footer bg-gradient-dark">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span class="text-white">Copyright © SalesManager<sup>1</sup> 2020</span>
        </div>
    </div>
</footer>

</body>
</html>