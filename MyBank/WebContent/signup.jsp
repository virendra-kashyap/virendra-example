<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.AccountDTO"%>
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
	<form action="signup" method="post" name="RegistrationForm"
		onsubmit="return validateRegistrationForm()">
		<h1 align="center">Sign Up</h1>
		<%
			AccountDTO accountDTO = new AccountDTO();
			if (request.getAttribute("accountDTO") != null) {
				accountDTO = (AccountDTO) request.getAttribute("accountDTO");
			}
		%>
		<div align="center">
			<table border="2px">
				<input type="hidden" name="id" value="<%=accountDTO.getId()%>">
				<tr>
					<td>Enter AccountNo</td>
					<td><input type="text" name="accountno"
						value="<%=BaseUtility.toEmpty(accountDTO.getAccountNo())%>"></td>
				</tr>
				<tr>
					<td>Enter FirstName</td>
					<td><input type="text" name="firstname"
						value="<%=BaseUtility.toEmpty(accountDTO.getFirstName())%>"></td>
				</tr>
				<tr>
					<td>Enter LastName</td>
					<td><input type="text" name="lastname"
						value="<%=BaseUtility.toEmpty(accountDTO.getLastName())%>"></td>
				</tr>
				<tr>
					<td>Enter EmailId</td>
					<td><input type="text" name="emailid"
						value="<%=BaseUtility.toEmpty(accountDTO.getEmailId())%>"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password"
						value="<%=BaseUtility.toEmpty(accountDTO.getPassword())%>"></td>
				</tr>
				<tr>
					<td>Enter ContactNo</td>
					<td><input type="text" name="contactno"
						value="<%=BaseUtility.toEmpty(accountDTO.getContactNo())%>"></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><input type="text" name="address"
						value="<%=BaseUtility.toEmpty(accountDTO.getAddress())%>"></td>
				</tr>
				<tr>
					<td>Enter Balance</td>
					<td><input type="text" name="balance"
						value="<%=accountDTO.getBalance()%>"></td>
				</tr>
			</table>
			<%
				if (accountDTO.getId() > 0) {
			%>
			<input type="submit" name="operation" value="update">
			<%
				} else {
			%>
			<input type="submit" name="operation" value="submit">
			<%
				}
			%>
		</div>
	</form>
</body>
</html>