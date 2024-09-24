<html>
<head>

<%@include file="./base.jsp" %>
	<%@ page isELIgnored ="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container mt-3">
	<div class="row">
		<div class="col-md-12">
		<h1 class="text-center mb-3">Welcome to Product app</h1>
		
		<table class="table">
  <thead class="thead-dark">
    <tr>
   
      <th scope="col">Id</th>
      <th scope="col">Product Name</th>
      <th scope="col">Product Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <!-- get here data one by one product which pass in addattribute in contoller  -->
  <c:forEach items="${products }" var="p">
  
    <tr>
      <th scope="row">${p.pid }</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td class="font-weight-bold">&#x20b9 ${p.price }</td>
      <td>
      <a href="delete/${p.pid }"><i class=" fas fa-trash text-danger" style="font-size: 20px;"></i></a>
      <a href="update/${p.pid }"><i class="fas fa-pen-nib text-primary" style="font-size: 20px;"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
		
		<div class="container text-center">
		<!--pass url in href  -->
		<a href="add-product" class="btn btn-outline-success">Add Product</a>
		
		</div>
		
		</div>
		
		
		</div>




</div>
</body>
</html>
