<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>x

<h1 class="text-center text-danger"> KHU VUC DU LICH </h1>
<a href="<c:url value="/admin/addTour"/>"><button>Add Place</button></a>

<div class="row">
    <c:forEach var="tour" items="${prod}"> 
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
                <h4>${tour.price}</h4>
                <h5>Detail | <a id="${tour.id}" href="<c:url value="/edit/${tour.id}"/>">${tour.id}. Edit</a></h5>
            </div> 
        </div>
    </c:forEach> 
</div>
