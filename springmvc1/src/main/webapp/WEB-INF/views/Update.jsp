<%@page import="com.jspiders.springmvc1.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%
    String msg =(String)request.getAttribute("msg");
    List<StudentPOJO> students = (List<StudentPOJO>)request.getAttribute("students");
    StudentPOJO pojo = (StudentPOJO)request.getAttribute("student");
    
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
<div align="center">
<%if(pojo==null){ %>
<fieldset>
<legend>Select Student For Update</legend>
<form action="./update" method="post">
<table>
<tr>
<td>Enter ID</td>
<td><input type="text" name="id"></td>
</tr>
</table>
<input type="submit" value="SELECT">

</form>

</fieldset>

<%if(msg != null){ %>
<h3>
<%= msg %>
</h3>
<%
}
%>

<%if(students != null){
	%>

<table id="data">
<tr>
<td>ID</td>
<td>NAME</td>
<td>EMAIL</td>
<td>CONTACT</td>
<td>ADDRESS</td>

</tr>
<%
for(StudentPOJO student:students){
	%>
<tr>
<td><%=student.getId()%></td>
<td><%=student.getName()%></td>
<td><%=student.getEmail()%></td>
<td><%=student.getContact()%></td>
<td><%=student.getAddress()%></td>

</tr>
<%
}
%>
</table>
<%
}}
else{
%>
<fieldset>
<legend>Update Student Information</legend>
<form action="./updateStudent" method="post">
<table>
<tr>
<td>ID</td>
<td><%=pojo.getId() %></td>
<td><input type="text" name="id" value="<%=pojo.getId() %>" hidden="true"></td>

</tr>

<tr>
<td>NAME</td>
<td><input type="text" name="name" value="<%=pojo.getName()%>"></td>
</tr>

<tr>
<td>EMAIL</td>
<td><input type="text" name="email" value="<%=pojo.getEmail()%>"></td>
</tr>

<tr>
<td>CONTACT</td>
<td><input type="text" name="contact" value="<%=pojo.getContact()%>"></td>
</tr>

<tr>
<td>ADDRESS</td>
<td><input type="text" name="address" value="<%=pojo.getAddress()%>"></td>
</tr>
</table>
<input type="submit" value="UPDATE">
</form>
</fieldset>

<%} %>
</div>

</body>
</html>

