<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="roomHandler" class="cs.tutorial.bs.entity.RoomJavaBean"
	scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
</head>
<body>
successForUpdate.jsp

	


	<% 
	session.setAttribute("javabeanroom", roomHandler);
    session.setAttribute("process", "update");
    session.setAttribute("roomId", roomHandler.getStrRoomNumber());  
	request.getRequestDispatcher("RoomControllerServlet").forward(request,
	response);
	//return;
	
%>
</body>
</html>