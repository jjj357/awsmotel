<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
<script type="text/javascript" src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
    <style type="text/css">
		* { margin:0; padding:0;}
		body { font:14px arial;}
		li { list-style:none;}
		a { text-decoration:none;}
		a:hover { text-decoration:underline;}
		
		#nav1 { margin-bottom:200px;}
		
		.nav { margin:10px auto; width:1000px;  height:35px; padding:0 10px; color:#000;}
		.nav li { border-width:1px; border-style:solid;border-color:#fffff #383838 #f0f0f0 #fffff;float:left;text-align:center; position:relative; height:35px; line-height:35px;border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu1 { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu1:hover { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}

		.nav li a.mainMenu2 { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu2:hover { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}

		.nav li a.mainMenu3 { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu3:hover { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}

		.nav li a.mainMenu4 { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu4:hover { padding:0 5px; height:35px; width:100px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}

		.nav li a.mainMenu5 { padding:0 5px; height:35px; width:200px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu5:hover { padding:0 5px; height:35px; width:200px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}

		.nav li a.mainMenu6 { padding:0 5px; height:35px; width:200px; line-height:35px; display:block; background:#f0f0f0; color:#000; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}
		.nav li a.mainMenu6:hover { padding:0 5px; height:35px; width:200px; line-height:35px; display:block; background:#00f; color:#fff; float:left; border-top-right-radius: 7px; border-top-left-radius: 7px;}


		.nav li span { float:left; width:17px; height:35px; background:url(subnav_btn.gif) no-repeat center top;}
		.nav li span.subhover { background-position:center bottom; cursor:pointer;}
		
		ul.subnav { display:none; float:left; position:absolute; top:35px; left:0px; width:120px; height: 110px; background:#00f;}
		ul.subnav li { padding:0; clear:both; width:120px;}
        ul.subnav li a { color:#fff; }
    </style>
    <script type="text/javascript">
        $(document).ready(function () {
            $('<span></span>').insertBefore($('.subnav'));


            $('#nav1 li span').hover(function () {
                $(this).addClass('subhover');
                $(this).parent().hover(function () {
                }, function () {
                    $(this).parent().find('ul.subnav').slideUp('fast');
                });
            }, function () {
                $(this).removeClass('subhover');
            }).click(function () {
                $(this).parent().find('ul.subnav').slideDown('slow');
            });


            $('#nav2 li').hover(function () {
                $(this).find('span').addClass('subhover').end()
					   .find('ul.subnav').slideDown('slow');
            }, function () {
                $(this).find('span').removeClass('subhover').end()
					   .find('ul.subnav').slideUp('fast');
            });


            //addtional part added for loading data into id=content

            $("#BookRoom").click(function () {
                
                $.ajax({
                    url: "BookRoom.jsp",
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                	$("#intro").hide();
                });
            });

            $("#EditBooking").click(function () {
                
                $.ajax({
                    url: 'EditBooking.jsp',
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                	$("#intro").hide();
                });
            });

            $("#EditRoom").click(function () {
                
                $.ajax({
                    url: 'EditRoom.jsp',
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                	$("#intro").hide();
                });
            });
            
            $("#EditClient").click(function () {
                
                $.ajax({
                    url: 'EditClient.jsp',
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                	$("#intro").hide();
                });
            });
            
            $("#GetRoomsMeetingACriteria").click(function () {
                
                $.ajax({
                    url: 'GetRoomsMeetingACriteria.jsp',
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                	$("#intro").hide();
                });
            });

            $("#motelhomepage").click(function () {
                
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
            
            $("#policies").click(function () {
                
                $.ajax({
                    url: 'policies.jsp',
                    success: function (data) {
                        //$("#content").fadeOut();
                        $("#content").html(data).fadeIn();
                    }
                }).done(function () {
                    $("#intro").hide();
                });
            });
            
            $('#editroomsubmit').click(function() { 
                var theprocess=$('#process').val();
                var theroomid=$('#roomid').val();
                $.get('RoomControllerServlet',{process:theprocess,roomId:theroomid},function(responseText) {
                    $('#content').text(responseText);        
                });
            });
        

        });
    </script>

   


</head>
<body>
<% if (request.getSession().getAttribute("username")==null) { request.getRequestDispatcher("index.jsp").forward(request, response);return; } %>
 <form id="form1" >
    <div>
    
        <span lang="EN-CA" style="font-size:11.0pt;font-family:
&quot;Arial&quot;,&quot;sans-serif&quot;;mso-fareast-font-family:SimSun;mso-fareast-theme-font:
minor-fareast;mso-bidi-font-family:&quot;Times New Roman&quot;;mso-ansi-language:EN-CA;
mso-fareast-language:EN-US;mso-bidi-language:AR-SA">
     <div class="topRow" style="text-align:center">Welcome!

        &nbsp;&nbsp;
        <% if (request.getSession().getAttribute("username")!=null) { %><%=request.getSession().getAttribute("username") %><%} %>
     
   &nbsp;&nbsp;|&nbsp;&nbsp;<a href="index.jsp">Log out</a>
        </div>
        <hr />
 <ul class="nav" id="nav2">
    	
    	<li><a href="#" class="mainMenu1" id="BookRoom">Book a Room</a>

      </li>
        <li><a href="#" class="mainMenu2" id="EditBooking">Edit a Booking</a>

        </li>
        <li><a href="#" class="mainMenu3"  id="EditRoom">Edit Room</a>
        </li>
        <li><a href="#" class="mainMenu4" id="EditClient">Edit Client</a>
        </li>
        <li><a href="#" class="mainMenu5"  id="GetRoomsMeetingACriteria">Get Rooms Meeting a Criteria</a>
        </li>
        <li><a href="#" class="mainMenu6" id="motelhomepage">To Motel Home Page</a>
        </li>

    </ul>
    <div class="content" id="content" style="background:#fff;">
       <div id="intro">
       <h3 style="margin:10% 30% 0 30%;">MingtaoMart International Inc. is an international sales store company.</h3>
       <h3 style="margin:0 30% 0 30%;">This motel website is used for Mingtao Li's J2EE practice. More to come. </h3>
       </div>
    
    </div>
	
        <br />
        <br />
        <br />
        <br />
        <br />  
        </span>
    
    </div>
    </form>
</body>
</html>