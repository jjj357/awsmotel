<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
    <jsp:useBean id="bookingHandler" class="cs.tutorial.bs.entity.BookingJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available rooms search result</title> 
    <link rel="stylesheet" href="bookRoomStyle.css" />   
    <script type="text/javascript">
    function validateRoomNumber()
    {       
       var x=document.getElementById("hidden_roomnumberlist_string");
       var y=document.getElementById("roomNumber1");
       
       //alert("temp value is "+y.value);
       //alert("hidden value is "+x.value);
       
	   var data = x.value.split(",");   
	   //alert("strings[1] is "+ data[0]);
	   //alert("strings[1] is "+ data[1]);
	   var temp=false;
	   for(var i = 0; i < data.length - 1; i++){
		   //alert("strings[i] value is "+data[i]);
		   if (y.value != "" && y.value == data[i]){
			   			 
			   temp=true;
			   
		   }
	   }	   
	   if (temp == false) {		   
		   alert("Please enter a room number in the table");
	   }
	   
	   return temp;
    };
    </script>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 



	<%
	List<Room> rooms = (List<Room>) request.getAttribute("AvailableRoomsSearchResult");
    String temp = "";
    for (Room r: rooms){
    	temp = temp + r.getRoomNumber().toString() + ",";
    }
	%>
	
<h3>Available rooms search result:</h3>
<h3>Rooms available from <%=request.getParameter("datepicker1") %>   to <%= request.getParameter("datepicker2") %></h3>
<h3>Now it is <%= new java.util.Date() %></h3>
<form name="bookroomform9"  method="post" action="BookingControllerServlet" onsubmit="return validateRoomNumber()">
<div>

<input type="hidden" id="hidden_roomnumberlist_string" name="hidden_roomnumberlist_string" value="<%= temp %>" >

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<table border="1">
  <tr class="bookroomsearchresulthead">
    <th>Room Number</th>
    <th>Room Name</th>
    <th>Room Price</th>
    <th>Room Description</th>
  </tr>
  <c:forEach items="${AvailableRoomsSearchResult}" var="rooms">
    <tr class="bookroomsearchresult">
      <td>${fn:escapeXml(rooms.roomNumber)}</td>
      <td>${fn:escapeXml(rooms.roomName)}</td>
      <td>${fn:escapeXml(rooms.price)}</td>
      <td>${fn:escapeXml(rooms.description)}</td>
    </tr>
  </c:forEach>
</table>
</div>
<hr />
<div>

<% int thisBookingNumber = ((Integer)request.getAttribute("CurrentMaxBookingNumber")).intValue();
   thisBookingNumber ++;
%>
This booking number will be: #<font color="red"><%=thisBookingNumber %></font>
<br /><br />
Enter room number:<input type="text" id="roomNumber1" name="roomNumber1" ><br />
<input type="hidden" name="bookNumber1" value="thisBookingNumber">
<input type="hidden" name="process" value="add">													
<input type="hidden" name="datepicker1" value="<%= (String)request.getAttribute("datepicker1") %>">
<input type="hidden" name="datepicker2" value="<%= (String)request.getAttribute("datepicker2") %>">
							
							
<input type="submit" name="Submit" value="Submit">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;					
<input name="Reset" type="reset" id="Reset" value="Clear">

</div>
</form>
</body>
</html>