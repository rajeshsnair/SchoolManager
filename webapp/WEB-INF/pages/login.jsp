<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
 
<title>School Manager</title>
 <link href="css/bootstrap.min.css" rel="stylesheet"  type="text/css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<style>
body {
    background-image: url("img/login.jpg");
    height: auto;
}
</style>

</head>
<body>




 <div class="header-container">
  
    <div class="site-name"><img src="img/feeman.JPG" class="img-rounded" alt="Cinque Terre" width="80" height="60"/>	Fee Manager </div>
    </div>
 
  
 
   <div class="container">
    <div class="row">
        <div class="col-lg-6 col-md-4 col-md-offset-4">   
       <!-- /login?error=true -->
  
       <br/><br/><br/>  <br/><br/><br/>

    <div class="">
         <c:if test="${param.error == 'true'}">
           <div style="color: red; margin: 10px 0px;">
 
               Login Failed!!!<br /> Reason :
               ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
 
           </div>
       </c:if>
       <form:form method="POST"
           action="${pageContext.request.contextPath}/j_spring_security_check">
           <div class="input-group">
           <table>
               <tr><td><span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span></td>
                   <td><input name="userName" path="userName" class="form-control" placeholder="Enter User Name"/></td>                 
              </tr>
 
               <tr><td><span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span></td>
					<td><input type="password" name="password"  path="password" class="form-control" placeholder="Enter Password"/></td>
               </tr>
 
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" class="btn btn-lg btn-primary btn-block" value="Login" /> </td>
               </tr>
               <tr>
               <td>&nbsp;</td>
               <td>
        <!--        	<div class="text-center">
													<a href="#" tabindex="5" data-toggle="modal"
						data-target="#forgotPassword" class="forgot-password">Forgot Password?</a>
												</div> -->
               </td>
               </tr>
           </table>
             </div>
       </form:form>
       </div>
 
       <span class="error-message">${error }</span>
 
   </div>
 </div>
 </div>
 
   
   <jsp:include page="_footer.jsp" />

 	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.js"></script>
</body>
</html>