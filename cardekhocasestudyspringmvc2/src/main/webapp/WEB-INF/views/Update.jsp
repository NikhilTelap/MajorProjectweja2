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
<title>Update Car</title>
</head>
<style type="text/css">
#body{
		background-color:black;
      background-image: url('https://www.girnarsoft.com/wp-content/uploads/2020/02/automobile-car.png');
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
<body id="body">

	<%
	if (car == null) {
	%>
	<fieldset>
		<legend>UPDATE CAR</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td  class="text">Enter ID</td>
					<td><input required="required" type="number" name="id"></td>
				</tr>


			</table>
			<input type="submit" value="SUBMIT">
		</form>
	</fieldset>


<%
	if (msg != null) {
	%>
	<h1 class="text"><%=msg%></h1>
	<%
	}
	%>


	<%
	} else {
	%>
	<fieldset>
		<legend>Update Student</legend>
		<form action="./updateCar" method="post">
			<table id="data">
				<tr>
					<td>ID</td>
					<td><%=car.getId()%></td>
					<td><input type="text" name="id" value="<%=car.getId()%>"
						hidden="true"></td>
				</tr>

				<tr>
					<td>CAR NAME</td>
					<td><input required="required" type="text" name="name" value="<%=car.getName()%>"></td>
				</tr>

				<tr>
					<td>CAR BRAND</td>
					<td><input required="required" type="text" name="brand"
						value="<%=car.getBrand()%>"></td>
				</tr>

				<tr>
					<td>FUEL TYPE</td>
					<td><input required="required" type="text" name="fuelType"
						value="<%=car.getFuelType()%>"></td>
				</tr>
				
				<tr>
					<td>CAR COLOR</td>
					<td><input required="required" type="text" name="color" value="<%=car.getColor()%>"></td>
				</tr>

				<tr>
					<td>PRICE</td>
					<td><input required="required" type="text" name="price"
						value="<%=car.getPrice()%>"></td>
				</tr>
				
				


			</table>
			<input type="submit" value="UPDATE">
		</form>

	</fieldset>

	<%
	}
	%>



	

	<%
	if (cars != null) {
	%>
	<fieldset>
		<legend>CARS DETAILS</legend>
		<table id="data">
			<tr>
				<td>ID</td>
				<td>CAR NAME</td>

				<td>CAR BRAND</td>

				<td>FUELTYPE</td>
				<td>COLOR</td>
				<td>PRICE</td>

			</tr>

			<%
			for (CarPOJO pojo : cars) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>

				<td><%=pojo.getBrand()%></td>

				<td><%=pojo.getFuelType()%></td>
				<td><%=pojo.getColor() %></td>

				<td><%=pojo.getPrice()%></td>

			</tr>

			<%
			}
			}
			%>
		</table>
	</fieldset>

</body>
</html>