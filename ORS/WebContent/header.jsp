<!DOCTYPE html>
<%@page import="com.dto.UserDTO"%>
<html lang="en">
<head>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.header {
	overflow: hidden;
	background-color: #f1f1f1;
	padding: 20px 10px;
}

.header a {
	float: left;
	color: black;
	text-align: center;
	padding: 12px;
	text-decoration: none;
	font-size: 18px;
	line-height: 25px;
	border-radius: 4px;
}

.header a.logo {
	font-size: 25px;
	font-weight: bold;
}

.header a:hover {
	background-color: #ddd;
	color: black;
}

.header a.active {
	background-color: dodgerblue;
	color: white;
}

.header-right {
	float: right;
}

@media screen and (max-width: 500px) {
	.header a {
		float: none;
		display: block;
		text-align: left;
	}
	.header-right {
		float: none;
	}
}
</style>
<script src="bootstrap/js/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script src="bootstrap/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/loginForm.js"></script>
<script type="text/javascript" src="js/forgotPasswordForm.js"></script>
<script type="text/javascript" src="js/changePasswordForm.js"></script>
<script type="text/javascript" src="js/userRegistrationForm.js"></script>
<script type="text/javascript" src="js/marksheetRegistrationForm.js"></script>
<script type="text/javascript" src="js/accountRegistrationForm.js"></script>
<script type="text/javascript" src="js/utility.js"></script>
</head>
<nav class="navbar navbar-expand-md navbar-dark bg-primary mb-3">
	<div class="container">
		<a href="#default" class="logo" style="color: white"><h2>Welcome</h2></a>
		<button type="button" class="navbar-toggler" data-toggle="collapse"
			data-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="header-right">

			<div class="collapse navbar-collapse" id="navbarSupportedContent">


				<ul class="navbar-nav mr-auto">
					<%
						if (session.getAttribute("userDTO") != null) {
							UserDTO dto = (UserDTO) session.getAttribute("userDTO");
					%>
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item-active dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Account </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="account.do">Account</a> <a
								class="dropdown-item" href="accountList.do">Account List</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> Marksheet </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="marksheet.do">Marksheet</a> <a
								class="dropdown-item" href="marksheetList.do">Marksheet List</a>
						</div></li>
					<li class="nav-item"><a class="nav-link" href="userList.do">User
							List</a></li>
					<li class="nav-item"><a class="nav-link" href="changePassword">Change Password</a></li>
					<li class="nav-item"><a class="nav-link"
						href="login?operation=logOut">Logout</a></li>
					<%
						} else {
					%>
					<li class="nav-item active"><a class="nav-link" href="login">LogIn
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="newUser">Sign
							Up</a></li>
					<li class="nav-item"><a class="nav-link"
						href="forgotPassword.jsp">Forgotted Password</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</div>
</nav>