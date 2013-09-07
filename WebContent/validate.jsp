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
validate.jsp

	<form action="process.jsp" method="post">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr class="validateroomhead">
					<th colspan=2><font size=5>Room
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				<tr  class="validateroom">
					<td valign=top><b>Room Number<sup>*</sup></b> <br> <input
						type="text" name="strRoomNumber" value='<%=roomHandler.getStrRoomNumber()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=roomHandler.getErrorMsg("roomNumber")%></font>
					</td>
				</tr>
				<tr   class="validateroom">
					<td valign=top><b>Room Name<sup>*</sup></b> <br> <input
						type="text" name="roomName" value='<%=roomHandler.getRoomName()%>'
						size=80 maxlength=80> <br> <font size=2 color=red><%=roomHandler.getErrorMsg("roomName")%></font>
					</td>
				</tr>
				<tr   class="validateroom">
					<td valign=top><b>Description<sup>*</sup></b> <br> <input
						type="text" name="description" value='<%=roomHandler.getDescription()%>'
						size=80 maxlength=200> <br> <font size=2 color=red><%= roomHandler.getErrorMsg("description")%></font>
					</td>
				</tr>
				<tr   class="validateroom">
					<td valign=top><b>Price:<sup>*</sup></b> <br> <input
						type="text" name="strPrice" value='<%=roomHandler.getStrPrice()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=roomHandler.getErrorMsg("price")%></font>
					</td>
				</tr>
				
				<tr   class="validateroom">
				   <td valign=top><b>Room Type:<sup>*</sup></b> <br> 
					<input type="radio" name="roomtype" value="1"> 1 bed in the room <br />
                    <input type="radio" name="roomtype" value="2"> 2 beds in the room <br />
                    <input type="radio" name="roomtype" value="3"> 3 beds in the room <br />
                    <input type="radio"	name="roomtype" value="4"> 4 beds in the room	<br />
					
                    <br> <font size=2 color=red><%=roomHandler.getErrorMsg("roomTypeID")%></font>
				   </td>
				</tr>

				<tr   class="validateroom">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>