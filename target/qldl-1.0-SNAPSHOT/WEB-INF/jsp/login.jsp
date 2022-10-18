<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--Goi Den login Trong SecConfig-->
<c:url value="/user/login" var="action"/>

<!--<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Login"/>
    </div>
</form>-->

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Has Error!
    </div>
</c:if>
<h1 style="text-align: center">Đăng nhập</h1>

<form method="post" action="${action}">
    <div class="  " id="dangnhap"> 
    <div class="form-group--user  ">
        <label for="username">Tài khoản</label>  

        <input type="text" id="username" name="username" class="form-control"/>

    </div>
    <div class="form-group--user">
        <label for="password">Mật khẩu</label>
        <div class="">
        <input  type="password" id="password" name="password" class="form-control"/>
        </div>
    </div>
    <div class="row mb-4">
        <div class="col d-flex justify-content-center">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                <label class="form-check-label" for="form2Example31"> Remember me </label>
            </div>
        </div>
        <div class="col">
            <a href="#!">Forgot password?</a>
        </div>
    </div>
    <button type="submit" class="btn btn-primary  mb-4">Sign in</button>

    <div class="text-center">
        <p>Not a member? <a href="#!">Register</a></p>
        <p>or sign up with:</p>
        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-facebook-f"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-google"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-twitter"></i>
        </button>

        <button type="button" class="btn btn-link btn-floating mx-1">
            <i class="fab fa-github"></i>
        </button>
    </div>
    </div>
</form>