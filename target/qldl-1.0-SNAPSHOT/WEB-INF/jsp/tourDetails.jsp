<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "jp" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url value="/admin/addTour" var="url"/>
<c:url value="/home/tour" var="url_p"/>
<c:set var="num_page" value="${Math.toIntExact(count/6)}" />
<c:set var="indexTour" value="1"/>
<div class="row container">

    <div class="col-md-8"  >
        <div class="emp-tourdetail">
            <c:choose>
                <c:when test="${tourId.image_url != null && tourId.image_url.startsWith('https') == true}">
                    <img class="card-img-top img-fluid" src="${tourId.image_url}" alt="${tourId.name}"/>
                </c:when>
                <c:when test="${tourId.image_url == null && tourId.image_url.startsWith('https') == false}">
                    <img class="card-img-top img-fluid" src="<c:url value="/js/bandovn.png" />" alt="${tourId.name}" />
                </c:when>
            </c:choose>
        </div>
    </div>
    <div class = "col-md-4" >
        <div class="emp-info"  ">

            <h1>${tourId.name} <span class="tourdt-time">${tourId.timetour}</span></h1>
            <hr>
            <label>Thời gian:   ${tourId.timetour} </label>
            <hr>
            <label>Khởi hành:   ${tourId.time_start} </label>
            <hr>
            <label>Xuất phát:   ${tourId.place_start} </label>

        </div>
        <div class="emp-price">
            <label>Giá từ:<span class="emp-fontprice"> ${tourId.price} </span>đ</label>
        </div>
    </div>

</div>
<br><br>
<hr>
<div class="tourdt-content container" style="height: 500px;   ">
    <div class="row">
        <div class="col-md-7">
            <div>
                <h4>Hành trình</h4>
                <hr><!-- comment -->
            </div>
            <div>
                <label class="tourdt-lb"> Địa điểm:</label><p class="tourdt-lb2">${tourId.name}</p><br>
                <label class="tourdt-lb"> Lịch trình:</label> <p class="tourdt-lb2">${tourId.timetour}</p>  <br>
                <label class="tourdt-lb"> Điểm khởi hành   </label><p class="tourdt-lb2">${tourId.place_start}</p><br>
            </div>
            <div class="tour-ct">
                <i>${tourId.content}</i>
            </div>
        </div>
        <div class="col-md-5" id="tourdt-bonus">
            <div class="tourdt-tilte">
                TOUR THAM KHẢO
            </div>
            <div class="tourdt-img">
                <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="true">

                    <div class="carousel-inner" id="tourdt-bg">

                        <div class="carousel-item active">
                            <img  src="<c:url value=' ${t[0].image_url}'/>" class="d-block w-100" style="width: 300px; height: 300px; " alt="...">
                            <label class="tourdt-lb3">${t[0].name} | <span class="tour-fp">${t[0].time}</span></label><p class="tourdt-lb4"> Giá chỉ từ: <span class="tourdt-fontp">${t[0].price}</span>đ</p><br>
                        </div>

                        <c:forEach begin="1" end="10" var="j">
                            <div class="carousel-item">
                                <img  src="<c:url value=' ${t[j].image_url}'/>"  style="width: 300px; height: 300px;" class="d-block w-100" alt="...">
                                 <label class="tourdt-lb3">${t[1].name} <span class="tour-fp">${t[1].time}</span></label><p class="tourdt-lb4"> Giá chỉ từ: <span class="tourdt-fontp">${t[1].price}</span>đ</p><br>
                        
                            </div>
                        </c:forEach>



                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
                <div>
                     

                </div>



            </div>
        </div>
    </div>
</div>




<div class="container"><h4>Bình luận:</h4></div>
<div class="container" id="tour-comment">
    <!--<form>-->
    <div class = "form-group">
        <textarea class="form-control" id="commentId" placeholder="Nhập đánh giá của bạn..."></textarea>
        <br>
        <input type="button" value ="Send Comment" onclick="addComment(${tourId.id}, ${currentUser.id})" class ="btn btn-danger" />
    </div>
    <!--</form>-->
    <div id="commentArea">
        <c:forEach var = "j" items="${tourId.commentCol}">
            <hr>
            <div class="row" style="padding-bottom: 30px;">
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
</div>




