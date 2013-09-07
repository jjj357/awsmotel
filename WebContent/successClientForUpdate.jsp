<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="clientHandler" class="cs.tutorial.bs.entity.ClientJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
</head>
<body>
successClientForUpdate.jsp

	


	<% 
	request.setAttribute("javabeanclient", clientHandler);
	request.setAttribute("process", "update");
	request.setAttribute("clientId", clientHandler.getStrClientID());
	request.getRequestDispatcher("ClientControllerServlet").forward(request,
	response);
	//return;
	
%>
</body>
</html>