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
 <% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
 <center>
	<form action="processClient.jsp" method="post">

		
			<table cellpadding=4 cellspacing=2 border=0>
				<tr>
					<th  class="addclienthead" colspan=2><font size=5>Client
							Definition:</font> <br> <font size=1><sup>*</sup> Required Fields</font></th>
				</tr>
				
				<tr   class="addclient">
					<td valign=top><b>Client ID<sup>*</sup></b> <br> 
					<% int thisClientNumber = ((Integer)request.getAttribute("CurrentMaxClientNumber")).intValue();
                       thisClientNumber ++;
                    %>
					<%= thisClientNumber %>
					   <input type="hidden" name="hidden_clientnumber" value="<%= thisClientNumber %>" >
					   
					</td>
				</tr>
				
				<tr    class="addclient">
					<td valign=top><b>Client First Name<sup>*</sup></b> <br> <input
						type="text" name="firstName" 
						size=80 maxlength=80> 
					</td>
				</tr>
				
				<tr   class="addclient">
					<td valign=top><b>Client Last Name<sup>*</sup></b> <br> <input
						type="text" name="lastName" 
						size=80 maxlength=200> <br> 
					</td>
				</tr>
				
				<tr    class="addclient">
					<td valign=top><b>Client Email<sup>*</sup></b> <br> <input
						type="text" name="email" 
						size=100 maxlength=200> <br> 
					</td>
				</tr>
				
				<tr    class="addclient">
					<td valign=top><b>Client Phone Number<sup>*</sup></b> <br> <input
						type="text" name="phoneNumber" 
						size=20 maxlength=20> <br> 
					</td>
				</tr>
				
				<tr    class="addclient">
					<td valign=top><b>Client Address<sup>*</sup></b> <br> <input
						type="text" name="address" 
						size=100 maxlength=200> <br> 
					</td>
				</tr>

				<tr    class="addclient">
					<td align=center colspan=2><input type="submit" value="Submit">
						<input type="reset" value="Reset"></td>
				</tr>
			</table>
		
	</form>
	<a href="main.jsp"> Back to Management System</a>
	</center>
</body>
</html>