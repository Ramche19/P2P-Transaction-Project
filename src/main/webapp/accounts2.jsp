 <%@page import="com.pack1.UserDetailsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
     pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Accounts JSP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/152/152533.png">
    <link rel="stylesheet" href="style2.css">
</head>
<body>

    <nav class="navbar">
        <div class="logo">
            <img src="./FASTMONEY logo.png" width="50" height="5" alt="logo">
        </div>
        <ul class="navlinks">
            <li><form method="post" action="accounts"><button id="selected" class="mbuttons" type="submit">Accounts</button></form></li>
            <li><form method="post" action="transactions"><button class="mbuttons" type="submit">Transactions</button></form></li>
            <li><form method="post" action="statement"><button class="mbuttons" type="submit">Statement</button></form></li>
            <li><form method="post" action="AddMoney.jsp"><button class="mbuttons" type="submit">Add Money</button></form></li>
            <li><form method="post" action="sendmoney.jsp"><button   class="mbuttons" type="submit">SendMoney</button></form></li>
<div class="profile-container">
    <img
      src="https://images.rawpixel.com/image_png_800/cHJpdmF0ZS9sci9pbWFnZXMvd2Vic2l0ZS8yMDIzLTAxL3JtNjA5LXNvbGlkaWNvbi13LTAwMi1wLnBuZw.png"
      alt="Profile Icon"
      class="profile-icon"
      onclick="togglePopup()"
    />
    <div id="popup" class="popup">
      <p><strong><%UserDetailsBean udb = (UserDetailsBean)session.getAttribute("bean");
      out.println(udb.getFname()); %></strong></p>
      <a href="Profile.jsp">Edit Profile</a><br>
      <a href="logout">Log Out</a>
    </div>
  </div>
       </ul>
    </nav>

    <div id="container">

        <div id="left">
            <div>
            <h4 id="fname">
                 <%
                     out.println("Hi, "+udb.getFname());
                %>   
            </h4></div>
            <div id="balancewrapper">
                <form action="accounts" method="post">
                    <h3 id="amttext">Amount Balance:</h3><br>
                    <h1><span id="balance">
                        <%
                        out.println("Rs. "+udb.getBalance_amount());
                        session.setAttribute("key", "0");
                    	
                        
                        
                        %>
                      
                    </span>
                    <span><button type="submit" id="icon"><i class="fa-solid fa-eye-slash" id="eye"></i></button></span></h1>
                </form>    
            </div>
        </div>

        <div id="right">
            <h2>Account Details: </h2><br><br><br>
            <div>
            <h4> Account Number:
                  <% out.println(udb.getMy_AccNumber());%> 
            </h4><br>
            <h4> Email:
                  <% out.println(udb.getEmail_id());%> 
            </h4><br>
            <h4> Phone Number:
                  <% out.println(udb.getPhone());%> 
            </h4><br>
            
            <h4> Account Status: Open</h4><br>
            <h4> Account Nominee: Registered</h4><br>
            </div>
        </div>
    </div>
    <script src="script2.js"></script>
</body>
</html>