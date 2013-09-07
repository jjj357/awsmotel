<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display a client</title>
</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
   <form action="processClientForUpdate.jsp" method="post">
	<%
		Client client = (Client) request.getAttribute("ThisClient");
	%>
	<center>
		<table cellpadding=4 cellspacing=2 border=0>
			<tr class="displayclientforedithead"> 
				<th colspan=2>
				<font size=5>Client ID: <br />
				<%= client.getClientID() %>
				</font> 
				<input type="hidden" name="hidden_clientnumber" value="<%= client.getClientID() %>" ><br></th>
			</tr>
			
			<tr  class="displayclientforedit">
				<td valign=top><b>Client First Name</b> <br> 
				<input type="text" name="firstName" value="<%= client.getFirstName() %>" >
				</td>
			</tr>
			<tr   class="displayclientforedit">
				<td valign=top><b>Client Last Name</b> <br> 
				<input type="text" name="lastName" value="<%= client.getLastName() %>" >
				</td>
			</tr>
			<tr   class="displayclientforedit">
				<td valign=top><b>Client email</b> <br> 
				<input type="text" name="email" value="<%= client.getEmail() %>" >
				</td>
			</tr>
			
						<tr   class="displayclientforedit">
				<td valign=top><b>Client Phone Number</b> <br> 
				<input type="text" name="phoneNumber" value="<%= client.getPhoneNumber() %>" >
				</td>
			</tr>
			
							<tr    class="displayclientforedit">
					<td valign=top><b>Client Address</b> <br> 
					<input type="text" name="address" value="<%= client.getAddress() %>" > 
					</td>
				</tr>
			
                <% request.setAttribute("ThisClient", client);   %>
                
				<tr   class="displayclientforedit">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			


		</table>
	</center>

</form>
	<a href="main.jsp"> Back to Management System</a>
</body>
</html>