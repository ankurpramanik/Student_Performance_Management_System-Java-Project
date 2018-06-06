<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Edit Details</title>
<!-- metatags-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="effective application form a Flat Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Meta tag Keywords -->
<link href="css/registrationPage.css" rel="stylesheet" type="text/css"
	media="all" />
<!--style_sheet-->
<link href="//fonts.googleapis.com/css?family=Quicksand"
	rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<!--online_fonts-->
<link href="//fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<!--online_fonts-->
</head>
<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<form id="takeRoll" action="ShowEditStudentPage" style="align-content: center;">
		<label class="alert-danger"
			style="letter-spacing: 0px !important; text-transform: capitalize; color: #fff; text-align: left;">
			${errorMsg.getErrorMessage()} </label><br> <span
			class="w3ls-text w3ls-name"> <select name="department"
			style="width: 400px;" required="required">
				<option value="">--Select Department From Below--</option>
				<c:forEach items="${departmentList}" var="department">
					<option value="${department.getDepartmentId()}">
						${department.getDepartmentName()}</option>
				</c:forEach>

		</select> <select name="sem" required="required" style="width: 400px;">
				<option value="">--Select Semester from below--</option>
				<option value="1">1st Semester</option>
				<option value="2">2nd Semester</option>
				<option value="3">3rd Semester</option>
				<option value="4">4th Semester</option>
				<option value="5">5th Semester</option>
				<option value="6">6th Semester</option>
				<option value="7">7th Semester</option>
				<option value="8">8th Semester</option>
		</select>
			<input
				style="border-radius: 5px; font-size: 18px; height: 40px; background-color: #9e1d20;; border: 1px solid #ffff; color: white;"
				type="submit" value="Search">
		</span>
	</form>

</body>

</html>