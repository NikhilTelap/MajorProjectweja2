<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%String msg = (String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
  background-image: url('https://www.serpentcs.in/web/image/4566');
  background-size: cover;
  background-repeat: no-repeat;
  background-attachment: fixed;
}


.button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #3498db; /* Button background color */
  color: #fff; /* Button text color */
  text-decoration: none;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  font-size: 16px;
  margin: 10px;
}
.customer-button {
  background-color: #27ae60; /* Custom color for the "Customer" button */
}

.trainer-button {
  background-color: #e74c3c; /* Custom color for the "Trainer" button */
}

.button:hover {
  background-color: #2980b9; /* Button background color on hover */
}

</style>
</head>


<body>
 <a class="button customer-button" id="customerPage" href="http://localhost:8080/gymmanagementsystem/customerPage">Customer</a> 
 <a class="button customer-button" id="trainerPage" href="http://localhost:8080/gymmanagementsystem/trainerPage">Trainer</a> 
 <%if(msg != null) {%>
 <h1><%=msg %></h1>
 <%} %>
</body>
</html>
