<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="jtop">
    <form action=""> 
        <div class="row">
            <div class="col-md-10">	
                <input class="form-control" type='text' name='kw' placeholder="Please Input kw to find"/>
            </div>		
            <div> 
                <input type='submit' value='search' class='btn btn-danger' />
            </div>	
        </div>
    </form>
</div>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
    <a class="navbar-brand" href="<c:url value="/tour" />">HOME</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#jtop">Link 1</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link 2</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                Category
            </a>
            <div class="dropdown-menu">
                <c:forEach var="j" items="${cate}">
                    <a class="dropdown-item" href="#">${j.id} - ${j.name}</a>
                </c:forEach>
            </div>
        </li>
    </ul>
</nav>

