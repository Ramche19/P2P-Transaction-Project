
<%@page import="com.pack1.UserDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>SENDMONEY JSP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/152/152533.png">
    <link rel="stylesheet" href="style2.css">
    <style>
    input[type=number]::-webkit-inner-spin-button,
    input[type=number]::-webkit-outer-spin-button
     {
	    -webkit-appearance: none;
	    margin: 0;
	 }
   
	
}
#wholewrapper{
    display:flex;
    flex-direction:row;
    justify-content:center;
    align-items:center;
    width:100%;
    height:100vh;
}

#container1{
    min-width:60%;
    display:flex;
    flex-direction:column;
    justify-content:space-between;
    align-items: center;
    gap:30px;
    border:solid grey 3px;
    border-radius:1rem;
    margin:1rem;
    padding:2rem;
    text-align:left;
    box-shadow:0 4px 8px rgba(0,0,0,0.5);
    background-color: #e0e0e0;
    border: solid 3px #333;
}

.inputbox{
    margin:0.5rem 0;
    width:20rem;
    max-width:100%;
    height:2rem;
    border:solid black 3px;
    border-radius:0.5rem;
    color:black;
    padding:0.5rem;
    box-sizing: border-box;
}

#passwordWrapper {
  position: relative;
  width: 100%;
}

#Pwd {
  width: 100%;
  padding: 10px;
  padding-right: 40px;
  font-size: 16px;
}

#eye{
background-color:white;
}

#pwdicon {
  position: absolute;
  right: 0.5rem;
  top: 30%;
  cursor: pointer;
  border:none;
}


    
    </style>
</head>
<body>

   
      <nav class="navbar">
        <div class="logo">
            <img src="./FASTMONEY logo.png" width="50" height="5" alt="logo">
        </div>
        <ul class="navlinks">
            <li><form method="post" action="accounts"><button  class="mbuttons" type="submit">Accounts</button></form></li>
            <li><form method="post" action="transactions"><button class="mbuttons" type="submit">Transactions</button></form></li>
            <li><form method="post" action="statement"><button class="mbuttons" type="submit">Statement</button></form></li>
            <li><form method="post" action="AddMoney.jsp"><button class="mbuttons" type="submit">Add Money</button></form></li>
            <li><form method="post" action="sendmoney.jsp"><button id="selected"  class="mbuttons" type="submit">SendMoney</button></form></li>
<div class="profile-container">
    <img
      src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTAxL3JtNjA5LXNvbGlkaWNvbi13LTAwMi1wLnBuZw.png"
      alt="Profile Icon"
      class="profile-icon"
      onclick="togglePopup()"
    />
    <div id="popup" class="popup">
      <p><strong><%UserDetailsBean udb = (UserDetailsBean)session.getAttribute("updatedbean");
      out.println(udb.getFname()); %></strong></p>
      <a href="Profile.jsp">Edit Profile</a><br>
      <a href="logout">Log Out</a>
    </div>
  </div>
       </ul>
    </nav>
    
   <div id="wholewrapper">
    <div id="container1">
		<form action="sendmoney" method="post" onsubmit="check(event)">
			<center><h2>Send Money</h2></center>
			<%
				String accno = udb.getMy_AccNumber();
			%>
                <input type="hidden" readonly name="AccNumber" class="inputbox" value="<%= accno %>" id="AccNumber" required><br><br>
            <label for="RAccNumber">To Account Number:</label><br>
                <input type="text" class="inputbox" name="RAccNumber" placeholder="Eg. A1XXXXXXX9" id="RAccNumber" required>
            	<div id="para">
                        <p id="errorMsg2">&nbsp;</p>
                    </div><br>
            
            <label for="amount">Amount:</label><br>
            	<input type="number" class="inputbox" name="amount" placeholder="1000" id="amount" required><br>
            	<div id="para">
                        <p id="errorMsg1">&nbsp;</p>
                    </div><br>    
            <label for="Pwd" >Transaction-Pin:</label>
                <div id="passwordWrapper">
                    <input type="password" maxlength="6" pattern="\d{6}" title="Should be 6 digit Number"  name="mtpin" class="inputbox" id="Pin" required>
                    <button type="button"  id="pwdicon">
                        <i class="fa-solid fa-eye" id="eye"></i>
                    </button>
                    <div id="para">
                        <p id="errorMsg">&nbsp;</p>
                    </div>
                </div>   
                <div id="login">
                    <button onclick="check()" class="buttons" type="submit">Send</button><br>
                </div>    			
		
		
		</form>	
       
    </div>
 </div>
<script src="script2.js">

</script>

   
</body>
</html>