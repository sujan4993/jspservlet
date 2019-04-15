<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: developer
  Date: 4/12/19
  Time: 7:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="${pageContext.request.contextPath}/addPerson.jsp" class="btn btn-success"> Add New Person</a>

</div>
<div class="container">
    <c:if test="${isSaved}">
        <div class="alert alert-success">
            <strong>Success!</strong> Successfully Saved...
        </div>
    </c:if>
    <div class="row">
        <table width="100%" border="1" class="table thead-light">
            <tr>
                <td>ID</td>
                <td>First name</td>
                <td>Last name</td>
                <td>Age</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${personList}" var="p">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.firstname}</td>
                    <td>${p.lastname}</td>
                    <td>${p.age}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/updatePerson?id=${p.id}" class="btn btn-warning">Update</a>
                        <a href="${pageContext.request.contextPath}/deletePerson?id=${p.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>


    </div>
</div>

</body>
</html>
