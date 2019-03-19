<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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



<jsp:include page="_menu.jsp" />

</head>

<body>
<br></br><br/>
<img src="img/error.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236"/>
<br/>
<div class="alert alert-danger">
<h1><strong></>OOPs </strong>Some error occurred..!!!</h1><br/>

<h3>
Please check your last action again.
</h3>
</div>
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	
	
	
</body>
</html>