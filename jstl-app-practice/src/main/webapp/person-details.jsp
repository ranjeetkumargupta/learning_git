​​<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person Details Page</title>
</head>
<body>
	
	<%-- To instantiate Person class, use <jsp:useBean> tag
			same as  Person personBean = new Person();
	 --%>
	
	<jsp:useBean id="personBean"  class="com.wipro.model.Person"  scope="request"/>
	
	<%-- To set properties, use <jsp:setProperty> tag --%>
	<jsp:setProperty property="adharCard" name="personBean" value="678765786923"/>
	<jsp:setProperty property="firstName" name="personBean" value="Ravi"/>
	<jsp:setProperty property="lastName" name="personBean" value="Sharma"/>
	<jsp:setProperty property="address" name="personBean" value="Pune"/>
	<jsp:setProperty property="mobile" name="personBean" value="8976567658"/>
	
	
	<h2> Person Details</h2>
	<b>Adhar Card:</b> ${personBean.adharCard }<br>
	<b>First Name:</b> ${personBean.firstName }<br>
	<b>Last Name:</b> ${personBean.lastName }<br>
	<b>Address:</b> ${personBean.address }<br>
	<b>Mobile:</b> ${personBean.mobile }<br>
	
	
	
</body>
</html>
