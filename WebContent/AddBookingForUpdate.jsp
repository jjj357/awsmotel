<jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Validation </title>
</head>
<body>
<%@ page import="java.text.DateFormat,java.text.SimpleDateFormat,java.util.Date,java.util.Calendar" %>
<center>
 <% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
	<form action="processBooking.jsp" method="post">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
			
				<tr class="addbookinghead">
					<th colspan=2><font size=5>Booking
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				
				<tr  class="addbooking">
					<td valign=top><b>Booking Number:</b> <br> 
					<%= request.getParameter("bookingNumber1") %>
					</td>
				</tr>
				
				<% DateFormat df = new SimpleDateFormat("yyyyMMdd");
				   Date today = Calendar.getInstance().getTime();        
				   String todayDate = df.format(today);
				   request.setAttribute("todayDate",todayDate);
				   
					String fromDate = (String) request.getAttribute("datepicker1");
					String toDate = (String) request.getAttribute("datepicker2");


						String delims = "/";
						String[] data1 = fromDate.split(delims);       
						String year1 = data1[2];
						String month1 = data1[0];  
						String day1 = data1[1];  
						String newFromDate = year1.concat(month1).concat(day1);
						request.setAttribute("newFromDate",newFromDate);
									
						String[] data2 = toDate.split(delims); 
						String year2 = data2[2];    
						String month2 = data2[0];   
						String day2 = data2[1];     
						String newToDate = year2.concat(month2).concat(day2);
						request.setAttribute("newToDate",newToDate);
				
				%>
				
				<tr  class="addbooking">
					<td valign=top><b>Booking Date</b> <br> <%=todayDate %>
					</td>
				</tr>
				
				<tr  class="addbooking">
					<td valign=top><b>Booking Start Date:</b> <br> 
					     <%= request.getAttribute("newFromDate") %>
					</td>
				</tr>
				
				<tr  class="addbooking">
					<td valign=top><b>Booking End Date:</b> <br> 
					<%= request.getAttribute("newToDate")  %>
					</td>
				</tr>
				
								
				<tr  class="addbooking">
					<td valign=top><b>Booking Client ID</b> <br> <input
						type="text" name="strClientID" 
						size=80 maxlength=80> 
					</td>
				</tr>
				
								
				<tr  class="addbooking">
					<td valign=top><b>Booking Room Number:</b> <br> 
					<%= request.getParameter("roomNumber1") %>
					</td>
				</tr>
				
								
				<tr  class="addbooking">
					<td valign=top><b>Booking Notes</b> <br> <input
						type="text" name="bookingNotes" 
						size=80 maxlength=80> 
					</td>
				</tr>
				
				<tr  class="addbooking">
					<td align=center colspan=2>
					<input type="submit" value="Submit">
				    <input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>
	</form><br /><br />
	<a href="main.jsp"> Back to Management System</a>
	</center>
</body>
</html>