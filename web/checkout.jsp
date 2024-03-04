
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="codepixer">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Coffee</title>
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/nice-select.css">					
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
        <script>
            var alertMessage = "${error}";
            if (alertMessage) {
                alert(alertMessage);
            }
        </script>

    </head>
    <body>

        <jsp:include page="orderheader.jsp"></jsp:include>
            <div class="container">
                <section class="h-100 h-custom" style="background-color: #fda12e;">
                    <div class="container py-5 pr-4 h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col-12">
                                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                                    <div class="card-body p-0">
                                        <div class="row g-0">
                                            <div class="col-lg-8">
                                                <div class="p-5">
                                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                                        <h1 class="fw-bold mb-0 text-black">Xác nhận đơn hàng</h1>
                                                        <h6 class="mb-0 text-muted">${size} Sản phẩm</h6>
                                                </div>
                                                <hr class="my-4">
                                                <c:set var="cart" value="${sessionScope.cart}"/>
                                                <c:forEach items="${cart.items}" var="i">
                                                    <c:set var="p" value="${i.product}"/>
                                                    <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                        <div class="col-md-2 col-lg-2 col-xl-2">
                                                            <img
                                                                src="${p.image_link}"
                                                                class="img-fluid rounded-3" alt="Cotton T-shirt">
                                                        </div>
                                                        <c:forEach items="${categories}" var="c">
                                                            <c:if test="${p.category_id eq c.id}">
                                                                <div class="col-md-3 col-lg-3 col-xl-3">
                                                                    <h6 class="text-muted">${c.name}</h6>
                                                                    <h6 class="text-black mb-0">${p.name}</h6>
                                                                </div>
                                                            </c:if>
                                                        </c:forEach>
                                                        <div class="quantity-controls">
                                                            <button type="button" class="btn"><a href="process?num=-1&pid=${p.id}">-</a></button>
                                                            <span class="text-black">${i.quantity}</span>
                                                            <button type="button" class="btn"><a href="process?num=1&pid=${p.id}">+</a></button>
                                                        </div>
                                                        <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                            <h6 class="mb-0">${p.price * i.quantity}00 đ</h6>
                                                        </div>
                                                        <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                            <form action="process" name="process" method="post">
                                                                <input value="${p.id}" name="pid" hidden>
                                                                <button type="submit" name="process" class="btn"><i class="bi bi-x-circle"></i></button>
                                                            </form>
                                                        </div>
                                                    </div>

                                                    <hr class="my-4">
                                                </c:forEach>

                                                <div class="pt-5">
                                                    <h6 class="mb-0"><a href="order" class="text-body"><i
                                                                class="fas fa-long-arrow-alt-left me-2"></i>Quay lại</a></h6>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-4 bg-grey">
                                            <div class="p-5">
                                                <h3 class="fw-bold mb-5 mt-2 pt-1">Đơn hàng</h3>
                                                <hr class="my-4">

                                                <form action="checkout" name="checkout" method="post">

                                                    <input name="customers_id" value="${c.id}" hidden/>
                                                    <input name="cart" value="${cart}" hidden/>

                                                    <div class="d-flex justify-content-between mb-4">
                                                        <h5 class="text-uppercase">Sản phẩm: ${size}</h5>
                                                    </div>

                                                    <h5 class="text-uppercase mb-3">Lời nhắn</h5>

                                                    <div class="mb-5">
                                                        <div class="form-outline">
                                                            <input type="text" name="message" id="message" class="form-control form-control-lg" />
                                                            <label class="form-label" for="message">Gửi lời nhắn của bạn</label>
                                                        </div>
                                                    </div>

                                                    <hr class="my-4">

                                                    <div class="d-flex justify-content-between mb-5">
                                                        <h5 class="text-uppercase">Tổng tiền</h5>
                                                        <h5>${totalprice}00 đ</h5>
                                                    </div>

                                                    <button type="submit" name="checkout" class="btn btn-dark btn-block btn-lg" data-mdb-ripple-color="dark">Đặt hàng</button>
                                                </form>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>			
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>
        <script src="js/easing.min.js"></script>			
        <script src="js/hoverIntent.js"></script>
        <script src="js/superfish.min.js"></script>	
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>	
        <script src="js/owl.carousel.min.js"></script>			
        <script src="js/jquery.sticky.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>			
        <script src="js/parallax.min.js"></script>	
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>					
        <script src="js/mail-script.js"></script>	
        <script src="js/main.js"></script>	
    </body>
</html>



