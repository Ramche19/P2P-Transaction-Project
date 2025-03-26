<%@page import="com.pack1.SendMoneyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error JSP</title>
<style>

#error{
	color:red;
	background-color: white;
	border: solid 2px red;
	border-radius: 0.5rem;
	padding:0.5rem;
	max-width:70%;
	position: fixed;
	top: 95%;
	left: 50%;
	transform: translate(-50%, -50%);
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	z-index: 1000;
	text-align: center;
}




</style>
</head>
<body>

<jsp:include page="sendmoney.jsp" />
<div id="Wrap">
<h3 id="error">
	<%
	SendMoneyBean eb = (SendMoneyBean)application.getAttribute("eb");
		String msg = eb.getMsg();
		out.println("❌"+msg);
	
	
	
	%>
</h3>
</div>
</body>
</html>