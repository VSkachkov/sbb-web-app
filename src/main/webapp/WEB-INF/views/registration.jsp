<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<html lang="en">
<head>
    <%--<title>Registration</title>--%>
</head>
<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input required="required" type="text" path="firstName" class="form-control" placeholder="First Name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="text" path="lastName" class="form-control" placeholder="Last Name"
                ></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>



        <spring:bind path="birthday">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="date" path="birthday" class="form-control" value="2000-06-01"
                             max="2017-06-01" min="1920-05-29"
                ></form:input>
                <form:errors path="birthday"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="text" path="email" class="form-control" placeholder="Email"
                             onblur="onBlurEmailFunction(this)"></form:input>
                <form:errors path="email"></form:errors>
                    <%--<form:errors id="emailExists"></form:errors>--%>
                <div id="emailExists" class="has-error"></div>
            </div>
        </spring:bind>


        <%--<spring:bind path="login">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input  required="required" type="text" path="login" class="form-control" placeholder="Login"--%>
                             <%--onblur="onBlurLoginFunction(this)"></form:input>--%>
                <%--<form:errors path="login"></form:errors>--%>
                    <%--&lt;%&ndash;<form:errors id="loginExists"></form:errors>&ndash;%&gt;--%>
                <%--<div id="loginExists" class="has-error"></div>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input  required="required" type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <%--<spring:bind path="confirmPassword">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input  required="required" type="password" path="confirmPassword" class="form-control"--%>
                             <%--placeholder="Confirm your password"></form:input>--%>
                <%--<form:errors path="confirmPassword"></form:errors>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <button class="btn btn-lg btn-primary btn-block" type="submit"
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
            url: "${pageContext.request.contextPath}/registration/findEmail/",
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
</body>
</html>
