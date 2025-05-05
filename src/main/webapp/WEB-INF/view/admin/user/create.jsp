<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
                <h1>Create a user</h1>
                <form:form action="/admin/user/create1" method="post" modelAttribute="newUser">
                    <div>
                    <label class="form-label">Email:</label>
                    <form:input type="email" class="form-control" path="email"/>
                    </div>
                    <div>
                    <label  class="form-label">Password:</label>
                    <form:input type="password" class="form-control" path="password"/>
                    </div>
                    <div>
                    <label  class="form-label">Phone Number:</label>
                    <form:input type="tel" class="form-control" path="phone"/>
                    </div>
                    <div>
                    <label class="form-label">Full Name:</label>
                    <form:input type="text" class="form-control" path="fullName"/>
                    </div>
                    <div>
                    <label  class="form-label">Address:</label>
                    <form:input type="text" class="form-control" path="address"/>
                    </div>
                    <button class="btn btn-primary mt-3" type="submit">Create</button>
                    
                </form:form>
            </div>
            
        </div>
        
    </div>
</body>
</html>