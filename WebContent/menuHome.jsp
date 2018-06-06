<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="font-family: 'Raleway', sans-serif;">
<head>
<head>
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
<!--//meta tags ends here-->
<!--booststrap-->
<link href="css/bootstrapmenu.css" rel="stylesheet" type="text/css">
<!--//booststrap end-->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- menu -->
<!-- <link type="text/css" rel="stylesheet" href="css/cm-overlay.css" /> -->
<!-- //menu -->
<link href="css/jquery.fatNav.css" rel="stylesheet" type="text/css">

<!--stylesheets-->
<link href="css/menuHome.css" rel='stylesheet' type='text/css'
	media="all">
<link rel="stylesheet" href="css/owl.carousel.css" type="text/css"
	media="all">
<link rel="stylesheet" href="css/lightbox.css">
<link rel="stylesheet" href="css/chocolathome.css" media="all">
<!--//style sheet end here-->
<link
	href="//fonts.googleapis.com/css?family=Raleway:300,400,500,600,700"
	rel="stylesheet">
</head>

</head>
<body>
	<div class="agileits_main jarallax">
		<div class="container-fluid">
			<div class="w3ls-header">
				<div class="w3layouts-header-top">
					<div class="w3-header-top-grids">
						<div class="w3-header-top-left">
							<div class="agileinfo-social-grids">
								<ul>
									<li><a href="#"><span class="fa fa-facebook"></span></a></li>
									<li><a href="#"><span class="fa fa-twitter"></span></a></li>
									<li><a href="#"><span class="fa fa-rss"></span></a></li>
									<li><a href="#"><span class="fa fa-vk"></span></a></li>
								</ul>
							</div>
						</div>
						<div class="w3-header-top-right">

							<div class="w3-header-top-right-text">
								<p>
									<span class="fa fa-home" aria-hidden="true"></span> Bengal
									Pailan Park, Joka,Kolkata-104
								</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="w3-agile-logo">
					<div class="head-wl">
						<div class="email">
							<p>
								<span class="fa fa-envelope" aria-hidden="true"></span> <a
									href="frontoffice@pcmt-india.net" class="info">frontoffice@pcmt-india.net</a>
							</p>

						</div>
						<div class="headder-w3">
							<h1>
								<a>PCMT</a>
							</h1>
						</div>
						<div class="tele">
							<p>
								<span class="fa fa-phone" aria-hidden="true"></span>
								+919830800310
							</p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<div class="w3layouts-nav-right">
					<div class="fat-nav">
						<div class="fat-nav__wrapper">
							<ul style="margin-bottom: auto;">
								<c:forEach items="${menuList}" var="menuList">
									<li style="font-size:20px; margin-bottom: auto;"><a
										href="<c:out value="${menuList.getMenuUrl()}"></c:out>"><c:out
												value="${menuList.getMenuName()}"></c:out></a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<script type='text/javascript' src='js/jquery-2.2.3.min.js'></script>
	<!-- //js -->

	<!--menu script-->
	<script type="text/javascript" src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!--navbar script-->
	<script src="js/jquery.fatNav.js"></script>
	<script>
		(function() {

			$.fatNav();

		}());
	</script>
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

</body>
</html>