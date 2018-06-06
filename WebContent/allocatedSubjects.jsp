<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<link rel="icon" href="images/logo.jpg">
<title>View Allocated Subjects</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style type="text/css">
td {
	padding: 20px;
}

.button2 {
	font-size: 15px;
	appearance: none;
	background-color: #ffff;
	border-radius: 8px;
	border: none;
	transition-duration: 0.7s;
	color: black;
	height: 25px;
	width: 70px;
	border-radius: 15px;
	font-weight: bold;
	cursor: pointer;
}

.button2:hover {
	background-color: #9e1d20;
	color: white;
}
</style>

<script type="text/javascript">
	function deleteAllocatedSubject(subCode, deptId, techerId) {
		var r = confirm("Are you sure to delete?");
		if (r == true) {
			window.location = "DeleteAllocated?subCode=" + subCode + "&deptId="
					+ deptId + "&techerId=" + techerId;
		}

	}
</script>



</head>
<body
	style="background: url('images/registration.jpg'); background-attachment: fixed;">
	<jsp:include page="menuHome.jsp"></jsp:include>
	<script src="js/jquery-3.1.1.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<!--here i will display the employee list-->
	<div style="overflow: auto; text-align: center;">
		<div style="height: 440px;">
			<form action="">
				<table
					style="color: #fff; border-spacing: 50px; border-collapse: separate;">
					<thead>
						<tr>
							<th>Faculty</th>
							<th>Subject</th>
							<th>Department</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${allocatedSubjectList}" var="allocationDto">
							<tr>
								<td>${allocationDto.getFirstName()}
									${allocationDto.getLastName()}</td>
								<td>${allocationDto.getSubjectName()}</td>
								<td>${allocationDto.getDepartmentName()}</td>
								<td></td>
								<td><input type="button" value="Delete" class="button2"
									onclick="deleteAllocatedSubject('${allocationDto.getSubjectCode()}','${allocationDto.getDepartmentId()}','${allocationDto.getTeacherId()}')"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>