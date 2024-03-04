
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

    </head>
    <body>

        <jsp:include page="orderheader.jsp"></jsp:include>

            <div class="container">
                <form action="account" method="post" class="col-12">
                    <div class="modal-header">						
                        <h4 class="modal-title">Cập nhật tài khoản</h4>
                    </div>
                    <p class="text-danger">${mess}</p>
                <div class="modal-body">	
                    <div class="form-group">
                        <label>Tên đăng nhập</label>
                        <input name="username" type="text" class="form-control" value="${acc.username}" readonly required>
                    </div>
                    <div class="form-group">
                        <label>Họ tên</label>
                        <input name="name" type="text" class="form-control" value="${acc.fullname}" required>
                    </div>
                    <div class="form-group">
                        <label>Số điện thoại</label>
                        <input name="phone" type="text" class="form-control" value="${acc.phone}" pattern="0[0-9]{9}" required>
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <input name="address" type="text" class="form-control" value="${acc.address}" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="order"><input type="button" class="btn btn-default" data-dismiss="modal" value="Quay lại"></a>
                    <a href="change-pass"><input type="button" class="btn btn-default" data-dismiss="modal" value="Đổi mật khẩu"></a>
                    <input type="submit" class="btn btn-success" value="Cập nhật">
                </div>
            </form>
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
        <script src="js/popper.min.js.js"></script>	
        <script src="js/main.js"></script>	
    </body>
</html>



