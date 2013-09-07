<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a client</title>
</head>
<body>

	<%
	    if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } 
	 
		Client client = (Client) request.getAttribute("ThisClient");
	%>
	<center>
		<h1>Display One Client</h1>


<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displayoneclienthead">
    <th>Client Number</th>
    <th>Client First Name</th>
    <th>Client Last Name</th>
    <th>Client Email</th>
    <th>Client Phone Number</th>
  </tr>

    <tr  class="displayoneclient">
      <td><%= client.getClientID() %></td>
      <td><%= client.getFirstName() %></td>
      <td><%= client.getLastName() %></td>
      <td><%= client.getEmail() %></td>
      <td><%= client.getPhoneNumber() %></td>
    </tr>


		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>

</body>
</html>