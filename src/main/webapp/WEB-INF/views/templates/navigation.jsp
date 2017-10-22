<%--
  Created by IntelliJ IDEA.
  User: skach
  Date: 22.10.2017
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>SBB</title>
</head>
<!-- Navigation -->
<c:if test = "${sessionScope.user.role=='ROLE_ANONYM'}">
<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="home">SBB main page</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="timetable">Timetable</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="trains">Trains</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="registration">Sign Up</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</c:if>

<c:if test = "${sessionScope.user.role=='ROLE_CLIENT'}">
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="home">SBB main page</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsiveUser">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="timetable">Timetable</a>
                    </li>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="trains">Trains</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="trains">Buy ticket</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Sign out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</c:if>

<c:if test = "${sessionScope.user.role=='ROLE_ADMIN'}">
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="home">SBB manager page</a>
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsiveAdmin">
                <ul class="navbar-nav ml-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="addStationLink">Add station</a>
                    </li>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="addTrainLink">Add train</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="getReservesLink">Passengers on train</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="getTrainsLink">Trains in database</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Sign out</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</c:if>

</html>
