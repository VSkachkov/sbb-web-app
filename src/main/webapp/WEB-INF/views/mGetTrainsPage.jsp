<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SBB - Manager </title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../resources/css/modern-business.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="home">SBB main page</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item">
                    <a class="nav-link" href="addStationLink">Add station</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addTrainLink">Add train</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getReservesLink">Get users on train</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="getTrainsLink">Get trains</a>
                </li>
                <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Portfolio--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">--%>
                <%--<a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>--%>
                <%--<a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>--%>
                <%--<a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>--%>
                <%--<a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>--%>
                <%--<a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>--%>
                <%--</div>--%>
                <%--</li>--%>
                <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Blog--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">--%>
                <%--<a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>--%>
                <%--<a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>--%>
                <%--<a class="dropdown-item" href="blog-post.html">Blog Post</a>--%>
                <%--</div>--%>
                <%--</li>--%>
                <%--<li class="nav-item dropdown">--%>
                <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                <%--Other Pages--%>
                <%--</a>--%>
                <%--<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">--%>
                <%--<a class="dropdown-item" href="full-width.html">Full Width Page</a>--%>
                <%--<a class="dropdown-item" href="sidebar.html">Sidebar Page</a>--%>
                <%--<a class="dropdown-item" href="faq.html">FAQ</a>--%>
                <%--<a class="dropdown-item" href="404.html">404</a>--%>
                <%--<a class="dropdown-item" href="pricing.html">Pricing Table</a>--%>
                <%--</div>--%>
                <%--</li>--%>
            </ul>
        </div>
    </div>
</nav>

<%--<header>--%>
    <%--<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">--%>
        <%--<ol class="carousel-indicators">--%>
            <%--<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>--%>
            <%--<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>--%>
            <%--<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>--%>
            <%--<li data-target="#carouselExampleIndicators" data-slide-to="3"></li>--%>
        <%--</ol>--%>
        <%--<div class="carousel-inner" role="listbox">--%>
            <%--<!-- Slide One - Set the background image for this slide in the line below -->--%>
            <%--<div class="carousel-item active" style="background-image: url('https://www.kinggoya.com/wp/wp-content/uploads/2015/08/train-summer-med.jpg')">--%>
                <%--<div class="carousel-caption d-none d-md-block">--%>
                    <%--&lt;%&ndash;<h3>First Slide</h3>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<p>This is a description for the first slide.</p>&ndash;%&gt;--%>
                    <%--<h3>   </h3>--%>
                    <%--<p>   </p>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- Slide Two - Set the background image for this slide in the line below -->--%>
            <%--<div class="carousel-item" style="background-image: url('http://arxitop.ru/foto/6/krasnyy_poezd_v_uschele_1920x1080.jpg')">--%>
                <%--<div class="carousel-caption d-none d-md-block">--%>
                    <%--<h3>   </h3>--%>
                    <%--<p>   </p>--%>
                    <%--&lt;%&ndash;<h3>Second Slide</h3>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<p>This is a description for the second slide.</p>&ndash;%&gt;--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<!-- Slide Three - Set the background image for this slide in the line below -->--%>
            <%--<div class="carousel-item" style="background-image: url('http://wp.widewallpapers.ru/2k/railroad/swiss/1920x1200/swiss-railroad-1920x1200-006.jpg')">--%>
                <%--<div class="carousel-caption d-none d-md-block">--%>
                    <%--<h3>   </h3>--%>
                    <%--<p>   </p>--%>
                    <%--&lt;%&ndash;<h3>Third Slide</h3>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<p>This is a description for the third slide.</p>&ndash;%&gt;--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="carousel-item" style="background-image: url('https://img3.goodfon.com/original/1920x1080/6/fd/bernina-express-poezd-most.jpg')">--%>
                <%--<div class="carousel-caption d-none d-md-block">--%>
                    <%--&lt;%&ndash;<h3>Fourth Slide</h3>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<p>This is a description for the fourth slide.</p>&ndash;%&gt;--%>
                    <%--<h3>   </h3>--%>
                    <%--<p>   </p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">--%>
            <%--<span class="carousel-control-prev-icon" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Previous</span>--%>
        <%--</a>--%>
        <%--<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">--%>
            <%--<span class="carousel-control-next-icon" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
    <%--</div>--%>
<%--</header>--%>


<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; T-Systems, 22nd Java School 2017</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/popper/popper.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
