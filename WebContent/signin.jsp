<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Meta tags -->
<link rel="icon" href="images/logo.jpg">
<title>Sign in</title>
<meta name="keywords"
	content="Winter Login Form Responsive widget, Flat Web Templates, Android Compatible web template, 
	Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- stylesheets -->
<link rel="stylesheet" href="css/font-awesomeS.css">
<link rel="stylesheet" href="css/signin.css">
<!-- google fonts  -->
<link href="//fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Raleway:400,500,600,700"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="loginmenu.jsp"></jsp:include>
	<div style="padding: 30px"></div>
	<div class="agile-login">
		<div class="wrapper">
			<h2>Sign In</h2>
			<label class="alert-danger"
				style="letter-spacing: 0px !important; text-transform: capitalize; text-align: left;">${errorMsg.getErrorMessage()}</label>
			<div class="w3ls-form">
				<form action="Login" method="post">
					<label></label> <input type="text" name="userId"
						placeholder="User Id" required /> <label></label> <input
						type="password" name="password" placeholder="Password" required />
					<a href="#" class="pass"></a> <input type="submit" value="Log In" />
				</form>
			</div>

			<div class="agile-icons">
				<a href="#"><span class="fa fa-twitter" aria-hidden="true"></span></a>
				<a href="#"><span class="fa fa-facebook"></span></a> <a href="#"><span
					class="fa fa-pinterest-p"></span></a>
			</div>
			<label style="padding: 10px; font-size: 12px; background-color: red;">For
				a student Roll number is acted as User Id</label>
		</div>
		<br>
		<div class="copyright"></div>
	</div>

</body>
</html>