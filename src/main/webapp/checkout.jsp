<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="n7.fr.metier.*" %>
<% Materiel mato = (Materiel)request.getSession().getAttribute("mato");
Utilisateur user = (Utilisateur)session.getAttribute("user");
if (user != null) {
	   request.setAttribute("user",user);
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Paiement</title>
	<script>
    function updateTotal() {
        const basePrice = parseFloat(document.getElementById("basePrice").innerText);
        const loanDuration = parseInt(document.getElementById("loanDuration").value);
        const totalPrice = basePrice * loanDuration;
        document.getElementById("totalAmount").innerText = totalPrice.toFixed(2) + "€";
    }

	</script>
     <style>
        body {
            background-color: #f5f5f5;
            color: #333;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #020744;
            text-align: center;
            margin-top: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #020744;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        #basePrice, #total {
            color: #020744;
            text-align: center;
            margin-top: 30px;
            font-size: 24px;
            animation: slide-in 1s ease;
        }

        input[type="range"] {
            width: 30%;
            margin-top: 10px;
        }

        form {
            margin-top: 30px;
            animation: fade-in 1s ease;
        }

        label {
            color: #020744;
            margin-top: 10px;
            display: block;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
        }

        input[type="submit"] {
            background-color: #020744;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #ff6699;
        }

        @keyframes slide-in {
            from {
                transform: translateY(-50px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes fade-in {
            from {
                opacity: 0;
            }
            to {
                opacity: 1;
            }
        }
    </style>
</head>
<body>
    <h1>Confirmez votre achat</h1>

    <table>
        <tr>
            <th>Matériel</th>
            <th>Prix</th>
        </tr>
        <tr>
            <td>${mato.getNom()}</td>
            <td>${mato.getPrix()}</td>
        </tr>
    </table>

<h2 id="basePrice">Base Total : <%= mato.getPrix() %>€</h2>

    <label for="loanDuration">Durée de l'emprunt (jours) :</label>
    <input type="range" id="loanDuration" name="loanDuration" min="0" max="60" value="0" onchange="updateTotal()">
    <h2>Total : <span id="totalAmount">${0}</span>€</h2>
    

    <form action="ControllerCheckout" method="post">
        <h2>Informations de paiement</h2>
        <label for="cardNumber">Numéro de carte :</label><br>
        <input type="text" id="cardNumber" name="cardNumber" required><br>
        <label for="expiryDate">Date d'expiration :</label><br>
        <input type="text" id="expiryDate" name="expiryDate" required><br>
        <label for="cvv">CVV :</label><br>
        <input type="text" id="cvv" name="cvv" required><br>
        <input type="submit" value="Confirmer le paiement">
        <input type="hidden" name="idmato" value=<%=mato.getId()%>>
    </form>

    <script>
        // Initialize the base price on page load
        const basePrice = <%= mato.getPrix() %>;
        document.getElementById("basePrice").innerText = basePrice.toFixed(2) + "€";

        // Initialize the total amount on page load
        updateTotal();
    </script>
</body>
</html>