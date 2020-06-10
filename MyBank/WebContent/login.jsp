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
	<form action="login" method="post" name="LoginForm"
		onsubmit="return validateLoginForm()">
		<h1 align="center">Login</h1>
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
					<td>Enter Password</td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
			<input type="submit" name="operation" value="login">
		</div>

	</form>
</body>
</html>