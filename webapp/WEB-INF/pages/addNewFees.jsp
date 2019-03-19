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
				</br><h3>Add New Fee Type</h3>

					<fieldset>
						<c:url value="/saveFeeType" var="addfeeUrl" />
						<form:form role="form" id="addfeetype" action="${addfeeUrl}"
							method="post" modelAttribute="feeTypeForm"
							class="well form-horizontal" data-toggle="validator">

							







							<%@ include file="feeTypeForm.jspf"%>





							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-3">
									<form:button type="submit" class="btn btn-lg btn-success">Save</form:button>
								</div>

							</div>


						</form:form>
					</fieldset>

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