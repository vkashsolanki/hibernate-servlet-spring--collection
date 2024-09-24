<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
</head>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h1 class="text-center mb-3"> Fill the Flower details</h1>
				<form action="handle-flower" method="post">
					<div class="form-group">
						<label for="name">Flower Name</label>
						 <input type="text" name="flowerTreeName" placeholder="Enter the Flower Name here"
						 id="flowerTreeName" aria-describedbby ="emailHelp">
							</div>
						<div class="form-group">
						<label for="description">Flower Description</label>	
							<textarea rows="5" class="form-control" name="flowerTreeDescription" 
							id="flowerTreeDescription" placeholder="Enter the FlowerTree For description">
							</textarea>
						</div>
						
						<div class="form-group">
						<label for="price">Flower Price</label>
						<input type="text" name="flowerTreePrice" placeholder="Enter the flowerTree price"
						id="flowerTreePrice" class="form-control" >
						</div>
						
						<div class="container text-center">
						<a href="${pageContext.request.contextPath }/"
						class="btn btn-outline-danger">Back</a>
						
						<button type="sumbit" class="btn btn-primary">Add</button>
						</div>
						
					</form>
		</div>
		</div>
</div>



</body>
</html>