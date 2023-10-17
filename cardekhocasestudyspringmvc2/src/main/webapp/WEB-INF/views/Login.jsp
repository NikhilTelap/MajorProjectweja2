<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Dekho Login Page</title>
<style type="text/css">
#body{
		background-color:black;
		background-image:url('https://www.adgully.com/img/800/201905/car-dekho.jpg');
		background-position:inherit;
		background-repeat:no-repeat;
	background-size:1525px;
	background-position: top;
	}
.text{
color: white;
text-align: center;
}

#login{
	position: center;
	}

#account{
	color: blue;
}	




</style>
</head>
<body id="body">

<fieldset>
<legend class="text">LOGIN</legend>
<form  id="login" action="./login" method="post">
<table>
<tr>
<td class="text">Username</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td class="text">Password</td>
<td><input type="password" name="password"></td>
</tr>

</table>
<input type="submit" value="LOGIN">
</form>
</fieldset>

<%if(msg != null){ %>
<h1 class="text"><%=msg %></h1>
<%} %>

<a  id="account" href="http://localhost:8080/cardekhocasestudyspringmvc2/createAccount">Dont have a Account..! CREATE ACCOUNT</a>

</body>
</html>