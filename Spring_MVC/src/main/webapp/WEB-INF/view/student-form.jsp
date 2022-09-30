<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Save Student details</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<c:if test="${action=='add'}">
			<h3>Add Student Details</h3>
		</c:if>
		<c:if test="${action=='update'}">
			<h3>Update Student Details</h3>
		</c:if>
		<form action="/Spring_MVCLabSolution/student/saveStudent"
			method="post">
			<c:if test="${action=='add'}">
				<input type="hidden" name="id" value="${student.id}">
				<input type="hidden" name="action" value="add">
			</c:if>
			<c:if test="${action=='update'}">
				<input type="hidden" name="action" value="update">
				<input type="hidden" name="id" value="${id}">
			</c:if>
			<div class="form-inline">
				<input type="text" name="name" value="${student.name}"
					placeholder="Student Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="department" value="${student.department}"
					placeholder="Student Department" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
				<input type="text" name="country" value="${student.country}"
					placeholder="Student Country" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>

		<a href="/Spring_MVCLabSolution/student/list">Back to Student List</a>

	</div>
</body>
</html>