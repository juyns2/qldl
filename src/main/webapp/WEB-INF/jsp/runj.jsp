<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Hello ${j}!</h1>
        <ul>	
            <c:forEach var="cat" items="${categories}">
                <li>${cat.id} - ${cat.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
