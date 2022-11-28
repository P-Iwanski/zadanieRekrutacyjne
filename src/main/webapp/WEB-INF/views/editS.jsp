<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Register</title>

    <!-- Bootstrap core CSS-->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin.css" rel="stylesheet">

</head>

<body class="bg-dark">

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Zapisz Studenta</div>
        <div class="card-body">
            <form:form method="post" modelAttribute="student">


                <div class="form-group">
                    <div class="form-label-group">
                        <form:label for="firstName" path="firstName">firstName</form:label>
                        <form:input path="firstName" type="text" id="firstName" class="form-control" placeholder="First name" required="required" autofocus="autofocus"/>
                        <form:errors path="firstName" cssStyle="color: red" element="div"/>
                    </div>

                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label for="lastName" path="lastName">lastName</form:label>
                        <form:input path="lastName" type="text" id="lastName" class="form-control" placeholder="Last name" required="required" autofocus="autofocus"/>
                        <form:errors path="lastName" cssStyle="color: red" element="div"/>
                    </div>

                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label for="email" path="email">email</form:label>
                        <form:input path="email" type="text" id="inputEmail" class="form-control" placeholder="Email address" required="required"/>
                        <form:errors path="email" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="age" for="age">age</form:label>
                        <form:input path="age" type="text" id="age" class="form-control" placeholder="age" required="required" autofocus="autofocus"/>
                        <form:errors path="age" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="specialization" for="specialization">specialization</form:label>
                        <form:input path="specialization" type="text" id="specialization" class="form-control" placeholder="specialization" required="required" autofocus="autofocus"/>
                        <form:errors path="specialization" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <form:label path="teachers" for="teachers">teachers</form:label>
                        <form:input path="teachers" type="text" id="teachers" class="form-control" placeholder="teachers" required="required" autofocus="autofocus"/>
                        <form:errors path="teachers" cssStyle="color: red" element="div"/>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Register"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form:form>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

</body>

</html>