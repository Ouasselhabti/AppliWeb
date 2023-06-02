<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="n7.fr.metier.Materiel" %>
<%@ page import="n7.fr.metier.*" %>
<% Materiel mato = (Materiel)request.getSession().getAttribute("mato");
Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Mes locations</title>
   <style>
      body {
         font-family: Arial, sans-serif;
         margin: 20px;
      }
      h1 {
         color: #333;
         margin-bottom: 20px;
      }
      table {
         width: 100%;
         border-collapse: collapse;
      }
      th, td {
         padding: 10px;
         text-align: left;
         border-bottom: 1px solid #ddd;
      }
      th {
         background-color: #f2f2f2;
         color: #333;
      }
   </style>
</head>
<body>
   <h1>Mes locations</h1>
   <table>
      <thead>
         <tr>
            <th>Matériel</th>
            <th>Durée de location</th>
         </tr>
      </thead>
      <tbody>
         <% 
            Object[] emprunt = (Object[]) request.getSession().getAttribute("Emprunt");
         	Facade facade = (Facade)request.getSession().getAttribute("facade");
            if (emprunt != null) {
               List<Integer> materielIds = (List<Integer>) emprunt[0];
               int dureeEmprunt = (int) emprunt[1];
               
               for (int materielId : materielIds) {
                  Materiel materiel = facade.trouverMaterielParId(materielId);
         %>
            <tr>
               <td><%= materiel.getNom() %></td>
               <td><%= dureeEmprunt %> jours</td>
            </tr>
         <% 
               }
            }
         %>
            <c:set var="myObject" value="${emprunt}" /> <!-- Replace 'someObject' with the actual object name -->

   <h1>
      <c:if test="${empty myObject}">
         Object is null
      </c:if>
      <c:if test="${not empty myObject}">
         Object is not null
      </c:if>
   </h1>
      </tbody>
   </table>
</body>
</html>