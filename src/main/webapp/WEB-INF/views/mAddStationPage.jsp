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
<jsp:include page="templates/navigation.jsp"/>

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">SBB
        <small> Mobility of the future </small>
    </h1>

    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="managerPage">Manager page</a>
        </li>
        <li class="breadcrumb-item active">Adding stations</li>
    </ol>


    <div class="container">

        <form:form method="POST" action="addStationResult" modelAttribute="stationForm" class="form-signin">
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
                        <form:select  path="cantonName" required="required">
                            <%--<form:option value=" " > --SELECT CANTON--</form:option>--%>
                            <form:options items="${cantonsList}"></form:options>
                        </form:select>
                    <form:errors path="cantonName"></form:errors>
                </div>
            </spring:bind>


            <button class="btn btn-lg btn-primary btn-block" type="submit"
                    id="submit-registration">Add station</button>
        </form:form>

    </div>


</div>

<br>
<br>


<%--END OF TIMETABLE !!!!!!!!!!!!!!!!!!!!!!!!!!--%>
<!-- Footer -->

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/popper/popper.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>

</html>

