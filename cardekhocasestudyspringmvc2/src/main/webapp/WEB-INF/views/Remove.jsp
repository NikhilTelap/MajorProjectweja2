<%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekhocasestudyspringmvc2.pojo.CarPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%CarPOJO car = (CarPOJO)request.getAttribute("car"); %>
    <%List<CarPOJO> cars = (List<CarPOJO>)request.getAttribute("cars"); %>
    <%String msg = (String)request.getAttribute("msg"); %>
    
        <jsp:include page="NavBar.jsp"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Car</title>
<style type="text/css">
#body{
		background-image:url('https://cdn2.vectorstock.com/i/1000x1000/22/26/tow-truck-takes-away-car-cartoon-vector-11932226.jpg');
		background-color:black;
		background-position:center;
		background-repeat:no-repeat;
	background-size:1200px;
	background-position: top;
	}
h1{
color: white;
}
.text{
		color:white;
		}	
</style>
</head>
<body id="body">
<fieldset>
<legend>REMOVE CAR</legend>
<form action="./remove" method="post">
<table>
<tr>
<td>Enter ID</td>
<td><input required="required" type="number" name="id"></td>
</tr>

</table>
<input type="submit" value="REMOVE">
</form>
</fieldset>


<%if(msg != null){ %>
<h1><%=msg %></h1>

<%} %>

<%if(cars != null){ %>
<fieldset>
<legend>CAR DETAILS</legend>
<table id="data">
<tr>
<td>ID</td>
<td>NAME</td>
<td>BRAND</td>
<td>FUELTYPE</td>
<td>COLOR</td>
<td>PRICE</td>
</tr>

<%for(CarPOJO pojo:cars){ %>
<tr>
<td><%=pojo.getId() %></td>
<td><%=pojo.getName() %></td>
<td><%=pojo.getBrand() %></td>
<td><%=pojo.getFuelType() %></td>
<td><%=pojo.getColor() %></td>
<td><%=pojo.getPrice()%></td>
</tr>

<%} %>

</table>

</fieldset>

<%} %>
</body>
</html>