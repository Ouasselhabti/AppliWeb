<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="n7.fr.metier.Materiel" %>
<% List<Materiel> matos = (List<Materiel>)request.getAttribute("matos"); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Matos</title>
    <style>
        /* Styles gÃŠnÃŠraux */
        body {
            font-family: Arial, sans-serif;
            background-color: #020744;
            color: #333;
            margin: 0;
            padding: 0;
        }
        
        h1 {
            font-size: 35px;
            color: white;
            margin-bottom: 30px;
            text-align: center;
            animation: fade-in 1s ease-in-out;
        }
        
        /* Animation */
        @keyframes fade-in {
            0% {
                opacity: 0;
                transform: translateY(-20px);
            }
            100% {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        /* Styles pour les produits */
 .produit {
  width: 400px;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 4px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
  margin-bottom: 20px;
  transition: transform 0.3s ease;
  display: inline-block;
  position: relative; /* Ajout de cette propriété */
}

.produit:hover {
  transform: translateY(-5px);
}

.produit h3 {
  font-size: 18px;
  margin-bottom: 10px;
}

.produit p {
  font-size: 14px;
  margin-bottom: 10px;
}

.produit img {
  width: 200px;
  height: 200px;
  object-fit: contain;
  object-position: center;
  border-radius: 50%;
  margin-bottom: 10px;
}

.additional-info {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: #f9f9f9;
  padding: 10px;
  border: 1px solid #ccc;
  visibility: hidden;
  opacity: 0;
  transition: visibility 0s, opacity 0.3s;
}

.produit:hover .additional-info {
  visibility: visible;
  opacity: 1;
}
.transmission input[type="submit"] {
  display: inline-block;
  padding: 8px 16px;
  font-size: 14px;
  text-align: center;
  text-decoration: none;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  transition: background-color 0.3s;
  margin-right: 10px;
  animation: slide-up 0.5s ease-in-out;
}

.transmission input[type="submit"]:hover {
  background-color: #0056b3;
}
    </style>
</head>
<body>
    <%@ include file="utils/navbar.jsp"%>
    <h1>Liste des produits</h1>

    <%-- Boucle pour afficher chaque produit --%>
    <form action="ControllerAchat" method="get">
    <%
        for (Materiel mato : matos) {
    %>
    <div class="produit">
        <div class="info-produit product-info">
            <h3><%= mato.getNom() %></h3>
            <p>Prix : <%= mato.getPrix() %> euros</p>
            <img src="<%= mato.getImagePath() %>" alt="Image du produit">
            <!-- Additional Information -->
            <div class="additional-info">
                <!-- Add any additional information you want to display -->
            	<p><%= mato.getDescription() %></p>
            	<p><%= mato.getId() %></p>
            </div>
        </div>
        <div class="transmission">
        		
                <input type="submit" name="achat-op" value="Reserver">
                <input type="submit" name="achat-op" value="Ajouter au panier">
                <input type="hidden" name="mato-id" value="<%= mato.getId() %>">
        </div>
    </div>
    <%
        }
    %>
            </form>
</body>
</html>


