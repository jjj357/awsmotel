<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Action Completed</title>
</head>
<body>

<%  
Room r = (Room)request.getAttribute("room");
if (r == null) {

request.getRequestDispatcher("fail.jsp").forward(request, response); 
return;
}
%>

<form action="ShowAllRooms.jsp" method="post">
					<table width="100%" border="1" cellspacing="1" cellpadding="1">
						<tr>
						<% if ( r == null )  return; %>
							<td>Room Number:<%=r.getRoomNumber()%></td>	
										
						</tr>
						<tr>
							<td>Room Name:<%=r.getRoomName()%></td>
							<td>Room Price:<%=r.getPrice()%></td>
							
						<tr>
							
							<td>Room Description<%=r.getDescription()%></td>
						</tr>
					</table>
					<input name="Next" type="submit" value="Next Room"/>
</form>

<a href="main.jsp"> Back to Management System</a>
	
</body>
</html>