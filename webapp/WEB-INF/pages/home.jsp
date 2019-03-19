<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<title>SchoolManager</title>





<jsp:include page="_menu.jsp" />

</head>

<body>
<br/><br/><br/>
<div class="row">
	<div class="col-lg-6 text-info text-center">
<h3> Total Students : ${dbForm.total_students}</h3>

<h3> No of Students Already Paid for  ${dbForm.curr_month} : <a href="${pageContext.request.contextPath}/viewPaidFees">${dbForm.paid_curr_month}</a></h3>

<h3> No of Students Remaining for  ${dbForm.curr_month} :<a href="${pageContext.request.contextPath}/viewRemFees"> ${dbForm.rem_curr_month}</a></h3>
</div>
<div class="col-lg-6">
<div class="row">
	<div class="col-lg-3"><h4>Standard</h4></div>
		<div class="col-lg-3"><h4>Total Students</h4	></div>
</div>

<div class="row">
	<div class="col-lg-3">
<div class="table-responsive">
<table class="table table-bordered table-hover table-striped">


	<c:forEach items="${dbForm.standards}" var="std">
<tr><th>
 <c:set var = "string1" value = "${std}"/>
<a href="${pageContext.request.contextPath}/${fn:toLowerCase(string1)}List">
	${std}
	</a>
	</th>
	</tr>	
			
	</c:forEach>
</table>
</div>
</div>


	<div class="col-lg-3">
<div class="table-responsive">
<table class="table table-bordered table-hover table-striped">

		<c:forEach items="${dbForm.standard_students}" var="std_stud">
	<tr><td>
	
		${std_stud}
		</td></tr>

		</c:forEach>
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