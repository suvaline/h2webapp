<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
table{
    border-collapse: collapse;
    width: 40%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
tr:nth-child(odd){background-color: lightgray}
th, h2{
    background-color: #4CAF50;
    color: white;
}
h2{
width: 40%;
text-align: center;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<div align="center">
<h2>Update Customer Information</h2>
</div>

</head>
<body style="background-color:white;">
<form action="update">

<table align="center">
<input type="hidden" value="${customer.id}" name="id">

<tr><td>Firstname :</td><td><input type="text" value="${customer.firstName}" name="firstname"></td></tr>
<tr><td>
Lastname :</td><td><input type="text" value="${customer.lastName}" name="lastname"></td></tr>
<tr><td>
Date of birth :</td><td><input type="date" value="${customer.dateOfBirth}" name="dateofbirth"></td></tr>
<tr><td>
Username :</td><td><input type="text" value="${customer.username}" name="username"></td></tr>
<tr><td>
Password :</td><td><input type="password" value="${customer.password}" name="password"></td></tr>

</table>
<div align="center"><input type="submit"></div>

</form>
<div align="center"><a href="${contextPath}/h2webapp/customers">View Customers</a></div>
<div align="center"><a href="${contextPath}/h2webapp">Add New Customer</a></div>

</body>
</html>