<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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

<header style="color: white">

		<nav class="navbar navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="#"> <img
					src=""C:\Users\nadim\Downloads\pexels-pixabay-60597.jpg"" alt="" width="30"
					height="24">
				</a>
			</div>
		</nav>
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
							aria-current="page" href="<%=request.getContextPath()%>/table">Customer</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>


	</header>
	<hr>

	
	<div class="container" style="width: 30%">
	
	<c:if test="${customer==null}">
			<h1>Registration Form</h1>
			<form action="signup" method="post">
	</c:if>
	
	<c:if test="${customer!=null}">
	
	<h1>Edit Form</h1>
	<form action="edit" method="post">
	
	</c:if>

		<div class="col-md-6" hidden>
			<input type="text" value="<c:out value="${customer.sNo }"></c:out>" class="form-control" placeholder="sNo" name="sno"
				aria-label="SNo">
		</div>
		<label for="inputEmail4" class="form-label">Full Name</label>
		<div class="row">
			<div class="col-md-6">
				<input type="text" value="<c:out value="${customer.firstName }"></c:out>" class="form-control" placeholder="First name"
					name="firstName" aria-label="First name" required="required">
			</div>
			<div class="col-md-6">
				<input type="text" value="<c:out value="${customer.lastName }"></c:out>" class="form-control" placeholder="Last name"
					aria-label="Last name" name="lastName" required="required">
			</div>
		</div>

		<div class="row">

			<div class="col-md-6">
				<label for="inputgender" class="form-label">Sex</label> <select
					class="form-select" id="gender" name="gender" value="<c:out value="${customer.sex }"></c:out>"  required="required">
					<option selected>Choose...</option>
					<option value="male">Male</option>
					<option value="Female">Female</option>
					<option value="other">Other</option>
				</select>
			</div>

			<div class="col-md-6">
				<label for="inputDOB" class="form-label">DOB</label> <input
					type="date" class="form-control" placeholder="dd-mm-yy"
					aria-label="Date" name="DOB" value="<c:out value="${customer.DOB }"></c:out>"  required="required">
			</div>

		</div>

		<div class="row">
			<div class="col-12">
				<label for="permanentAddress" class="form-label">PermanentAddress</label>
				<input type="text" class="form-control" id="permanentAddress"
					placeholder="1234 Main St" name="permanentAddress" value="<c:out value="${customer.permanentAddress }"></c:out>" required="required" >
			</div>
			<div class="col-12">
				<label for="inputAddress2" class="form-label">ResidenceAddress</label>
				<input type="text" class="form-control" id="residenceAddress"
					placeholder="Apartment, studio, or floor" name="residenceAddress" value="<c:out value="${customer.residenceAddress }"></c:out>"  required="required">
			</div>

		</div>

		<div class="row">

			<div class="col-md-5">
				<label for="state" class="form-label">State</label> <select
					id="state" class="form-select" name="state" value="<c:out value="${customer.state }"></c:out>" required="required">
					<option selected>Choose...</option>
					<option value="Andhra Pradesh">Andhra Pradesh</option>
					<option value="Telengana">Telangana</option>
					<option value="Karnataka">Karnataka</option>
					<option value="TamilNadu">TamilNadu</option>
					<option value="MahaRastra">Maharashtra</option>
					<option value="MadhyaPradesh">MadyaPradesh</option>
					<option value="Kerala">Kerala</option>
				</select>
			</div>
			<div class="col-md-4">
				<label for="city" class="form-label">City</label> <input type="text"
					class="form-control" id="city" name="city" value="<c:out value="${customer.city }"></c:out>" required="required">
			</div>

			<div class="col-md-3">
				<label for="zipCode" class="form-label">Zip</label> <input
					type="text" class="form-control" id="zipCode" name="zipCode" value="<c:out value="${customer.zipCode }"></c:out>" required="required" >
			</div>

		</div>

		<div class="row">

			<div class="col-md-2">
				<label for="areaCode" class="form-label">AreaCode</label> <input
					type="text" class="form-control" id="areaCode" name="areaCode" value="<c:out value="${customer.areaCode }"></c:out>" required="required">
			</div>

			<div class="col-md-6">
				<label for="mobileNo" class="form-label">MobileNo</label> <input
					type="tel" class="form-control" id="mobileNo" name="mobileNo" value="<c:out value="${customer.mobileNo }"></c:out>" required="required">
			</div>
		</div>

		<div class="row">
			<div class="col-md-10">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email" value="<c:out value="${customer.email}"></c:out>" required="required">
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Check me
						out </label>
				</div>

			</div>

		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">Sign Up</button>

			<button type="reset" class="btn btn-danger">Cancel</button>
		</div>
		
</form>
	</div>
	
</body>
</html>