<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String msg = (String)request.getAttribute("msg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

fieldset table{
	margin:auto;
	text-align:left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

ul {
	list-style-type: none;
	background-color: black;
	overflow: hidden;
	background-color: #333;
}

li {
	float: right;
}

li a {
	display: block;
	margin: 0px;
	padding: 15px;
}

li a:hover {
	background-color: #111;
}
</style>
</head>
<body>
<fieldset>
<legend>LOGIN PAGE</legend>
<form action="./login" method="post">
<table>
<tr>
<td>Username</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="password"></td>
</tr>
</table>
<input type="submit" value="LOGIN">
</form>
</fieldset>

<%if(msg != null){ %>
<h1><%=msg %></h1>
<%} %>
<a href="http://localhost:8080/springmvc1/createAccount">Create Account</a>


</body>
</html>