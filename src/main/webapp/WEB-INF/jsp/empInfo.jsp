<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-danger">${empType}</h1>

<div class="row">
    <c:forEach var="j" items="${emp}"> 
        <div class="card col-md-4"> 
            <div class="card-body text-center">
                <c:if test="${j.gioiTinh.id == 1}">
                    <img class="img-fluid rounded rounded-circle" src="<c:url value='/images/img_male.png' />" alt='' />
                </c:if>
                <c:if test="${j.gioiTinh.id == 2}">
                    <img class="img-fluid rounded" src="<c:url value='/images/img_female.png' />" alt='' />
                </c:if>
                <c:if test="${j.gioiTinh.id != 1 && j.gioiTinh.id != 2}">
                    <img class="img-fluid rounded" src="<c:url value='/images/img_no.png' />" alt='' />
                </c:if>
            </div> 
            <div class='card-footer text-center'>
                <h4>${j.fullName} | ${j.gioiTinh.type} | ${j.position.type}</h4>
            </div> 
        </div>
    </c:forEach> 
</div>
