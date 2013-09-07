<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display bookings</title>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>

	<%
		List<Booking> bookings = (List<Booking>) request.getAttribute("ThisBooking");
	%>
	
	<% Room r = new Room(); RoomServiceLocator sl = new RoomServiceLocator(); %>
	<center>
		<h1>Display Booking List</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displaybookingshead">
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
  <c:forEach items="${ThisBooking}" var="bookings">
    <tr  class="displaybookings">
      <td>${fn:escapeXml(bookings.bookingID)}</td>
      <td>${fn:escapeXml(bookings.bookingDate)}</td>
      <td>${fn:escapeXml(bookings.bookingStartDate)}</td>
      <td>${fn:escapeXml(bookings.bookingEndDate)}</td>
      <td>${fn:escapeXml(bookings.clientID)}</td>
      <td>${fn:escapeXml(bookings.roomNumber)}</td>
      <td>${fn:escapeXml(bookings.bookingPrice)}</td>
      <td>${fn:escapeXml(bookings.bookingNotes)}</td>
      <td>${fn:escapeXml(bookings.isActive)}</td>
    </tr>
  </c:forEach>

		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>
</center>
</body>
</html>