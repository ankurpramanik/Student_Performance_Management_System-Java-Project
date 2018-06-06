<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Approve Users</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<style type="text/css">
td {
	padding: 20px;
}

.button1, .button2 {
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

.button1:hover {
	background-color: #008CBA;
	color: white;
}

.button2:hover {
	background-color: #9e1d20;
	color: white;
}
</style>

<script type="text/javascript">
	function acceptUser(userId) {
		window.location = "AcceptUser?userId=" + userId;
	}

	function refuseUser(userId) {
		var r = confirm("Are you sure to refuse?");
		if (r == true) {

			window.location = "RefuseUser?userId=" + userId;
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
							<th>User Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Role</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${userList}" var="userDto">
							<tr>
								<td>${userDto.getUserId()}</td>
								<td>${userDto.getFirstName()}</td>
								<td>${userDto.getLastName()}</td>
								<td>${userDto.getEmail()}</td>
								<td>${userDto.getPhone()}</td>
								<td>${userDto.getRoleName()}</td>
								<td><input type="button" value="Accept" class="button1"
									onclick="acceptUser('${userDto.getUserId()}')"> <input
									type="button" value="Refuse" class="button2"
									onclick="refuseUser('${userDto.getUserId()}')"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>