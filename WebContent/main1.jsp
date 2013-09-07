<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Motel Peony Booking System</title>
</head>
<body>
<%
 if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } 

session.removeAttribute("roomId"); 
session.removeAttribute("process");
session.removeAttribute("ThisRoom");

session.removeAttribute("clientId"); 
session.removeAttribute("ThisClient");

session.removeAttribute("bookingId"); 
session.removeAttribute("ThisBooking");


%>
<center>
<h1 align="center">Motel Peony Booking System</h1>
<h2 align="center">Wrote by Mingtao Li</h2>
<h2 align="center">Skills Used: J2EE, jsp, MVC, Tomcat, Eclipse, servlet, MySQL, javascript, jQuery, css, html</h2>
<button name="bookaroom" type="button" onclick="location.href='BookRoom.jsp'">
<img src="bookRoom.png" alt="Book a Room" />
<br />Book a Room</button>

<button name="editabooking" type="button" onclick="location.href='EditBooking.jsp'">
<img src="editBook.png" alt="Edit a Booking" />
<br />Edit a Booking</button>

<button name="editroom" type="button" onclick="location.href='EditRoom.jsp'">
<img src="editRoom.png" alt="Edit Room" />
<br />Edit Room</button><br />

<!--<button name="editroomtype" type="button" onclick="location.href='EditRoomType.jsp'">  -->
<!--<img src="editRoomType.png" alt="Edit Room Type" />  -->
<!--<br />Edit Room Type</button><br>  -->

<button name="editclient" type="button" onclick="location.href='EditClient.jsp'">
<img src="editClient.png" alt="Edit Client" />
<br />Edit Client</button>

<!--<button name="getallroomsandstatus" type="button" onclick="location.href='GetAllRoomsAndStatus.jsp'"> -->
<!--<img src="allRoomList.png" alt="Get All Rooms & Status" /> -->
<!--<br />Get All Rooms & Status</button> -->

  
<!-- <button name="getfreeroomsforaperiod" type="button" onclick="location.href='GetFreeRoomsForAPeriod.jsp'"> -->
<!-- <img src="allRoomNonBookedInaPeriod.png" alt="Rooms For a Period" />  -->
<!-- <br />Get Free Rooms For a Period</button>  -->

<button name="getroomsmeetingacriteria" type="button" onclick="location.href='GetRoomsMeetingACriteria.jsp'">
<img src="allRoomMeetingaCriteria.png" alt="Rooms Meeting a Criteria" />
<br />Get Rooms Meeting a Criteria</button>

<button name="tomotelhomepage" type="button" onclick="location.href='motelhomepage.jsp'"> 
<img src="homepage.png" alt="Motel home page" /> 
<br />To Motel Home Page</button> 

</center>
</body>
</html>