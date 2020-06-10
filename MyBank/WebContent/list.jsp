<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.AccountDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp" />
<body>
	<form action="accountList" method="post">
		<%
			ArrayList list = (ArrayList) request.getAttribute("list");
			int pageIndex = 0;
			if (request.getAttribute("pageIndex") != null) {
				pageIndex = BaseUtility.toInteger(request.getAttribute("pageIndex"));
			}
			int searialNumber = pageIndex == 0 ? pageIndex : pageIndex * 3;
		%>
		<h1 align="center">Account List</h1>
		<div align="center">
			Search Name : <input type="text" name="searchByName"> <input
				type="submit" name="operation" value="search">
			<table border="2px">
				<tr>
					<th>Delete</th>
					<th>Serial #</th>
					<th>AccountNo</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>EmailId</th>
					<th>Password</th>
					<th>ContactNo</th>
					<th>Address</th>
					<th>Balance</th>
				</tr>
				<%
					Iterator it = list.iterator();
					while (it.hasNext()) {
						AccountDTO dto = (AccountDTO) it.next();
				%>
				<tr>
					<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
					<td><%=++searialNumber%></td>
					<td><a href="signup?operation=get&id=<%=dto.getId()%>"><%=dto.getAccountNo()%></a></td>
					<td><%=dto.getFirstName()%></td>
					<td><%=dto.getLastName()%></td>
					<td><a href="signup?operation=get&id=<%=dto.getId()%>"><%=dto.getEmailId()%></a></td>
					<td><%=dto.getPassword()%></td>
					<td><%=dto.getContactNo()%></td>
					<td><%=dto.getAddress()%></td>
					<td><%=dto.getBalance()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%=pageIndex%>
			<a href="accountList?operation=next&pageIndex=<%=pageIndex%>">Next</a>
			<input type="submit" name="operation" value="delete">
			<%
				if (pageIndex > 0) {
			%>
			<a href="accountList?operation=previous&pageIndex=<%=pageIndex%>">Previous</a>
			<%
				}
			%>
		</div>
	</form>
</body>
</html>