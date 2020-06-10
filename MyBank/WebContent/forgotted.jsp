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
	<form action="login" method="post" name="ForgotPasswordForm"
		onsubmit="return validateForgotPasswordForm()">
		<h1 align="center">Forgot Password</h1>
		<div align="center">
			<%
				if (request.getAttribute("error") != null) {
			%>
			<h1 align="center" style="color: red"><%=request.getAttribute("error")%></h1>
			<%
				}
			%>
			<table border="2px">
				<tr>
					<td>Enter EmailId</td>
					<td><input type="text" name="emailid"></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td><input type="password" name="newpass"></td>
				</tr>
				<tr>
					<td>Confirm EmailId</td>
					<td><input type="password" name="confirm"></td>
				</tr>
			</table>
			<input type="submit" value="reset password" name="operation">
		</div>
	</form>
</body>
</html>