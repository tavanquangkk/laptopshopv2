<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Quang SE - Dự án laptopshop" />
                <meta name="author" content="Quang SE" />
                <title>Product Detail</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Product Detail</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Product</li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="row">
                                        <div class="col-12 mx-auto">
                                            <div class="table-header d-flex justify-content-between">
                                                <h3>Product detail with id = ${id}</h3>

                                            </div>
                                            <hr />
                                            <div class="card" style="width: 60%;">
                                                <img src="${urlImage}" alt="" class="card-img-top"
                                                    style="width: 200px;">
                                                <div class="card-header">
                                                    Product Information
                                                </div>

                                                <ul class="list-group list-group-flush">
                                                    <li class="list-group-item"><b>ID:</b> ${id}</li>
                                                    <li class="list-group-item"><b>Name:</b> ${productDetail.name}
                                                    </li>
                                                    <li class="list-group-item"><b>Price:</b> ${productDetail.price}
                                                    </li>
                                                    <li class="list-group-item"><b>Short Description:</b>
                                                        ${productDetail.shortDesc}</li>
                                                </ul>
                                            </div>
                                            <a href="/admin/product" class="btn btn-primary mt-3">Back</a>

                                        </div>
                                    </div>
                                </div>


                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="js/scripts.js"></script>

            </body>

            </html>