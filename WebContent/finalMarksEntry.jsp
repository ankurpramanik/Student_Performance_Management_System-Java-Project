<%@page import="com.performance.dao.StudentDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Enter Marks</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" type="text/css" href="css/marksEntry.css">
<link rel="stylesheet" type="text/css" href="css/finalmarks.css">

</head>
<body
	style="background: url('images/bg1.jpg'); background-attachment: fixed;">
	<jsp:include page="menuHome.jsp"></jsp:include>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!--here i will display the employee list-->
	<div style="overflow: auto; text-align: center;">
		<div style="height: 445px;">
			<form action="AddFinalMarks">
				<div class="subject">
					<label style="color: white; font-weight: bold;">Select
						Subject:</label> <select required="required" class="mark"
						name="subjectCode">
						<option value="">--Select From Below--</option>
						<c:forEach items="${subjectList}" var="subject">
							<option value="${subject.getSubjectCode()}">${subject.getSubjectName()}(${subject.getSubjectCode()})</option>
						</c:forEach>
					</select>
				</div>
				<table class="tab1">
					<thead>
						<tr>
							<th>Roll Number</th>
							<th>Name</th>
							<th>Semester</th>
							<th>Points Got</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${studentsList}" var="studentDto">
							<tr>
								<td><input type="text"
									value="${studentDto.getRollNumber()}" readonly class="mark"
									name="rollNumber"></td>
								<td>${studentDto.getFirstName()}
									${studentDto.getLastName()}</td>
								<td><input type="number" name="sem" class="mark"
									value="${studentDto.getSem()}" readonly></td>
								<td><input type="number" placeholder="Points Got"
									class="mark" name="pointsGot" required="required"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="submit" value="Save" class="button2">
			</form>
		</div>
	</div>
</body>