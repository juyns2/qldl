<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger"> TOUR </h1>
<c:if test="${orderByTour != null}">
    <p>${orderByTour[0]}</p>
</c:if>
<table class="table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Num_Ticket</th>
        <th>Time_Start</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="j" items="${orderByTour}">
        <tr id="tour${j.tourId}">
            <td>${j.tourId}</td>
            <td>${j.name}</td>
            <td class="priceTour">${j.price}</td>
            <td><input type="number" onblur="updateOrder(this, ${j.tourId})" value="${j.count}"/></td>
            <td><input type="date" value="${j.jtimeStart}"/> ${j.jtimeStart} </td> <!-- Ðinh Dang 'value_(yyyy-MM-dd)' Phai Dung Moi Hien Thi Duoc -->
            <td><input type="button" onclick="deleteOrder(${j.tourId})" value="Del" class="btn btn-danger"/></td>
        </tr>
    </c:forEach>
</table>
<input type="button" value="Pay Now" class="btn btn-danger" onclick="getIdUser(${currentUser.id})"/> Total: <span id="priceTotal">${priceOrder}</span>
<%--<a href="<c:url value="/api/vnpay/${currentUser.id}" />" ><button>Thanh Toan</button> </a>--%>
<button onclick="payUrl(${currentUser.id})">Thanh Toan</button>
