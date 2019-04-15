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
</head>
<body>


<div class="row">
    <form action="${pageContext.request.contextPath}/updatePerson" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id" value="${person.id}" readonly/> </td>
            </tr>
            <tr>
                <td>First name</td>
                <td><input type="text" name="firstname" value="${person.firstname}"/> </td>
            </tr>

            <tr>
                <td>Lastname</td>
                <td><input type="text" name="lastname" value="${person.lastname}"/> </td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="${person.age}"/> </td>
            </tr>
            <tr>
               x` <td><input type="submit" value="Update"/> </td>
            </tr>
        </table>


    </form>
</div>
</body>
</html>
