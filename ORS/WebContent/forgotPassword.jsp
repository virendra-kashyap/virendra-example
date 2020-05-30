<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<body>
	<form action="login" method="post" name="forgotPasswordForm"
		onsubmit="return validateForgotPasswordForm()">
		<%
			if (request.getAttribute("forgotError") != null) {
		%>
		<h1 align="center" style="color: red"><%=request.getAttribute("forgotError")%></h1>
		<%
			}
		%>
		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">

					<h1>Reset Password</h1>
					<br>
					<div class="form-group">
						<input type="email" class="form-control form-control-lg"
							placeholder="Enter Email" name="emailId">
					</div>
					<div class="form-group">
						<input type="password" class="form-control form-control-lg"
							placeholder="Enter New Password" name="newPassword">
					</div>
					<div class="form-group">
						<input type="password" class="form-control form-control-lg"
							placeholder="Enter Confirm Password" name="confirmPassword">
					</div>
					<div class="form-group">
						<button type="submit" name="operation" value="Reset"
							class="btn btn-lg btn-primary btn-block">Reset</button>
					</div>

				</div>
			</div>
		</div>
	</form>
</body>
<%@ include file="footer.jsp"%>