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
                    <a class="nav-link" href="getTrainsLink">Get trains</a>
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
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
        </ol>
        <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('https://www.kinggoya.com/wp/wp-content/uploads/2015/08/train-summer-med.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <%--<h3>First Slide</h3>--%>
                    <%--<p>This is a description for the first slide.</p>--%>
                    <h3>   </h3>
                    <p>   </p>
                </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('http://arxitop.ru/foto/6/krasnyy_poezd_v_uschele_1920x1080.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>   </h3>
                    <p>   </p>
                    <%--<h3>Second Slide</h3>--%>
                    <%--<p>This is a description for the second slide.</p>--%>
                </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('http://wp.widewallpapers.ru/2k/railroad/swiss/1920x1200/swiss-railroad-1920x1200-006.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <h3>   </h3>
                    <p>   </p>
                    <%--<h3>Third Slide</h3>--%>
                    <%--<p>This is a description for the third slide.</p>--%>
                </div>
            </div>
            <div class="carousel-item" style="background-image: url('https://img3.goodfon.com/original/1920x1080/6/fd/bernina-express-poezd-most.jpg')">
                <div class="carousel-caption d-none d-md-block">
                    <%--<h3>Fourth Slide</h3>--%>
                    <%--<p>This is a description for the fourth slide.</p>--%>
                    <h3>   </h3>
                    <p>   </p>
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

<%--<!-- Page Content -->--%>
<%--<div class="container">--%>

    <%--<h1 class="my-4">Welcome to Modern Business</h1>--%>

    <%--<!-- Features Section -->--%>
    <%--<div class="row">--%>
        <%--<div class="col-lg-6">--%>
            <%--<h2>Modern Business Features</h2>--%>
            <%--<p>The Modern Business template by Start Bootstrap includes:</p>--%>
            <%--<ul>--%>
                <%--<li>--%>
                    <%--<strong>Bootstrap v4</strong>--%>
                <%--</li>--%>
                <%--<li>jQuery</li>--%>
                <%--<li>Font Awesome</li>--%>
                <%--<li>Working contact form with validation</li>--%>
                <%--<li>Unstyled page elements for easy customization</li>--%>
            <%--</ul>--%>
            <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>--%>
        <%--</div>--%>
        <%--<div class="col-lg-6">--%>
            <%--<img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<!-- /.row -->--%>

    <%--<hr>--%>

    <%--<!-- Call to Action Section -->--%>
    <%--<div class="row mb-4">--%>
        <%--<div class="col-md-8">--%>
            <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>--%>
        <%--</div>--%>
        <%--<div class="col-md-4">--%>
            <%--<a class="btn btn-lg btn-secondary btn-block" href="#">Call to Action</a>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--</div>--%>
<%--<!-- /.container -->--%>

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
