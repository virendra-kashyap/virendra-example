<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<body>
	<fieldset>
		<h1>Login</h1>
		<form action="login" method="post" name="LoginForm"
			onsubmit="return validateLoginForm()">

			<%
				if (request.getAttribute("error") != null) {
			%>
			<h1 align="center" style="color: red"><%=request.getAttribute("error")%></h1>
			<%
				}
			%>
			<div class="iconUser"></div>
			<input type="text" name="emailid" placeholder="Username" required>

			<input type="password" name="password" placeholder="Password"
				id="myInput" required>
			<div class="iconPassword"></div>
			<input type="submit" name="operation" value="login"> 

		</form>
	</fieldset>
</body>
<jsp:include page="footer.jsp" />