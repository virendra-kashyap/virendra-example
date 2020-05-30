<%@page import="com.utility.BaseUtility"%>
<%@page import="com.dto.MarksheetDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />

<body>
	<div class="container-fluid h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">

				<form action="marksheet.do" method="post"
					name="MarksheetRegistrationForm"
					onsubmit="return validateMarksheetRegistrationForm()">

					<%
						if (request.getAttribute("marksheetError") != null) {
					%>
					<h1 align="center" style="color: red"><%=request.getAttribute("marksheetError")%></h1>
					<%
						}
					%>

					<h1 align="center">Marksheet</h1>
					<br>
					<%
						MarksheetDTO marksheetDTO = new MarksheetDTO();
						if (request.getAttribute("marksheetDTO") != null) {
							marksheetDTO = (MarksheetDTO) request.getAttribute("marksheetDTO");
						}
					%>
					<input type="hidden" name="id" value="<%=marksheetDTO.getId()%>">
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Enter RollNubmer" name="rollNumber"
							value="<%=BaseUtility.toEmpty(marksheetDTO.getRollNumber())%>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Enter Name"
							name="name"
							value="<%=BaseUtility.toEmpty(marksheetDTO.getName())%>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Hindi Number"
							name="hindi" value="<%=marksheetDTO.getHindi()%>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="English Number" name="english"
							value="<%=marksheetDTO.getEnglish()%>">
					</div>
					<div class="form-group ">
						<input type="text" class="form-control"
							placeholder="Physics Number" name="physics"
							value="<%=marksheetDTO.getPhysics()%>">
					</div>
					<div class="form-group">
						<input type="text" class="form-control"
							placeholder="Chemistry Number" name="chemistry"
							value="<%=marksheetDTO.getChemistry()%>">
					</div>

					<div class="form-group">
						<input type="text" class="form-control" placeholder="Maths Number"
							name="maths" value="<%=marksheetDTO.getMaths()%>">
					</div>
					<%
						if (marksheetDTO.getId() > 0) {
					%>

					<button type="submit" name="operation" value="update"
						class="btn btn-primary btn-block">Update</button>
					<%
						} else {
					%>
					<button type="submit" name="operation" value="add"
						class="btn btn-primary btn-block">Add</button>
					<%
						}
					%>



				</form>
			</div>
		</div>
	</div>
</body>
<jsp:include page="footer.jsp" />