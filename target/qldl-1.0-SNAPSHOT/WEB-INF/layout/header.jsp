<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-expand-lg fixed-top" style="background-color: #ad1c84">
    <div class="container-fluid">
        <a class="navbar-brand mx-3 fw-normal fs-2 " id="fonthome" href="<c:url value="/home/tour" />">Home</a>
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
                            <i class="bi bi-person-circle"></i> ${pageContext.request.userPrincipal.name}
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
<div style="height: 90px"></div>




