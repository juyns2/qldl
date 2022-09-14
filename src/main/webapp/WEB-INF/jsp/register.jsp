<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<c:url value="/register" var="action" />

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<formj:form method="post" action="${action}" modelAttribute="user">
    <div class="form-group">
        <label for="FirstName">First Name</label>
        <formj:input type="text" id="firstname" path="firstName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <!--<input type="text" id="username" name="username" class="form-control"/>-->
        <formj:input type="text" id="username" path="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <formj:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Create User" class="form-control"/>
    </div>
</formj:form>