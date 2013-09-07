<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*,java.io.*,cs.tutorial.bs.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!
	List<Integer> li = new RoomServiceLocator().getRoomNumbers();
	Room r = null;
	static Integer currentindex = 0;
	%>
	
	<%
	
		if ( (Boolean)request.getAttribute("doitagain") != null) {
			currentindex = 0;
			li = new RoomServiceLocator().getRoomNumbers();
		}
		if (currentindex < li.size()) {
			Integer roomNumber = li.get(currentindex);
			if (roomNumber == null) {
				request.getRequestDispatcher("fail.jsp").forward(request,
						response);
				return;
			}
			r = new RoomServiceLocator().getRoom(roomNumber);
			request.setAttribute("room", r);
			currentindex++;
			request.getRequestDispatcher("ShowaRoom.jsp").forward(request,
					response);
			return;
			
		} else {
			request.getRequestDispatcher("xsuccessfully.jsp").forward(request,
					response);
			return;
		}
	
	%>

</body>
</html>