
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Admin</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/admin/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/admin/css/style.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container-xxl position-relative bg-body d-flex p-0">

            <form action="edit" method="post" class="col-12">
                <div class="modal-header">						
                    <h4 class="modal-title">Sửa sản phẩm</h4>
                </div>
                <div class="modal-body">	
                    <div class="form-group">
                        <label>ID</label>
                        <input name="id" type="text" class="form-control" value="${p.id}" readonly required>
                    </div>	
                    <div class="form-group">
                        <label>Link Ảnh</label>
                        <input name="image_link" type="text" class="form-control" value="${p.image_link}" required>
                    </div>				
                    <div class="form-group">
                        <label>Tên</label>
                        <input name="name" type="text" class="form-control" value="${p.name}" required>
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea name="description" class="form-control" value="${p.description}" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input name="price" type="text" class="form-control" value="${p.price}" required>
                    </div>
                    <div class="form-group">
                        <label>Loại</label>
                        <select name="category_id" class="form-select" aria-label="Default select example">
                            <c:forEach items="${categories}" var="c">
                                <c:if test="${p.category_id eq c.id}">
                                    <option value="${c.id}" selected>${c.name}</option>
                                </c:if>
                                <c:if test="${p.category_id != c.id}">
                                    <option value="${c.id}" selected>${c.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <div class="modal-footer">
                    <a href="manage-menu"><input type="button" class="btn btn-default" data-dismiss="modal" value="Quay lại"></a>
                    <input type="submit" class="btn btn-success" value="Sửa">
                </div>
            </form>

        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/chart/chart.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>