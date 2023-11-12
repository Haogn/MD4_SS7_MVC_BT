<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/10/2023
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>Danh sách sinh viên</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <table class="table">
                <thead>
                <tr class="bg-dark text-white">
                    <th>StudentCode</th>
                    <th>StudentName</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${list}" var="st">
                    <tr>
                        <td>${st.studentCode}</td>
                        <td>${st.studentName}</td>
                        <td>${st.age} Tuổi</td>
                        <td>${st.gender?"Nam":"Nữ"}</td>
                        <td>
                            <a href="studentservlet?action=edit&&id=${st.studentCode}" type="button" class="btn btn-outline-success">Sửa</a>
                            <a href="studentservlet?action=delete&&id=${st.studentCode}" type="button" class="btn btn-outline-danger">Xoá</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
            <a href="views/student-add.jsp" type="button" class="btn btn-outline-dark">Thêm mới sinh viên</a>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
