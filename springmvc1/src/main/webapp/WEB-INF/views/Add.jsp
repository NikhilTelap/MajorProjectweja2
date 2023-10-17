<%@page import="com.jspiders.springmvc1.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    String msg =(String)request.getAttribute("msg");
   List<StudentPOJO> students = (List<StudentPOJO> )request.getAttribute("students");
    %>
    <jsp:include page="NavBar.jsp"></jsp:include>
    
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
<h1>welcome to add page</h1>
<fieldset>
<legend>Add Students</legend>
<form action="./add" method="post">
<table>
<tr>
<td>Name</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>Contact</td>
<td><input type="text" name="contact"></td>
</tr>
<tr>
<td>Address</td>
<td><input type="text" name="address"></td>
</tr>
<tr>

</table>
<input type="submit" value="ADD">
</form>
</fieldset>

<%if(msg != null){
	%>
	<h1><%=msg %></h1>
	<%}%>
<%if (students != null) {%>
<table id="data">
<tr>
<td>ID</td>
<td>NAME</td>
<td>EMAIL</td>
<td>CONTACT</td>
<td>ADDRESS</td>
</tr>

<%for(StudentPOJO pojo:students) {%>

<tr>
<td><%=pojo.getId() %></td>
<td><%=pojo.getName() %></td>
<td><%=pojo.getEmail() %></td>
<td><%=pojo.getContact() %></td>
<td><%=pojo.getAddress() %></td>
</tr>

<%}
}
%>


</table>
</body>
</html>