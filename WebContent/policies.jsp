<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Policies</title>
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
        	 $("#motelhomepage1").click(function () {
                 
                 $.ajax({
                     url: 'motelhomepage.jsp',
                     success: function (data) {
                         //$("#content").fadeOut();
                         $("#content").html(data).fadeIn();
                     }
                 }).done(function () {
                     $("#intro").hide();
                 });
             });

         });
     </script>	
</head>
<body>

<div style="margin:0 30% 0 30%;">
<h1>Motel Peony Policy</h1>
<div align="left">
1. Don't speak loud after 11pm. Please be considerate to other guests.<br /><br />
2. Don't download movies and software from the internet.<br /><br />
3. Don't destroy devices in the room. Otherwise you need to pay for it.<br /><br />

</div>
<!--  <a href=# id="motelhomepage1"> Back to Motel Home Page</a>   -->
</div>

</body>
</html>