<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-center text-danger" style="margin-bottom: 50px; margin-top: 30px;">${empType}</h1>

<div class="add-empl"><a href="<c:url value="/emp/add${j.id}"/>"><button> <i class="bi bi-plus"></i> Thêm nhân viên mới</button></a></div>
<div class=" container row" id="emplcenter">

    <c:forEach var="j" items="${emp}"> 
        <div class="card col-md-3" id="impbg"> 
            <div class="card-body text-center" id="imgemp">
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
            <hr>
            <div class='empl'>

                <label >Họ và Tên: ${j.fullName}</label>
                <label>Giới tính: ${j.gioiTinh.type} </label>
                <label style="margin-bottom: 5px;">Chức vụ: ${j.position.type}</label>
                <a class="editlogin1" id="${j.id}" href="<c:url value="/emp/detail/${j.id}"/>"> Chi tiết</a>
                 <a class="editlogin1" id="${j.id}" href="<c:url value="/emp/detail/${j.id}"/>">  Chỉnh sửa</a>
            </div> 
        </div>
    </c:forEach> 
</div>
