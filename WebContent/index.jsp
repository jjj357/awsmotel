<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Motel Peony!</title>
<link rel="stylesheet" href="styles/flexslider.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script src="scripts/jquery.flexslider.js"></script>
<script type="text/javascript" charset="utf-8">
  $(window).load(function() {
    $('.flexslider').flexslider({
        animation: "slide"
    }
);
  });
</script>
 <style type="text/css">
    body 
    {font-family:"Arial", Times, serif;} 
    
    .content
    {background-color: Blue;}
    
    .white
    {color: White;}
    
    .blue
    {color: blue;}
    

    
    div.wholebody {
    padding: 0px 0px 64px 0px;
    margin: 0px 5% 0px 5%;
        -webkit-box-shadow: 2px 2px 4px 1px #fff;
    box-shadow: 5px 5px 5px #888888;
    height: 100%;
    }
    
    div.flexslider {
   
    display: inline-block;
width: 60%;
height: 100%;
    }
    
        div.content {
        vertical-align: top;
    display: inline-block;
width: 38%;
height: 100%;
    }
    
    p.flex-caption {
    text-align: center;
    color: brown;
    background: rgb(184,225,252); /* Old browsers */
background: -moz-linear-gradient(top,  rgba(184,225,252,1) 0%, rgba(169,210,243,1) 10%, rgba(144,186,228,1) 25%, rgba(144,188,234,1) 37%, rgba(144,191,240,1) 50%, rgba(107,168,229,1) 51%, rgba(162,218,245,1) 83%, rgba(189,243,253,1) 100%); /* FF3.6+ */
background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(184,225,252,1)), color-stop(10%,rgba(169,210,243,1)), color-stop(25%,rgba(144,186,228,1)), color-stop(37%,rgba(144,188,234,1)), color-stop(50%,rgba(144,191,240,1)), color-stop(51%,rgba(107,168,229,1)), color-stop(83%,rgba(162,218,245,1)), color-stop(100%,rgba(189,243,253,1))); /* Chrome,Safari4+ */
background: -webkit-linear-gradient(top,  rgba(184,225,252,1) 0%,rgba(169,210,243,1) 10%,rgba(144,186,228,1) 25%,rgba(144,188,234,1) 37%,rgba(144,191,240,1) 50%,rgba(107,168,229,1) 51%,rgba(162,218,245,1) 83%,rgba(189,243,253,1) 100%); /* Chrome10+,Safari5.1+ */
background: -o-linear-gradient(top,  rgba(184,225,252,1) 0%,rgba(169,210,243,1) 10%,rgba(144,186,228,1) 25%,rgba(144,188,234,1) 37%,rgba(144,191,240,1) 50%,rgba(107,168,229,1) 51%,rgba(162,218,245,1) 83%,rgba(189,243,253,1) 100%); /* Opera 11.10+ */
background: -ms-linear-gradient(top,  rgba(184,225,252,1) 0%,rgba(169,210,243,1) 10%,rgba(144,186,228,1) 25%,rgba(144,188,234,1) 37%,rgba(144,191,240,1) 50%,rgba(107,168,229,1) 51%,rgba(162,218,245,1) 83%,rgba(189,243,253,1) 100%); /* IE10+ */
background: linear-gradient(to bottom,  rgba(184,225,252,1) 0%,rgba(169,210,243,1) 10%,rgba(144,186,228,1) 25%,rgba(144,188,234,1) 37%,rgba(144,191,240,1) 50%,rgba(107,168,229,1) 51%,rgba(162,218,245,1) 83%,rgba(189,243,253,1) 100%); /* W3C */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#b8e1fc', endColorstr='#bdf3fd',GradientType=0 ); /* IE6-9 */
    
    }
    

    </style>
</head>
<body>
<div class="wholebody">
<div class="flexslider">
  <ul class="slides">
    <li>
      <img src="slide1.jpg" />
      <p class="flex-caption"><br />Menu -- Easy to Use<br />&nbsp;</p>
    </li>
    <li>
      <img src="slide2.jpg" />
      <p class="flex-caption"><br />System Helps You to Get Available Rooms<br />&nbsp;</p>
    </li>
    <li>
      <img src="slide3.jpg" />
      <p class="flex-caption"><br />Easy to Query Database<br />&nbsp;</p>
    </li>
  </ul>
</div>

<div class="content">
 <form id="form1"  action="LoginServlet" method="post">
    <div>

    
    <div class="white">
    <a class="white" href="register.jsp">Register</a></div>
    <div class="thecenter">
    <div class="white">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br />
        <br />
        <br />
        <br />
        <br />
        <br />
         Login<br />
        <br />
        </div>
    <div align="left"  class="white"><a class="white">Username: 
        <input type="text" id="username" name="username" />
        </a><br />
    <br />
        <br />
        </div>
    <div align="left"><a class="white">Password: </a>
        <input type="password" id="password"  name="password" />
        <br />
        <br />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" id="Button1"  value="Submit" />
        <br /></div>
        <div align="center">&nbsp;&nbsp;&nbsp; <br />
            <div id="Label1"> <%if (request.getSession().getAttribute("errormessage") != null) { %> <%=request.getSession().getAttribute("errormessage") %> <% } %></div>
            </div>
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
            <br />
        </div>
    </div>
    

<%if (session != null) {session.invalidate(); session = null;} %>
    </form>
    </div>
    </div>
</body>
</html>