<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Create User</title>
                <!-- Latest compiled and minified CSS -->

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <!-- <link rel="stylesheet" href="/css/demo.css"> -->


            </head>

            <body>
                <div class="container mt-5">
                    <div class="row">
                        <div class="mx-auto  col-md-6 col-12">
                            <h1>Delete user ${willDeleteUser.id}</h1>
                            <form:form action="/admin/user/delete" method="post" modelAttribute="willDeleteUser">
                                <div style="display: block;">
                                    <label class="form-label">ID:${willDeleteUser.id}</label>
                                    <form:input type="text" class="form-control" path="id" />
                                </div>
                                <div class="alert alert-danger" role="alert">
                                    Are you serious ?
                                </div>

                                <button class="btn btn-warning mt-3" type="submit">Delete</button>

                            </form:form>
                        </div>

                    </div>

                </div>
            </body>

            </html>