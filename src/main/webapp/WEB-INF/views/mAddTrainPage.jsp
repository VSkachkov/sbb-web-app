<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>

<%--<head>--%>

    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>SBB - Manager </title>--%>

    <%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
    <%--<link href="../resources/css/modern-business.css" rel="stylesheet">--%>

<%--</head>--%>

<%--<body>--%>

<%--<!-- Navigation -->--%>
<%--<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">--%>
    <%--<div class="container">--%>
        <%--<a class="navbar-brand" href="home">SBB main page</a>--%>
        <%--<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--<span class="navbar-toggler-icon"></span>--%>
        <%--</button>--%>
        <%--<div class="collapse navbar-collapse" id="navbarResponsive">--%>
            <%--<ul class="navbar-nav ml-auto">--%>

                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="addStationLink">Add station</a>--%>
                <%--</li>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link active" href="addTrainLink">Add train</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="getReservesLink">Get users on train</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="getTrainsLink">Get trains</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</nav>--%>


<%--<div class="container">--%>

    <%--<form:form method="POST" action="resultTrainsLink" modelAttribute="trainsForm" class="form-signin">--%>
        <%--<h2 class="form-signin-heading">Enter travelling data</h2>--%>

        <%--<spring:bind path="stationFrom">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input required="required" type="text" path="stationFrom" class="form-control" placeholder="From Station"--%>
                            <%--autofocus="true"></form:input>--%>
                <%--<form:errors path="stationFrom"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>
        <%--<spring:bind path="stationTo">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input  required="required" type="text" path="stationTo" class="form-control" placeholder="To Station"--%>
                <%--></form:input>--%>
                <%--<form:errors path="stationTo"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <%--<spring:bind path="earlyTime">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input  type="text" path="earlyTime" class="form-control" placeholder="Not earlier than ...(HHMM)"--%>
                <%--></form:input>--%>
                <%--<form:errors path="earlyTime"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <%--<spring:bind path="lateTime">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input  type="text" path="lateTime" class="form-control" placeholder="Not later than ...(HHMM)"--%>
                <%--></form:input>--%>
                <%--<form:errors path="lateTime"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <%--<button class="btn btn-lg btn-primary btn-block" type="submit"--%>
                <%--id="submit-registration">Find trains</button>--%>
    <%--</form:form>--%>

<%--</div>--%>
<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
<%--&lt;%&ndash;function checkParams() {&ndash;%&gt;--%>
<%--&lt;%&ndash;var loginError = document.getElementById('loginExists').innerHTML;&ndash;%&gt;--%>
<%--&lt;%&ndash;var emailError = document.getElementById('emailExists').innerHTML;&ndash;%&gt;--%>

<%--&lt;%&ndash;if(loginError.length !== 0 || emailError.length !== 0) {&ndash;%&gt;--%>
<%--&lt;%&ndash;$('#submit-registration').removeAttr('active');&ndash;%&gt;--%>
<%--&lt;%&ndash;$('#submit-registration').attr('disabled', 'disabled');&ndash;%&gt;--%>
<%--&lt;%&ndash;} else {&ndash;%&gt;--%>
<%--&lt;%&ndash;$('#submit-registration').removeAttr('disabled');&ndash;%&gt;--%>
<%--&lt;%&ndash;$('#submit-registration').attr('active', 'active');&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>

<%--&lt;%&ndash;function onBlurEmailFunction(obj){&ndash;%&gt;--%>
<%--&lt;%&ndash;var email = obj.value;&ndash;%&gt;--%>
<%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
<%--&lt;%&ndash;type: "POST",&ndash;%&gt;--%>
<%--&lt;%&ndash;data: {email : email},&ndash;%&gt;--%>
<%--&lt;%&ndash;url: "${pageContext.request.contextPath}/registration/findEmail/",&ndash;%&gt;--%>
<%--&lt;%&ndash;success: function (msg) {&ndash;%&gt;--%>
<%--&lt;%&ndash;$("#emailExists").html(msg);&ndash;%&gt;--%>
<%--&lt;%&ndash;checkParams();&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;})&ndash;%&gt;--%>

<%--&lt;%&ndash;};&ndash;%&gt;--%>

<%--&lt;%&ndash;function onBlurLoginFunction(obj) {&ndash;%&gt;--%>
<%--&lt;%&ndash;var login = obj.value;&ndash;%&gt;--%>
<%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
<%--&lt;%&ndash;type: "POST",&ndash;%&gt;--%>
<%--&lt;%&ndash;data: {login : login},&ndash;%&gt;--%>
<%--&lt;%&ndash;url: "${pageContext.request.contextPath}/registration/findLogin/",&ndash;%&gt;--%>
<%--&lt;%&ndash;success: function (msg) {&ndash;%&gt;--%>
<%--&lt;%&ndash;$("#loginExists").text(msg);&ndash;%&gt;--%>
<%--&lt;%&ndash;checkParams();&ndash;%&gt;--%>
<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;})&ndash;%&gt;--%>

<%--&lt;%&ndash;}&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>

