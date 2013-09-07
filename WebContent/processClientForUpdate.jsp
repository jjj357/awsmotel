<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process JSP</title>
</head>
<body>

	<jsp:useBean id="clientHandler" class="cs.tutorial.bs.entity.ClientJavaBean"
		scope="request">

		<jsp:setProperty name="clientHandler" property="strClientID" value='<%= request.getParameter("hidden_clientnumber") %>' />
		<jsp:setProperty name="clientHandler" property="firstName" value='<%= request.getParameter("firstName") %>' />
		<jsp:setProperty name="clientHandler" property="lastName" value='<%= request.getParameter("lastName") %>' />
		<jsp:setProperty name="clientHandler" property="email" value='<%= request.getParameter("email") %>' />
		<jsp:setProperty name="clientHandler" property="phoneNumber" value='<%= request.getParameter("phoneNumber") %>' />
	    <jsp:setProperty name="clientHandler" property="address" value='<%= request.getParameter("address") %>' />							

		<% if (clientHandler.validate()) { %>

		<jsp:forward page="successClientForUpdate.jsp" />

		<%} else { %>

		<jsp:forward page="validateClient.jsp" />

		<%}%>

	</jsp:useBean>

</body>

</html>