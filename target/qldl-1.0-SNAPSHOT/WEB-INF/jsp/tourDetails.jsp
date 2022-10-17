<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-6">
        <c:choose>
            <c:when test="${tourId.image_url != null && tourId.image_url.startsWith('https') == true}">
                <img class="card-img-top img-fluid" src="${tourId.image_url}" alt="${tourId.name}"/>
            </c:when>
            <c:when test="${tourId.image_url == null && tourId.image_url.startsWith('https') == false}">
                <img class="card-img-top img-fluid" src="<c:url value="/js/bandovn.png" />" alt="${tourId.name}" />
            </c:when>
        </c:choose>
    </div>
    <div class = "col-md-6">
        <h1>${tourId.name}</h1>
    </div>
</div>

<br><br>
<!--<form>-->
    <div class = "form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhap danh gia cua ban..."></textarea>
        <br>
        <input type="button" value ="Send Comment" onclick="addComment(${tourId.id}, ${currentUser.id})" class ="btn btn-danger" />
    </div>
<!--</form>-->

<div id="commentArea">
    <c:forEach var = "j" items="${tourId.commentCol}">
        <div class="row" style="padding-bottom: 40px;">
            <div class="col-md-1">
                <img class="rounded-circle img-fluid" src="<c:url value="/images/img_no.png"/>" />
            </div>
            <div class="col-md-10 my-date-j">
                ${j.idUser.username} _ id: ${j.idUser.id} | UserCurrent: ${pageContext.request.userPrincipal.name} _ id: ${currentUser.id}_${currentUser.username}<br>
                ${j.content} <br>
                <i>${j.postDate}</i>
            </div>
        </div>
    </c:forEach>
</div>




