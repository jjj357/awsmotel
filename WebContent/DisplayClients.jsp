<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display clients</title>
</head>
<body>

	<%
	    if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } 
	 
		List<Client> clients = (List<Client>) request.getAttribute("ThisClient");
	%>
	<center>
		<h1>Display Client List</h1>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table cellpadding=4 cellspacing=2 border=1>
  <tr class="displayclientshead">
    <th>Client Number</th>
    <th>Client First Name</th>
    <th>Client Last Name</th>
    <th>Client Email</th>
    <th>Client Phone Number</th>
    <th>Client Address</th>
  </tr>
  <c:forEach items="${ThisClient}" var="clients">
    <tr  class="displayclients">
      <td>${fn:escapeXml(clients.clientID)}</td>
      <td>${fn:escapeXml(clients.firstName)}</td>
      <td>${fn:escapeXml(clients.lastName)}</td>
      <td>${fn:escapeXml(clients.email)}</td>
      <td>${fn:escapeXml(clients.phoneNumber)}</td>
      <td>${fn:escapeXml(clients.address)}</td>
    </tr>
  </c:forEach>

		</table>	
		<br /><br /><br /><br /><br />
			<a href="main.jsp"> Back to Management System</a>
			
		
	</center>

</body>
</html>