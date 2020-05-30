<%@page import="com.dto.AccountDTO"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp" />
<body>
	<form action="login" method="post" name="ChangePasswordForm"
		onsubmit="return validateChangePasswordForm()">
		<%
			AccountDTO dto = (AccountDTO) session.getAttribute("myaccount");
		%>
		<h1 align="center">Change Password</h1>
		<div align="center">
			<table border="2px">
				<tr>
					<td>Enter EmailId</td>
					<td><input readonly="readonly" name="emailid"
						value="<%=dto.getEmailId()%>"></td>
				</tr>
				<tr>
					<td>Current Password</td>
					<td><input type="password" name="current"></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type="password" name="newpass"></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><input type="password" name="confirm"></td>
				</tr>
			</table>
			<input type="submit" name="operation" value="change">
		</div>
	</form>
</body>
</html>