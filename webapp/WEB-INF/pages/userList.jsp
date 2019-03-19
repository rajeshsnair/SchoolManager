<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>


<title>School Manager</title>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />
<jsp:include page="_menu.jsp" />
</head>

<body>

	<div id="wrapper">


		<div class="container-fluid">

			<br />
			<!-- Page Heading -->
			<div class="row">
		
				<div class="col-lg-12">
				<br></br>	<h3>User List</h3>
								<div class="table-responsive">
									<table class="table table-bordered table-hover table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th>User Name</th>
												<security:authorize access="hasRole('Admin')">
												<th>Password</th>
												</security:authorize>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Email</th>
												<th>Designation</th>
												<th>Phone</th>
												<th>Role</th>
												<security:authorize access="hasRole('Admin')">
													<th></th>
												</security:authorize>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${accountList}" var="user">

												<tr>
													<td></td>
													<td>${user.userName}</td>
												<security:authorize access="hasRole('Admin')">
													<td>${user.password}</td>
														</security:authorize>
													<td>${user.firstName}</td>
													<td>${user.lastName}</td>
													<td>${user.email}</td>
													<td>${user.designation}</td>
													<td>${user.phone}</td>
													<td>${user.role}</td>

													<security:authorize access="hasRole('Admin')">
														<td><a
															href="${pageContext.request.contextPath}/deleteUser?userid=${user.userId}"
															class="glyphicon glyphicon-trash confirm-delete" /></td>
													</security:authorize>
												</tr>

											</c:forEach>
										</tbody>
									</table>
								</div>
				</div>

			</div>

		</div>

	</div>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>