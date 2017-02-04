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
    <title>users</title>
</head>
<body>

<h1>User List</h1>

<c:if test="${!empty listUsers}">
  <table border="1">
    <tr>
      <th width="80">ID</th>
      <th width="120">Name</th>
      <th width="120">Age</th>
      <th width="120">isAdmin</th>
      <th width="120">createData</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
      <tr>
        <td>${user.id}</td>
        <td><a href="/userdata/${user.id}" target="_blank">${user.userName}</a></td>
        <td>${user.userAge}</td>
        <td>${user.userIsAdmin}</td>
        <td>${user.userCreatedData}</td>
        <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
      </tr>
    </c:forEach>
  </table>


  <table>
    <tr>
      <td><td><a href="<c:url value='/users/-1'/>">prev</a></td></td>
      <td><td><a href="<c:url value='/users/1'/>">next</a></td></td>
    </tr>

  </table>

</c:if>

<h1>Add User</h1>

<c:url var="addAction" value="/users/add"/>

<form:form action="${addAction}" commandName="user">
  <table>
    <c:if test="${!empty user.userName}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8" disabled="true"/>
          <form:hidden path="id"/>
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="userName">
          <spring:message text="Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="userName"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="userAge">
          <spring:message text="Age"/>
        </form:label>
      </td>
      <td>
        <form:input path="userAge"/>
      </td>
    </tr>

    <tr>
      <td>
        <form:label path="userIsAdmin">
          <spring:message text="isAdmin"/>
        </form:label>
      </td>
      <td>
        <form:checkbox path="userIsAdmin"/>
      </td>
    </tr>


    <tr>
      <td colspan="2">
        <c:if test="${!empty user.userName}">
          <input type="submit"
                 value="<spring:message text="Edit User"/>"/>
        </c:if>
        <c:if test="${empty user.userName}">
          <input type="submit"
                 value="<spring:message text="Add User"/>"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>

<h1>Search</h1>

<c:url var="addAction" value="/userdata/data"/>

<form:form action="${addAction}" modelAttribute="user" target="_blank">
  <table>
    <tr>
      <td>

        <form:input path="id" target="_blank"/>
      </td>
      <td>
        <input type="submit"  value="IdSearch"/>
      </td>
    </tr>
  </table>
</form:form>



<form action="/userdata/name"method="get" target="_blank">
  <table>
    <tr>
      <td>
        <input type="text" name="name" target="_blank"/>
      </td>
      <td>
        <input type="submit"  value="SearchByName"/>
      </td>
    </tr>
  </table>
</form>


<c:url var="addAction" value="/users/add10users"/>
<form:form action="${addAction}" commandName="user">

  <input type="submit"  value="full table"/>
</form:form>


</body>
</html>
