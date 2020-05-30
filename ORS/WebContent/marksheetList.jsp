<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.MarksheetDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="marksheetList.do" method="post">
			<%
				ArrayList list = (ArrayList) request.getAttribute("marksheetList");
				int pageIndex = 0;
				if (request.getAttribute("pageIndex") != null) {
					pageIndex = BaseUtility.toInteger(request.getAttribute("pageIndex"));
				}
				int searialNumber = pageIndex == 0 ? pageIndex : pageIndex * 3;
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

			<h1 align="center">Marksheet List</h1>
			<br>
			<div align="center" class="table-responsive-xl">
				<table class="table">
					<thead class="thead-dark">

						<tr>
							<th><input type="checkbox" onclick="masterCheckox(this)"
								id="ids"></th>
							<th>Serial #</th>
							<th>RollNumber</th>
							<th>Name</th>
							<th>Hindi</th>
							<th>English</th>
							<th>Physics</th>
							<th>Chemistry</th>
							<th>Maths</th>
						</tr>
					</thead>
					<%
						Iterator it = list.iterator();
						while (it.hasNext()) {
							MarksheetDTO dto = (MarksheetDTO) it.next();
					%><tr>
						<td><input type="checkbox" name="ids"
							value="<%=dto.getId()%>"></td>
						<td><%=++searialNumber%></td>
						<td><a href="marksheet.do?operation=get&id=<%=dto.getId()%>"><%=dto.getRollNumber()%></a></td>
						<td><a href="marksheet.do?operation=get&id=<%=dto.getId()%>"><%=dto.getName()%></a></td>
						<td><%=dto.getHindi()%></td>
						<td><%=dto.getEnglish()%></td>
						<td><%=dto.getPhysics()%></td>
						<td><%=dto.getChemistry()%></td>
						<td><%=dto.getMaths()%></td>
					</tr>
					<%
						}
					%>
				</table>

				<a class="btn btn-mybutton btn-secondary" role="button"
					href="marksheetList.do?operation=next&pageIndex=<%=pageIndex%>">Next</a>
				<button type="submit" name="operation" class="btn btn-danger"
					value="delete">Delete</button>
				<%
					if (pageIndex > 0) {
				%>
				<a class="btn btn-mybutton btn-secondary" role="button"
					href="marksheetList.do?operation=previous&pageIndex=<%=pageIndex%>">Previous</a>
				<%
					}
				%>


			</div>
		</form>
	</div>
</body>
<%@ include file="footer.jsp"%>