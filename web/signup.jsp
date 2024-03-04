
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login Form</title>
    </head>
    <body>
        <div id="logreg-forms">
            <form class="form-signup" action="signup" method="post">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Đăng ký</h1>
                <p class="text-danger">${mess}</p>
                <input name="username" type="text" class="form-control" placeholder="Tên đăng nhập" required="" autofocus="">
                <input name="password" type="password" class="form-control" placeholder="Mật khẩu" required>
                <input name="repass" type="password" class="form-control" placeholder="Nhập lại mật khẩu" required>
                <input name="fullname" type="text" class="form-control" placeholder="Họ tên" required>
                <input name="phone" type="tel" class="form-control" placeholder="Số điện thoại" pattern="0[0-9]{9}" required>
                <input name="address" type="text" class="form-control" placeholder="Địa chỉ" required>
                <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Đăng ký</button>
                <a href="login" id="cancel_signup"><i class="fas fa-angle-left"></i> Quay lại</a>
            </form>
            <br>

        </div>
    </body>
</html>