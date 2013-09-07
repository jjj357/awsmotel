<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Motel Peony Booking System</title>
</head>
<body class="index">
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<div >
<h1>Motel Peony Booking System</h1>

<button name="editabooking" type="button" onclick="location.href='EditBooking.jsp'">
<img src="editBook.png" alt="Edit a Booking" />
<br />Edit a Booking</button>

<button name="editroom" type="button" onclick="location.href='EditRoom.jsp'">
<img src="editRoom.png" alt="Edit Room" />
<br />Edit Room</button>

<button name="editclient" type="button" onclick="location.href='EditClient.jsp'">
<img src="editClient.png" alt="Edit Client" />
<br />Edit Client</button>


</div>
</center>
</body>
</html>