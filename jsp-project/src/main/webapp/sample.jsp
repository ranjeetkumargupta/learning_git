<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%@ include file="demo.jsp" %>
<%@ include file="header.jsp" %>
<%@ include file="footer.jsp" %>


<%--Declaration --%>

<%!
	int counter =0;
	public void greeting(){
		System.out.println("Time is: "+LocalTime.now());	
	}
%>

<%--Expression --%>
<%= LocalDateTime.now()%>

<%--Scriplet --%>

<%
	out.println("Im scriplet");
%>



</body>
</html>