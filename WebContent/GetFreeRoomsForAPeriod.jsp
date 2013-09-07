<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a Room</title> 
<script type="text/javascript">
    function validateDate()
    {       
    	var x=document.getElementById("datepicker1");
	   var data1 = x.value.split("/");      
	   var year1 = data1[2];
	   var month1 = data1[0];  
	   var day1 = data1[1];  
		
	   var y=document.getElementById("datepicker2");
	   var data2 = y.value.split("/"); 
	   var year2 = data2[2];    
	   var month2 = data2[0];   
	   var day2 = data2[1];   
	
	   if (parseInt(year1+month1+day1) > parseInt(year2+month2+day2)) {   			
	       alert("\"From\" date should be earlier than \"To\" date.");
           return false;
	   } 
	   else {
		   
		   return true;
	   }
	
    };
    </script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
    <script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="bookRoomStyle.css" />
    <script>
    $(function() {
        $( "#datepicker1" ).datepicker();
        $( "#datepicker2" ).datepicker();
        $( "#anim" ).change(function() {
            $( "#datepicker1" ).datepicker( "option", "showAnim", $( this ).val() );
            $( "#datepicker2" ).datepicker( "option", "showAnim", $( this ).val() );
        });
    });
    </script>
    
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<h1>Book a Room</h1>
<h3>Today is <%= new java.util.Date() %></h3>
<form name="bookroomform1"  method="post" action="RoomControllerServlet" onsubmit="return validateDate()">
<div>
  <p>Enter a start date: <input type="text" id="datepicker1" name="datepicker1" size="30" /></p> 
  <p>Enter an end date: <input type="text" id="datepicker2" name="datepicker2" size="30" /></p>
  <p><button name="buttonName_getAllAvailableRooms" value="buttonValue_getAllAvailableRooms" type="submit">Search un-booked rooms in this period</button> </p>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table border="1">
  <tr>
    <th>Room Number</th>
    <th>Room Name</th>
  </tr>
  <c:forEach items="${AllAvailableRooms}" var="room">
    <tr>
      <td>${fn:escapeXml(room.roomNumber)}</td>
      <td>${fn:escapeXml(room.roomName)}</td>
    </tr>
  </c:forEach>
</table>
</div>
</form>
</body>
</html>