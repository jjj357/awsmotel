<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="java.util.*,java.text.*,java.io.*,cs.tutorial.bs.entity.*"%>
       <jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean"
	scope="request">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process JSP</title>
</head>
<body>
processBooking.jsp


		<jsp:setProperty name="bookingHandler" property="strBookingID" value='<%= request.getParameter("hidden_bookingnumber") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingDate" value='<%= request.getParameter("hidden_bookingdate") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingStartDate" value='<%= request.getParameter("hidden_fromdate") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingEndDate" value='<%= request.getParameter("hidden_todate") %>' />
		<jsp:setProperty name="bookingHandler" property="strClientID" value='<%= request.getParameter("hidden_clientnumber") %>' />
		<jsp:setProperty name="bookingHandler" property="strRoomNumber" value='<%= request.getParameter("hidden_roomnumber") %>' />
		<jsp:setProperty name="bookingHandler" property="strBookingPrice" value='<%= request.getParameter("bookingPriceString") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingNotes" value='<%= request.getParameter("bookingNotes") %>' />
		<jsp:setProperty name="bookingHandler" property="strIsActive" value="y" />
		
		<% if (bookingHandler.validate()) { %>

		<jsp:forward page="successBooking.jsp" />

		<%} else { %>

		<jsp:forward page="validateBooking.jsp" />

		<%}%>

	</jsp:useBean>
   
</body>

</html>