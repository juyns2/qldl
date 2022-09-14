<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/admin/addTour" var="url"/>
<c:url value="/home/tour" var="url_p"/>
<c:set var="num_page" value="${Math.ceil(count/6)}" />

<h1 class="text-center text-danger"> KHU VUC DU LICH </h1>

<div class="d-inline-block">
    <div class="float-left">
        <a href="${url}"><button>Add Place</button></a>    
    </div>
    <div class="float-right">
        ${count} | ${num_page} | ${page}
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="${url_p}/?page=1"><<</a></li>
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page-1}"><</a></li>
                <c:if test ="${page == 1 || page == 2 || page == null}">
                <li class="page-item"><a class="page-link" href="${url_p}/?page=1">1</a></li>
                <li class="page-item"><a class="page-link" href="${url_p}/?page=2">2</a></li>
                <li class="page-item"><a class="page-link" href="${url_p}/?page=3">3</a></li>
                </c:if>
                <c:if test ="${page > 2 && page <= num_page}">
                <li class="page-item"><a class="page-link" href="${url_p}/?page=${page - 1}">${page - 1}</a></li>
                <li class="page-item"><a class="page-link" href="${url_p}/?page=${page}">${page}</a></li>
                <li class="page-item"><a class="page-link" href="${url_p}/?page=${page + 1}">${page + 1}</a></li>
                </c:if>

            <li class="page-item"><a class="page-link" href="${url_p}/?page=${page+1}">></a></li>
            <li class="page-item"><a class="page-link" href="${url_p}/?page=${num_page}">>></a></li>
        </ul>
    </div>
</div>

<div class="row">
    <c:forEach var="tour" items="${tour}"> 
        <div class="card col-md-4"> 
            <div class="card-body text-center">
                <c:if test="${tour.image_url != null && tour.image_url.contains('ddq8il5ve') == true}">
                    <img class="img-fluid rounded" src="<c:url value='${tour.image_url}' />" alt='${tour.name}' />
                </c:if>
                <c:if test="${tour.image_url == null || tour.image_url.contains('ddq8il5ve') == false}">
                    <img class="img-fluid rounded" src="<c:url value='images/pic3.jpg' />" alt='${tour.name}' />
                </c:if>
            </div> 
            <div class='card-footer text-center'>
                <h3>${tour.name}</h3> 
                <h4>${tour.price} | ${tour.khuvuc}</h4>
                <h5>Detail | <a id="${tour.id}" href="<c:url value="/edit/${tour.id}"/>">${tour.id}. Edit</a></h5>
            </div> 
        </div>
    </c:forEach> 
</div>
