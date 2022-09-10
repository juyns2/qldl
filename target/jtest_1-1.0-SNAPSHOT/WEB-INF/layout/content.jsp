<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <h3>Truoc Content</h3>
    <img src="<c:url value="/images/pic1.png" />" />
</div>

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
