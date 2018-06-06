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
			<h2 class="sub-head-w3-agileits">Subject Allocation</h2>
			<p>${errorMsg.getErrorMessage()}</p>
			<div class="login-form">
				<form action="SaveSubject" method="post">
					<select required name="subjectCode">
						<option value="">--Select Subject--</option>
						<c:forEach items="${subjectList}" var="subjects">
							<option value="${subjects.getSubjectCode()}">${subjects.getSubjectName()}(${subjects.getSubjectCode()})</option>
						</c:forEach>
					</select> <select required name="teacher">
						<option value="">--Select Faculty--</option>
						<c:forEach items="${facultyList}" var="faculty">
							<option value="${faculty.getUserId()}">${faculty.getFirstName()}
								${faculty.getLastName()}</option>
						</c:forEach>
					</select> <input type="submit" value="Save">
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