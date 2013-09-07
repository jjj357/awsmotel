<jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Validation </title>
</head>
<body>
validateBooking.jsp

	<form action="processBooking.jsp" method="post">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr class="validatebookinghead">
					<th colspan=2><font size=5>Booking
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				<tr  class="validatebooking">
					<td valign=top><b>Booking Number<sup>*</sup></b> <br> <input
						type="text" name="hidden_bookingnumber" value='<%=bookingHandler.getStrBookingID()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("bookingID")%></font>
				
					</td>
				</tr>
				<tr  class="validatebooking">
					<td valign=top><b>Booking Date<sup>*</sup></b> <br> <input
						type="text" name="hidden_bookingdate" value='<%=bookingHandler.getBookingDate()%>'
						size=80 maxlength=80> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("bookingDate")%></font>
					</td>
				</tr>
				<tr   class="validatebooking">
					<td valign=top><b>Booking Start Date<sup>*</sup></b> <br> <input
						type="text" name="hidden_fromdate" value='<%=bookingHandler.getBookingStartDate()%>'
						size=80 maxlength=200> <br> <font size=2 color=red><%= bookingHandler.getErrorMsg("bookingStartDate")%></font>
					</td>
				</tr>
				<tr   class="validatebooking">
					<td valign=top><b>Booking End Date<sup>*</sup></b> <br> <input
						type="text" name="hidden_todate" value='<%=bookingHandler.getBookingEndDate()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("bookingEndDate")%></font>
					</td>
				</tr>
				
								<tr   class="validatebooking">
					<td valign=top><b>Booking Client ID</b> <br> <input
						type="text" name="strClientID" value='<%=bookingHandler.getStrClientID()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("clientID")%></font>
					</td>
				</tr>
				
								<tr   class="validatebooking">
					<td valign=top><b>Booking Room Number<sup>*</sup></b> <br> <input
						type="text" name="hidden_roomnumber" value='<%=bookingHandler.getStrRoomNumber()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("roomNumber")%></font>
					</td>
				</tr>
				
								<tr   class="validatebooking">
					<td valign=top><b>Booking Notes<sup>*</sup></b> <br> <input
						type="text" name="bookingNotes" value='<%=bookingHandler.getBookingNotes()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=bookingHandler.getErrorMsg("bookingNotes")%></font>
					</td>
				</tr>

				<tr   class="validatebooking">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>
	</form>
	<a href="main.jsp"> Back to Management System</a>
</body>
</html>