 <%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process JSP</title>
</head>
<body>
<%@ page import="java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date,java.util.Calendar" %>
processBookingForUpdate.jsp

	       <jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean"
	scope="request">

		<jsp:setProperty name="bookingHandler" property="strBookingID" value='<%= request.getParameter("hidden_bookingnumber1") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingDate" value='<%= request.getParameter("bookingDate") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingStartDate" value='<%= request.getParameter("bookingStartDate") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingEndDate" value='<%= request.getParameter("bookingEndDate") %>' />
		<jsp:setProperty name="bookingHandler" property="strClientID" value='<%= request.getParameter("clientID") %>' />
		<jsp:setProperty name="bookingHandler" property="strRoomNumber" value='<%= request.getParameter("roomNumber") %>' />
		<jsp:setProperty name="bookingHandler" property="strBookingPrice" value='<%= request.getParameter("bookingPrice1") %>' />
		<jsp:setProperty name="bookingHandler" property="bookingNotes" value='<%= request.getParameter("bookingNotes") %>' />
		<jsp:setProperty name="bookingHandler" property="strIsActive" value='<%= request.getParameter("strIsActive").toLowerCase() %>' />
										

		<% if (bookingHandler.validateForUpdateBooking()) { %>

		<jsp:forward page="successBookingForUpdate.jsp" />

		<%} else { %>

		<jsp:forward page="validateBookingForUpdate.jsp" />

		<%}%>

	</jsp:useBean>

</body>

</html>