<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "jp" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/admin/addTour" var="url"/>
<c:url value="/home/tour" var="url_p"/>
<c:set var="num_page" value="${Math.toIntExact(count/6)}" />
<c:set var="indexTour" value="1"/>
<%--<jp:parseNumber var = "num_page" type = "number" value = "${num_page}" />--%>

<c:if test="${count/6 < Math.ceil(count/6)}">
    <c:set var="num_page" value="${num_page + 1}" />
</c:if>

<h1 class="text-center text-danger"> LIST OF TOURS </h1>
<div class="d-inline-block">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="float-left">
            <a href="${url}"><button>Add Place</button></a>    
        </div>
    </div>
</sec:authorize>

<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="C:\Users\Lenovo\Desktop\Travel2.png" alt="Los Angeles" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="chicago.jpg" alt="Chicago" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="ny.jpg" alt="New York" class="d-block w-100">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>




    <div class="container-fluid d-flex justify-content-evenly" id="divtour">
    
        <button class="btntour"><i class="bi bi-globe" style="color: red"></i> Du lịch <span class="fontbt">NƯỚC NGOÀI</span></button>
        <button class="btntour"><i class="bi bi-geo-alt-fill" style="color: blueviolet;"></i>Du lịch <span class="fontbt">TRONG NƯỚC</span></button>
        <button class="btntour"><i class="bi bi-pin-map-fill" style="color: #9C4682"></i> Du lịch <span class="fontbt">MIỀN BẮC</span></button>
        <button class="btntour"><i class="bi bi-pin-map-fill" style="color: #4EF54E"></i> Du lịch <span class="fontbt">MIỀN NAM</span></button>
   
</div>

<div class="d-flex justify-content-center ">

    <ul class="pagination ">
        <li class="page-item"><a class="page-link" href="${url_p}/?page=1"><<</a></li>
            <c:if test="${page > 1}">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page-1}"><</a></li>
            </c:if>
            <c:if test ="${page == 1 || page == 2 || page == null}">
            <li class="page-item" id=""><a class="page-link" href="${url_p}/?page=1">1</a></li>
            <li class="page-item" id=""><a class="page-link" href="${url_p}/?page=2">2</a></li>
            <li class="page-item" id=""><a class="page-link" href="${url_p}/?page=3">3</a></li>
            </c:if>
            <c:if test ="${page > 2 && page < num_page}">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page - 1}">${page - 1}</a></li>
            <li class="page-item" style="background-color:red"><a class="page-link" href="${url_p}/?page=${page}">${page}</a></li>
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page + 1}">${page + 1}</a></li>
            </c:if>
            <c:if test ="${page == num_page}">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page - 2}">${page - 2}</a></li>
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page - 1}">${page - 1}</a></li>
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page}">${page}</a></li>
            </c:if>
            <c:if test="${page < num_page}">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page + 1}">></a></li>
            </c:if>
            <c:if test="${page == null}">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=2">></a></li>
            </c:if>
        <li class="page-item"><a class="page-link" href="${url_p}/?page=${num_page}">>></a></li>
    </ul>

</div>
<div class="row " id="marginlist"  >
    <c:forEach var="tour" items="${tour}"> 
        <div class="  card col-md-4" id="listtour"> 
            <div class="card-body text-center">
                <a href="<c:url value="/tourDetails/${tour.id}" />" class="ahover">
                    <c:if test="${tour.image_url != null && tour.image_url.contains('ddq8il5ve') == true}">
                        <img class="img-fluid rounded" src="<c:url value='${tour.image_url}' />" alt='${tour.name}' />
                    </c:if>
                    <c:if test="${tour.image_url == null || tour.image_url.contains('ddq8il5ve') == false}">
                        <img class="img-fluid rounded" src="<c:url value='images/pic3.jpg' />" alt='${tour.name}' />
                    </c:if>
                </a>
            </div> 
            <a href="<c:url value="/tourDetails/${tour.id}" />" class="atour">
                <div class="" style="background-color: ">
                    <div class='card-footer '>
                        <label class="fontlb"  style="display: block;"><i class="bi bi-shop-window"></i> Địa điểm: <span id="fontname">${tour.name}</span>  </label>

                        <label  class="fontlb"  style="display: block;"><i class="bi bi-calendar-check"></i> Lịch trình:<span id="fontcale"> ${tour.name}</span> </label>

                        <label class="fontlb"  style="display: block;;"><i class="bi bi-alarm"></i> Khởi hành: <span id="fonttime"></span> </label>

                        <label class="fontlb"  style="display: block;"> <i class="bi bi-currency-dollar"></i> Giá: <span id="fontprice"> ${tour.price}</span> VND  </label>


                        <h5>Detail | <a id="${tour.id}" href="<c:url value="/edit/${tour.id}"/>">${tour.id}. Edit</a>

                        </h5>
                    </div>
            </a>
        </div> 
    </div>
    <c:set var="indexTour" value="${indexTour+1}"/>
</c:forEach> 
</div>



