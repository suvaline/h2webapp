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
<body style="background-color:white;">
<div align="center">
<h2>Add Customer</h2>
</div>


<form action="new">
<table align="center">
<tr>
<td>
Firstname:
</td>
<td> <input type="text" name="firstname"></td>
</tr>
<tr>
<td>
Lastname :
</td><td><input type="text" name="lastname"></td></tr>
<tr>
<td>
Date of birth :
</td><td><input type="date" name="dateofbirth"></td></tr>
<tr>
<td>
Username :</td><td><input type="text" name="username"></td></tr>
<tr>
<td>
Password :</td><td><input type="password" name="password"></td></tr>

</table>
<div align="center">
	<input type="submit" text="Add customer!">
</div>

</form>
<div align="center"><a href="customers">View Customers</a></div>
</body>
</html>
