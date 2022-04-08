<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <title>Accident</title>
</head>

<body>
<div class="container mt-3">
    <div class="row">
        <h4>Здесь можете оставить комментарии</h4>
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${attribute.name}"/></td>
                </tr>
            </tbody>

        </table>
    </div>

</div>
<div class="container mt-3">
    <div class="row">
    </div>
    <div class="row">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Тема</th>
            </tr>
            </thead>
            <form action="<c:url value='/add?id=${post.id}'/>" method="post">
                <input type="text" name="imp" placeholder="write some thing">
                <input type="submit">
            </form>
            <c:forEach items="${attribute2}" var="comment">

                <tr>
                    <td>
                        <c:out value="${comment}"/>
                    </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>

</div>
</body>
</html>
