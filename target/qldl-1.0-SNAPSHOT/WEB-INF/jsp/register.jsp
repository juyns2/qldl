<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<c:url value="/user/register" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<h1 style="text-align: center">Register</h1>
<formj:form method="post" action="${action}" modelAttribute="user" autocomplete="off">
    <div  id="dangky">

        <div class="form-group--userRe">
            <label class="label--register" for="FirstName">First Name</label>
            <formj:input type="text" id="fullName" path="fullName" class="form-control" tabindex="1"/>
        </div>
        <div class="form-group--userRe">
            <label class="label--register" for="username">Username</label>
            <!--<input type="text" id="username" name="username" class="form-control"/>-->
            <formj:input type="text" id="username" path="username" class="form-control" value="" autocomplete="nope" tabindex="2"/>
        </div>
        <%--        <div class="form-group--userRe">
                    <label class="label--register" for="password">Password</label>
                    <formj:input type="password" id="password" path="password" class="form-control" autocomplete="new-password"/>
                </div>--%>
        <div class="form-group--userRe">
            <label class="label--register" for="password">Password</label>
            <div class="input-group" id="show_hide_password">
                <formj:input type="password" id="passj" path="password" class="form-control" autocomplete="new-password" tabindex="3"/>
                <div class="input-group-addon">
                    <a href=""><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <div class="form-group--userRe">
            <label class="label--register" for="password">Confirm Password</label>
            <div class="input-group" id="confirm_password">
                <input class="form-control" type="password" id="conf_pass" autocomplete="off" tabindex="4">
                <div class="input-group-addon">
                    <a href=""><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                </div>
            </div>
        </div>
        <span id='message'></span>
        <div class="form-group--submit">
            <input type="submit" id="signup_button" value="Create User" class="form-control" style="background-color: #0000EE; color: white">
            <a href="<c:url value="/user/login" />" id="signup_bt"> Login</a>
        </div>

    </div>
</formj:form>
