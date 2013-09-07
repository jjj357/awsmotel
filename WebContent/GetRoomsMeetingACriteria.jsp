<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Rooms Meeting a Criteria</title>
</head>

<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<form name="roomlist2"  method="post" action="RoomControllerServlet">
<div>
<h1>Get Rooms Meeting a Criteria</h1>
Please choose a criteria:<br /><br />

<input type="radio" name="process" value="choosecriteria"> Get all occupied rooms list(client is physically in the room) <br />	
<input type="radio" name="process" value="choosecriteria1"> Get all booked rooms list(maybe the client has not arrived yet) <br />	

													
<!--  
<input type="radio" name="process" value="get"> Get <br />
<input type="radio" name="process" value="getAll" checked="checked"> Get All <br />
<input type="radio" name="process" value="remove"> Remove <br />
<input type="radio"	name="process" value="update"> Update	<br /><br />
-->							
							
<input type="submit" name="Submit" value="Submit">
					
<input name="Reset" type="reset" id="Reset" value="Clear">

</div>
</form><br /><br />
<!-- <a href="index.jsp"> Back to Management System</a>   -->
</center>
</body>
</html>