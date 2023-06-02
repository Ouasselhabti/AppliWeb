<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="n7.fr.metier.*" %> 
<%@ page import="n7.fr.servlets.*" %>
<% 
   Utilisateur user = (Utilisateur)session.getAttribute("user");
   if (user != null) {
	   request.setAttribute("user",user);
	   response.sendRedirect("home.jsp");
   }
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title> Login </title>
  <link rel="stylesheet" href="./styling/styleLogin.css">
  <link rel="stylesheet" type="text/css" href="./styling/global.css">

</head>
<body>
<!-- partial:index.partial.html --> 
<div class="login-form">
  <form action = "Controller" method="post">
    <h1>Login</h1>
    <div class="content">
      <div class="input-field">
        <input type="text" name="userMail" placeholder="Email" autocomplete="nope">
      </div>
      <div class="input-field">
        <input type="password" name="passWord" placeholder="Password" autocomplete="new-password">
      </div>
      <a href="#" class="link">Forgot Your Password?</a>
      <a href="loginadmin.html" class="link"> Admin?</a>
    </div>
    <div class="action">
      <input type="submit" name="operation" value="login">
      <input type ="submit" name="operation" value="register"> 
    </div>
  </form>

</div>
<!-- partial --> 
  <script  src="./script.js"></script>

</body>
</html>
