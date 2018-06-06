<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="images/logo.jpg">
<title>viewResult</title>

<link rel="stylesheet" href="css/viewResult.css" type="text/css">
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<script type="text/javascript">
	function home() {
		window.location = "HomePage";
	}

	function printSem() {
		var printContents = document.getElementById('semResult').innerHTML;
		var originalContents = document.body.innerHTML;
		document.body.innerHTML = printContents;
		window.print();
		document.body.innerHTML = originalContents;
	}
	function printClass() {
		var printContents = document.getElementById('classResult').innerHTML;
		var originalContents = document.body.innerHTML;
		document.body.innerHTML = printContents;
		window.print();
		document.body.innerHTML = originalContents;
	}
</script>
</head>

<body>
	<div class="btn-home">
		<i onclick="home()" class="fas fa-home"></i>
	</div>
	<div class="semesterResult" id="semResult">
		<form>
			<div class="heading">
				<h1>Pailan College of Management & Technology</h1>
				<img src="images/pailan_logo.jpg" class="logo">
				<h3>
					<span>SEMESTER RESULT</span>
				</h3>
			</div>
			<div class="tab">
				<table width="800" border="" class="table1">
					<tbody>
						<tr>
							<td width="500px"><span>Name: </span>${studentDto.getFirstName()}
								${studentDto.getLastName()}</td>
							<td><span>Semester:</span> ${semester}</td>
						</tr>
						<tr>
							<td colspan="2"><span>Roll Number: </span>${studentDto.getRollNumber()}</td>
						</tr>
						<tr>
							<td colspan="2"><span>Department: </span>${studentDto.getDepartmentName()}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="tab1">
				<table width="800" border="1" class="table2">
					<tbody>
						<tr>
							<th width="30px">subject code</th>
							<th>subject name</th>
							<th width="20px">letter grade</th>
							<th width="20px">points</th>
							<th width="20px">credit</th>
							<th width="20px">credit points</th>
						</tr>
						<c:forEach items="${subjectWiseMarkList}" var="mark">
							<tr>
								<td align="left">${mark.getSubjectCode()}</td>
								<td align="left">${mark.getSubjectName()}</td>
								<td align="center">${mark.getLetterGrade()}</td>
								<td align="right">${mark.getPoints()}</td>
								<td align="right">${mark.getSubjectCredit()}</td>
								<td align="right">${mark.getCreditPoints()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="tab1">
				<table width="800" border="1" class="table2">
					<tbody>
						<tr>
							<th colspan="2" width="117px">Total</th>
							<th width="20px" colspan="2">&nbsp;</th>
							<th align="right" width="53px">${total.getTotalCredit()}</th>
							<th align="right" width="53px">${total.getTotalCreditPoints()}</th>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="tab">
				<table width="800" border="1" class="table2">
					<tbody>
						<tr>
							<th colspan="6" align="right"><span>sgpa: </span>${total.getSgpa()}</th>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn">
				<button class="btn-click" onclick="printSem()" id="generateSem">Print</button>
			</div>
		</form>
	</div>

	<div class="classPerformance" id="classResult">
		<div style="padding-top: 100px"></div>
		<form>
			<div class="heading">
				<h1>Pailan College of Management & Technology</h1>
				<img src="images/pailan_logo.jpg" class="logo">
				<h3>
					<span>class performance</span>
				</h3>
			</div>
			<div class="tab">
				<table width="800" border="" class="table1">
					<tbody>
						<tr>
							<td width="500px"><span>Name: </span>${studentDto.getFirstName()}
								${studentDto.getLastName()}</td>
							<td><span>Semester: </span>${semester}</td>
						</tr>
						<tr>
							<td colspan="2"><span>Roll Number: </span>${studentDto.getRollNumber()}</td>
						</tr>
						<tr>
							<td colspan="2"><span>Department: </span>${studentDto.getDepartmentName()}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="tab1">
				<table width="800" border="1" class="table2">
					<tbody>
						<tr>
							<th width="20px">subject code</th>
							<th>subject name</th>
							<th width="20px">1st internal</th>
							<th width="20px">2nd internal</th>
							<th width="20px">class test</th>
							<th width="20px">assign ment</th>
							<th width="20px">mcq marks</th>
							<th width="20px">classes attended</th>
							<th width="20px">total classes</th>
							<th width="20px">Attendence percentage</th>
						</tr>
						<c:forEach items="${internalMarkList}" var="classMarks">
							<tr>
								<td>${classMarks.getSubjectCode()}</td>
								<td>${classMarks.getSubjectName()}</td>
								<td align="right">${classMarks.getInternal1()}</td>
								<td align="right">${classMarks.getInternal2()}</td>
								<td align="right">${classMarks.getClassTest()}</td>
								<td align="right">${classMarks.getAssignment()}</td>
								<td align="right">${classMarks.getMcq()}</td>
								<td align="right">${classMarks.getAttendedClass()}</td>
								<td align="right">${classMarks.getTotalClasses()}</td>
								<td align="right">${classMarks.getAttendence()}</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan="2" align="right">total:</td>
							<td colspan="5">&nbsp;</td>
							<td align="right">${totalAttendedClass}</td>
							<td align="right">${totalClasses}</td>
							<td align="right">${totalAttendencePercentage}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn">
				<button class="btn-click" onclick="printClass()" id="generateClass">Print</button>
			</div>
		</form>
	</div>

</body>
</html>
