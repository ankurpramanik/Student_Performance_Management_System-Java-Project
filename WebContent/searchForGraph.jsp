<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Search Student</title>
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
	<form id="takeRoll" action="ShowProgressGraph">
		<label class="alert-danger"
			style="letter-spacing: 0px !important; text-transform: capitalize; color: #fff; text-align: left;">
			${errorMsg.getErrorMessage()} </label><br> <span
			class="w3ls-text w3ls-name"> <input style="width: 300px"
			type="text" name="rollNumber" placeholder="Enter roll number"
			required="" />
			<button
				style="border-radius: 5px; font-size: 18px; height: 40px; background-color: #9e1d20;; border: 1px solid #ffff; color: white;">Search</button>
		</span>
	</form>

</body>

</html>