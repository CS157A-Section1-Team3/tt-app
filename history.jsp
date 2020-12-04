<!DOCTYPE html>
<%@ page import="java.sql.*"%>
<html lang="en">
<head>
	<title>Contact V6</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main1.css">
<!--===============================================================================================-->
</head>
<body>


	<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>

		<button class="contact100-btn-show">
			<i class="fa fa-envelope-o" aria-hidden="true"></i>
		</button>

		<div class="wrap-contact100">
			<button class="contact100-btn-hide">
				<i class="fa fa-close" aria-hidden="true"></i>
			</button>

			<form class="contact100-form validate-form">
				<span class="contact100-form-title">
					Time Tracking History
				</span>

				<div class="wrap-input100 rs1-wrap-input100 validate-input" data-validate="Begin date is required">
					<span class="label-input100">Enter Shift ID</span>
					<input class="input100" type="number" name="name" placeholder="">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 rs1-wrap-input100 validate-input" data-validate="End date is required">
					<span class="label-input100">Enter Project ID</span>
					<input class="input100" type="number" name="name" placeholder="">
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
								<a href="http://localhost:8080/HistoryPage.jsp" class="txt2">
							Get the time
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i></a>
						</span>
					</button>
				</div>

				<div class="wrap-input100 validate-input" data-validate = "">

					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							<a href="http://localhost:8080/home.jsp" class="txt2">
							Back to Homepage
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i></a>
						</span>
					</button>
				</div>
			</form>

			<div class="container-contact100-form-btn">
				<button class="contact100-form-btn">
					<span>
						<a href="http://localhost:8080/ProjectPage.jsp" class="txt2">
						Go to Project Tracking
						<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i></a>
					</span>
				</button>
			</div>
		</form>

			<span class="contact100-more">
				<span class="contact100-more-highlight">Your perspiration is recorded here</span>
			</span>
		</div>
	</div>



	<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="js/map-custom.js"></script>
<!--===============================================================================================-->
	<script src="js/main1.js"></script>


<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>


</body>
</html>
