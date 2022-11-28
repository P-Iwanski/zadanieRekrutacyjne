<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<!-- Bootstrap core CSS-->
<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template-->
<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="/resources/css/bootstrap-reboot.css" rel="stylesheet">
<body>
<div>
    <h5>Wyszukaj nauczyciela po jego imieniu i nazwisku</h5>
    <form action="/wyszukajNauczyciela" method="get">
        <input type="text" name="firstName" placeholder="podaj imię">
        <input type="text" name="lastName" placeholder="podaj nazwisko">
        <input type="submit" value="Szukaj">
    </form>
</div>
<table class="table">
    <thead>
    <th>age</th>
    <th>email</th>
    <th>imię</th>
    <th>nazwisko</th>
    <th>przedmiot</th>
    <th>studenci</th>
    <th>zmiana profilu</th>
    <th>usunięcie nauczyciela</th>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="teachers">
        <tr>
            <td><c:out value="${teachers.age}"/></td>
            <td><c:out value="${teachers.email}"/></td>
            <td><c:out value="${teachers.firstName}"/></td>
            <td><c:out value="${teachers.lastName}"/></td>
            <td><c:out value="${teachers.subject}"/></td>
            <td><c:out value="${teachers.students}"/></td>
            <td>
                <a class="dropdown-item" href="/edit?id=${teachers.id}">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Zmiana profilu </a>
            </td>
            <td>
                <a class="dropdown-item" href="/delete?id=${teachers.id}">
                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                    usunięcie profilu </a>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</html>
