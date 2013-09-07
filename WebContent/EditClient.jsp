<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="ejb605style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 
<center>
<form name="clientlist1"  method="post" action="ClientControllerServlet">
<div>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<h1>Client Edit Page</h1>
Enter client number:<input type="text" name="clientId" ><br /><br />

<input type="radio" name="process" value="add"> Add <br />														
<input type="radio" name="process" value="get"> Get <br />
<input type="radio" name="process" value="getAll" checked="checked"> Get All <br />
<input type="radio" name="process" value="remove"> Remove <br />
<input type="radio"	name="process" value="update"> Update	<br /><br />
							
							
<input type="submit" name="Submit" value="Submit">
					
<input name="Reset" type="reset" id="Reset" value="Clear">

</div>
</form><br /><br />
<!-- <a href="index.jsp"> Back to Management System</a>   -->
</center>
</body>
</html>