<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" style="font-family: 'Raleway', 'sans-serif'">
<head>
<link rel="icon" href="images/logo.jpg">
<title>Enter marks</title>
<!-- Meta tags -->
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Talent Application Form Responsive Widget, Audio and Video players, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- Meta tags -->
<!--stylesheets-->
<link href="css/marksEditClass.css" rel='stylesheet' type='text/css' media="all">
<!--//style sheet end here-->
<!-- Calendar -->
<link rel="stylesheet" href="css/jquery-ui.css" />
<!-- //Calendar -->

<link href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="menuHome.jsp"></jsp:include>
	<div style="padding: 10px;"></div>
	<h1 class="header-w3ls">Enter details</h1>
	<div class="appointment-w3">
		<form action="UpdateMarks" method="post">

			<div class="information">
				<h3>
					<span style="color: aqua; font-weight: bold;">${editMarksDto.getFirstName()}
						${editMarksDto.getLastName()}</span>
				</h3>
				<h3>
					Student of <span style="color: aqua; text-transform: capitalize;">${editMarksDto.getDepartmentName()}</span>
				</h3>
				<div class="form-left-w3l" style="visibility: hidden;">

					<input type="text" name="rollNumber"
						value="${editMarksDto.getRollNumber()}">
				</div>
				<div class="" style="visibility: hidden;">

					<input type="text" name="sem" value="${editMarksDto.getSem()}">
				</div>
				<div class="form-left-w3l" style="visibility: hidden;">

					<input type="text" name="subjectCode"
						value="${editMarksDto.getSubjectCode()}">
				</div>
				<div class="form-left-w3l">
					<p>First Internal</p>
					<input type="text" name="internal1"
						value="${editMarksDto.getInternal1()}"
						placeholder="Enter marks of 1st Internal" required="required">
				</div>
				<div class="form-right-w3ls ">
					<p>Second Internal</p>
					<input type="text" name="internal2"
						value="${editMarksDto.getInternal2()}"
						placeholder="Enter marks of 2nd Internal" required="required">
				</div>
				<div class="form-left-w3l">
					<p>Class Test</p>
					<input type="text" name="classTest"
						value="${editMarksDto.getClassTest()}"
						placeholder="Enter marks of Class test" required="required">
				</div>
				<div class="form-right-w3ls ">
					<p>Assignment</p>
					<input type="text" name="assignment"
						value="${editMarksDto.getAssignment()}"
						placeholder="Enter marks of Assignment" required="required">
				</div>
				<div class="form-left-w3l">
					<p>Multiple choice</p>
					<input type="text" name="mcq"
						value="${editMarksDto.getMcq()}"
						placeholder="Enter marks of MCQ" required="required">
				</div>
				<div class="clear"></div>
				<div class="form-left-w3l">
					<p>Classes Attended</p>
					<input type="text" name="classAttended"
						value="${editMarksDto.getAttendedClass()}"
						placeholder="Number of Classes Attended" required="required">
				</div>
				<div class="form-right-w3ls">
					<p>Out of Classes</p>
					<input type="text" name="totalClasses"
						value="${editMarksDto.getTotalClass()}"
						placeholder="Total Number of Classes" required="required">
				</div>
				<div class="clear"></div>
			</div>
			<input type="submit" value="Submit">
		</form>
	</div>

	<div class="copy"></div>
	<!-- js -->
	<script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
	<!-- //js -->
	<!-- Calendar -->

	<script src="js/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker,#datepicker1,#datepicker2,#datepicker3")
					.datepicker();
		});
	</script>
	<!-- //Calendar -->
</body>
</html>