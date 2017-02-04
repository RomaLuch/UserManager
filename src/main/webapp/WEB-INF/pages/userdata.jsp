<%--
  Created by IntelliJ IDEA.
  User: RLuchinsky
  Date: 03.02.2017
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>UserData</title>
</head>

<br/>
<br/>

<h1>User data</h1>

<table border="1">
  <tr>
    <th width="80">ID</th>
    <th width="120">Name</th>
    <th width="120">Age</th>
    <th width="120">isAdmin</th>
    <th width="120">createdData</th>
  </tr>
  <tr>
    <td>${user.id}</td>
    <td>${user.userName}</td>
    <td>${user.userAge}</td>
    <td>${user.userIsAdmin}</td>
    <td>${user.userCreatedData}</td>
  </tr>
</table>

</html>
