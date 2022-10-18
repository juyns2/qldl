<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center text-danger">Edit Place</h2>

<!--action="/qldl/edit/"-->
<c:url value="/edit/${id}" var="action"/> 
<div class="container" id="formedit">
<formj:form method="post" action="/qldl/edit/${id}" modelAttribute="tour" enctype="multipart/form-data"> 
    <div class="container " >
        <div class="editform" id="editinfo">
            <div class="form-group"> 
                <!--<label for="name">Ten ${id}</label>--> 
                <label for="name">Name Tour:</label> 
                <formj:input type="text" id="name" path="name" cssClass="form-control" value="${tourIndex.name}" /> 
            </div>

            <div class="form-group"> 
                <label for="price">Price:</label> 
                <formj:input type="text" id="price" path="price" cssClass="form-control" value="${tourIndex.price}" /> 
            </div>
            <div class="form-group"> 
                <label for="cate">Place:</label>
                <formj:select id="khuvuc" path="khuvuc" cssClass="form-control">
                    <c:forEach var="j" items="${place}">
                        <option value="${j.id}">${j.name}</option>
                    </c:forEach>
                </formj:select>
            </div>
            <label>Image:</label>
        </div>
            
            
            

        <div class="form-group d-flex align-items-center justify-content-center"> 
            <!--<label for="file"><p>Pic Tour</p></br></label>-->
           
            <div class=" ">
                <div class="img_bor d-flex align-items-center justify-content-center float-left" style="margin-right: 100px;">
                    <img class="img-thumbnail img_sel" id="output"/>
                </div>
                <div class="img_bor d-flex align-items-center justify-content-center ">
                    <img class="img-thumbnail img_sel" src="<c:url value='${tourIndex.image_url}' />" alt='${tourIndex.name}' />
                </div>
                <div class="input-group " >
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroupFileAddon01">Upload</span>
                    </div>
                    <div class="custom-file" >
                        <formj:input type="file" class="custom-file-input" id="file" path="img" accept="image/*" onchange="loadFile(event)"/>
                        <label class="custom-file-label"  for="inputGroupFile01" style="width: 325px;" >Choose file</label>
                    </div>

                </div>
                <%--<formj:input type="file" id="file" path="img" cssClass="form-control" accept="image/*" onchange="loadFile(event)"/>--%> 
            </div>
        </div>
    </div>






            <div class="form-group text-center" > 
        <input type="submit" value="Update" class="btn btn-danger" />
    </div> 
</formj:form>
    
    </div>