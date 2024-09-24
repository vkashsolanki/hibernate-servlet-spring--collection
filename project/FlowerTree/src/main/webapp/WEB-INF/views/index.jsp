<html>
<head>

<%@include file="./base.jsp" %>
	<%@ page isELIgnored ="false" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body bgcolor="red">

<div class="container mt-3">
	<div class="row">
		<div class="col-md-12">
		<h1 class="text-center mb-3">Welcome to Flower Tree</h1>
		
		<table class="table">
  <thead class="thead-dark">
    <tr>
   
      <th scope="col">FlowerTree Id</th>
      <th scope="col">FlowerTree Name</th>
      <th scope="col">FlowerTree Description</th>
      <th scope="col">FlowerTree Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
    <!-- get here data one by one product which pass in add attribute in controller  -->
  <c:forEach items="${flowerTrees }" var="p">
  
    <tr>
      <th scope="row">${p.flowerTreeId }</th>
      <td>${p.flowerTreeName }</td>
      <td>${p.flowerTreeDescription }</td>
      <td class="font-weight-bold">&#x20b9 ${p.flowerTreePrice }</td>
      <td>
      <a href="delete/${p.flowerTreeId }"><i class=" fas fa-trash text-danger" style="font-size: 20px;"></i></a>
      <a href="update/${p.flowerTreeId }"><i class="fas fa-pen-nib text-primary" style="font-size: 20px;"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
		
		<div class="container text-center">
		<!--pass url in href  -->
		<a href="add-flower" class="btn btn-outline-success">Add FloweTree</a>
		
		</div>
		
		</div>
		
		
		</div>




</div>
</body>
</html>

