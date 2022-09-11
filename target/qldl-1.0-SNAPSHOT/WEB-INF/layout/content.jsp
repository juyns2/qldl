<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <!--<img src="<c:url value="/images/pic1.png" />" />-->
</div>
<h2 class="text-center text-danger">TEST PAGE</h2>
<!--<div style="text-align: center;">
    <c:forEach begin="1" end="30" var="j">
        <p>This is Col ${j}</p>
    </c:forEach>
</div>-->

<div>
    <ul>
        <c:forEach var="j" items="${tour}">
            <li>${j.id} - ${j.name}</li>
            </c:forEach>
    </ul>
</div>
