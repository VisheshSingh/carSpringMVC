<%@page import="java.util.ArrayList"%>
<%@page import="com.vishesh.springmvc.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resource scope</title>
</head>
<body>
<table align="center" cellpadding="2" cellspacing="5" border="2" >
		<tr bgcolor="#bdb70b" class="tableHead">
			<td><b>ModelNumber</b></td>
			<td><b>YearofProduction</b></td>
			<td><b>DownPayment</b></td>
		</tr>
<!-- 	USE REFERENCE -->
<%-- 	<% ArrayList<Car> car = (ArrayList<Car>) request.getAttribute("carlist"); 
		for(Car c: car){
	%>
	
		<tr bgcolor="#f5fffa">
				<td><%=c.getModelNumber() %></td>
				<td><%=c.getYearOfProduction() %></td>
				<td><%=c.getDownpayment() %></td>
		</tr>
	<%	}
	%> --%>
	</table>
	<br/><br/>
			
	<table align="center" cellpadding="2" cellspacing="5" border="2" >
		<tr bgcolor="#606060" class="tableHead">
			<td><b>ModelNumber</b></td>
			<td><b>YearofProduction</b></td>
			<td><b>DownPayment</b></td>
		</tr>
	<% ArrayList<Car> cars = (ArrayList<Car>) session.getAttribute("carlist"); 
		for(Car c: cars){
	%>
			
		<tr bgcolor="#C0C0C0">
			<td><%=c.getModelNumber() %></td>
				<td><%=c.getYearOfProduction() %></td>
				<td><%=c.getDownpayment() %></td>
		</tr>
		
	<%	}
	%>
	</table>
	
</body>
</html>