<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

form {
  margin: 0;
  padding: 0;
  border: 0;
 
}
 h2 {
  font-size: 36px; 
  font-weight: bold;
  color: #333;
 text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
  }

.form-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f4f4f4;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.form-group {
  margin-bottom: 20px;
}

.label {
  font-weight: bold;
  display: block;
}

.input {
  width: 95%;
  padding: 10px;
  margin-top: 5px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

.submit-button {
  background-color: #007bff;
  color: #fff;
  margin-left:125px;
  padding: 20px 15px;
  border: 0;
  border-radius: 3px;
  cursor: pointer;
}


</style>

</head>
<body>
 <h2>Customer Registration</h2>
 
 <div class="form-container">
    <form action="./customer" method="post">
        <label class="label" for="name">Name:</label>
        <input class="input" type="text" name="name" required><br>

        <label class="label" for="email">Email:</label>
        <input class="input" type="email" name="email" required><br>

        <label class="label" for="contact">Contact:</label>
        <input class="input" type="text" name="contact" required><br>

        <label class="label" for="age">Age:</label>
        <input class="input" type="number" name="age" required><br>

        <label class="label" for="address">Address:</label>
        <input class="input" type="text" name="address" required><br>

        <label class="label" for="time">Available Time:</label>
        <input class="input" type="text" name="time" required><br>

        <input class="submit-button" type="submit" value="Register Customer">
    </form>
     </div>
    
</body>
</html>