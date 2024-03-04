
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sidebar Start -->
<div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-light navbar-light d-flex flex-column flex-shrink-0 p-3 ">
        <h1 class="text-primary"><i class="fa fa-hashtag me-2"></i>Quản lý</h1>
        <hr>
        <div class="navbar-nav w-100 nav nav-pills flex-column mb-auto">
            <a href="admin" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>Trang chủ</a>
            <a href="manage-menu" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Menu</a>
            <a href="manage-order" class="nav-item nav-link"><i class="bi bi-receipt-cutoff me-2"></i>Đơn hàng</a>
            <a href="manage-customers" class="nav-item nav-link"><i class="bi bi-file-earmark-person-fill me-2"></i>Khách hàng</a>
            <a href="manage-categories" class="nav-item nav-link"><i class="bi bi-grid-fill me-2"></i>Loại sản phẩm</a>
        </div>
        <hr>
        <div>
            <button type="button" class="btn btn-dark">
                <a href="logout" class="d-flex align-items-center link-dark text-decoration-none text-white">
                    <i class="bi bi-box-arrow-left"></i>
                    <div style="margin-left: 5px;">Đăng xuất</div>
                </a>
            </button>
        </div>
    </nav>
</div>
<!-- Sidebar End -->
