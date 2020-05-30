<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
				<%
					request.getAttribute("account");
				%>
				<form action="account.do" method="post"
					name="AccountRegistrationForm"
					onsubmit="return validateAccountRegistrationForm()">
					<h1 align="center">Account Sign Up</h1>
					<br>

					<%
						if (request.getAttribute("accountError") != null) {
					%>
					<h1 align="center" style="color: red"><%=request.getAttribute("accountError")%></h1>
					<%
						}
					%>
					<%
						AccountDTO accountDTO = new AccountDTO();
						if (request.getAttribute("accountDTO") != null) {
							accountDTO = (AccountDTO) request.getAttribute("accountDTO");
						}
					%>
					<input type="hidden" name="id" value="<%=accountDTO.getId()%>">
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Enter Account Number" name="accountNo"
							value="<%=BaseUtility.toEmpty(accountDTO.getAccountNo())%>">
					</div>

					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Name"
							name="userName"
							value="<%=BaseUtility.toEmpty(accountDTO.getUserName())%>">
					</div>

					<div class="form-group">
						<input type="email" class="form-control"
							placeholder="Enter EmailId" name="emailId"
							value="<%=BaseUtility.toEmpty(accountDTO.getEmailId())%>">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Enter Password" name="password"
							value="<%=BaseUtility.toEmpty(accountDTO.getPassword())%>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Enter Balance" name="balance"
							value="<%=BaseUtility.toInteger(accountDTO.getBalance())%>">
					</div>

					<%
						if (accountDTO.getId() > 0) {
					%>
					<button type="submit" name="operation" value="update"
						class="btn btn-primary btn-block">Update</button>
					<%
						} else {
					%>
					<button type="submit" name="operation" value="add"
						class="btn btn-primary btn-block">Add</button>
					<%
						}
					%>
				</form>
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />