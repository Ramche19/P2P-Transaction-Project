<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FM - Forgot Password</title>
</head>
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="icon" href="./FASTMONEY logo.png">
    <link rel="stylesheet" href="style.css">
    <style>
    #container
{
   	min-height: 50%;
    width:85%;
    max-width:30rem;
    
    margin:1rem;
    padding:1rem;

    display:flex;
    justify-content: start;
    align-items: center;
    flex-direction: column;
    gap:3rem;

    border-radius: 0.5rem;
    box-shadow:var(--container-shadow);
    border:solid 2px var(--color0);

    background-color: var(--container-color);
    color:var(--color0);
    
}
    
    
    </style>
<body>
<%
    String msg = (String)   request.getAttribute("msg");
    if (msg != null) 
 out.println("<h3 id='info'>"+ msg +"</h3><br>");

else
 out.println("<h3 id='info'>Reset Password and Transaction-Pin</h3><br>");

%><br>
 

    <div id="container">
    <img src="FASTMONEY_logo-removebg-preview.png" height="50" width="50" alt="logo" id="logo">
    	<div class="forms">
            <form  action="validation" method="post" onsubmit="formSubmit(event)">
               
                <label for="Email">Email or AccountNumber:</label><br><br>
                <input type="text" class="inputbox" name="data" placeholder="Enter Your Email/AccountNumber" id="Email" required><br><br>
     			<div id="login">
                    <button  class="buttons" type="submit">Reset</button><br>
                </div>
           
            </form>
		</div>
	</div>	
<script>
	

	
</script>
</body>
</html>