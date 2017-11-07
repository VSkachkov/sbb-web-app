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
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">


    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

    <script type="text/javascript"
            src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript"
            src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
    <script type="text/javascript"
            src="response.js"></script>
    <script src="/js/response.js"></script>
<%--<link rel='stylesheet' href='webjars/bootstrap/3.1.0/css/bootstrap.min.css'>--%>
</head>
<body>

<jsp:include page="templates/navigation.jsp"/>

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

<div class="col-sm-offset-1 col-sm-10">

    <legend>
       Timetable by station
    </legend>

    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>  Train Number  </th>
                    <th>  Arrival time  </th>
                    <th>  Departure time</th>
                </tr>
            <thead>
            <tbody>
                <c:forEach var="t" items="${timetableModel}">
                    <tr>
                        <td>${t.trainId}</td>
                        <td>${t.arrival}</td>
                        <td>${t.departure}</td>
                    <tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<jsp:include page="templates/footer.jsp"/>

<!-- Bootstrap core JavaScript -->
<script src="../resources/vendor/jquery/jquery.min.js"></script>
<script src="../resources/vendor/popper/popper.min.js"></script>
<script src="../resources/vendor/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>