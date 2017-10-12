<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
    <%--pageEncoding="ISO-8859-1"%>--%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">--%>
<%--<title>Bootstrap Example</title>--%>
	<%--<meta charset="utf-8">--%>
	<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
	<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
	<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
	<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>

		<%--<a href="users">users</a><br/>--%>
		<%--<a href="usersList">json users list</a><br/>--%>
		<%--<a href="authoritiesList">json authorities list</a><br/>--%>
		<%--<a href="timetableList">json timetable list</a><br/>--%>
		<%--<a href="cantonsList">json cantons list</a><br/>--%>
		<%--<a href="stationsList">json stations list</a><br/>--%>
		<%--<a href="linkToHelloWorld">GO to hello world! </a><br/>--%>
		<%--&lt;%&ndash;<a href="linkToAuthorities">Authorities </a>&ndash;%&gt;--%>
		<%--&lt;%&ndash;<button type="submit" formaction="http://localhost:8080/users">ClickMe</button>&ndash;%&gt;--%>
		<%--&lt;%&ndash;<p>Hello World!</p>&ndash;%&gt;--%>
<%--&lt;%&ndash;<div>&ndash;%&gt;--%>
<%--&lt;%&ndash;<spring:form method="post" modelAttribute="CantonJSP" action="">&ndash;%&gt;--%>
	<%--&lt;%&ndash;Enter Canton Id: <spring:input path="id"/> <br>&ndash;%&gt;--%>
	<%--&lt;%&ndash;<spring:button>Submit</spring:button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</spring:form>&ndash;%&gt;--%>
		<%--<img src="../resources/images/swiss_train1.jpg" alt="Mountain View" style="width:304px;height:228px;">--%>
		<%--<div class="w3-content w3-section" style="max-width:500px">--%>
			<%--<img class="mySlides" src="../resources/images/swiss_train1.jpg" style="width:100%">--%>
			<%--<img class="mySlides" src="../resources/images/swiss_train2.jpg" style="width:100%">--%>
		<%--</div>--%>
		<%--<script>--%>
            <%--var myIndex = 0;--%>
            <%--carousel();--%>

            <%--function carousel() {--%>
                <%--var i;--%>
                <%--var x = document.getElementsByClassName("mySlides");--%>
                <%--for (i = 0; i < x.length; i++) {--%>
                    <%--x[i].style.display = "none";--%>
                <%--}--%>
                <%--myIndex++;--%>
                <%--if (myIndex > x.length) {myIndex = 1}--%>
                <%--x[myIndex-1].style.display = "block";--%>
                <%--setTimeout(carousel, 2000); // Change image every 2 seconds--%>
            <%--}--%>
		<%--</script>--%>

		<%--<div class="jumbotron text-center">--%>
			<%--<h1>My First Bootstrap Page</h1>--%>
			<%--<p>Resize this responsive page to see the effect!</p>--%>
		<%--</div>--%>

		<%--<div class="container">--%>
			<%--<div class="row">--%>
				<%--<div class="col-sm-4">--%>
					<%--<h3>Column 1</h3>--%>
					<%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>--%>
					<%--<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>--%>
				<%--</div>--%>
				<%--<div class="col-sm-4">--%>
					<%--<h3>Column 2</h3>--%>
					<%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>--%>
					<%--<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>--%>
				<%--</div>--%>
				<%--<div class="col-sm-4">--%>
					<%--<h3>Column 3</h3>--%>
					<%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>--%>
					<%--<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>--%>
				<%--</div>--%>
			<%--</div>--%>
		<%--</div>--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>Modern Business - Start Bootstrap Template</title>

	<!-- Bootstrap core CSS -->
	<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="../resources/css/modern-business.css" rel="stylesheet">

</head>

