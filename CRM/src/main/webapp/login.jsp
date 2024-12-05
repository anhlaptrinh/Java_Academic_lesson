<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<%
    String savedEmail = "";
    String savedPassword = "";

    // Đọc cookie
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("email".equals(cookie.getName())) {
                savedEmail = cookie.getValue();
            } else if ("password".equals(cookie.getName())) {
                savedPassword = cookie.getValue();
            }
        }
    }
%>
<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
      <div class="p-4 border mt-4">
        <form action="login" method="post">
            <div class="form-group">
              <label>Email</label>
              <input type="email" class="form-control" name="email" value="<%= savedEmail %>" />
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password" value="<%= savedPassword %>" />
            </div>
            <input type="checkbox" name="remember"/>Remember me <br/>
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
          </form>
      </div>
      </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
