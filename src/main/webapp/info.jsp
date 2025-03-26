<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FM - Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body><br>
<h3 id="info">
<%
		
		String msg = (String)request.getAttribute("msg");
		out.println(msg);
		session.invalidate();
%>
<br>
</h3><br>
 <jsp:include page="index.html" />
 
</body>
</html>