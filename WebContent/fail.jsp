<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Management System</title>
</head>
<body  class="fail">
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<div>
	<% 
		Integer roomNumber = (Integer)request.getAttribute("roomNumber");
		if (roomNumber != null) {
			out.println("Room Number out of range: " + roomNumber);
		request.removeAttribute("roomNumber");
		}
		
		String roomId = (String)request.getAttribute("roomId");
		if (roomId == null || roomId.isEmpty())
			out.println("Wrong Room Number : " + roomId);
	%>
	<h2>Failed, try again!</h2>
	<a href="main.jsp"> Back to Management System</a>
	</div>
	</center>
</body>
</html>