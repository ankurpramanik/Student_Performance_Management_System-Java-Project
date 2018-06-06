<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<link rel="icon" href="images/logo.jpg">
<title>Search Result</title>
<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Core Login Form a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- //Meta-Tags -->
<!-- Index-Page-CSS -->
<link rel="stylesheet" href="css/searchResult.css" type="text/css"
	media="all">
<!-- //Custom-Stylesheet-Links -->
<!--fonts -->
<link
	href="//fonts.googleapis.com/css?family=Mukta+Mahee:200,300,400,500,600,700,800"
	rel="stylesheet">
<!-- //fonts -->
<!-- Font-Awesome-File -->
<link rel="stylesheet" href="css/font-awesome.css" type="text/css"
	media="all">
<style type="text/css">
.errmsg {
	letter-spacing: 1px !important;
	background-color: red;
	text-transform: capitalize;
	border-radius: 10px;
	color: #fff;
	text-align: left;
}
</style>
</head>

<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<h1 class="title-agile text-center"></h1>
	<div class="content-w3ls">
		<div class="agileits-grid">
			<label class="errmsg"> ${errorMsg.getErrorMessage()} </label> <br>
			<div class="content-top-agile">
				<h2>Enter Details</h2>
			</div>
			<div class="content-bottom">
				<form action="ShowResult" method="post">
					<div class="field_w3ls">
						<div class="field-group">
							<input name="rollNumber" id="text1" type="text" value=""
								placeholder="Enter Roll Number" required>
						</div>
						<div class="field-group">
							<select name="semester" id="password-field" class="form-control"
								required>
								<option value="">--Select from below--</option>
								<option value="1">1st Semester</option>
								<option value="2">2nd Semester</option>
								<option value="3">3rd Semester</option>
								<option value="4">4th Semester</option>
								<option value="5">5th Semester</option>
								<option value="6">6th Semester</option>
								<option value="7">7th Semester</option>
								<option value="8">8th Semester</option>
							</select>
						</div>
					</div>
					<div class="wthree-field">
						<input id="saveForm" name="saveForm" type="submit" value="Show" />
					</div>
				</form>
			</div>
			<!-- //content bottom -->
		</div>
	</div>
	<script src="js/jquery-2.2.3.min.js"></script>
</body>
<!-- //Body -->

</html>