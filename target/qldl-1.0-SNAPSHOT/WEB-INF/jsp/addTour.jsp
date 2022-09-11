<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center text-danger">THEM DIA DIEM</h2>
<formj:form method="post" action="/qldl/admin/addTour" modelAttribute="tour" enctype="multipart/form-data"> 
    <div class="form-group"> 
        <label for="name">Ten</label> 
        <formj:input type="text" id="name" path="name" cssClass="form-control" /> 
    </div>

    <div class="form-group"> 
        <label for="cate">Danh Muc</label>
        <formj:select id="place" path="khuvuc" cssClass="form-control">
            <c:forEach var="j" items="${place}">
                <option value="${j.id}">${j.name}</option>
            </c:forEach>
        </formj:select>
    </div>

    <div class="form-group"> 
        <label for="price">Gia</label> 
        <formj:input type="text" id="price" path="price" cssClass="form-control" /> 
    </div>

    <div class="form-group d-flex align-items-center justify-content-center"> 
        <!--<label for="file"><p>Pic Tour</p></br></label>-->
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
                    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                </div>
            </div>
            <%--<formj:input type="file" id="file" path="img" cssClass="form-control" accept="image/*" onchange="loadFile(event)"/>--%> 
        </div>
    </div>

    <div class="form-group text-center"> 
        <input type="submit" value="ADD TOUR" class="btn btn-danger" />
    </div> 
</formj:form>