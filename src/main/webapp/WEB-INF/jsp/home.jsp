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

<h1 class="text-center text-danger"> KHU VUC DU LICH </h1>
<c:if test="${pic == null}">
    <p>pic null</p>
</c:if>
<c:if test="${pic != null}">
    <p>pic != null</p>
</c:if>
<c:if test="${pic > 0}">
    <p>Pic > 0 => Have Pic</p>
</c:if>
<c:if test="${pic == 0}">
    <p>Pic == 0 => No Pic</p>
</c:if>
<p>is_ ${pic}</p>


<div class="d-inline-block">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="float-left">
            <a href="${url}"><button>Add Place</button></a>    
        </div>
    </sec:authorize>
    <div class="float-right">
        ${count} | ${num_page} | ${page} | a = ${a} | ${count/6} _ ${Math.ceil(count/6)} | userId: ${currentUser} _ ${currentUser.id}
        <ul class="pagination">
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
</div>

<div class="row">
    <c:forEach var="tour" items="${tour}"> 
        <div class="card col-md-4"> 
            <div class="card-body text-center">
                <a href="<c:url value="/tourDetails/${tour.id}" />">
                    <c:if test="${tour.image_url != null && tour.image_url.contains('ddq8il5ve') == true}">
                        <img class="img-fluid rounded" src="<c:url value='${tour.image_url}' />" alt='${tour.name}' />
                    </c:if>
                    <c:if test="${tour.image_url == null || tour.image_url.contains('ddq8il5ve') == false}">
                        <img class="img-fluid rounded" src="<c:url value='images/pic3.jpg' />" alt='${tour.name}' />
                    </c:if>
                </a>
            </div> 
            <div class='card-footer text-center'>
                <h3>${tour.name}</h3> 
                <h4><span id="priceTour${indexTour}" class="priceTour">${tour.price}</span> | ${tour.khuvuc.name}</h4>
                <h5>Detail | <a id="${tour.id}" href="<c:url value="/edit/${tour.id}"/>">${tour.id}. Edit</a>
                    | <a href="javascript:;" class="btn btn-danger" onclick="addToOrder(${tour.id})">Order</a>
                </h5>
            </div> 
        </div>
        <c:set var="indexTour" value="${indexTour+1}"/>
    </c:forEach> 
</div>
