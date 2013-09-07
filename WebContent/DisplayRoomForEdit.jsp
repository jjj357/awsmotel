<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a room</title>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 

<SCRIPT type="text/javascript">
  function setHiddenValue(temp) {
      
  document.getElementById("strRoomTypeID").value = temp;
  return true;
  }
</SCRIPT>

   <form action="processForUpdate.jsp" method="post">
	<%
	
		Room room = (Room) request.getAttribute("ThisRoom");
	%>
	<center>
		<table cellpadding=4 cellspacing=2 border=0>
			<tr class="displayroomforedithead">
				<th colspan=2>
				<font size=5>Room Number: <br />
				<%= room.getRoomNumber() %>
				</font> 
				<input type="hidden" name="hidden_roomnumber" value="<%= room.getRoomNumber() %>" ><br></th>
			</tr>
			
			<tr  class="displayroomforedit">
				<td valign=top><b>Room Name</b> <br> 
				<input type="text" name="roomName" value="<%= room.getRoomName() %>" >
				</td>
			</tr>
			<tr   class="displayroomforedit">
				<td valign=top><b>Room Description</b> <br> 
				<input type="text" name="description" value="<%= room.getDescription() %>" >
				</td>
			</tr>
			<tr   class="displayroomforedit">
				<td valign=top><b>Room Price</b> <br> 
				<input type="text" name="strPrice" value="<%= room.getPrice() %>" >
				</td>
			</tr>
			
			<tr   class="displayroomforedit">
				   <td valign=top><b>Room Type</b> <br> 
					<input type="radio" name="strRoomTypeID1" value="1" onclick="return setHiddenValue('1')" <% if (room.getRoomTypeID()==1){%> checked="checked" <% } %>> 1 bed in the room <br />
                    <input type="radio" name="strRoomTypeID2" value="2" onclick="return setHiddenValue('2')" <% if (room.getRoomTypeID()==2){%> checked="checked" <% } %>> 2 beds in the room <br />
                    <input type="radio" name="strRoomTypeID3" value="3" onclick="return setHiddenValue('3')" <% if (room.getRoomTypeID()==3){%> checked="checked" <% } %>> 3 beds in the room <br />
                    <input type="radio"	name="strRoomTypeID4" value="4" onclick="return setHiddenValue('4')" <% if (room.getRoomTypeID()==4){%> checked="checked" <% } %>> 4 beds in the room	<br />
					
					<input type="hidden" name="strRoomTypeID" 
					<% if (room.getRoomTypeID()==1){%> value="1" <% } %>
					<% if (room.getRoomTypeID()==2){%> value="2" <% } %>
					<% if (room.getRoomTypeID()==3){%> value="3" <% } %>
					<% if (room.getRoomTypeID()==4){%> value="4" <% } %>
					 >
					
                    
				   </td>
				</tr>
				
                <% request.setAttribute("ThisRoom", room);   %>
				<tr   class="displayroomforedit">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			


		</table>
	</center>

</form>
	<a href="main.jsp"> Back to Management System</a>
</body>
</html>