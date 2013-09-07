<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a booking</title>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
   <form action="processBookingForUpdate.jsp" method="post">
	<%
		Booking booking = (Booking) request.getAttribute("ThisBooking");
	%>
	<center>
		<table cellpadding=4 cellspacing=2 border=0>
			<tr class="displaybookingforedithead">
				<th colspan=2>
				<font size=5>Booking Number: <br />
				<%= booking.getBookingID() %>
				</font> 
				<input type="hidden" name="hidden_bookingnumber1" value="<%= booking.getBookingID() %>" ><br></th>
			</tr>
			
			<tr  class="displaybookingforedit">
				<td valign=top><b>Booking Date</b> <br> 
				<%= booking.getBookingDate() %>
				<input type="hidden" name="bookingDate" value="<%= booking.getBookingDate() %>" >
				</td>
			</tr>
			<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Start Date</b> <br> 
				<%= booking.getBookingStartDate() %>
				<input type="hidden" name="bookingStartDate" value="<%= booking.getBookingStartDate() %>" >
				</td>
			</tr>
			<tr   class="displaybookingforedit">
				<td valign=top><b>Booking End Date</b> <br> 
				<%= booking.getBookingEndDate() %>
				<input type="hidden" name="bookingEndDate" value="<%= booking.getBookingEndDate() %>" >
				</td>
			</tr>
			
						<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Client ID</b> <br> 
				<%= booking.getClientID() %>
				<input type="hidden" name="clientID" value="<%= booking.getClientID() %>" >
				</td>
			</tr>
			
			<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Room Number</b> <br> 
				<%= booking.getRoomNumber() %>
				<input type="hidden" name="roomNumber" value="<%= booking.getRoomNumber() %>" >
				</td>
			</tr>
			
			<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Price</b> <br> 
				<%= booking.getBookingPrice() %>
				<input type="hidden" name="bookingPrice1" value="<%= booking.getBookingPrice() %>" >
				</td>
			</tr>
			
			<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Notes</b> <br> 
				<input type="text" name="bookingNotes" value="<%= booking.getBookingNotes() %>" >
				</td>
			</tr>
			<%! String result;  %>
			<%if (booking.getIsActive().equals("FALSE")){
				result = "n";
			} else if (booking.getIsActive().equals("TRUE")){
				result = "y";
			}
				%>
			
				<tr   class="displaybookingforedit">
				<td valign=top><b>Booking Is Active? (y/n)</b> <br> 
				<input type="text" name="strIsActive" value="<%= result %>" >
				</td>
			</tr>
			
			
                <% request.setAttribute("ThisBooking", booking);   %>
                
				<tr   class="displaybookingforedit">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			


		</table>
	</center>

</form>
	<a href="main.jsp"> Back to Management System</a>
</body>
</html>