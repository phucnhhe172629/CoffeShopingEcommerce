
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header id="header" id="home" style="position: sticky; background: rgba(20, 2, 0, 0.8);">
    <div class="header-top">
        <div class="container">
            <div class="row justify-content-between">
                <div id="logo">
                    <a href="order"><img src="img/logo.png" alt="" title="" /></a>
                </div>
                <div class="row justify-content-around col-md-3">
                    <div class="btn-group btn-group-sm bg-gradient">
                        <button type="button" class="btn btn-dark dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="bi-person-circle" style="font-size: 2rem; color: whitesmoke;"></i>
                        </button>
                        <div class="dropdown-menu">
                            <c:if test="${not empty acc}">
                                <a class="dropdown-item" href="order-check">Kiểm tra đơn hàng</a>
                                <a class="dropdown-item" href="account">Cập nhật tài khoản</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="logout"><div style="margin-left: 5px;">Đăng xuất</div></a>
                            </c:if>
                            <c:if test="${empty acc}">
                                <a class="dropdown-item" href="login"><div style="margin-left: 5px;">Đăng nhập</div></a>
                            </c:if>
                        </div>
                    </div>
                    <a href="checkout"><i class="bi-bag" style="font-size: 2rem; color: whitesmoke;"></i></a>
                </div>
            </div>			  					
        </div>
    </div>
</header>