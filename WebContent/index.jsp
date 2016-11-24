<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Index</title> <!-- The login page aka index.html-->
</head>
<body>
<h1>Login</h1>
<form action="" method="">
<div style="width:30% float:left text-align:right">
<label for="Name">Name:</label>
</div>
<div style="width:65% margin-left:10px float:right">
<input type="text" name="Name" id="Name" style="width:65% margin-left:10px float:left"/> <!-- Type user name here-->
</br>
</div>
<div style="width:30% float:left text-align:right">
<label for="Password" style="width:30% float:left text-align:right">Password:</label>
</div>
<div style="width:65% margin-left:10px float:right">
<input type="text" name="Password" id="Password" /> <!-- Type password here-->
    </br>
    </br>
</div>
<div style="text-align:center" >
<input type="button" name="ok" value="Ok" /> <!--Send the credentials to be verified and if ok, goes to the next page. If not, error message appears-->
<input type="button" name="cancel" value="Cancel"/> <!-- Clears the name and password textboxes-->
</div>
</form>
</body>
</html>