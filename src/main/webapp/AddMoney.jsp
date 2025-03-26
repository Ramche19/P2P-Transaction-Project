
<%@page import="com.pack1.SendMoneyBean"%>
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
    margin:3rem;
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
            <li><form method="post" action="AddMoney.jsp"><button id="selected"  class="mbuttons" type="submit">Add Money</button></form></li>
            <li><form method="post" action="sendmoney.jsp"><button  class="mbuttons" type="submit">SendMoney</button></form></li>
<div class="profile-container">
    <img
      src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTAxL3JtNjA5LXNvbGlkaWNvbi13LTAwMi1wLnBuZw.png"
      alt="Profile Icon"
      class="profile-icon"
      onclick="togglePopup()"
    />
    <div id="popup" class="popup">
      <p><strong>
      <%UserDetailsBean udb = (UserDetailsBean)session.getAttribute("updatedbean");
      out.println(udb.getFname());
      %></strong></p>
      <a href="Profile.jsp">Edit Profile</a><br>
      <a href="logout">Log Out</a>
    </div>
  </div>
       </ul>
    </nav>
    
      <div id="wholewrapper">
    <div id="container1"><h2>Add Money</h2>
		<form action="addmoney" method="post" onsubmit="check(event)">
			<h3 id="acc" >Account Number: 
			<%
			        String accno = udb.getMy_AccNumber();
					out.println(udb.getMy_AccNumber());
			%></h3>
                <input type="hidden"  name="AccNumber" class="inputbox" value="BANK" id="AccNumber" required>
                <input type="hidden"  name="RAccNumber" class="inputbox" value="<%= udb.getMy_AccNumber() %>" id="RAccNumber" required><br><br>
            	
            <label for="amount">Enter Amount:</label><br>
            	<input type="number" class="inputbox" name="amount" placeholder="1000" id="amount" required><br>
            	<div id="para">
                        <p id="errorMsg1"></p>
                    </div><br>    
              
            <div id="login">
                    <button style="font-size:0.7rem; font-weight:500;" onclick="check()" class="buttons" type="submit">Add Money</button><br>
            </div>    			
		
		
		</form>	
       
    </div>
 </div>
<script src="script2.js">
const password = document.getElementById("Pwd");
const icon = document.getElementById("eye");
const from_acc = document.getElementById("AccNumber");
const to_acc = document.getElementById("RAccNumber");
const amount = document.getElementById("amount");

icon.addEventListener("click", function () {
    if (password.type === "password") {
        password.type = "text";
        icon.className = "fa-solid fa-eye-slash";
    } else {
        password.type = "password";
        icon.className = "fa-solid fa-eye";
    }
});


function validAccount() {
    const errorMsg2 = document.getElementById("errorMsg2");
    if (from_acc.value === to_acc.value) {
        errorMsg2.textContent = "Cannot Send Money to the Same Account!";
        return false;
    } else {
        errorMsg2.textContent = "";
        return true;
    }
}


function validAmount() {
    const errorMsg1 = document.getElementById("errorMsg1");
    if (amount.value < 100) {
        errorMsg1.textContent = "Minimum Amount should be Rs.100";
        return false;
    } else {
        errorMsg1.textContent = "";
        return true;
    }
}


function check(event) {
    const isAccountValid = validAccount();
    const isAmountValid = validAmount();

    if (!isAccountValid || !isAmountValid) {
        event.preventDefault();
        }
}


to_acc.addEventListener("input", validAccount);
amount.addEventListener("input", validAmount);



</script>

   
</body>
</html>