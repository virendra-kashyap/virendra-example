<%@page import="com.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<body>
	<%
		AccountDTO dto = (AccountDTO) session.getAttribute("myaccount");
	%>
	<form action="accountList" method="post">
		<h1 align="center">Deposit Amount</h1>
		<div align="center">
			<table border="1px">
				<tr>
					<td>Account Number</td>
					<td><input value="<%=dto.getAccountNo()%>" name="accountno"></td>
				<tr>
				<tr>
					<td>User Name</td>
					<td><input
						value="<%=dto.getFirstName()%> <%=dto.getLastName()%>"></td>
				<tr>
					<td>Enter Amount</td>
					<td><input type="text" name="amount"></td>
				</tr>
			</table>
			<button class="btn btn-outline-info" type="submit" name="operation"
				value="deposit">Deposit</button>
		</div>
	</form>
</body>
</html>