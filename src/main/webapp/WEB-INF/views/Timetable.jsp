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
                <li class="nav-item active">
                    <a class="nav-link" href="Timetable">Timetable</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Trains">Trains</a>
                </li>
                <%--<li class="nav-item dropdown">--%>
                    <%--<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                        <%--Portfolio--%>
                    <%--</a>--%>
                    <%--&lt;%&ndash;<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
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
<!-- Page Content -->
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

    <h3>Please, enter the station</h3>
    <form:form method="post" action="resultTT" modelAttribute="station">
        <form:label path="stationName">station Name( For ex. "Bern")</form:label>
        <form:input path="stationName"/>
        <br>
        <input type="submit" value="Get Timetable"/>
    </form:form>





    <%--<div>--%>
        <%--&lt;%&ndash;${greeting.id}&ndash;%&gt;--%>
        <%--&lt;%&ndash;${greeting.content}&ndash;%&gt;--%>

        <%--&lt;%&ndash;TIMETABLE !!!!!!!!!!!!!!!!!!!!!!!!&ndash;%&gt;--%>
        <%--<div class="col-sm-offset-1 col-sm-10">--%>

            <%--&lt;%&ndash;<legend>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<spring:message code="table.timetable.title" />&ndash;%&gt;--%>
            <%--&lt;%&ndash;</legend>&ndash;%&gt;--%>

            <%--&lt;%&ndash;<div>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<table id="dataTable" class="table table-striped table-bordered">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<thead>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th><spring:message code="table.timetable.timetableId" /></th>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th><spring:message code="table.timetable.stationId" /></th>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th><spring:message code="table.timetable.trainNumber" /></th>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th><spring:message code="table.timetable.arrival" /></th>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<th><spring:message code="table.timetable.departure" /></th>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</tr>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<thead>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<tbody>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<c:forEach var="t" items="${timetableModel}">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<td>${t.timetableId}</td>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<td>${t.arrival}</td>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<td>${t.departure}</td>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<tr>&ndash;%&gt;--%>
                        <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</tbody>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</table>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</div>--%>

    <%--&lt;%&ndash;<!-- Image Header -->&ndash;%&gt;--%>
    <%--&lt;%&ndash;<img class="img-fluid rounded mb-4" src="http://placehold.it/1200x300" alt="">&ndash;%&gt;--%>

<%--</div>--%>

<%--<h3>Form</h3>--%>
<%--<form:form method="post" action="resultZ" modelAttribute="greeting">--%>
    <%--<form:label path="id">id</form:label>--%>
    <%--<form:input path="id"/>--%>

    <%--<form:label path="content">content</form:label>--%>
    <%--<form:input path="content"/>--%>

    <%--<input type="submit" value="Submit"/>--%>
<%--</form:form>--%>
<br>
<br>


<%--<h3>Form For timetable sending to another page</h3>--%>
<%--<form:form method="post" action="Timetable" modelAttribute="stationNameAttrib">--%>
    <%--&lt;%&ndash;<form:label path="stationNameAttrib">stationNameAttrib</form:label>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:input path="stationNameAttrib"/>&ndash;%&gt;--%>
    <%--<input type="submit" value="Submit Timetable"/>--%>
<%--</form:form>--%>

<%--<h3>Form for Entering Station Name</h3>--%>
<%--<form:form method="post" action="result" modelAttribute="StationName">--%>

    <%--<form:label path="StationName">StationName</form:label>--%>
    <%--<form:input path="StationName"/>--%>

    <%--<input type="submit" value="Submit"/>--%>
<%--</form:form>--%>




<%--<h2>Spring MVC Autocomplete with JQuery &amp; JSON example</h2>--%>
<%--<form:form method="post" action="save.html" modelAttribute="userForm">--%>
    <%--<table>--%>
        <%--<tr>--%>
            <%--<th>Name</th>--%>
            <%--<td><form:input path="name" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<th>Country</th>--%>
            <%--<td><form:input path="country" id="country" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<th>Technologies</th>--%>
            <%--<td><form:input path="technologies" id="technologies" /></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2">--%>
                <%--<input type="submit" value="Save" />--%>
                <%--<input type="reset" value="Reset" />--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
    <%--<br />--%>

<%--</form:form>--%>


<%--<script type="text/javascript">--%>
    <%--function split(val) {--%>
        <%--return val.split(/,\s*/);--%>
    <%--}--%>
    <%--function extractLast(term) {--%>
        <%--return split(term).pop();--%>
    <%--}--%>

    <%--$(document).ready(function() {--%>

        <%--$( "#country" ).autocomplete({--%>
            <%--source: '${pageContext. request. contextPath}/get_station_list.html'--%>
        <%--});--%>

        <%--$( "#technologies").autocomplete({--%>
            <%--source: function (request, response) {--%>
                <%--$.getJSON("${pageContext. request. contextPath}/get_tech_list.html", {--%>
                    <%--term: extractLast(request.term)--%>
                <%--}, response);--%>
            <%--},--%>
            <%--search: function () {--%>
                <%--// custom minLength--%>
                <%--var term = extractLast(this.value);--%>
                <%--if (term.length < 1) {--%>
                    <%--return false;--%>
                <%--}--%>
            <%--},--%>
            <%--focus: function () {--%>
                <%--// prevent value inserted on focus--%>
                <%--return false;--%>
            <%--},--%>
            <%--select: function (event, ui) {--%>
                <%--var terms = split(this.value);--%>
                <%--// remove the current input--%>
                <%--terms.pop();--%>
                <%--// add the selected item--%>
                <%--terms.push(ui.item.value);--%>
                <%--// add placeholder to get the comma-and-space at the end--%>
                <%--terms.push("");--%>
                <%--this.value = terms.join(", ");--%>
                <%--return false;--%>
            <%--}--%>
        <%--});--%>

    <%--});--%>
<%--</script>--%>

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
