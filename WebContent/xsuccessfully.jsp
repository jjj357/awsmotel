<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body  class="xsuccessfullyjsp">
<%
session.removeAttribute("roomId"); 
session.removeAttribute("process");
session.removeAttribute("ThisRoom");

session.removeAttribute("clientId"); 
session.removeAttribute("ThisClient");

session.removeAttribute("bookingId"); 
session.removeAttribute("ThisBooking");

request.removeAttribute("bookingId");
request.removeAttribute("process");
request.removeAttribute("datepicker1");
request.removeAttribute("datepicker2");

request.removeAttribute("roomId");
request.removeAttribute("ThisRoom");
request.removeAttribute("clientId");
request.removeAttribute("ThisClient");
request.removeAttribute("ThisBooking");


%>
<div>
  Your request has been done successfully!
  <br /><br /><br /><br /><br /><br />
   <a href="main.jsp"> Back to Management System</a>  
  </div>
</body>
</html>