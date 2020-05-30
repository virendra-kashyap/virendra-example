<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <%
		if (request.getAttribute("error") != null) {
	%>
	<h1 align="center" style="color: red"><%=request.getAttribute("error")%></h1>
	<%
		}
	%> --%>


	<form action="">
		<div align="center">
			<table border="1px">
				<tr>
					<td>Enter EmailId</td>
					<td><input type="text" name="emailId" style="color: blue" style="width: 300px"></td>
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password" style="color: blue" style="width: 300px"></td>
				</tr>
			</table>
			<input type="submit" name="operation" value="Log In"
				style="color: red"><a href="account.jsp">Sign Up</a>


		</div>

	</form>

</body>

<jsp:include page="footer.jsp" />