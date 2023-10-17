<%@page import="com.jspiders.springmvc1.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="NavBar.jsp"/>
    <%    String msg = (String)request.getAttribute("msg");
			StudentPOJO student = (StudentPOJO)request.getAttribute("student");    
    %>

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
<legend>Search Student</legend>
<form action="./search" method="post">
<table>
<tr>
<td>Enter id</td>
<td><input type="text" name="id"></td>
</tr>
</table>
<input type="submit" value="Search">
</form>
</fieldset>
<%if(msg != null){ %>
<h1><%=msg %></h1>
<%} %>

<%if(student != null){ %>

<table id="data">
<tr>
<td>ID</td>
<td>NAME</td>

<td>EMAIL</td>

<td>CONTACT</td>

<td>ADDRESS</td>

</tr>

<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getContact() %></td>
<td><%=student.getAddress() %></td>
</tr>

</table>

<%} %>
</body>
</html>