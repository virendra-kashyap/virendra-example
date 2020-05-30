<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.UserDTO"%>
<%@page import="com.dto.MarksheetDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />

<body>
	<div class="container">
		<form action="userList.do" method="post">
			<%
				ArrayList list = (ArrayList) request.getAttribute("userList");
				int pageIndex = 0;
				if (request.getAttribute("pageIndex") != null) {
					pageIndex = BaseUtility.toInteger(request.getAttribute("pageIndex"));
				}
				int searialNumber = pageIndex == 0 ? pageIndex : pageIndex * 4;
			%>
			<nav class="navbar navbar-expand-lg navbar-darrk">
				<div class="form-group row">
					<label class="sr-only" for="search">Enter UserName</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="search"
							placeholder="Enter UserName" name="searchByName">
					</div>
					<div class="col-sm-2">
						<button class="btn btn-outline-success my-2 my-sm-0"
							name="operation" type="submit" value="search">Search</button>

					</div>
				</div>
			</nav>


			<h1 align="center">User List</h1>
			<br>
			<div align="center" class="table-responsive-xl">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th><input name="ids" type="checkbox"
								onclick="masterCheckox(this)"></th>
							<th>Serial #</th>
							<th>FirstName</th>
							<th>LastName</th>
							<th>EmailId</th>
							<th>Password</th>
							<th>Address</th>
							<th>MobileNumber</th>
						</tr>
					</thead>
					<%
						Iterator it = list.iterator();
						while (it.hasNext()) {
							UserDTO dto = (UserDTO) it.next();
					%><tr>
						<td><input type="checkbox" name="ids"
							value="<%=dto.getId()%>"></td>
						<td><%=++searialNumber%></td>
						<td><a href="user.do?operation=get&id=<%=dto.getId()%>"><%=dto.getFirstName()%></a></td>
						<td><%=dto.getLastName()%></td>
						<td><%=dto.getEmailId()%></td>
						<td><%=dto.getPassword()%></td>
						<td><%=dto.getAddress()%></td>
						<td><%=dto.getMobileNumber()%></td>
					</tr>
					<%
						}
					%>

				</table>

				<a class="btn btn-mybutton btn-secondary" role="button"
					href="userList.do?operation=next&pageIndex=<%=pageIndex%>">Next</a>
				<button type="submit" name="operation" value="delete"
					class="btn btn-danger">Delete</button>
				<%
					if (pageIndex > 0) {
				%>
				<a class="btn btn-mybutton btn-secondary" role="button"
					href="userList.do?operation=previous&pageIndex=<%=pageIndex%>">Previous</a>
				<%
					}
				%>

			</div>
		</form>
	</div>
</body>
<jsp:include page="footer.jsp" />
