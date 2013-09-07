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
	
	   if (x.value == "") {
		   alert("Please enter a beginning date.");
           return false;
	   }
	   
	   if (y.value == "") {
		   alert("Please enter an end date.");
           return false;
	   }
	   
	   var today = new Date();
	   var dd = parseInt(today.getDate());
	   var mm = parseInt(today.getMonth())+1; //January is 0!

	   var yyyy = today.getFullYear().toString();
	   if(dd<10){dd='0'+dd.toString();} 
	   if(mm<10){mm='0'+mm.toString();} 
	   today = yyyy.toString() + mm.toString() + dd.toString();
	   //document.write("today is " + today);
	   
	   if (parseInt(year1+month1+day1) < parseInt(today)) {   			
	       alert("Beginning date should NOT be earlier than today.");
           return false;
	   } 
	   
	   if (parseInt(year2+month2+day2) < parseInt(today)) {   			
	       alert("End date should NOT be earlier than today.");
           return false;
	   } 
	   
	   if (parseInt(year1+month1+day1) > parseInt(year2+month2+day2)) {   			
	       alert("Beginning date should be earlier than end date.");
           return false;
	   } 
	   
		   
		   return true;
	   
	
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
 
<div style="margin:0 30% 0 30%;">
<h1>Book a Room</h1>
<h3>Today is <%= new java.util.Date() %></h3>
<form name="bookroomform1"  method="post" action="BookingControllerServlet" onsubmit="return validateDate()">
<div>
  <p>Enter a start date: <input type="text" id="datepicker1" name="datepicker1" size="30" /></p> 
  <p>Enter an end date: <input type="text" id="datepicker2" name="datepicker2" size="30" /></p>
  <input type="hidden" name="process" value="bookroom" />


  <p><button name="buttonName_getAllAvailableRooms" value="buttonValue_getAllAvailableRooms" type="submit">Search un-booked rooms in this period</button> </p>
  



</div>
</form>
</div>
</body>
</html>