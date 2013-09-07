<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a booking</title>
</head>
<body>

	<%
	 if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } 
	 
		Booking booking = (Booking) request.getAttribute("ThisBooking");
	%>
	<center>
		<h1>Display One Booking</h1>


<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displayonebookinghead">
    <th>Booking Number</th>
    <th>Booking Date</th>
    <th>Booking Start Date</th>
    <th>Booking End Date</th>
    <th>Booking Client ID</th>
    <th>Booking Room Number</th>
    <th>Total Price</th>
    <th>Booking Notes</th>
    <th>Booking Is Active?</th>
  </tr>

    <tr  class="displayonebooking">
      <td><%= booking.getBookingID() %></td>
      <td><%= booking.getBookingDate() %></td>
      <td><%= booking.getBookingStartDate() %></td>
      <td><%= booking.getBookingEndDate() %></td>
      <td><%= booking.getClientID() %></td>
      <td><%= booking.getRoomNumber() %></td>
      <td><%= booking.getBookingPrice() %></td>
      <td><%= booking.getBookingNotes() %></td>
      <td><%= booking.getIsActive() %></td>
    </tr>


		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>

</body>
</html>