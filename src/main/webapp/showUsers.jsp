<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="n7.fr.metier.*" %>
<%@ page import="java.util.List" %>

<% List<Utilisateur> users = (List<Utilisateur>)request.getAttribute("users"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./styling/styleShowUsers.css">
<title>Insert title here</title>
</head>
<body>
	 <%@ include file="utils/navbar.jsp"%>
      <h1>User List</h1>
      <table>
         <thead>
            <tr>
               <th>Nom</th>
               <th>Prenom</th>
               <th>Email</th>
            </tr>
         </thead>
         <tbody>
            <% for (Utilisateur u : users ) { %>
               <tr>
                  <td><%= u.getNom() %></td>
                  <td><%= u.getPrenom() %></td>
                  <td><%= u.getEmail() %></td>
               </tr>
            <% } %>
         </tbody>
      </table>
</body>
</html>