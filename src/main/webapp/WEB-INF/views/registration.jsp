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
<body>
<!-- Navigation -->
<jsp:include page="templates/navigation.jsp"/>
<%--<a href="timetableList">json timetable list</a><br/>--%>
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
        <li class="breadcrumb-item active">Registration</li>
    </ol>
</div>







<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input required="required" type="text" path="firstName" placeholder="First Name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="text" path="lastName"  placeholder="Last Name"
                ></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>



        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  type="date" path="birthday" value="2000-06-01"
                             max="2017-06-01" min="1920-05-29"
                ></form:input>
                <form:errors path="birthday"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="text" path="email" placeholder="Email"
                             onblur="onBlurEmailFunction(this)"></form:input>
                <form:errors path="email"></form:errors>
                    <%--<form:errors id="emailExists"></form:errors>--%>
                <div id="emailExists" class="has-error"></div>
            </div>
        </spring:bind>


        <spring:bind path="login">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input required="required"  type="text" path="login"  placeholder="Login"
                             onblur="onBlurLoginFunction(this)"></form:input>
                <form:errors path="login"></form:errors>
                    <%--<form:errors id="loginExists"></form:errors>--%>
                <div id="loginExists" class="has-error"></div>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input required="required"  type="password" path="password"  placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary " type="submit"
                id="submit-registration">Submit</button>
    </form:form>

</div>
<script>
    function checkParams() {
        var loginError = document.getElementById('loginExists').innerHTML;
        var emailError = document.getElementById('emailExists').innerHTML;

        if(loginError.length !== 0 || emailError.length !== 0) {
            $('#submit-registration').removeAttr('active');
            $('#submit-registration').attr('disabled', 'disabled');
        } else {
            $('#submit-registration').removeAttr('disabled');
            $('#submit-registration').attr('active', 'active');
        }
    }

    function onBlurEmailFunction(obj){
        var email = obj.value;
        $.ajax({
            type: "POST",
            data: {email : email},
            url: "$findEmail/",
            success: function (msg) {
                $("#emailExists").html(msg);
                checkParams();
            }
        })

    };

    function onBlurLoginFunction(obj) {
        var login = obj.value;
        $.ajax({
            type: "POST",
            data: {login : login},
            url: "${pageContext.request.contextPath}/registration/findLogin/",
            success: function (msg) {
                $("#loginExists").text(msg);
                checkParams();
            }
        })

    }
</script>




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