<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<head>
    <%--<link rel='stylesheet' href='webjars/bootstrap/3.1.0/css/bootstrap.min.css'>--%>

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
<body  class="bg-dark">
<jsp:include page="templates/navigation.jsp"/>


<<div class="container">
    <%--<<div class="card card-login mx-auto mt-5">--%>
<form method="POST" action="/login" class="form-signin">
    <h2 class="form-heading">Log in</h2>

    <div class="form-group ${error != null ? 'has-error' : ''}">
        <span>${message}</span>
        <input id="login-login" required name="login" type="text" class="form-control" placeholder="Login"
               autofocus="true"/>
        <input id="login-password" required name="pass" type="password" class="form-control"
               placeholder="Password"/>
        <span id="login-error">${error}</span>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        <h4 class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an account</a></h4>
        <p class="text-center" style="color: #a5a5a5; text-decoration: underline"><a id="click-forgot-password">I forgot my password</a></p>
    </div>

</form>
</div>
<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>




<%--<div class="container">--%>

    <%--<form method="POST" action="login" class="form-signin">--%>
        <%--&lt;%&ndash;<form method="POST" action="${pageContext.request.contextPath}/login" class="form-signin">        &ndash;%&gt;--%>
        <%--h2 class="form-heading">Log in</h2>--%>

        <%--<div class="form-group ${error != null ? 'has-error' : ''}">--%>
            <%--<span>${message}</span>--%>
            <%--<input id="login-login" required name="login" type="text" class="form-control" placeholder="Login"--%>
                   <%--autofocus="true"/>--%>
            <%--<input id="login-password" required name="password" type="password" class="form-control"--%>
                   <%--placeholder="Password"/>--%>
            <%--<span id="login-error">${error}</span>--%>
            <%--&lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>&ndash;%&gt;--%>

            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>--%>
            <%--&lt;%&ndash;<h4 class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an account</a></h4>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<p class="text-center" style="color: #a5a5a5; text-decoration: underline"><a id="click-forgot-password">I forgot my password</a></p>&ndash;%&gt;--%>
        <%--</div>--%>

    <%--</form>--%>

<%--</div>--%>

<%--&lt;%&ndash;<div id="modal-forgot-password" class="modal fade" style="padding-top: 200px;">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="modal-dialog">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<div class="modal-content">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<div class="modal-body" style="padding-bottom: 50px">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>&ndash;%&gt;--%>
                <%--&lt;%&ndash;<div class="text-center">&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<h4 style="padding: 20px">Input your e-mail, please.</h4>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;<form>&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<input id="input-email-forgot-password" type="email" class="form-control"&ndash;%&gt;--%>
                           <%--&lt;%&ndash;required placeholder="Email" style="width: 250px; display: inline-block"/>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;&lt;%&ndash;</form>&ndash;%&gt;&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<button id="send-forgot-password" type="button" style="margin-bottom: 8px" class="btn btn-primary">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<i class="fa fa-paper-plane" aria-hidden="true"></i> Send&ndash;%&gt;--%>
                    <%--&lt;%&ndash;</button>&ndash;%&gt;--%>
                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
<%--&lt;%&ndash;</div>&ndash;%&gt;--%>

<%--&lt;%&ndash;<script>&ndash;%&gt;--%>
    <%--&lt;%&ndash;$("#click-forgot-password").click(function (e) {&ndash;%&gt;--%>
            <%--&lt;%&ndash;e.preventDefault();&ndash;%&gt;--%>
            <%--&lt;%&ndash;$("#modal-forgot-password").modal('show');&ndash;%&gt;--%>
        <%--&lt;%&ndash;}&ndash;%&gt;--%>
    <%--&lt;%&ndash;)&ndash;%&gt;--%>
    <%--&lt;%&ndash;$("#send-forgot-password").click(function (e) {&ndash;%&gt;--%>
        <%--&lt;%&ndash;e.preventDefault();&ndash;%&gt;--%>
        <%--&lt;%&ndash;$("#modal-forgot-password").modal('hide');&ndash;%&gt;--%>
        <%--&lt;%&ndash;$.ajax({&ndash;%&gt;--%>
            <%--&lt;%&ndash;type: "POST",&ndash;%&gt;--%>
            <%--&lt;%&ndash;data: {sendEmail: $("#input-email-forgot-password").val()},&ndash;%&gt;--%>
            <%--&lt;%&ndash;url: "${pageContext.request.contextPath}/sendPassword",&ndash;%&gt;--%>
            <%--&lt;%&ndash;success: function (resp) {&ndash;%&gt;--%>
                <%--&lt;%&ndash;if (resp) {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#message-success-send-email").fadeIn(500);&ndash;%&gt;--%>
                    <%--&lt;%&ndash;setTimeout(function () {&ndash;%&gt;--%>
                        <%--&lt;%&ndash;$("#message-success-send-email").fadeOut(1000)&ndash;%&gt;--%>
                    <%--&lt;%&ndash;}, 2000);&ndash;%&gt;--%>
                <%--&lt;%&ndash;} else {&ndash;%&gt;--%>
                    <%--&lt;%&ndash;$("#message-fail-send-email").fadeIn(500);&ndash;%&gt;--%>
                    <%--&lt;%&ndash;setTimeout(function () {&ndash;%&gt;--%>
                        <%--&lt;%&ndash;$("#message-fail-send-email").fadeOut(1000)&ndash;%&gt;--%>
                    <%--&lt;%&ndash;}, 2000);&ndash;%&gt;--%>
                <%--&lt;%&ndash;}&ndash;%&gt;--%>
            <%--&lt;%&ndash;}&ndash;%&gt;--%>
        <%--&lt;%&ndash;})&ndash;%&gt;--%>
    <%--&lt;%&ndash;})&ndash;%&gt;--%>
<%--&lt;%&ndash;</script>&ndash;%&gt;--%>


</body>
</html>
