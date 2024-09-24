<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	
<body>

	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Mobile</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${allUsers}" var="user">
					<tr>
						<td scope="row">${user.getName() }</td>
						<td scope="row">${user.getEmail() }</td>
						<td scope="row">${user.getMobile() }</td>
						<td><a href="<c:url value='/employee/edit/${employee.employeeId}' />" >Edit</a></td>
						<td><a href="<c:url value='user/remove/${employee.employeeId}' />" >Delete</a></td>
					</tr>
				</c:forEach>
					
					
				</tbody>
			</table>
		</div>
	</div>

</body>
	
</body>
</html>