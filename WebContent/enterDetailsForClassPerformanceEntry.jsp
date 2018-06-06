<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML>
<html lang="en">
<head>
<link rel="icon" href="images/logo.jpg">
<title>Enter Details</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Online Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/marksClassEntry.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!-- online-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Dosis:200,300,400,500,600,700,800&amp;subset=latin-ext"
	rel="stylesheet">
<!-- //online-fonts -->
</head>
<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<!-- main -->
	<div class="center-container">
		<!--header-->
		<div class="header-w3l">
			<h1>Enter Details</h1>
		</div>
		<!--//header-->
		<div class="main-content-agile">
			<div class="sub-main-w3">
				<div class="wthree-pro">
					<h2 style="background-color: red;">${errorMsg.getErrorMessage()}</h2>
				</div>
				<form action="ShowMarksEntryForm" method="post">
					<div class="pom-agile">
						<select name="sem" required="required">
							<option value="">--Select semester--</option>
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
					<div style="padding-top: 10px;"></div>
					<div class="pom-agile">
						<select name="departmentId" required="required">
							<option value="">--Select Department--</option>
							<c:forEach items="${departmentList}" var="department">
								<option value="${department.getDepartmentId()}">
									${department.getDepartmentName()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="sub-w3l">
						<div class="right-w3l">
							<input type="submit" value="GO">
						</div>
					</div>
				</form>
			</div>
		</div>
		<!--//main-->
		<!--footer-->
		<!-- <div class="footer">
			
		</div> -->
		<!--//footer-->
	</div>
</body>
</html>