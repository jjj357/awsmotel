<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Edit Page</title>
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>

</head>

<body>
    <script type="text/javascript">
    	
        $(document).ready(function () {
        	 //$("#editroomsubmit").live('click',function () {
                 
             //    $.ajax({
             //        url: '/RoomControllerServlet',
             //        success: function (data) {
             //            //$("#content").fadeOut();
              //           $("#content").html(data).fadeIn();
              //       }
              //   }).done(function () {
             //        $("#intro").hide();
             //    });
                 
                 $('#editroomsubmit').click(function(event) { 
                     var theprocess=$('#process').val();
                     var theroomid=$('#roomid').val();
                     $.get('RoomControllerServlet',{process:theprocess,roomId:theroomid},function(responseText) {
                         $('#content').text(responseText);        
                     }.done(function () {$("#intro").hide();} );
                 });
             });


     </script>	

<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<form name="roomlist1"  method="post" action="RoomControllerServlet">
<div>
<h1>Room Edit Page</h1>
Enter room number:<input type="text" id="roomid" name="roomId" ><br /><br />

<input type="radio" id="process" name="process" value="add"> Add <br />														
<input type="radio" id="process" name="process" value="get"> Get <br />
<input type="radio" id="process" name="process" value="getAll" checked="checked"> Get All <br />
<input type="radio" id="process" name="process" value="remove"> Remove <br />
<input type="radio"	id="process" name="process" value="update"> Update	<br /><br />
							
							
<input type="submit" id="editroomsubmit" name="Submit" value="Submit">
					
<input name="Reset" type="reset" id="Reset" value="Clear">

</div>
</form><br /><br />
<!-- <a href="index.jsp"> Back to Management System</a>   -->
</center>
</body>
</html>