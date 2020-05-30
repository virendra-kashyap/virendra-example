<%@page import="com.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="header.jsp" />
<body>
	<form action="changePassword" method="post"
		name="changePasswordForm"
		onsubmit="return validateChangePasswordForm()">

		<%
			UserDTO dto = (UserDTO) session.getAttribute("userDTO");
		%>

		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
					<div class="form-group">
						<input type="text" class="form-control form-control-lg"
							readonly="readonly" value="<%=dto.getEmailId()%>" name="emailId">
					</div>
					<div class="form-group">
						<input type="password" class="form-control form-control-lg"
							placeholder="Enter Current Password" name="currentPassword">
					</div>
					<div class="form-group">
						<input type="password" class="form-control form-control-lg"
							placeholder="Enter New Password" name="newPassword">
					</div>
					<div class="form-group">
						<input type="password" class="form-control form-control-lg"
							placeholder="Enter Confirm Password" name="confirmPassword">
					</div>
					<div class="from-group">
						<button type="submit" name="operation" value="change Password"
							class="btn btn-primary btn-block">Change Password</button>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<%@ include file="footer.jsp"%>