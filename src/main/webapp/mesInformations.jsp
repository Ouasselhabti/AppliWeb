<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="n7.fr.metier.Utilisateur" %>
<%@ page import="n7.fr.servlets.*" %>
<%   
   Utilisateur user = (Utilisateur)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>User Information</title>
   <style>
      body {
         font-family: Arial, sans-serif;
         margin: 20px;
      }
      h1 {
         color: #333;
         margin-bottom: 20px;
      }
      p {
         margin-bottom: 10px;
      }
      label {
         font-weight: bold;
      }
   </style>
</head>
<body>
   <h1>Mes Infos : </h1>
   <p>Nom: <%= user.getNom() %></p>
   <p>Prenom: <%= user.getPrenom() %></p>
   <p>Email: <%= user.getEmail() %></p>
   <p>Email: <%= user.getMotDePasse() %></p>
   <!-- Add more user information as needed -->
</body>
</html>