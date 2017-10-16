<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link rel='stylesheet' href='webjars/bootstrap/3.1.0/css/bootstrap.min.css'>
</head>
<body>

<div class="col-sm-offset-1 col-sm-10">

    <legend>
        <spring:message code="table.timetable.title" />
    </legend>

    <div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th><spring:message code="table.timetable.title" /></th>
                    <th><spring:message code="table.timetable.trainNumber" /></th>
                    <th><spring:message code="table.timetable.stationId" /></th>
                    <th><spring:message code="table.timetable.arrival" /></th>
                    <th><spring:message code="table.timetable.departure" /></th>
                </tr>
            <thead>
            <tbody>
                <c:forEach var="t" items="${timetableModel}">
                    <tr>
                        <td>${t.timetableId}</td>
                        <td>${t.trainNumber}</td>
                        <td>${t.stationId}</td>
                        <td>${t.arrival}</td>
                        <td>${t.departure}</td>
                    <tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>