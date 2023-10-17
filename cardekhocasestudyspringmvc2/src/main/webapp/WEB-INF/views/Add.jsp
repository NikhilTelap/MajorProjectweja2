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
<title>ADD CAR</title>
<style type="text/css">
#body{
		background-color:black;
		background-image:url('https://stimg2.cardekho.com/images/carNewsEditorImages/816x544/20190816_153016/24172/general-features0.jpg');
		background-position:center;
		background-repeat:no-repeat;
	background-size:1200px;
	background-position: top;
	}
h1{
color: white;
}
.text{
		color:black;
		}	
</style>
</head>
<body id="body">
<fieldset>
<legend>ADD CAR</legend>
<form action="./add" method="post">
<table>
<tr>
<td class="text">CAR NAME</td>
<td><input required="required" type="text" name="name"></td>
</tr>

<tr>
<td class="text">CAR BRAND</td>
<td><input required="required" type="text" name="brand"></td>
</tr>

<tr>
<td class="text">FUEL-TYPE</td>
<td><input required="required" type="text" name="fuelType"></td>
</tr>

<tr>
<td class="text">CAR COLOR</td>
<td><input required="required" type="text" name="color"></td>
</tr>

<tr>
<td class="text">CAR PRICE</td>
<td><input required="required" type="text" name="price"></td>
</tr>
</table>
<input type="submit" value="ADD">

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
<td><%=pojo.getFuelType()%></td>
<td><%=pojo.getColor() %></td>
<td><%=pojo.getPrice()%></td>
</tr>

<%} %>

</table>

</fieldset>

<%} %>
</body>
</html>