<%--</div>--%>


<%--<br>--%>
<%--<br>--%>


<%--<!-- Footer -->--%>
<%--<footer class="py-5 bg-dark">--%>
    <%--<div class="container">--%>
        <%--<p class="m-0 text-center text-white">Copyright &copy; T-Systems, 22nd Java School 2017</p>--%>
    <%--</div>--%>
    <%--<!-- /.container -->--%>
<%--</footer>--%>

<%--<!-- Bootstrap core JavaScript -->--%>
<%--<script src="../resources/vendor/jquery/jquery.min.js"></script>--%>
<%--<script src="../resources/vendor/popper/popper.min.js"></script>--%>
<%--<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>--%>

<%--</body>--%>

<%--</html>--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SBB - Timetable</title>

    <!-- Bootstrap core CSS -->
    <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../resources/css/modern-business.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>


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
                    <a class="nav-link" href="about.html">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="services.html">Services</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Timetable">Timetable</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="Trains">Trains</a>
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
<%--<a href="timetableList">json timetable list</a><br/>--%>
<!-- Page Content -->
<%--<div class="container">--%>

    <%--<!-- Page Heading/Breadcrumbs -->--%>
    <%--<h1 class="mt-4 mb-3">SBB--%>
        <%--<small> Mobility of the future </small>--%>
    <%--</h1>--%>

    <%--<ol class="breadcrumb">--%>
        <%--<li class="breadcrumb-item">--%>
            <%--<a href="home">Home</a>--%>
        <%--</li>--%>
        <%--<li class="breadcrumb-item active">Timetable</li>--%>
    <%--</ol>--%>


    <%--<div class="container">--%>

        <%--<form:form method="POST" action="addTrainResultLink" modelAttribute="trainsForm" class="form-signin">--%>
            <%--<h2 class="form-signin-heading">Enter travelling data</h2>--%>

            <%--<spring:bind path="stationFrom">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input required="required" type="text" path="stationFrom" class="form-control" placeholder="From Station"--%>
                                <%--autofocus="true"></form:input>--%>
                    <%--<form:errors path="stationFrom"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>
            <%--<spring:bind path="stationTo">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input  required="required" type="text" path="stationTo" class="form-control" placeholder="To Station"--%>
                    <%--></form:input>--%>
                    <%--<form:errors path="stationTo"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>

            <%--<spring:bind path="earlyTime">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input  type="text" path="earlyTime" class="form-control" placeholder="Not earlier than ...(HHMM)"--%>
                    <%--></form:input>--%>
                    <%--<form:errors path="earlyTime"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>

            <%--<spring:bind path="lateTime">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input  type="text" path="lateTime" class="form-control" placeholder="Not later than ...(HHMM)"--%>
                    <%--></form:input>--%>
                    <%--<form:errors path="lateTime"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>

            <%--<button class="btn btn-lg btn-primary btn-block" type="submit"--%>
                    <%--id="submit-registration">Find trains</button>--%>
        <%--</form:form>--%>

    <%--</div>--%>
    <%--&lt;%&ndash;<script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;function checkParams() {&ndash;%&gt;--%>
    <%--&lt;%&ndash;var loginError = document.getElementById('loginExists').innerHTML;&ndash;%&gt;--%>
    <%--&lt;%&ndash;var emailError = document.getElementById('emailExists').innerHTML;&ndash;%&gt;--%>

    <%--&lt;%&ndash;if(loginError.length !== 0 || emailError.length !== 0) {&ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#submit-registration').removeAttr('active');&ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#submit-registration').attr('disabled', 'disabled');&ndash;%&gt;--%>
    <%--&lt;%&ndash;} else {&ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#submit-registration').removeAttr('disabled');&ndash;%&gt;--%>
    <%--&lt;%&ndash;$('#submit-registration').attr('active', 'active');&ndash;%&gt;--%>
    <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;}&ndash;%&gt;--%>

    <%--&lt;%&ndash;function onBlurEmailFunction(obj){&ndash;%&gt;--%>
    <%--&lt;%&ndash;var email = obj.value;&ndash;%&gt;--%>
    <%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
    <%--&lt;%&ndash;type: "POST",&ndash;%&gt;--%>
    <%--&lt;%&ndash;data: {email : email},&ndash;%&gt;--%>
    <%--&lt;%&ndash;url: "${pageContext.request.contextPath}/registration/findEmail/",&ndash;%&gt;--%>
    <%--&lt;%&ndash;success: function (msg) {&ndash;%&gt;--%>
    <%--&lt;%&ndash;$("#emailExists").html(msg);&ndash;%&gt;--%>
    <%--&lt;%&ndash;checkParams();&ndash;%&gt;--%>
    <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;})&ndash;%&gt;--%>

    <%--&lt;%&ndash;};&ndash;%&gt;--%>

    <%--&lt;%&ndash;function onBlurLoginFunction(obj) {&ndash;%&gt;--%>
    <%--&lt;%&ndash;var login = obj.value;&ndash;%&gt;--%>
    <%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
    <%--&lt;%&ndash;type: "POST",&ndash;%&gt;--%>
    <%--&lt;%&ndash;data: {login : login},&ndash;%&gt;--%>
    <%--&lt;%&ndash;url: "${pageContext.request.contextPath}/registration/findLogin/",&ndash;%&gt;--%>
    <%--&lt;%&ndash;success: function (msg) {&ndash;%&gt;--%>
    <%--&lt;%&ndash;$("#loginExists").text(msg);&ndash;%&gt;--%>
    <%--&lt;%&ndash;checkParams();&ndash;%&gt;--%>
    <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;})&ndash;%&gt;--%>

    <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;</script>&ndash;%&gt;--%>

