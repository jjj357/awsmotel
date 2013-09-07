<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
#Label1 {
color: red;
}
</style>
<script  type="text/javascript">
function verifyInput() {
	
	var x=document.getElementById("firstname");
	   if (x.value == "") {
		   alert("Please enter your first name.");
        return false;
	   }
	   
		var y=document.getElementById("lastname");
		   if (y.value == "") {
			   alert("Please enter your last name.");
	        return false;
		   }
		   
			var x1=document.getElementById("username");
			   if (x1.value == "") {
				   alert("Please enter your username.");
		        return false;
			   }
			   
				var y1=document.getElementById("password");
				   if (y1.value == "") {
					   alert("Please enter your password.");
			        return false;
				   }
				  
					var x4=document.forms["form2"]["password"].value;
					if (x4.length < 6) {
						  alert("Password should be at least 6 characters");
						  return false;
					}
					
					var x2=document.getElementById("emailaddress");
					   if (x2.value == "") {
						   alert("Please enter your email address.");
				        return false;
					   }
					   
						var y2=document.getElementById("phonenumber");
						   if (y2.value == "") {
							   alert("Please enter your phone number.");
					        return false;
						   }
	   
	var x3=document.forms["form2"]["emailaddress"].value;
	var atpos=x3.indexOf("@");
	var dotpos=x3.lastIndexOf(".");
	if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x3.length)
	  {
	  alert("Not a valid e-mail address");
	  return false;
	  }
	

	
	var x5=document.forms["form2"]["phonenumber"].value;
	if(/\D/.test(x5))
    {
    alert("Please only enter numbers for phone number! (Allowed input:0-9)");
    return false;
    }
	return true;
}
</script>
</head>
<body>
<form id="form2"   action="RegisterServlet" method="post">
    <div>
    
        <br />
        Register a new user:<br />
        <br />
        First Name*:&nbsp;<input type="text" id="firstname" name="firstname" />
    
        <br />
        Last Name*: &nbsp;<input type="text" id="lastname"  name="lastname" />
    
        <br />
        Username*:
        <input type="text" id="username"  name="username" />
        <br />
        Password*: 
        &nbsp;<input type="password" id="password"  name="password" />
  
        &nbsp; (minimum 6 characters)<br />
        Email Address*: 
        &nbsp;<input type="text" id="emailaddress"  name="emailaddress" />
        <br />Phone Number*(Please only enter numbers,e.g. 4165456576): 
        &nbsp;<input type="text" id="phonenumber"  name="phonenumber" />
                <br />Security Question: 
        &nbsp;<input type="text" id="securityquestion"  name="securityquestion" />
                <br />Security Answer: 
        &nbsp;<input type="text" id="securityanswer"  name="securityanswer" />
    
        <br />
        <br />



        &nbsp;<input type="submit" name="Button1" value="Register" onclick="return verifyInput()"  />
        <br />
        <div id="Label1" ><% if(request.getSession().getAttribute("registerErrorMessage")!=null){%>Register Error<%}%></div>
        <br />
        <br />
        <br />
    </div>
    </form>
</body>
</html>