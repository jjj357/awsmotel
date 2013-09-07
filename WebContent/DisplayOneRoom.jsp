<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a room</title>
</head>
<body>

	<%
	    if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } 
	 
		Room room = (Room) request.getAttribute("ThisRoom");
	%>
	<center>
		<h1>Display One Room</h1>


<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displayoneroomhead">
    <th>Room Number</th>
    <th>Room Name</th>
    <th>Room Price</th>
    <th>Room Description</th>
  </tr>

    <tr  class="displayoneroom">
      <td><%= room.getRoomNumber() %></td>
      <td><%= room.getRoomName() %></td>
      <td><%= room.getPrice() %></td>
      <td><%= room.getDescription() %></td>
    </tr>


		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>

</body>
</html>