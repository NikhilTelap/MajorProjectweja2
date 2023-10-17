<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form{
margin-top:10px;
}

form table{
	margin:auto;
	width:100%;
}

tr{
	text-align:center;
	}
	
fieldset table{
margin:auto;
text-align:center;
}	

fieldset {
margin:15px 520px;
text-align:center;

}
legend{
	color:white;
	back-groundcolor:#333;
}

#data{
	background-color:white;
	border:1px solid black;
	width:100%;
	border:1px solid black;
}

#data td{
border:1px solid black;
text-align:center;
}
</style>
</head>
<body>
<fieldset>
<legend>ENTER INFO</legend>
<form action="./createAccount" method="post">
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
<input type="submit" value="SUBMIT">
</form> 
</fieldset>

<%if(msg !=null){ %>
<h1><%=msg %></h1>
<%} %>
</body>
</html>