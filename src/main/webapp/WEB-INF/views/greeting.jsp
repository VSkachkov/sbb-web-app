<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<form action ='greeting' method POST>
    <input type="text" id="greeting.id" name="greeting.id" value=""/><br>
    <input type="text" id="greeting.content" name="greeting.content" value=""/><br>
    <input type="submit" value="Submit" />
</form>

<h2>Result</h2>

<c:out value="${greeting.id}"/>
<c:out value="${greeting.content}"/>
<br>
<br>
<br>
<br>



















</body>
</html>
