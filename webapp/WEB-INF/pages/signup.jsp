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


<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet"/>

<!-- Custom Fonts -->
<link href="css/font-awesome.min.css" rel="stylesheet"
	type="text/css"/>
<jsp:include page="_menu.jsp" />

</head>

<body>

	<div id="wrapper">
	
			<div class="container-fluid">

				<br></br><br></br>
				<!-- Page Heading -->
				<div class="row">
			<div class="col-lg-3">
			</div>

					<div class="col-lg-3">

						<c:url value="/signup" var="signupUrl" />
						<form:form id="signup" role="form" action="${signupUrl}" method="post"
							modelAttribute="signupForm" class="form-horizontal" data-toggle="validator">
							<div class="form-group ">



								<%@ include file="signupForm.jspf"%>
								<br/>
								<p>
									<form:button type="submit" class="btn btn-sm btn-success">Add User</form:button>
								</p>
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
    	<script src="js/validate.js"></script> 
	<script src="js/bootstrapvalidator.js"></script>

</body>