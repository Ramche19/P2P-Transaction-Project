
<%@page import="com.pack1.UserDetailsBean"%>
<%@page import="com.pack1.SendMoneyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Receipt JSP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/152/152533.png">
    <link rel="stylesheet" href="style2.css">
    <style>
 
#wholewrapper{
    display:flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    width:100%;
}

#container1{
    min-width:40%;
    display:flex;
    flex-direction:column;
    justify-content:space-between;
    align-items: center;
    gap:30px;
    border:solid grey 3px;
    border-radius:1rem;
    margin:1rem;
    margin-top:10rem;
    padding:1rem;
    text-align:left;
    box-shadow:0 4px 8px rgba(0,0,0,0.5);
    background-color: #e0e0e0;
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
            <li><form method="post" action="sendmoney.jsp"><button  class="mbuttons" type="submit">SendMoney</button></form></li>
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
    <h2><u>Transaction Receipt:</u></h2>
		<%
		SendMoneyBean smb=(SendMoneyBean)application.getAttribute("smb");
		out.println("Transaction ID:"+smb.getTrans_id()+"<br><br>");
		out.println(smb.getMsg()+"<br>");
		

		
		%>	
       
    </div>
 </div>

 
 

   <script src="script2.js"></script>
</body>
</html>

