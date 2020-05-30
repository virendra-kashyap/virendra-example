<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<body>
	<form action="newUser" method="post" class="form-horizontal"
		name="UserRegistrationForm"
		onsubmit="return validateUserRegistrationForm()">

		<div class="text-center">
			<img src="user.png" class="rounded">
		</div>
		<%
			if (request.getAttribute("userError") != null) {
		%>
		<h1 align="center" style="color: red"><%=request.getAttribute("userError")%></h1>
		<%
			}
		%>
		<%
			UserDTO userDTO = new UserDTO();
			if (request.getAttribute("userDTO") != null) {
				userDTO = (UserDTO) request.getAttribute("userDTO");
		%>
		<%
			}
		%>
		<div class="container-fluid h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col col-sm-6 col-md-6 col-lg-6 col-xl-6">
					<h1 align="center">User Sign Up</h1>
					<br> <input type="hidden" name="id"
						value="<%=userDTO.getId()%>">
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" class="form-control "
									placeholder="Enter First Name" name="firstName"
									value="<%=BaseUtility.toEmpty(userDTO.getFirstName())%>">
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Enter Last Name" name="lastName"
									value="<%=BaseUtility.toEmpty(userDTO.getLastName())%>">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="Enter Email"
							name="emailId"
							value="<%=BaseUtility.toEmpty(userDTO.getEmailId())%>">
					</div>
					<div class="form-group">
						<input type="password" class="form-control"
							placeholder="Enter Password" name="password"
							value="<%=BaseUtility.toEmpty(userDTO.getPassword())%>">
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Enter Address" name="address"
									value="<%=BaseUtility.toEmpty(userDTO.getAddress())%>">
							</div>
						</div>
						<div class="col-xs-6 col-sm-6 col-md-6">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Enter Mobile Number" name="mobileNumber"
									value="<%=BaseUtility.toEmpty(userDTO.getMobileNumber())%>">
							</div>
						</div>
					</div>
					<%
						if (userDTO.getId() > 0) {
					%>
					<div class="from-group btn-mybutton">
						<button type="submit" name="operation" value="update"
							class="btn btn-sm-2 btn-primary  btn-block">Update</button>
					</div>
					<%
						} else {
					%>
					<div class="from-group btn-mybutton">
						<button type="submit" name="operation" value="add"
							class="btn btn-primary  btn-block">Add</button>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</form>

</body>

<jsp:include page="footer.jsp" />