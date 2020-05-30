<%@page import="com.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<body>
	<form action="login" method="post" name="LoginForm"
		onsubmit="return validateLoginForm()">
		<%
			if (request.getAttribute("sessionExpired") != null) {
		%>
		<h1 align="center" style="color: red"><%=request.getAttribute("sessionExpired")%></h1>
		<%
			}
		%>
		<%
			if (request.getAttribute("error") != null) {
		%>
		<h1 align="center" style="color: red"><%=request.getAttribute("error")%></h1>
		<%
			}
		%>
		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">


					<h2 align="center">Log In</h2>
					<br>

					<div class="form-group">
						<input class="form-control form-control-lg" type="email"
							placeholder="Enter Email" name="emailId">
					</div>
					<div class="form-group">
						<input class="form-control form-control-lg" placeholder="Password"
							type="password" name="password">
					</div>
					<div class="form-group">
						<button type="submit" name="operation" value="Log In"
							class="btn btn-info btn-sm-2 btn-block">Log In</button>
					</div>

				</div>
			</div>
		</div>
	</form>
</body>
<%@ include file="footer.jsp"%>