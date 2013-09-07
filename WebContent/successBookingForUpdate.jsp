<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
</head>
<body>
successBookingForUpdate.jsp

	


	<% 
	request.setAttribute("javabeanbooking", bookingHandler);
	request.setAttribute("process", "update");
	request.setAttribute("bookingId", bookingHandler.getStrBookingID());
	request.getRequestDispatcher("BookingControllerServlet").forward(request,
	response);
	//return;
	
%>
</body>
</html>