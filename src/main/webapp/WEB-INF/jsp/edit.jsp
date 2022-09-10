<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="formj" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2 class="text-center text-danger">Edit Place</h2>

<formj:form method="post" action="/jtest_1/admin/addTour" modelAttribute="tour" enctype="multipart/form-data"> 
    <div class="form-group"> 
        <label for="name">Ten ${id}</label> 
        <formj:input type="text" id="name" path="name" cssClass="form-control" /> 
    </div>

    <div class="form-group"> 
        <label for="price">Gia</label> 
        <formj:input type="text" id="price" path="price" cssClass="form-control" /> 
    </div>
    <div class="form-group"> 
        <label for="file">Pic Tour</label> 
        <formj:input type="file" id="file" path="img" cssClass="form-control" /> 
    </div> 
    <div class="form-group"> 
        <input type="submit" value="Edit" class="btn btn-danger" />
    </div> 
</formj:form>