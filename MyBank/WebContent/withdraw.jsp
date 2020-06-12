<%@page import="com.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<body>
	<form action="accountList" method="post">
		<%
			AccountDTO dto = (AccountDTO) session.getAttribute("myaccount");
		%>
		<h1 align="center">Withdraw Amount</h1>
		<%
			if (request.getAttribute("dto") != null) {
		%>
		<h1 align="center" style="color: red"><%=request.getAttribute("dto")%></h1>
		<%
			}
		%>
		<div align="center">
			<table border="2px">
				<tr>
					<td>Account Number</td>
					<td><input value="<%=dto.getAccountNo()%>" name="accountno"></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input
						value="<%=dto.getFirstName()%> <%=dto.getLastName()%>"></td>
				</tr>
				<tr>
					<td>Enter Amount</td>
					<td><input type="text" name="amount"></td>
				</tr>
			</table>
			<button class="btn btn-outline-primary" type="submit"
				name="operation" value="withdraw">Withdraw</button>
		</div>
	</form>
</body>
</html>