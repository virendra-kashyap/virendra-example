<%@page import="com.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a: hover: not (.active ) {
	background-color: #111;
}

.active {
	background-color: #4CAF50;
}
</style>
<script type="text/javascript" src="js/loginForm.js"></script>
<script type="text/javascript" src="js/signupForm.js"></script>
<script type="text/javascript" src="js/forgotPasswordForm.js"></script>
<script type="text/javascript" src="js/changePasswordForm.js"></script>
</head>
<body>
	<%
		if (session.getAttribute("myaccount") != null) {
			AccountDTO accountDTO = (AccountDTO) session.getAttribute("myaccount");
	%>
	<ul>
		<li><a href="accountList">List</a></li>
		<li><a href="deposit.jsp">Deposit</a></li>
		<li><a href="withdraw.jsp">Withdraw</a></li>
		<li><a href="changePass.jsp">Change Password</a></li>
		<li><a href="login?operation=Logout">Logout</a></li>
		<li style="float: right"><a href="#about">About</a></li>
	</ul>
	<%
		} else {
	%>
	<ul>
		<li><a href="login">Login</a></li>
		<li><a href="signup">Signup</a></li>
		<li><a href="forgotted.jsp">Forgot Password</a></li>
		<li style="float: right"><a href="#about">About</a></li>
	</ul>
	<%
		}
	%>
</body>
</html>