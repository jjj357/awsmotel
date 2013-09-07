<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="roomHandler" class="cs.tutorial.bs.entity.RoomJavaBean"
	scope="request">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process JSP</title>
</head>
<body>

process.jsp

		<jsp:setProperty name="roomHandler" property="strRoomNumber" value='<%= request.getParameter("strRoomNumber") %>' />
		<jsp:setProperty name="roomHandler" property="roomName" value='<%= request.getParameter("roomName") %>' />
		<jsp:setProperty name="roomHandler" property="description" value='<%= request.getParameter("description") %>' />
		<jsp:setProperty name="roomHandler" property="strPrice" value='<%= request.getParameter("strPrice") %>' />
        <jsp:setProperty name="roomHandler" property="strRoomTypeID" value='<%= request.getParameter("roomtype") %>' />


		<% if (roomHandler.validate()) { %>

		<jsp:forward page="success.jsp" />

		<%} else { %>

		<jsp:forward page="validate.jsp" />

		<%}%>

	</jsp:useBean>

</body>

</html>