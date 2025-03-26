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
<body>
 <header>
    <img src="FASTMONEY_logo-removebg-preview.png" height="50" width="50" alt="logo" id="logo">
    </header>
    <div class="container">

        <div class="forms">
            <form  action="setpwd" method="post" onsubmit="formSubmit(event)">
                <br>
                <input type="hidden" class="inputbox" name="credData" value="<%= request.getAttribute("credData") %>" >
     			<input type="hidden" class="inputbox" name="credType" value="<%= request.getAttribute("credType") %>" >
     			
                <label for="pwd">Set Password</label><br>
                <input type="text" class="inputbox" name="password" placeholder="Enter New Password" id="pwd" required><br><br>
                 <label for="pwd">Set Transaction-Pin</label><br>
                <input type="number" max="999999" name="mtpin" placeholder="Enter New Transaction Pin" class="inputbox" id="Pin" required>
     			<div id="login">
                    <button  class="buttons" type="submit">Submit</button><br>
                </div>
           
            </form>
		</div>
	</div>	
	<script>
	function formSubmit(e)
	{
		const password = document.getElementById("pwd")
	    e.preventDefault();
	    const passlength = password.value.length;
	    console.log(passlength);
	    if (passlength < 8) {
	        const errormsg = document.getElementById("errorMsg");
	        errormsg.textContent = "Password should be min. 8 characters"
	        
	    }
	    else {
	        e.target.submit();
	    }
	}
	
	
	
	
	</script>
</body>
</html>