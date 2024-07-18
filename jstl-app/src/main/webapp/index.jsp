<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>


<%@ taglib prefix="c" uri="jakarta.tags.core"%>






<html>
<body>
	<h2>JSTL Example</h2>
	<c:set var="income" scope="session" value="${5000*4 }" />
	<p>
		Your Income is:
		<c:out value="${income }" />
	</p>
	
	<%
	
	Map<String,String>ch =new HashMap<>();
	ch.put("India","Delhi");
	ch.put("USA","Washington DC");
	ch.put("France","Paris");
	
	request.setAttribute("capital",ch);
	
	
	
	%>
	
	<table border="1">
		<tr><th bgcolor="green">COUNTRY</th><th bgcolor="green">CAPITAL</th></tr>
		<c:forEach var="c" items="${capital}">
			<tr><td>${c.key}</td><td>${c.value}</td></tr>
		</c:forEach>
	</table>
	


</body>
</html>
