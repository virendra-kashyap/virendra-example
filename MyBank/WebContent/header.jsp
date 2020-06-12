<%@page import="com.dto.AccountDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: 'Open Sans', sans-serif;
}

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

.active {
	background-color: #4CAF50;
}

fieldset {
	width: 400px;
	margin: 0 auto;
	margin-top: 8px;
	margin-bottom: 2%;
	transition: opacity 1s;
	-webkit-transition: opacity 1s;
}

h1 {
	background: #004A3E;
	padding: 20px 0;
	font-size: 140%;
	font-weight: 300;
	text-align: center;
	color: #fff;
}

form {
	background: #f0f0f0;
	padding: 6% 4%;
}

input[type="password"] {
	width: 76%;
	height: 20px;
	margin-bottom: 4%;
	border: 1px solid #ccc;
	padding: 4% 4% 4% 4%;
	font-family: 'Open Sans', sans-serif;
	font-size: 95%;
	color: #555;
}

.iconPassword {
	width: 20px;
	height: 20px;
	background-color: #004A3E;
	float: left;
	padding: 4% 4% 4% 4%;
	margin-bottom: 4%;
	background-repeat: no-repeat;
	background-image:
		url(https://cdn4.iconfinder.com/data/icons/font-awesome-2/2048/f09c-32.png);
	background-position: center;
	border: 1px solid #ccc;
}

.iconUser {
	width: 20px;
	height: 20px;
	background-color: #004A3E;
	float: left;
	padding: 4% 4% 4% 4%;
	margin-bottom: 4%;
	background-repeat: no-repeat;
	background-image:
		url(https://cdn4.iconfinder.com/data/icons/font-awesome-2/2048/f007-32.png);
	background-position: center;
	border: 1px solid #ccc;
}

input[type="text"] {
	width: 76%;
	height: 20px;
	margin-bottom: 4%;
	border: 1px solid #ccc;
	padding: 4% 4% 4% 4%;
	font-family: 'Open Sans', sans-serif;
	font-size: 95%;
	color: #555;
}

input[type="submit"] {
	width: 100%;
	background: #004A3E;
	border: 0;
	padding: 4%;
	font-family: 'Open Sans', sans-serif;
	font-size: 100%;
	color: #fff;
	cursor: pointer;
	transition: background .3s;
	-webkit-transition: background .3s;
}

input[type="submit"]:hover {
	background: #53B9A8;
}

::-webkit-input-placeholder {
	
}
</style>
<script type="text/javascript" src="js/loginForm.js"></script>
<script type="text/javascript" src="js/signupForm.js"></script>
<script type="text/javascript" src="js/forgotPasswordForm.js"></script>
<script type="text/javascript" src="js/changePasswordForm.js"></script>
<script type="text/javascript" src="js/master.js"></script>
<script type="text/javascript" src="js/togglePassword.js"></script>
</head>

<script src="bootstrap/js/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script src="bootstrap/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>


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