<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome | Logged-in!</title>
<style>
	body{
			background-color:#ddd;
			font-family:Georgia, serif;
		}
		
	form {
			font-size: 1.1em;
		}
		
	a{
		background-color: #4CAF50;
		border: none;
		color: white;
		padding: 10px 20px;
		text-decoration: none;
		margin: 4px 2px;
		cursor: pointer;
	}
	
	a:hover{
		background-color:green;
	}
</style>
</head>
<body>
<h2>	
	<h2>Hi,${param.username }</h2>
	<h3>You've successfully logged in...</h3>
	<hr>
	<form action="processInventory" method="post">
		If you like to see cars<br/>
		<input type="submit" value="Visit Catalog"/>
	</form>
</body>
</html>