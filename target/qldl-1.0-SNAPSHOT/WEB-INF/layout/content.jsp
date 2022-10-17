<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="prof" uri="http://www.springframework.org/tags" %>
<%@ page import="java.io.*,java.util.*" %>

<fmt:formatNumber type="number" pattern="###.###E0" value="${12876.0321}" />
<p>Comment: ${tour[0].commentCol[0].content} | UserId: ${userId} |=> <prof:message code="juyn.test" /></p>

<div id="flip" onlick="console.log(format2(12387.14, 'vnd '));">Click to slide up panel</div>
<div id="panel">Hello world!</div>

<div id="box">
    <h2>Click button to load new content inside DIV box</h2>
</div>
<button type="button">Load Content</button>

<h2 class="text-center text-danger">TEST PAGE</h2>
<!--<div style="text-align: center;">
<c:forEach begin="1" end="30" var="j">
    <p>This is Col ${j}</p>
</c:forEach>
</div>-->

<div>
    <ul>
        <c:forEach var="j" items="${tour}">
            <li>${j.id} - ${j.name} - ${j.khuvuc.name}</li>
            </c:forEach>
    </ul>
</div>

<center>
<%
   // Set error code and reason.
   response.sendError(407, "Need authentication!!!" );
%>
</center>
