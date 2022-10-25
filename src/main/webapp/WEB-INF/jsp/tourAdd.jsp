<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="prof" uri="http://www.springframework.org/tags" %>

<h2 class="text-center text-danger">ADD TOUR</h2>
<div class="fromaaddtour">
    <formj:form method="post" action="/qldl/admin/addTour" modelAttribute="tour" enctype="multipart/form-data"> 
        <div class="form-group"> 
            <label for="name">Ten</label> 
            <formj:input type="text" id="name" path="name" cssClass="form-control" /> 
        </div>

        <div class="form-group"> 
            <label for="cate">Khu Vực</label>
            <formj:select id="place" path="khuvuc" cssClass="form-control">
                <c:forEach var="j" items="${place}">
                    <option value="${j.id}">${j.name}</option>
                </c:forEach>
            </formj:select>
        </div>
         <div class="form-group"> 
            <label for="cate">Loại Tour</label>
            <formj:select id="place" path="khuvuc" cssClass="form-control">
                <c:forEach var="j" items="${tourtype}">
                    <option value="${j.id}">${j.name}</option>
                </c:forEach>
            </formj:select>
        </div>
        <div class="form-group"> 
            <label for="price">Giá</label> 
            <formj:input type="text" id="price" path="price" cssClass="form-control" placeholder="VNĐ" />
            <formj:errors path="price" cssClass="alert alert-danger" element="div" />
        </div>


        <div class="form-group"> 
            <label for="price">Địa điểm khởi hành</label> 
            <formj:input type="text" id="price" path="place_start" cssClass="form-control" />
            <formj:errors path="place_start" cssClass="alert alert-danger" element="div" />
        </div>
<%--        <div class="form-group"> 
            <label for="price">Thời gian khởi hành</label> 
            <formj:input type="date" id="timestart" path="time_start" cssClass="form-control" />
            <formj:errors path="time" cssClass="alert alert-danger" element="div" />
        </div>--%>
        <div class="form-group"> 
            <label for="price">Thông tin Tour</label> 
            <formj:textarea type="text" id="content" path="content" cssClass="form-control" />
            <formj:errors path="content" cssClass="alert alert-danger" element="div" />
        </div>



        <label>Hình ảnh:</label>
        <div class="form-group d-flex align-items-center justify-content-center"> 
            <div class="d-block">
                <div class="img_bor d-flex align-items-center justify-content-center">
                    <img class="img-thumbnail img_sel" id="output"/>
                </div>

                <div class="input-group">

                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                    </div>

                    <div class="custom-file">

                        <formj:input type="file" class="custom-file-input" id="file" path="img" accept="image/*" onchange="loadFile(event)"
                                     aria-describedby="inputGroupFileAddon01"/>
                        <label class="custom-file-label" for="inputGroupFile01" style="margin-left: 0px; width: 324px;">Choose file</label>
                    </div>
                </div>
            </div>
        </div>

        <div class="form-group text-center"> 
            <input type="submit" value="ADD TOUR" class="btn btn-danger" />
        </div>

    </div>
</formj:form>