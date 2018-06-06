<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Enter Subject</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Curved Contact Form template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs Sign up Web Templates, 
 Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free web designs for Nokia, Samsung, LG, SonyEricsson, Motorola web design">
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/subject.css" rel='stylesheet' type='text/css' />
<!--fonts-->
<link
	href="//fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800"
	rel="stylesheet">
<!--//fonts-->
</head>
<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<!--background-->
	<!-- login -->
	<h1></h1>
	<div class="login-w3l">
		<div class="top-img-agileits-w3layouts">
			<h2 class="sub-head-w3-agileits">Enter Semester</h2>
			<p>${errorMsg.getErrorMessage()}</p>
			<div class="login-form">
				<form action="SubjectAllocation" method="post">
					<select required name="sem">
						<option value="">--Select Semester--</option>
						<option value="1">1st Semester</option>
						<option value="2">2nd Semester</option>
						<option value="3">3rd Semester</option>
						<option value="4">4th Semester</option>
						<option value="5">5th Semester</option>
						<option value="6">6th Semester</option>
						<option value="7">7th Semester</option>
						<option value="8">8th Semester</option>
					</select> <select required name="departmentId">
						<option value="">--Select Department--</option>
						<c:forEach items="${departmentList}" var="department">
							<option value="${department.getDepartmentId()}">
								${department.getDepartmentName()}</option>
						</c:forEach>
					</select> <input type="submit" value="Enter">
				</form>
			</div>
		</div>

		<!-- //login -->
	</div>
	<div class="clear"></div>
	<div class="footer-agileits">
		<p></p>
	</div>
	<!--//login-->
</body>
</html>