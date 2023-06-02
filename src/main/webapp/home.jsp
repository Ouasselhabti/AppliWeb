<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="n7.fr.metier.*" %> 
<%@ page import="n7.fr.servlets.*" %>
<% List<Materiel> matos = (List<Materiel>)request.getAttribute("matos");
   Utilisateur user = (Utilisateur)session.getAttribute("user");
   if (user != null) {
	   request.setAttribute("user",user);
   }
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./styling/styleHome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">


</head>
<body>
    <!-- Barre de navigation -->
        <div class="menu-bar">
          <a href="img.html"><img class="logo" src="./assets/logo.jpg" alt="Logo"></a>
          <ul>
          <% if (user != null) { %>
            <li class="active"><a href="home.jsp"><i class="fa fa-home"></i>Home</a></li>

            <li><a href="#"><i class="fa fa-user"></i>Accueil</a>
                <div class="sub-menu-1" style="z-index : 1000;">
                    <ul>
                        <li><a href="quiSommeNous.html"><i class="fa fa-question-circle"></i>Qui sommes-nous ?</a></li>
                        <li><a href="notreEquipe.html"><i class="fa fa-users"></i>Notre équipe</a></li>
                        <li><a href="nosPartenaires.html"><i class="fa fa-handshake"></i>Nos partenaires</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="#"><i class="fa fa-chess-rook"></i>Catégorie</a>
                <form action="ServletTest" method="get">
                <div class="sub-menu-1" style="z-index : 10000;">
                    <ul>
                        <li><a href="#"><i class="fa fa-laptop"></i><input type="submit" name="choix" value="Ordinateurs"></a></li>
                        <li><a href="#"><i class="fa fa-phone"></i><input type="submit" name="choix" value="Telephone"></a></li>
                        <li><a href="#"><i class="fa fa-tablet"></i><input type="submit" name="choix" value="Tablette"></a></li>
                        <li><a href="#"><i class="fa fa-tv"></i><input type="submit" name="choix" value="Tele"></a></li>
                        <li><a href="#"><i class="fa fa-gamepad"></i><input type="submit" name="choix" value="Console"></a></li>
                        <li><a href="#"><i class="fa fa-camera"></i><input type="submit" name="choix" value="Camera"></a></li>
                        <li><a href="#"><i class="fa fa-print"></i><input type="submit" name="choix" value="Imprimante"></a></li>
                        <li><a href="#"><i class="fa fa-cogs"></i><input type="submit" name="choix" value="Accessoire"></a></li>
                    </ul>
                </div>
                </form>
            </li>
            <li><a href="#"><i class="fa fa-search"></i>Rechercher</a></li>
            <li><a href="moncompte.jsp"><i class="fa fa-info"></i>Mon Compte</a>
                <div class="sub-menu-1" style="z-index : 1000;">
                        <form action = "ControllerLogOut" method="get">
                    <ul>
                        <li><a href="mesInformations.jsp"><i class="fa fa-info-circle"></i>Mes informations</a></li>
                        <li><a href="mesLocations.jsp"><i class="fa fa-shopping-cart"></i>Ma location</a></li>
                        <li><a href="mesAvis.jsp"><i class="fa fa-comment"></i>Mes avis</a></li>
                        <li><a href="mesMessages.jsp"><i class="fa fa-mail-bulk"></i>Mes messages</a></li>
                        <li><i class="fa fa-sign-in-alt"></i><input type="submit" name="logout" value="Déconnexion"></li>
                    </ul>
                        </form>
                </div>
            </li>
            <li><a href="#"><i class="fa fa-shopping-basket"></i>Panier</a>
                <div class="sub-menu-1" style="z-index : 1000;">
                    <ul>
                        <li><a href="panier.jsp"><i class="fa fa-shopping-basket"></i>Mon panier</a></li>
                        <li><a href="mesfavoris.jsp"><i class="fa fa-heart"></i>Mes favoris</a></li>
                    </ul>
                </div>
            </li> 
            <%  } else { %>
            	<li><a href="login.jsp">Connexion</a></li>
            	<%} %>
            <li class="aboutus"><a href="aproposdenous.html"><i class="fa fa-user"></i>A propos de nous</a>
          </ul>
        </div>

        <!-- End barre de navigation-->
        <!-- Debut body home -->
        	<!-- Debut intro -->
        	<section class="introduction">
  				<div class="container">
    				<h2>Bienvenue sur notre site de location de matériel éducatif</h2>
    					<p>Explorez notre vaste sélection de matériel éducatif pour améliorer votre expérience d'apprentissage.</p>
    					<p class="solde">Profitez de nos prix soldés pendant une période limitée !</p>
  				</div>
  				
			</section>
        	<!-- Fin intro -->
<form action="ServletTest" method="get">
<div class="body-home">
    <div class="categorie">
        <img src="./assets/mac.jpg" alt="Ordinateurs">
        <h3>Ordinateurs</h3>
        <p>Découvrez notre sélection d'ordinateurs performants.</p>
        <input type="submit" name="choix" value="Ordinateurs" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/iphone14.jpg" alt="Téléphones">
        <h3>Téléphones</h3>
        <p>Découvrez notre collection de téléphones haut de gamme.</p>
        <input type="submit" name="choix" value="Telephone" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/IpadPro.jpg" alt="Tablettes">
        <h3>Tablettes</h3>
        <p>Explorez notre gamme de tablettes élégantes et performantes.</p>
        <input type="submit" name="choix" value="Tablette" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/LG.jpg" alt="Télévisions">
        <h3>Télévisions</h3>
        <p>Découvrez nos télévisions à la pointe de la technologie.</p>
        <input type="submit" name="choix" value="Tele" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/expphoto.jpg" alt="Imprimantes">
        <h3>Imprimantes</h3>
        <p>Découvrez nos imprimantes performantes.</p>
        <input type="submit" name="choix" value="Imprimante" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/console.jpg" alt="Consoles">
        <h3>Consoles</h3>
        <p>Découvrez nos consoles multi-tâches de très haut niveau.</p>
        <input type="submit" name="choix" value="Console" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/legria.jpg" alt="Cameras">
        <h3>Caméra</h3>
        <p>Découvrez notre seléction de camèras.</p>
        <input type="submit" name="choix" value="Camera" class="btn">
    </div>
    <div class="categorie">
        <img src="./assets/eastpackgris.jpg" alt="Accessoire">
        <h3>Accessoire</h3>
        <p>D'autre accessoire? Par ici.</p>
        <input type="submit" name="choix" value="Accessoire" class="btn">
    </div>
    <!-- Ajoutez les autres catégories ici -->
</div>
 </form>      
        
        <!-- End body home -->
<div>        
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p>&copy; 2023 Ouassel-Nabil-Lisa. Tous droits réservés.</p>
            </div>
        </div>
    </div>
</footer>
</div>
</body>
</html>