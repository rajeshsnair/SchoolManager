<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>


<title>SchoolManager</title>
<script src="https://s.codepen.io/assets/libs/modernizr.js"
	type="text/javascript"></script>

<link href="css/bootstrap.min.css" rel="stylesheet" />

<link href="css/search.css" rel="stylesheet" />

<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css" />

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css' />
<link rel='stylesheet prefetch'
	href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css' />

<link href="css/styles.css" rel="stylesheet" />

<jsp:include page="_menu.jsp" />
</head>

<body>
	<div id="wrapper">
		<div class="container-fluid">

		<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">
						<br /> Student List :Standard - LKG 
					</h3>
				</div>
			</div>
	

			<div class="row">

				<div class="col-lg-24 ">

					
<div class="form-group ">
<span class="counter pull-right"></span>
    <input type="text" class="search form-control" placeholder="What you looking for?"/>
</div>
					<div class="table-responsive">
						<table class="table table-bordered table-hover table-striped table-bordered results">
							<thead>
								<tr>
									<th>#</th>
									<th>Admission No</th>
									<th>First Name</th>								
									<th>Last Name</th>
									<th>DOB</th>
									<th>Sex</th>
									<th>Guardian's Name</th>
									<th>Emergency Contact</th>
							
								</tr>
													 <tr class="warning no-result">
      <td colspan="4"><i class="fa fa-warning"></i> No result</td>
    </tr>
							</thead>
							<tbody>
								<c:forEach items="${stdList}" var="std">
									<c:if test="${std.standard=='LKG'}">
										<tr>
											<td><a
												href="${pageContext.request.contextPath}/viewStudent?stdid=${std.std_id}"
												class="glyphicon glyphicon-eye-open" /></td>
											<td>${std.adm_no}</td>
											<td>${std.firstname}</td>
											<td>${std.lastname}</td>											
											<td>${std.dob}</td>	
											<td>${std.sex}</td>	
											<td>${std.guardian_name}</td>	
											<td>${std.contact}</td>	
											
									
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>



			</div>
		</div>

	</div>

	<script src="js/jquery.js"></script>
	<script src="js/search.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.js"></script>

	
	<script src="js/validate.js"></script>
	<script src="js/bootstrapvalidator.js"></script>
	


</body>
</html>