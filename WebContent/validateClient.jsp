<jsp:useBean id="clientHandler" class="cs.tutorial.bs.entity.ClientJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Validation </title>
</head>
<body>
validateClient.jsp

	<form action="processClient.jsp" method="post">

		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<tr class="validateclienthead">
					<th colspan=2><font size=5>Client
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				<tr  class="validateclient">
					<td valign=top><b>Client ID</b> <br> 
					<%=clientHandler.getStrClientID()%>
						<font size=2 color=red><%=clientHandler.getErrorMsg("clientID")%></font>
					<input type="hidden" name="hidden_clientnumber" value="<%=clientHandler.getStrClientID()%>" />
					</td>
				</tr>
				<tr   class="validateclient">
					<td valign=top><b>Client First Name<sup>*</sup></b> <br> <input
						type="text" name="firstName" value='<%=clientHandler.getFirstName()%>'
						size=80 maxlength=80> <br> <font size=2 color=red><%=clientHandler.getErrorMsg("firstName")%></font>
					</td>
				</tr>
				<tr   class="validateclient">
					<td valign=top><b>Client Last Name<sup>*</sup></b> <br> <input
						type="text" name="lastName" value='<%=clientHandler.getLastName()%>'
						size=80 maxlength=200> <br> <font size=2 color=red><%= clientHandler.getErrorMsg("lastName")%></font>
					</td>
				</tr>
				<tr   class="validateclient">
					<td valign=top><b>Client Email<sup>*</sup></b> <br> <input
						type="text" name="email" value='<%=clientHandler.getEmail()%>'
						size=100 maxlength=200> <br> <font size=2 color=red><%=clientHandler.getErrorMsg("email")%></font>
					</td>
				</tr>
				
				<tr   class="validateclient">
					<td valign=top><b>Client Phone Number<sup>*</sup></b> <br> <input
						type="text" name="phoneNumber" value='<%=clientHandler.getPhoneNumber()%>'
						size=20 maxlength=20> <br> <font size=2 color=red><%=clientHandler.getErrorMsg("phoneNumber")%></font>
					</td>
				</tr>
				
				<tr    class="validateclient">
					<td valign=top><b>Client Address<sup>*</sup></b> <br> <input
						type="text" name="address" 
						size=100 maxlength=200> <br> <font size=2 color=red><%=clientHandler.getErrorMsg("address")%></font>
					</td>
				</tr>

				<tr   class="validateclient">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>