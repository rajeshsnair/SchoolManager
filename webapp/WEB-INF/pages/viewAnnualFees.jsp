<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				</br><h3>Annual Fees Structure set by Admin</h3>
					
					<div class="table-responsive">
									<table class="table table-bordered table-hover table-striped">
										<thead>
											<tr>												
												<th>Standard</th>
												<c:forEach items="${feeForm.feeList[0].fee_types}" var="fees_type">												
												<th>
												${fees_type}
												</th>
												</c:forEach>
											</tr>
										</thead>
										<tbody>
				
											<c:forEach items="${feeForm.feeList}" var="fees" varStatus="status">
											<tr>
												<td>${fees.standard}</td>
													<td>
												${fees.annual_fees}
												</td>
													</tr>											
											</c:forEach>
										<tr>
										<td></td>
										<td>
											
										</td>
										</tr>
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