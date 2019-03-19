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
				<br/><h3>Mark Payment for below Student</h3>
					<form:form role="form" id="setStudFees" action="${pageContext.request.contextPath}/saveStudFees"
					method="post" modelAttribute="stdFeeForm"
					class="well form-horizontal">
					<div class="table-responsive">
									<table class="table table-bordered table-hover table-striped">
										
										<tbody>
				
											<tr>
												<form:input type="hidden" value="${stdFeeForm.adm_no}" name="adm_no" path="adm_no"/>		
												<form:input type="hidden" value="${stdFeeForm.std_id}" name="std_id" path="std_id"/>		
												
												
												<th>Adm No</th><td>${stdFeeForm.adm_no}</td>
												</tr>
												<tr>
												<th>Name</th><td>${stdFeeForm.firstname} ${stdFeeForm.lastname}</td>
												</tr>
												
												<tr>
												<th>Standard</th><td>${stdFeeForm.standard}</td>
												</tr>
												<tr>
												<th>Monthly Fees</th><td>${stdFeeForm.mnthly_fees}</td>
												</tr>
												<tr>
												<th>Remaining Fees</th><td>${stdFeeForm.rem_fees}</td>
												</tr>
												<tr>
												<th>Last Fee Paid for Month</th><td>${stdFeeForm.last_paid_mnth}</td>
												</tr>
												<tr>
												<th>Last Paid Date</th><td>${stdFeeForm.last_paid_dt}</td>
												</tr>
											
												
													
																								
									<security:authorize access="hasRole('Operator')">	
										<tr>
										<td></td>
									
										<td>
										
											<form:button type="submit"  class="btn btn-lg btn-success">Mark As Paid</form:button>
										
										</td>
										</tr>
										</security:authorize>
										</tbody>
										</table>
										
								
				</div>

						
					</form:form>	
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