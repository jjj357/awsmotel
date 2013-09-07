<jsp:useBean id="roomHandler" class="cs.tutorial.bs.entity.RoomJavaBean"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Validation </title>
</head>
<body>
 <% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
	<form action="process.jsp" method="post">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th class="addroomhead" colspan=2><font size=5>Room
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				<tr  class="addroom">
					<td valign=top><b>Room Number<sup>*</sup></b> <br> 
					<input type="text" name="strRoomNumber" 
						size=20 maxlength=20> 
					</td>
				</tr>
				<tr   class="addroom">
					<td valign=top><b>Room Name<sup>*</sup></b> <br> <input
						type="text" name="roomName" 
						size=80 maxlength=80> 
					</td>
				</tr>
				<tr   class="addroom">
					<td valign=top><b>Description<sup>*</sup></b> <br> <input
						type="text" name="description" 
						size=80 maxlength=200> <br> 
					</td>
				</tr>
				<tr   class="addroom">
					<td valign=top><b>Price:<sup>*</sup></b> <br> <input
						type="text" name="strPrice" 
						size=20 maxlength=20> <br> 
					</td>
				</tr>
				
				<tr   class="addroom">
					<td valign=top><b>Room Type:<sup>*</sup></b> <br> 
																
<input type="radio" name="roomtype" value="1"> 1 bed in the room <br />
<input type="radio" name="roomtype" value="2" checked="checked"> 2 beds in the room <br />
<input type="radio" name="roomtype" value="3"> 3 beds in the room <br />
<input type="radio"	name="roomtype" value="4"> 4 beds in the room	<br />

					</td>
				</tr>

				<tr   class="addroom">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>
	</form>
	<a href="main.jsp"> Back to Management System</a>
</body>
</html>