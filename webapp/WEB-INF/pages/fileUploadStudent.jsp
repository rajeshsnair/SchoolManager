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
				
					<div class="container">
					<br/><br/><br/><br/>
<h3>Upload Student Details- [excel file 2003/07 format]</h3>
					<form:form role="form" id="fileUpload" action="${pageContext.request.contextPath}/studentUpload"
						method="post" modelAttribute="fileUploadStd" enctype="multipart/form-data" data-toggle="validator">
						<div class="form-inline">
							<br />
							<div class="form-group">
								<form:input name="fileName" type="file" class="form-control"
									path="fileName" required="required"/>
							</div>

							<form:button type="submit" class="btn btn-sm btn-primary"
								>Upload File</form:button>

						</div>
					</form:form>

				</div>
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