<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="n7.fr.metier.Utilisateur" %>
<%@ page import="n7.fr.metier.Panier" %>
<%@ page import="n7.fr.metier.Materiel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Panier</title>
</head>
<body>
<%@ include file="utils/navbar.jsp"%>
<h2>Votre panier :</h2>
<%
    // Récupération de l'utilisateur depuis la requête
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
    if(utilisateur != null) {
        Panier panier = utilisateur.getPanier();
        if(panier != null && panier.getMateriels().size() > 0) {
            for(Materiel materiel : panier.getMateriels()) {
%>
<p><%= materiel.getNom() %> - <%= materiel.getPrix() %></p>
<%
            }
        } else {
%>
<p>Votre panier est vide.</p>
<%
        }
    }
%>
<form action="checkout.jsp" method="post">
    <input type="submit" value="Payer" />
</form>
</body>
</html>