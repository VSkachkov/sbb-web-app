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
                    <a class="nav-link" href="Timetable">Timetable</a>
                </li>
                <li class="nav-item ">
                    <a class="nav-link active" href="Trains">Trains</a>
                </li>

            </ul>
        </div>
    </div>
</nav>


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

        <form:form method="POST" action="addStationResultLink" modelAttribute="stationForm" class="form-signin">
            <h2 class="form-signin-heading">Enter travelling data</h2>

            <spring:bind path="stationName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input required="required" type="text" path="stationName" class="form-control" placeholder="Enter station name"
                                autofocus="true"></form:input>
                    <form:errors path="stationName"></form:errors>
                </div>
            </spring:bind>

            <spring:bind path="cantonName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <%--<form:input required="required" type="text"  path="cantonName" class="form-control"  placeholder="cantonName"--%>
                                <%--autofocus="true"></form:input>--%>
                        <form:select  path="cantonName">
                            <form:option value="NONE"> --SELECT CANTON--</form:option>
                            <form:options items="${cantonsList}"></form:options>
                        </form:select>
                    <form:errors path="cantonName"></form:errors>
                </div>
            </spring:bind>

            <%--<p> Please, set departure days: </p>--%>
            <%--&lt;%&ndash;<spring:bind path="departMon">&ndash;%&gt;--%>
            <%--<spring:bind path="departMon">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
            <%--<label class="form-check-label"--%>
            <%--<form:input type="boolean"  path="departMon"--%>
            <%--autofocus="true"></form:input>--%>

            <%--</div>--%>

            <%--</spring:bind>--%>

            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    id="submit-registration">Add station</button>
        </form:form>

    </div>


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

