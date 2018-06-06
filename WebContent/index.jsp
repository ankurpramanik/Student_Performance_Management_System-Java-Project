<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="icon" href="images/logo.jpg">
<title>PCMT</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Inspire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript">
	function showSignup() {

		window.location = "ShowSignUpPage";

	}
	function showLogin() {
		window.location = "ShowLoginPage";

	}
</script>
<!-- css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/popup-box.css" rel="stylesheet" type="text/css"
	media="all" />

<link rel="stylesheet" href="css/index.css" type="text/css" media="all" />
<link rel="stylesheet" href="css/chocolat.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/brand.css" type="text/css" media="all" />

<!--// css -->
<!-- font -->
<link
	href='//fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- //font -->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<!-- Popup-Box-JavaScript -->
<script src="js/modernizr.custom.97074.js"></script>
<script src="js/jquery.chocolat.js"></script>
<script type="text/javascript">
	$(function() {
		$('.gallery-grids a').Chocolat();
	});
</script>
<!-- //Popup-Box-JavaScript -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- //start-smoth-scrolling -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
	$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		 */

		$().UItoTop({
			easingType : 'easeOutQuart'
		});

	});
</script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});

	});
</script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="w3l_header_left">
				<ul>
					<li><span class="glyphicon glyphicon-earphone"
						aria-hidden="true"></span>+91(0)33 2497 8238</li>
					<li><span class="glyphicon glyphicon-envelope"
						aria-hidden="true"></span><a href="frontoffice@pcmt-india.net">frontoffice@pcmt-india.net</a></li>
				</ul>
			</div>

			<div class="w3l_header_right">
				<ul>
					<li><a class="" data-wow-delay="" href="#"
						onclick="showLogin()"><span class="glyphicon glyphicon-user"
							aria-hidden="true"></span>Sign In</a></li>
					<li><a class="" data-wow-delay="" href="#"
						onclick="showSignup()"><span class="glyphicon glyphicon-user"
							aria-hidden="true"></span>Sign Up</a></li>
				</ul>
			</div>

			<div class="clearfix"></div>

		</div>
	</div>
	<div class="logo-navigation-w3layouts">
		<div class="container">
			<div class="logo-w3">
				<a href="#"><h1>
						<img src="images/logo.jpg" alt=" " /><span></span>
					</h1></a>
			</div>
			<div class="navigation agileits w3layouts">
				<nav class="navbar agileits w3layouts navbar-default">
					<div class="navbar-header agileits w3layouts">
						<button type="button"
							class="navbar-toggle agileits w3layouts collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false">
							<span class="sr-only agileits w3layouts">Toggle navigation</span>
							<span class="icon-bar agileits w3layouts"></span> <span
								class="icon-bar agileits w3layouts"></span> <span
								class="icon-bar agileits w3layouts"></span>
						</button>
					</div>
					<div
						class="navbar-collapse agileits w3layouts collapse hover-effect"
						id="navbar">
						<ul class="agileits w3layouts">
							<li class="agileits w3layouts"><a href="#" class="active">Home</a></li>
							<li class="agileits w3layouts"><a class="scroll"
								href="#about">About</a></li>
							<li class="agileits w3layouts"><a class="scroll"
								href="#services">Services</a></li>
							<li class="agileits w3layouts"><a class="scroll"
								href="#contact">Contact</a></li>
						</ul>
					</div>
				</nav>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="banner">
		<h3>College of Engineering</h3>
		<h2>
			<span>Pailan College of Management & Technology </span>
		</h2>
		<div class="arrow">
			<a href="#contact" class="scroll"><img src="images/arrow.png"
				alt=" " /></a>
		</div>
	</div>
	<!-- about -->
	<div class="about-w3-agile" id="about">
		<div class="container">
			<div class="wthree_about_grids">
				<div class="col-md-6 wthree_about_grid_left">
					<h3>About us</h3>
					<p>All of our members have fifteen years of experience and we
						are providing best education to our students. We provide hostel
						facility, transport facility, scholarship, and of course 100%
						placement. Most of our students are setteled in USA, UK, Japan,
						Australia etc. country</p>
					<a href="#" data-toggle="modal" data-target="#myModal">Read
						More</a>
				</div>
				<div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">About</h4>
							</div>
							<div class="modal-body">
								<p>The Pailan College Of Management & Technology is the
									first successful venture of the Pailan Group. Since its
									inception in it has grown in leaps and bounds and established
									itself as the best institute in Eastern India in the field of
									Engineering and Management. The Institute has produced some of
									the best brains who have done substantial work in the form of
									innovative projects leading to filing patents and research
									papers in Indian and International journals.The wi-fi enabled
									campuses house a large auditorium, a cafeteria, a parking lot
									and a playground, thus rendering it self-sufficient in every
									respect. Some of the well known business organisations,
									hospitals, shopping malls, eateries and theatres are located in
									the vicinity, thus making the campus easily accessible and well
									connected to the city. The group also operates its own bus
									services which can be availed by students, faculty and Staff.
									Hostel facilities are also available within and outside the
									campus area. Last but not the least; the campuses have their
									own psychiatrist/Counsellor, an in-house physician and an
									ambulance to tackle emergencies/casualties..</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>

				<div class="col-md-6 wthree_about_grid_right">
					<img src="images/11.jpg" alt=" " class="img-responsive" />
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //about -->
	<!-- team -->
	<!-- //team -->
	<div class="services" id="services">
		<div class="container">
			<h3>Our services</h3>
			<div class="col-md-4 services-grids services-grids1">
				<span class="glyphicon glyphicon-education" aria-hidden="true"></span>
				<h4>Scholarship</h4>
				<p>We provide scholarship for our student. So that they learn
					smoothly.</p>
			</div>
			<div class="col-md-4 services-grids services-grids2">
				<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
				<h4>Placement</h4>
				<p>We provide 100% placement. All of our ex-students are working
					for MNCs.</p>
			</div>
			<div class="col-md-4 services-grids services-grids3">
				<span class="glyphicon glyphicon-book" aria-hidden="true"></span>
				<h4>Best Education</h4>
				<p>We provide best education to our students very carefully.</p>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="contact-w3-agileits" id="contact">
		<div class="container">
			<div class="col-md-5 contact-left-w3ls">
				<h3>Contact info</h3>
				<div class="visit">
					<div class="col-md-2 contact-icon-wthree">
						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					</div>
					<div class="col-md-10 contact-text-agileinf0">
						<h4>Visit us</h4>
						<h5>Bengal Pailan Park, Sector-1 Phase-1 Amgachia Road, Joka,
							Kolkata-104</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="mail">
					<div class="col-md-2 contact-icon-wthree">
						<span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
					</div>
					<div class="col-md-10 contact-text-agileinf0">
						<h4>Mail us</h4>
						<h5>
							<a href="mailto:info@example.com">frontoffice@pcmt-india.net</a>
							<a href="mailto:info@example.com">admission@pcmt-india.net</a>
						</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="call">
					<div class="col-md-2 contact-icon-wthree">
						<span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
					</div>
					<div class="col-md-10 contact-text-agileinf0">
						<h4>Call us</h4>
						<h5>+91(0)3324978238</h5>
						<h5>+919830800310</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="visit">
					<div class="col-md-2 contact-icon-wthree">
						<span class="glyphicon glyphicon-time" aria-hidden="true"></span>
					</div>
					<div class="col-md-10 contact-text-agileinf0">
						<h4>Work hours</h4>
						<h5>Mon-Sat 10:00 AM - 05:00PM</h5>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-md-7 contact-right-w3l">
				<h3>Leave message</h3>
				<form action="SendMail" method="post">
					<input type="text" class="name" name="firstName"
						placeholder="First Name" required=""> <input type="text"
						class="name" name="lastName" placeholder="Last Name" required="">
					<input type="text" class="name" name="email" placeholder="Email"
						required=""> <input type="text" class="name"
						name="subject" placeholder="Subject">
					<textarea name="messege" placeholder="Your Message" required=""></textarea>
					<input type="submit" value="SEND MESSAGE">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="footer-w3l">
		<p>
			&copy; PCMT . All Rights Reserved | Design by <a
				href="http://pcmt-india.net">PCMT</a>
		</p>
	</div>
</body>
</html>