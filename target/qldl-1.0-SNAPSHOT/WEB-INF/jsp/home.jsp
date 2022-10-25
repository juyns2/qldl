<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "jp" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/admin/addTour" var="url"/>
<c:url value="/home/tour" var="url_p"/>
<c:set var="num_page" value="${Math.toIntExact(count/12)}" />
<c:set var="indexTour" value="1"/>
<%--<jp:parseNumber var = "num_page" type = "number" value = "${num_page}" />--%>

<c:if test="${count/12 < Math.ceil(count/12)}">
    <c:set var="num_page" value="${num_page + 1}" />
</c:if>

<div class="d-inline-block">
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active"  >
                <img src="https://dulichviet.com.vn/images/bandidau/banner/BANNER-TET/noidia-tet-web-2(1).jpg"   class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://dulichviet.com.vn/images/bandidau/banner/BANNER-TET/noidia-tet-web-2(1).jpg" class="d-block w-100" alt="...">
            </div>
            <div class="carousel-item">
                <img src="https://dulichviet.com.vn/images/bandidau/banner/BANNER-TET/noidia-tet-web-2(1).jpg" class="d-block w-100" alt="...">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>




    <div class="container-fluid d-flex justify-content-evenly" id="divtour">

        <button type="button" onclick="location.href = '${cUrl}';" class="btntour" >
            <c:url value="/home/tour" var="cUrl">
                <c:param name="placeId" value="2" />
                <c:param name="placeName" value="${tourType.name}" />
            </c:url>
            <i class="bi bi-globe" style="color: blue"></i> Du lịch <span class="fontbt">TRONG NƯỚC</span>
        </button>

        <button type="button" onclick="location.href = '${cUrl}';" class="btntour" >
            <c:url value="/home/tour" var="cUrl">
                <c:param name="placeId" value="1" />
                <c:param name="placeName" value="${j.name}" />
            </c:url>
            <i class="bi bi-globe" style="color: red"></i> Du lịch <span class="fontbt">NƯỚC NGOÀI</span>
        </button>

        <button type="button" onclick="location.href = '${cUrl}';" class="btntour" >
            <c:url value="/home/tour" var="cUrl">
                <c:param name="placeId" value="4" />
                <c:param name="placeName" value="${j.name}" />
            </c:url>
            <i class="bi bi-pin-map-fill" style="color: #9C4682"></i> Du lịch <span class="fontbt">MIỀN BẮC</span>
        </button>

        <button type="button" onclick="location.href = '${cUrl}';" class="btntour" >
            <c:url value="/home/tour" var="cUrl">
                <c:param name="placeId" value="4" />
                <c:param name="placeName" value="${j.name}" />
            </c:url>
            <i class="bi bi-pin-map-fill" style="color: #4EF54E"></i> Du lịch <span class="fontbt">MIỀN NAM</span>
        </button>


    </div>
    <div class="d-inline-block">
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="homeadd">
                <a href="${url}"><button> <i class="bi bi-plus"></i> Add Place</button></a>    
            </div>
        </div>
    </sec:authorize>

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
                        <img class="img-fluid rounded" src="<c:url value='${tour.image_url}' />" onerror="this.onerror=null; this.src='<c:url value='/images/Travel2.png' />'" alt='${tour.name}' />
                    </c:if>
                    <c:if test="${tour.image_url == null || tour.image_url.contains('ddq8il5ve') == false}">
                        <img class="img-fluid rounded" src="<c:url value='/images/pic3.jpg' />" alt='${tour.name}' />
                    </c:if>
 </a>

                </div> 
                <a href="<c:url value="/tourDetails/${tour.id}" />" class="atour">
                    <div class="" style="background-color: ">
                        <div class='card-footer '>
                            <label class="fontlb"  style="display: block;"><i class="bi bi-shop-window"></i> Địa điểm: <span id="fontname">${tour.name}</span>  </label>

                            <label  class="fontlb"  style="display: block;"><i class="bi bi-calendar-check"></i> Lịch trình:<span id="fontcale"> ${tour.name}</span> </label>

                            <label class="fontlb"  style="display: block;;"><i class="bi bi-alarm"></i> Khởi hành: <span id="fonttime"></span> </label>

                            <label class="fontlb"  style="display: block;"> <i class="bi bi-currency-dollar"></i> Giá: <span id="priceTour${indexTour}" class="fontprice priceTour"> ${tour.price}</span></label>


                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <div class="editlogin">
                                    <h5> <a class="editlogin1" id="${tour.id}" href="<c:url value="/edit/${tour.id}"/>"> Edit</a>
                                    </h5>    
                                </div>
                            </sec:authorize>
                        </div>
                    </div> 
                </a>

            </div>
            <c:set var="indexTour" value="${indexTour+1}"/>
        </c:forEach> 
    </div>