<body>
<a href="stationsList">json stations list</a><br/>
<a href="cantonsList">json cantons list</a><br/>
<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index.html">Start Bootstrap</a>
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="about.html">About</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="services.html">Services</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="contact.html">Contact</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="Timetable">Timetable</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Portfolio
					</a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
						<a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
						<a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Blog
					</a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
						<a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
						<a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
						<a class="dropdown-item" href="blog-post.html">Blog Post</a>
					</div>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Other Pages
					</a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
						<a class="dropdown-item" href="full-width.html">Full Width Page</a>
						<a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
						<a class="dropdown-item" href="faq.html">FAQ</a>
						<a class="dropdown-item" href="404.html">404</a>
						<a class="dropdown-item" href="pricing.html">Pricing Table</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>

<header>
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<!-- Slide One - Set the background image for this slide in the line below -->
			<div class="carousel-item active" style="background-image: url('https://www.kinggoya.com/wp/wp-content/uploads/2015/08/train-summer-med.jpg')">
				<div class="carousel-caption d-none d-md-block">
					<h3>First Slide</h3>
					<p>This is a description for the first slide.</p>
				</div>
			</div>
			<!-- Slide Two - Set the background image for this slide in the line below -->
			<div class="carousel-item" style="background-image: url('http://arxitop.ru/foto/6/krasnyy_poezd_v_uschele_1920x1080.jpg')">
				<div class="carousel-caption d-none d-md-block">
					<h3>Second Slide</h3>
					<p>This is a description for the second slide.</p>
				</div>
			</div>
			<!-- Slide Three - Set the background image for this slide in the line below -->
			<div class="carousel-item" style="background-image: url('http://wp.widewallpapers.ru/2k/railroad/swiss/1920x1200/swiss-railroad-1920x1200-006.jpg')">
				<div class="carousel-caption d-none d-md-block">
					<h3>Third Slide</h3>
					<p>This is a description for the third slide.</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</header>

<!-- Page Content -->
<div class="container">

	<h1 class="my-4">Welcome to Modern Business</h1>

	<!-- Marketing Icons Section -->
	<div class="row">
		<div class="col-lg-4 mb-4">
			<div class="card h-100">
				<h4 class="card-header">Card Title</h4>
				<div class="card-body">
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
				</div>
				<div class="card-footer">
					<a href="#" class="btn btn-primary">Learn More</a>
				</div>
			</div>
		</div>
		<div class="col-lg-4 mb-4">
			<div class="card h-100">
				<h4 class="card-header">Card Title</h4>
				<div class="card-body">
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.</p>
				</div>
				<div class="card-footer">
					<a href="#" class="btn btn-primary">Learn More</a>
				</div>
			</div>
		</div>
		<div class="col-lg-4 mb-4">
			<div class="card h-100">
				<h4 class="card-header">Card Title</h4>
				<div class="card-body">
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
				</div>
				<div class="card-footer">
					<a href="#" class="btn btn-primary">Learn More</a>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->

	<!-- Portfolio Section -->
	<h2>Portfolio Heading</h2>

	<div class="row">
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project One</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Amet numquam aspernatur eum quasi sapiente nesciunt? Voluptatibus sit, repellat sequi itaque deserunt, dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Two</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Three</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quos quisquam, error quod sed cumque, odio distinctio velit nostrum temporibus necessitatibus et facere atque iure perspiciatis mollitia recusandae vero vel quam!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Four</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Five</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam viverra euismod odio, gravida pellentesque urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Six</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.</p>
				</div>
			</div>
		</div>
	</div>
	<!-- /.row -->

	<!-- Features Section -->
	<div class="row">
		<div class="col-lg-6">
			<h2>Modern Business Features</h2>
			<p>The Modern Business template by Start Bootstrap includes:</p>
			<ul>
				<li>
					<strong>Bootstrap v4</strong>
				</li>
				<li>jQuery</li>
				<li>Font Awesome</li>
				<li>Working contact form with validation</li>
				<li>Unstyled page elements for easy customization</li>
			</ul>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
		</div>
		<div class="col-lg-6">
			<img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
		</div>
	</div>
	<!-- /.row -->

	<hr>

	<!-- Call to Action Section -->
	<div class="row mb-4">
		<div class="col-md-8">
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
		</div>
		<div class="col-md-4">
			<a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>
		</div>
	</div>

</div>
<!-- /.container -->

<!-- Footer -->
<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
	</div>
	<!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/popper/popper.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
