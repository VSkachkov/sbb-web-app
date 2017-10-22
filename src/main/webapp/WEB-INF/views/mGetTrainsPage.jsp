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
<%--<a class="nav-link" href="addTrainLink">Add train</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link" href="getReservesLink">Get users on train</a>--%>
<%--</li>--%>
<%--<li class="nav-item">--%>
<%--<a class="nav-link active" href="getTrainsLink">Get trains</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</nav>--%>

<%--&lt;%&ndash;Table&ndash;%&gt;--%>

<%--<div class="col-sm-offset-1 col-sm-10">--%>

    <%--<legend>--%>
        <%--<spring:message code="table.alltrains.title" />--%>
    <%--</legend>--%>

    <%--<div>--%>
        <%--<table id="dataTable" class="table table-striped table-bordered">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th><spring:message code="table.alltrains.trainId" /></th>--%>
                <%--<th><spring:message code="table.alltrains.trainName" /></th>--%>
                <%--<th><spring:message code="table.alltrains.initStation" /></th>--%>
                <%--<th><spring:message code="table.alltrains.departureTime" /></th>--%>
                <%--<th><spring:message code="table.alltrains.lastStation" /></th>--%>
                <%--<th><spring:message code="table.alltrains.arrivalTime" /></th>--%>
            <%--</tr>--%>
            <%--<thead>--%>
            <%--<tbody>--%>
            <%--<c:forEach var="t" items="${timetableModel}">--%>
            <%--<tr>--%>
                <%--<td>${t.trainId}</td>--%>
                <%--<td>${t.trainName}</td>--%>
                <%--<td>${t.initStation}</td>--%>
                <%--<td>${t.departureTime}</td>--%>
                <%--<td>${t.lastStation}</td>--%>
                <%--<td>${t.arrivalTime}</td>--%>

            <%--<tr>--%>
                <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>
    <%--</div>--%>
<%--</div>--%>


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


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel='stylesheet' href='webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>

<jsp:include page="templates/navigation.jsp"/>

<div class="col-sm-offset-1 col-sm-10">

    <legend>
        <spring:message code="table.alltrains.title" />
    </legend>

    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th><spring:message code="table.alltrains.trainId" /></th>
                <th><spring:message code="table.alltrains.trainName" /></th>
                <th><spring:message code="table.alltrains.initStation" /></th>
                <th><spring:message code="table.alltrains.departureTime" /></th>
                <th><spring:message code="table.alltrains.lastStation" /></th>
                <th><spring:message code="table.alltrains.arrivalTime" /></th>
            </tr>
            <thead>
            <tbody>
            <c:forEach var="t" items="${timetableModel}">
            <tr>
                <td>${t.trainId}</td>
                <td>${t.trainName}</td>
                <td>${t.initStation}</td>
                <td>${t.departureTime}</td>
                <td>${t.lastStation}</td>
                <td>${t.arrivalTime}</td>

            <tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>