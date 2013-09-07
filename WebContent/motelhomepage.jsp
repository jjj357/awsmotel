<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>


    <script type="text/javascript">
    	
        $(document).ready(function () {
        	 $("#policies").live('click',function () {
                 
                 $.ajax({
                     url: 'policies.jsp',
                     success: function (data) {
                         //$("#content").fadeOut();
                         $("#content").html(data).fadeIn();
                     }
                 }).done(function () {
                     $("#intro").hide();
                 });
             });

         });
     </script>	
        	
        </head>	
    <body>    
    <% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<h1>Welcome to Motel Peony!</h1>
<table>
<tr>
<td>
1 bed in the room:<br />
<img src="1bed.jpg" alt="Pulpit rock" width="304" height="228">
</td>
<td>
2 beds in the room:<br />
<img src="2beds.jpg" alt="Pulpit rock" width="304" height="228">
</td>
</tr>
<tr><td><br /><br /></td><td><br /><br /></td></tr>
<tr>
<td>
3 beds in the room:<br />
<img src="3beds.jpg" alt="Pulpit rock" width="304" height="228">
</td>
<td>
4 beds in the room:<br />
<img src="4beds.jpg" alt="Pulpit rock" width="304" height="228">
</td>
</tr>
<tr><td><br /><br /></td><td><br /><br /></td></tr>
<tr>
<td>
Parking:<br />
<img src="parking.jpg" alt="Pulpit rock" width="304" height="228">
</td>
<td>
Swimming pool:<br />
<img src="swim.jpg" alt="Pulpit rock" width="304" height="228">
</td>
</tr>
<tr><td><br /><br /></td><td><br /><br /></td></tr>
<tr>
<td>
Free Breakfast:<br />
<img src="breakfast.jpg" alt="Pulpit rock" width="304" height="228">
</td>
<td>
Free wifi:<br />
<img src="freewifi.jpg" alt="Pulpit rock" width="304" height="228">
</td>
</tr>
<tr><td><br /><br /></td><td><br /><br /></td></tr>
</table>

<br /><a href=# id="policies">Motel policies:</a><br /><br /><br /><br />
<!-- <a href="index.jsp"> Back to Management System</a>   -->
</center>
</body>
</html>