<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<c:url value="/user/register" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>
<h1 style="text-align: center">Register</h1>
<formj:form method="post" action="${action}" modelAttribute="user">
    <div  id="dangky">

        <div class="form-group--userRe">
            <label class="label--register" for="FirstName">First Name</label>
            <formj:input type="text" id="firstname" path="firstName" class="form-control"/>
        </div>
        <div class="form-group--userRe">
            <label class="label--register" for="username">Username</label>
            <!--<input type="text" id="username" name="username" class="form-control"/>-->
            <formj:input type="text" id="username" path="username" class="form-control" value="" autocomplete="nope"/>
        </div>
        <div class="form-group--userRe  ">
            <label class="label--register" for="password">Password</label>
            <formj:input type="password" id="password" path="password" class="form-control" autocomplete="new-password"/>
        </div>
        <div class="form-group--submit">
            <input type="submit" value="Create User" class="form-control" style="background-color: #0000EE; color: white">
            <a href="<c:url value="/user/login" />"> Login</a>
        </div>
        
    </div>
</formj:form>