<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table {
    border-collapse: collapse;
    width: 65%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
tr:nth-child(odd){background-color: lightgray}
th {
    background-color: #4CAF50;
    color: white;
}
</style>
<title>Insert title here</title>

</head>
<body style="background-color:white;">
${msg}
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<table align="center">
       <tr>
    <th>First name</th>
    <th>Last name</th>
    <th>Date Of Birth</th>
    <th>Username</th>
    <th>Password</th>
    <th>Update</th>
    <th>Delete</th>
       </tr>
   <c:forEach var = "customer" items = "${customers}">
       <tr>
          <td>
              <c:out value="${customer.firstName}"/>
          </td>
          <td>
              <c:out value="${customer.lastName}"/>
          </td>
          
          <td>
              <c:out value="${customer.dateOfBirth}"/>
          </td>
          <td>
              <c:out value="${customer.username}"/>
          </td>
          <td>
              <c:out value="${customer.password}"/>
          </td>
          <td>
              <a href="${contextPath}/customers/${customer.id}">Update</a>
          </td>
          <td>
          	  <a href="${contextPath}/customers/delete?id=${customer.id}">Delete</a>
          </td>
       </tr>
    </c:forEach>
       
</table>
<div align="center"><a href="${contextPath}">Add New Customer!</a></div>

</body>
</html>