<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
<head>
<link rel="icon" href="images/logo.jpg">
<title>Signup</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Validation Signup Form Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!-- fonts -->
<link href="//fonts.googleapis.com/css?family=Muli:300,400"
	rel="stylesheet">
<!-- /fonts -->
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type='text/css'
	media="all" />
<link href="css/signup.css" rel="stylesheet" type='text/css' media="all" />
<style type="text/css">
.abcd {
	padding: 10px;
	color: white;
	font-weight: bold;
	font-size: 12px;
	background-color: red;
	text-transform: uppercase;
	text-align: center;
}
</style>
<!-- /css -->
</head>
<body>
	<jsp:include page="loginmenu.jsp"></jsp:include>
	<div class="lift-bottom"></div>
	<h1 class="w3ls">Enter Details to Signup</h1>
	<div class="content-agileits">
		<form action="AddUser" method="post" data-toggle="validator"
			role="form">
			<div style="background-color: olive; color: black;">
				<label>${errorMsg.getErrorMessage()}</label>
			</div>
			<div class="abcd">
				<label>for students enter roll number at user id field</label>
			</div>
			<div class="form-group agileinfo wthree w3-agileits agile">
				<label for="Phone" class="control-label">User Id</label> <input
					name="userId" type="text" class="form-control" id="Phone"
					placeholder="userId" data-error="Enter Your User Id" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group w3layouts w3 w3l">
				<label for="firstname" class="control-label">First Name</label> <input
					type="text" name="firstName" class="form-control" id="firstname"
					placeholder="First Name" data-error="Enter Your First Name"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group agileits w3layouts w3">
				<label for="lastname" class="control-label">Last Name</label> <input
					type="text" name="lastName" class="form-control" id="lastname"
					placeholder="Last Name" data-error="Enter Your Last Name" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group w3l agileinfo wthree w3-agileits">
				<label for="inputEmail" class="control-label">Email</label> <input
					type="email" name="email" class="form-control" id="inputEmail"
					placeholder="Email" data-error="This email address is invalid"
					required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group agileinfo wthree w3-agileits agile">
				<label for="Phone" class="control-label">Phone</label> <input
					type="text" name="phone" class="form-control" id="Phone"
					placeholder="Phone" data-error="Enter Your Phone Number" required>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group agile agileits-w3layouts w3-agile">
				<label for="inputPassword" class="control-label">Password</label>
				<div class="form-inline row">
					<div class="form-group col-sm-6 agileits-w3layouts">
						<input type="password" name="password" data-minlength="6"
							class="form-control" id="inputPassword" placeholder="Password"
							required>
						<div class="help-block">Minimum of 6 characters</div>
					</div>
					<div class="form-group col-sm-6 w3-agile">
						<input type="password" class="form-control"
							id="inputPasswordConfirm" data-match="#inputPassword"
							data-match-error="Whoops, these don't match"
							placeholder="Confirm Password" required>
						<div class="help-block with-errors"></div>
					</div>
				</div>
			</div>
			<div class="form-group agileits w3layouts w3">
				<label for="lastname" class="control-label">User Type</label><span>
					<select name="roleId" class="form-control"
					id="usertype" name="roleId" required="required">
						<option value="">--Select from below--</option>
						<c:forEach items="${roleList}" var="role">
							<option value="${role.getRoleId()}">
								${role.getRoleName()}</option>
						</c:forEach>
				</select>
				</span>
				<div class="help-block with-errors"></div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-lg">Submit</button>
			</div>
		</form>
	</div>
	<!-- js files -->
	<script src="js/jquery-1.10.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/validator.min.js"></script>
	<!-- /js files -->
</body>
</html>
