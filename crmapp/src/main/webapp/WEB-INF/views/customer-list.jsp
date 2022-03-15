<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Customer Relationship Management</title>
</head>

<body>
	<div class="container">
		<h3 class="bg-info text-white text-center p-3">Customer Relationship Management</h3>

		<a href="/crmapp/customer/showFormForAdd"
			class="btn btn-secondary btn-sm mt-5">Add Customer</a>

		<table class="table table-bordered table-striped mt-3">
			<thead class="bg-info text-white">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstName}" /></td>
						<td><c:out value="${customer.lastName}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a
							href="/crmapp/customer/showFormForUpdate?customerId=${customer.id}"
							class="btn btn-secondary btn-sm mr-1">Update</a> <a
							href="/crmapp/customer/delete?customerId=${customer.id}"
							class="btn btn-danger btn-sm" onclick="showDeleteConfirmation()">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<script type="text/javascript">
		function showDeleteConfirmation() {
			var isConfirmed = confirm('Are you sure you want to delete this Customer?');
			if (!isConfirmed) {
				return false;
			}
		}
	</script>
</body>
</html>