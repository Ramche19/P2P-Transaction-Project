<%@page import="com.pack1.UserDetailsBean"%>
<%@page import="java.util.Iterator" %>
<%@page import="com.pack1.StatementBean" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Statement JSP</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css">
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/152/152533.png">
    <link rel="stylesheet" href="style2.css">
    <style>

 
#container1{
    display:flex;
    flex-direction:column;
    justify-content:left;
    align-items:center;
    width:100%;
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
            <li><form method="post" action="statement"><button id="selected" class="mbuttons" type="submit">Statement</button></form></li>
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
  <div id="container1">
  <h1>Account Statement</h1>
   	<table id="txntable">
   	
   	<tr>
   	<th>Date & Time(IST)</th>
   	<th>Transaction ID</th>
   	<th>From-Account</th>
   	<th>To-Account</th>
   	<th>Transaction Type</th>
   	<th>Amount</th>
   	<th>Updated Balance</th>
   	<%
	  ArrayList<StatementBean> al =(ArrayList<StatementBean>)request.getAttribute("data");

	 
	 if(al.size()==0)
	 {
		 out.println("<tr><td colspan='7'><center>No Transactions Found</td></tr>");
	 }
	 else
	 {
		 Iterator<StatementBean> i = al.iterator();
		 while(i.hasNext())
		{
			StatementBean sb = i.next();
			out.println("<tr>");
			out.println("<td>"+sb.getDate()+"</td>");
			out.println("<td>"+sb.getTxn_id()+"</td>");
			out.println("<td>"+sb.getMy_accNumber()+"</td>");
			out.println("<td>"+sb.getTo_accNumber()+"</td>");
			out.println("<td>"+sb.getTxn_type()+"</td>");
			if(sb.getTxn_type().equals("DEBIT")){
				out.println("<td class=\"debit\">-"+sb.getAmount()+"</td>");
			}
			else{
				out.println("<td class=\"credit\">+"+sb.getAmount()+"</td>");
			}
			
			
			out.println("<td>"+sb.getUbal()+"</td>");	
			
			

			
			out.println("</tr>");			  
		}
	 }
	
	%>
   	
   	</table>
    
 </div>

  <script src="script2.js">
  const txntype[] = document.getElementsByClassName("txntype");
  console.log(txntype)
  txntype.forEach((ele)=>{
  if(txntype.value=='DEBIT')
  	txntype.ClassName ="debit"
  else
	 txntype.ClassName ="credit"
  } 
  </script> 
</body>
</html>