<%--</div>--%>


<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">SBB
        <small> Mobility of the future </small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="home">Home</a>
        </li>
        <li class="breadcrumb-item active">Timetable</li>
    </ol>


    <div class="container">

        <form:form method="POST" action="addTrainResultLink" modelAttribute="trainDto" class="form-signin">
            <h2 class="form-signin-heading">Enter travelling data</h2>

            <spring:bind path="trainName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input required="required" type="text" path="trainName" class="form-control" placeholder="Enter train name"
                                autofocus="true"></form:input>
                    <form:errors path="trainName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="initStation">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input required="required" type="text" path="initStation" class="form-control" placeholder="Init Station"
                                autofocus="true"></form:input>
                    <form:errors path="initStation"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="lastStation">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input  required="required" type="text" path="lastStation" class="form-control" placeholder="Last Station"
                    ></form:input>
                    <form:errors path="lastStation"></form:errors>
                </div>
            </spring:bind>

            <%--<spring:bind path="earlyTime">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input  type="text" path="earlyTime" class="form-control" placeholder="Not earlier than ...(HHMM)"--%>
                    <%--></form:input>--%>
                    <%--<form:errors path="earlyTime"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>

            <%--<spring:bind path="lateTime">--%>
                <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                    <%--<form:input  type="text" path="lateTime" class="form-control" placeholder="Not later than ...(HHMM)"--%>
                    <%--></form:input>--%>
                    <%--<form:errors path="lateTime"></form:errors>--%>
                <%--</div>--%>
            <%--</spring:bind>--%>

            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    id="submit-registration">Find trains</button>
        </form:form>

    </div>
    <%--<script>--%>
    <%--function checkParams() {--%>
    <%--var loginError = document.getElementById('loginExists').innerHTML;--%>
    <%--var emailError = document.getElementById('emailExists').innerHTML;--%>

    <%--if(loginError.length !== 0 || emailError.length !== 0) {--%>
    <%--$('#submit-registration').removeAttr('active');--%>
    <%--$('#submit-registration').attr('disabled', 'disabled');--%>
    <%--} else {--%>
    <%--$('#submit-registration').removeAttr('disabled');--%>
    <%--$('#submit-registration').attr('active', 'active');--%>
    <%--}--%>
    <%--}--%>

    <%--function onBlurEmailFunction(obj){--%>
    <%--var email = obj.value;--%>
    <%--$.ajax({--%>
    <%--type: "POST",--%>
    <%--data: {email : email},--%>
    <%--url: "${pageContext.request.contextPath}/registration/findEmail/",--%>
    <%--success: function (msg) {--%>
    <%--$("#emailExists").html(msg);--%>
    <%--checkParams();--%>
    <%--}--%>
    <%--})--%>

    <%--};--%>

    <%--function onBlurLoginFunction(obj) {--%>
    <%--var login = obj.value;--%>
    <%--$.ajax({--%>
    <%--type: "POST",--%>
    <%--data: {login : login},--%>
    <%--url: "${pageContext.request.contextPath}/registration/findLogin/",--%>
    <%--success: function (msg) {--%>
    <%--$("#loginExists").text(msg);--%>
    <%--checkParams();--%>
    <%--}--%>
    <%--})--%>

    <%--}--%>
    <%--</script>--%>

</div>

<br>
<br>


<%--END OF TIMETABLE !!!!!!!!!!!!!!!!!!!!!!!!!!--%>
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

