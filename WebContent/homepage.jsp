<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
<link rel="icon" href="images/logo.jpg">
<title>homepage</title>
<!--meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Anchor Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/jquery.fatNav.css" rel="stylesheet" type="text/css">
<link href="css/homepage.css" rel='stylesheet' type='text/css'
	media="all">
<link
	href="//fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
	rel="stylesheet">
</head>
<body>
	<!-- header-->
	<jsp:include page="menuHome.jsp"></jsp:include>
	<!-- banner -->
	<div class="w3_banner" style="background-image: url(images/b1.jpg)">
		<div class="container">
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides callbacks callbacks1" id="slider4">
						<li>
							<div class="banner_text_w3layouts">
								<h3>
									welcome <span
										style="font-weight: bold; text-transform: capitalize!imortant;">
										<c:out value="${user.getFirstName()} ${user.getLastName()}"></c:out>
									</span>
								</h3>
								<p></p>
								<div class="w3-button"></div>
							</div>
						</li>
						<li>
							<div class="banner_text_w3layouts">
								<h3>
									welcome <span
										style="font-weight: bold; text-transform: capitalize!imortant;">
										<c:out value="${user.getFirstName()} ${user.getLastName()}"></c:out>
									</span>
								</h3>
								<p></p>
								<div class="w3-button"></div>
							</div>
						</li>
						<li>
							<div class="banner_text_w3layouts">
								<h3>
									welcome<span
										style="font-weight: bold; text-transform: capitalize!imortant;">
										<c:out value="${user.getFirstName()} ${user.getLastName()}"></c:out>
									</span>
								</h3>
								<p></p>
								<div class="w3-button"></div>
							</div>
						</li>

					</ul>
				</div>

			</div>
		</div>
	</div>
	<!-- //banner -->
	<!-- //header -->
	<!-- about-->

	<!--footer-->
	<div class="footer">
		<div class="container">
			<div class="col-md-6 bottom-head">
				<h2>
					<a href="index.html">PCMT</a>
				</h2>
				<span class="cap">College of Engineering</span>
			</div>
			<div class="col-md-6 copyright">
				<p>
					&copy; 2017 PCMT . All Rights Reserved | Design by <a href="#"
						target="_blank"> PCMT </a>
				</p>
				<div class="icons">
					<ul>
						<li><a href="#"><span class="fa fa-facebook"></span></a></li>
						<li><a href="#"><span class="fa fa-twitter"></span></a></li>
						<li><a href="#"><span class="fa fa-rss"></span></a></li>
						<li><a href="#"><span class="fa fa-vk"></span></a></li>
					</ul>
				</div>
			</div>
			<!-- //Copyright -->
			<div class="clearfix"></div>
		</div>
	</div>
	<!--//footer-->
	<!-- js -->
	<script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
	<!-- //js -->

	<!--menu script-->
	<script type="text/javascript" src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!--navbar script-->
	<script src="js/jquery.fatNav.js"></script>
	<!--banner slider script-->
	<script src="js/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : true,
				nav : true,
				speed : 500,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>

	<!--client carousel -->
	<script src="js/owl.carousel.js"></script>
	<script>
		$(document).ready(function() {
			$("#owl-demo").owlCarousel({
				items : 1,
				itemsDesktop : [ 768, 1 ],
				itemsDesktopSmall : [ 414, 1 ],
				lazyLoad : true,
				autoPlay : true,
				navigation : true,

				navigationText : false,
				pagination : true,

			});

		});
	</script>
	<!-- //carousel -->
	<!-- gallery-pop-up -->
	<script src="js/jquery.chocolat.js"></script>
	<!--light-box-files -->
	<script type="text/javascript">
		$(function() {
			$('.agileinfo_portfolio_grid a').Chocolat();
		});
	</script>
	<!-- //gallery-pop-up -->
	<!-- start-smoth-scrolling -->
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
	<!-- start-smoth-scrolling -->

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
	<!-- //here ends scrolling icon -->
</body>
</html>