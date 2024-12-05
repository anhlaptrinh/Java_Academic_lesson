<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<body>
	 <h1>
        <% 
            String username = (String) request.getAttribute("username");
        	String password = (String) request.getAttribute("password");
            if (username != null) {
        %>
            Xin chào <%= username %> <%=password %>!
        <% 
            } else { 
        %>
            Welcome, guest!
        <% 
            } 
        %>
    </h1>
</body>
</html>