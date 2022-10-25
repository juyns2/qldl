<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "jp" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<nav class="navbar navbar-expand-lg fixed-top" style="background-color: #ad1c84">
    <div class="container-fluid">
        <image src="data:image/jpeg;base64,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" style="height: 60px; width: 120px; padding: 0px;">
        <div class="fonthome" ><a class="navbar-brand mx-3 fw-normal fs-2 " id="homefont" href="<c:url value="/home/tour" />">Home</a></div>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse fw-normal" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 mx-5" id="fontnavbar">

                <li class="nav-item" >
                    <a class="nav-link active" href="#">NEWS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="#">TOUR</a>
                </li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Employee
                        </a>
                        <div class="dropdown-menu">
                            <c:forEach var="j" items="${mngEmp}">
                                <c:url value="/emp/showinfo" var="cUrl">
                                    <c:param name="mngEmpId" value="${j.id}" />
                                    <c:param name="empType" value="${j.type}" />
                                </c:url>
                                <a class="dropdown-item" href="${cUrl}">${j.id} - ${j.type}</a>
                            </c:forEach>
                        </div>
                    </li>
                </sec:authorize>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        Places
                    </a>
                    <div class="dropdown-menu">
                        <c:forEach var="j" items="${place}">
                            <c:url value="/home/tour" var="cUrl">
                                <c:param name="placeId" value="${j.id}" />
                                <c:param name="placeName" value="${j.name}" />
                            </c:url>
                            <a class="dropdown-item" href="${cUrl}">${j.id} - ${j.name}</a>
                        </c:forEach>
                    </div>
                </li>

            </ul>
            <div class="  " style="padding-top: 7px">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <div class="float-right">
                        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" id="tab-login" data-mdb-toggle="pill" href="<c:url value="/user/login" />" role="tab"
                                   aria-controls="pills-login" aria-selected="true"><i class="bi bi-person-circle"></i> Login</a>
                            </li>
                            <li class="nav-item" role="presentation">
                                <a class="nav-link active" id="tab-register" data-mdb-toggle="pill" href="<c:url value="/user/register"/>"   role="tab"
                                   aria-controls="pills-register" aria-selected="false"><i class="bi bi-person-plus-fill"></i> Register</a>
                            </li>
                        </ul>
                    </div>

                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <div class="dropdown">
                        <button class=" dropdown-toggle" type="button" id="btn-drop" data-bs-toggle="dropdown" aria-expanded="false">
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                           <label>Admin: </label></sec:authorize>
                           <i class="bi bi-person-circle"></i> ${currentUser.fullName}
                        </button>
                        <ul class="dropdown-menu" >
                            <li class="dropdown-item"> 
                                <a class="tablogin" data-mdb-toggle="pill" href="<c:url value="/" />" role="tab"
                                   aria-controls="pills-login" aria-selected="true"><i class="bi bi-person-lines-fill"></i>  Profile</a></li>
                            <li class="dropdown-item">
                                <a class="tablogin" data-mdb-toggle="pill" href="<c:url value="/logout" />" role="tab"
                                   aria-controls="pills-login" aria-selected="true"><i class="bi bi-person-x"></i>  Logout</a></li>
                            <li class="dropdown-item">
                                <a class="tablogin" href="<c:url value="/order" />"><i class="bi bi-cart-check-fill"></i>  Order <span class="badge badge-danger" >${totalNumOrder}</span></a>
                            </li>
                        </ul>
                    </div>
                </c:if>
            </div>
            <form class="d-flex" role="search">
                <input class="form-control d-inline" type='text' name='kw' placeholder="Please Input kw to find"/>
                <button class="btn btn-outline-success" type="submit" style="color: white; background-color: #ED2173;margin-left: 5px;">Search</button>
            </form>
        </div>
    </div>
</nav>
<div style="height: 76px"></div>



