<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<title>Shopping Cart Application</title>
</head>
<body>
	<div class="py-2 text-center text-white bg-dark ">Shopping
		Cart Application</div>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="text-center text-danger">Cart Item Details</div>
			</div>
		</div>
		<div class="row mt-2">
			<div class="col col-md-8 offset-md-2">

				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Price</th>
						
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cartdetails.products}" var="product">
							<tr>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.price}</td>
								
							</tr>
						
						</c:forEach>
						<tr class="bg-success">
							<td colspan="2">Total Price</td>
							<td>${cartdetails.totalPrice}</td>						
						</tr>
						<tr>
							<td colspan="2"></td>
							<td><a href="" class="btn btn-info">Checkout</a></td>
						</tr>
					</tbody>
				</table>
				<a href="home">Add More Items</a>
			</div>
		</div>

	</div>

	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    -->
</body>
</html>