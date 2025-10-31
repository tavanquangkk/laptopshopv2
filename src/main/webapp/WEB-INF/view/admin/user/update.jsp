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
                <title>Update User</title>
                <link href="/css/styles.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile   ");
                        const orgImage = "${currentUser.avatar}";
                        if (orgImage) {
                            const urlImage = "/images/avatar/" + orgImage;
                            $("#avatarPreview").attr("src", urlImage);
                            $("#avatarPreview").css({ "display": "block" });
                        }
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });

                </script>

            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manage Users</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active">Users</li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="row">
                                        <div class="mx-auto  col-md-6 col-12">
                                            <h1>Update Information</h1>
                                            <form:form action="/admin/user/update" method="put"
                                                modelAttribute="currentUser" enctype="multipart/form-data">
                                                <div style="display: none;">
                                                    <label class="form-label">ID:${currentUser.id}</label>
                                                    <form:input type="text" class="form-control" path="id" />
                                                </div>
                                                <div>
                                                    <label class="form-label">Email:</label>
                                                    <form:input type="email" class="form-control" path="email"
                                                        disabled="true" />
                                                </div>

                                                <div>
                                                    <label class="form-label">Phone Number:</label>
                                                    <form:input type="tel" class="form-control" path="phone" />
                                                </div>
                                                <div>
                                                    <label class="form-label">Full Name:</label>
                                                    <form:input type="text" class="form-control" path="fullName" />
                                                </div>
                                                <div>
                                                    <label class="form-label">Address:</label>
                                                    <form:input type="text" class="form-control" path="address" />
                                                </div>
                                                <div class="row mb-3">
                                                    <div class="col">
                                                        <label for="formFile" class="form-label">Role:</label>
                                                        <form:select class="form-select" path="role.id">
                                                            <form:option value="1">ADMIN</form:option>
                                                            <form:option value="2">USER</form:option>
                                                        </form:select>

                                                    </div>

                                                    <div class="col">
                                                        <label for="avatarFile" class="form-label">Avatar:</label>
                                                        <input class="form-control" type="file" id="avatarFile"
                                                            name="avatarFile" accept=".png, .jpg, .jpeg">
                                                    </div>
                                                    <div class="col-12 mb-3"><img alt="avatar preview"
                                                            style="max-height: 250px; display: none;"
                                                            id="avatarPreview">
                                                    </div>

                                                </div>
                                                <button class="btn btn-warning mt-3" type="submit">Update</button>

                                            </form:form>
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
                <script src="/js/scripts.js"></script>

            </body>

            </html>