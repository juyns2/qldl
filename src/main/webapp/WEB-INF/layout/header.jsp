<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="">
    <div id="jtop" class="d-block">
        <div class="float-left">
            <form action="">
                <div class="form-group">
                    <input class="form-control d-inline" type='text' name='kw' placeholder="Please Input kw to find"/>
                    <input type='submit' value='search' class='btn btn-danger d-inline' />
                </div>
            </form>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <div class="float-right">
                <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="<c:url value="/login" />" role="tab"
                           aria-controls="pills-login" aria-selected="true">Login</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" id="tab-register" data-mdb-toggle="pill" href="<c:url value="/register"/>"   role="tab"
                           aria-controls="pills-register" aria-selected="false">Register</a>
                    </li>
                </ul>
            </div>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div class="float-right">
                <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="<c:url value="/" />" role="tab"
                           aria-controls="pills-login" aria-selected="true">${pageContext.request.userPrincipal.name}</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="<c:url value="/logout" />" role="tab"
                           aria-controls="pills-login" aria-selected="true">Logout</a>
                    </li>
                </ul>
            </div>
        </c:if>
    </div>
</div>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="<c:url value="/home/tour" />">HOME</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#jtop">NEWS</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">TOUR</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Employee</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">#</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Places
            </a>
            <div class="dropdown-menu">
                <c:forEach var="j" items="${place}">
                    <a class="dropdown-item" href="#">${j.id} - ${j.name}</a>
                </c:forEach>
            </div>
        </li>
        <li>
            ${pageContext.request.userPrincipal.name}
        </li>
    </ul>
</nav>

