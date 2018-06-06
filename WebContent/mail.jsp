<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Mail</title>
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
	function deleteMail(slNo) {
		var r = confirm("Are you sure to delete?");
		if (r == true) {

			window.location = "DeleteMail?slNo="+slNo;
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
		<div style="height: 300px;">
			<form action="">
				<table
					style="color: #fff; border-spacing: 50px; border-collapse: separate;">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Subject</th>
							<th></th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${mailList}" var="emailDto">
							<tr>
								<td>${emailDto.getFirstName()} ${emailDto.getLastName()}</td>
								<td>${emailDto.getEmail()}</td>
								<td>${emailDto.getSubject()}</td>
								<td><textarea style="height: 70px; width: 350px;"
										disabled="disabled">${emailDto.getMessege()}</textarea></td>
								<td><input type="button" value="Delete" class="button2"
									onclick="deleteMail(${emailDto.getSlNo()})"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>