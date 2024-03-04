
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
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/nice-select.css">					
        <link rel="stylesheet" href="css/animate.min.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="scss/bootstrap.scss">
        <link rel="stylesheet" href="scss/main.scss">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    </head>
    <body>

        <jsp:include page="orderheader.jsp"></jsp:include>

            <!-- menu -->
            <div class="row menu-area" style="padding-top: 20px">
                <div class="col-2">
                <c:forEach items="${menu}" var="m">
                    <div class="row justify-content-center" style="position: sticky; top: ${90 * m.id}px">
                        <a href="order?cid=${m.id}">
                            <div class="single-menu" style="padding-bottom: 0">
                                <div class="title-div justify-content-between d-flex">
                                    <h4>${m.name}</h4>
                                </div>							
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
            <!-- End menu -->

            <!--container-->
            <div class="container menu-area col-10">
                <!--search-->
                <div class="row justify-content-end" style="position: sticky; top: 90px; right: 10px; z-index: 1">
                    <form action="order" method="post">
                        <input type="text" name="name">
                        <input type="hidden" name="cid" value="${c.id}">
                        <input type="submit" class="btn btn-secondary" value="Search">
                    </form>
                </div>
                <!--end search-->

                <!--all products-->
                <c:if test="${not empty categories}">
                    <div class="row justify-content-around">
                        <c:forEach items="${products}" var="p">
                            <div class="col-md-2 single-menu" style="margin: 25px 10px">
                                <a href="orderproduct?pid=${p.id}" title="${p.name}">
                                    <img style="width: 100%; border-radius: 10px; margin-bottom: 10px" class="lazyloaded" src="${p.image_link}" alt="">
                                </a>
                                <a href="orderproduct?pid=${p.id}" title="${p.name}">
                                    <h3 style="font-size: 100%">${p.name}</h3></a>
                                <div class="row justify-content-around">
                                    <div>${p.price}00 đ</div>
                                    <a href="buy?pid=${p.id}&num=1"><i class="bi bi-plus-circle"></i></a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>

                <!--menu when search-->
                <c:if test="${not empty c}">
                    <div class="row justify-content-center">
                        <a href="#">
                            <div class="single-menu" style="padding-bottom: 0">
                                <div class="title-div justify-content-between d-flex">
                                    <h4>${c.name}</h4>
                                </div>							
                            </div>
                        </a>
                    </div>

                    <div class="row justify-content-around">
                        <c:forEach items="${products}" var="p">
                            <div class="col-md-2 single-menu" style="margin: 25px 10px">
                                <a href="orderproduct?pid=${p.id}" title="${p.name}">
                                    <img style="width: 100%; border-radius: 10px; margin-bottom: 10px" class="lazyloaded" src="${p.image_link}" alt="">
                                </a>
                                <a href="orderproduct?pid=${p.id}" title="${p.name}">
                                    <h3 style="font-size: 100%">${p.name}</h3></a>
                                <div class="row justify-content-around">
                                    <div>${p.price}00 đ</div>
                                    <a href="buy?pid=${p.id}&num=1"><i class="bi bi-plus-circle"></i></a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
            </div>

            <!-- end container -->

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
            <script src="js/popper.min.js.js"></script>	
            <script src="js/main.js"></script>	
    </body>
</html>



