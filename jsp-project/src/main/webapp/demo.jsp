<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello , Today's Date is </h1>
	<%
	LocalDateTime today = LocalDateTime.now();
	out.println(today);
	request.setAttribute("email", "abc@b.com");
	%>
	
	<h2>End</h2>
	<%
		out.println(request.getAttribute("email"));
	%>
	
</body>
</html>