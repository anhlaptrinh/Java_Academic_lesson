<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login here</title>
</head>
<body>
	<h2>Trang đăng nhập</h2>
    <%
        String accountError = (String) request.getAttribute("accounterror");
        String passwordError = (String) request.getAttribute("passworderror");
    %>
    
    <form action="login" method="POST">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <% if (accountError != null) { %>
            <span style="color:red;"><%= accountError %></span>
        <% } %>
        <br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <% if (passwordError != null) { %>
            <span style="color:red;"><%= passwordError %></span>
        <% } %>
        <br><br>
        
        <input type="submit" value="Đăng nhập">
    </form>
</body>
</html>