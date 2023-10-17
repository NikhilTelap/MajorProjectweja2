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
<title>Insert title here</title>
</head>
<style type="text/css">
#body{
		background-image:url('https://media.istockphoto.com/id/820815780/vector/magnifying-glass-in-human-hand-with-car.jpg?s=612x612&w=0&k=20&c=6g3GffVIKqmx3etdsQLIWzd3ta0e6G2NREk7JA62Wng=');
		background-color:black;
		background-position:top;
		background-repeat:no-repeat;
		background-size:1200px;
	


	}
h1{
color: white;}	
</style>
<body id="body">

<fieldset>
<legend>SEARCH CAR</legend>
<form action="./search" method="post">
<table>
<tr>
<td>ENTER ID</td>
<td><input required="required" type="number" name="id"></td>

</table>
<input type="submit" value="SEARCH">
</form>
</fieldset>




<%if(msg != null){ %>
<h1><%=msg %></h1>

<%} %>

<%if(car != null){ %>
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


<tr>
<td><%=car.getId() %></td>
<td><%=car.getName() %></td>
<td><%=car.getBrand() %></td>
<td><%=car.getFuelType() %></td>
<td><%=car.getColor() %></td>
<td><%=car.getPrice()%></td>
</tr>


</table>
<%} %>

</fieldset>

</body>
</html>