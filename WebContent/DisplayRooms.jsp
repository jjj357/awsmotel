<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display rooms</title>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
	<%
		List<Room> rooms = (List<Room>) request.getAttribute("ThisRoom");
	%>
	<center>
		<h1>Display Room List</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displayroomshead">
    <th>Room Number</th>
    <th>Room Name</th>
    <th>Room Price</th>
    <th>Room Description</th>
    <th>Room Type(number of bed(s))</th>
  </tr>
  <c:forEach items="${ThisRoom}" var="rooms">
    <tr  class="displayrooms">
      <td>${fn:escapeXml(rooms.roomNumber)}</td>
      <td>${fn:escapeXml(rooms.roomName)}</td>
      <td>${fn:escapeXml(rooms.price)}</td>
      <td>${fn:escapeXml(rooms.description)}</td>
      <td>${fn:escapeXml(rooms.roomTypeID)}</td>
    </tr>
  </c:forEach>

		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>

</body>
</html>