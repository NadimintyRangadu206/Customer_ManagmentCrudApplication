<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.customermanagment.model.CustomerInfo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>
	<a></a>
	<header style="color: white">

		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Customer Managment</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="table">Customer</a></li>
					</ul>
				</div>
			</div>


		</nav>



	</header>
	</br>
	</br>
	<div class="container">

		<h2 align="center">Customer List</h2>
		<hr>
		<form action="addcustomer" method="post">
			<button type="submit" class="btn btn-success">Add Customer</button>
		</form>

		<table class="table table-bordered border-primary table caption-top">
			<caption>List of users</caption>
			<thead>
				<tr>
					<th scope="col">SNo</th>
					<th scope="col">FirstName</th>
					<th scope="col">LastName</th>
					<th scope="col">Sex</th>
					<th scope="col">DOB</th>
					<th scope="col">PermanentAddress</th>
					<th scope="col">ResidenceAddress</th>
					<th scope="col">State</th>
					<th scope="col">City</th>
					<th scope="col">ZipCode</th>
					<th scope="col">AreaCode</th>
					<th scope="col">MobileNo</th>
					<th scope="col">Email</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="customer" items="${CustomerDetails}">
					<tr class="table-active">
						<td><c:out value="${customer.sNo}"></c:out></td>
						<td><c:out value="${customer.firstName}"></c:out></td>
						<td><c:out value="${customer.lastName}"></c:out></td>
						<td><c:out value="${customer.sex}"></c:out></td>
						<td><c:out value="${customer.DOB}"></c:out></td>
						<td><c:out value="${customer.permanentAddress}"></c:out></td>
						<td><c:out value="${customer.residenceAddress}"></c:out></td>
						<td><c:out value="${customer.state}"></c:out></td>
						<td><c:out value="${customer.city}"></c:out></td>
						<td><c:out value="${customer.zipCode}"></c:out></td>
						<td><c:out value="${customer.areaCode}"></c:out></td>
						<td><c:out value="${customer.mobileNo}"></c:out></td>
						<td><c:out value="${customer.email}"></c:out></td>


						<!--Query String  -->
						<td><a
							href="editform?sno=<c:out value="${customer.sNo}"></c:out>">Edit</a>&nbsp;&nbsp;<a
							href="deleteform?sno=<c:out value="${customer.sNo }"></c:out>">Delete</a></td>

					</tr>

				</c:forEach>


			</tbody>

		</table>

		<nav aria-label="Page navigation example">
			<ul class="pagination">
			<c:if test="${pageNo==-1}">
				<li class="page-item"><a class="page-link" href="table?pageNo">Previous</a></li>
				</c:if>
					<c:if test="${pageNo==1}">
				<li class="page-item"><a class="page-link" href="table?pageNo">1</a></li></c:if>
				
				<c:if test="${pageNo==2}">
				<li class="page-item"><a class="page-link" href="table?pageNo">2</a></li></c:if>
				
					<c:if test="${pageNo==3}">
				<li class="page-item"><a class="page-link" href="table?pageNo">3</a></li></c:if>
				
				<li class="page-item"><a class="page-link" href="table?pageNo">Next</a></li>
			</ul>
		</nav>
	</div>
</body>
</html>