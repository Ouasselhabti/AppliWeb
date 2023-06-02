<!-- Barre de navigation -->

<style>
/* Barre de navigation */
*
{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.menu-bar
{
  background: #020744;
  text-align: center;
}
.menu-bar ul
{
  display: inline-flex;
  list-style: none;
  color: #f1f1f1;
}
.menu-bar ul li 
{
  width: 120px;
  margin: 15px;
  padding : 15px;
}
.menu-bar ul li a
{
  text-decoration: none;
  color: #f1f1f1;
}
.active,.menu-bar ul li:hover
{
  background: #f90;
  border-radius: 2px;
}
.menu-bar .fa
{
  margin-right: 8px;
}

.sub-menu-1
{
  display: none;
}
.menu-bar ul li:hover .sub-menu-1
{
  display: block;
  position: absolute;
  background-color: #020744;
  margin-top: 15px;
  margin-left: -15px;
}
.menu-bar ul li:hover .sub-menu-1 ul
{
  display: block;
  margin: 10px;
}
.menu-bar ul li:hover .sub-menu-1 ul li
{
  width: 150px;
  padding: 10px;
  border-bottom: 1px dotted #fff;
  background: transparent;
  border-radius: 0;
  text-align: left;
}
.menu-bar ul li:hover .sub-menu-1 ul li:last-child
{
  border-bottom: none;
}
.menu-bar ul li:hover .sub-menu-1 ul li a:hover
{
  color: #f90;
}





.logo
{
  position: fixed;
  left: 2%;
  top: 2.5%;
  width: 40px;
  height: 40px;
}
.aboutus
{
  position: fixed;
  right: 0;
  padding: 10px;
}

</style>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ page import="java.util.List" %>
	<%@ page import="n7.fr.metier.*" %> 

   <% Utilisateur user = (Utilisateur)request.getSession().getAttribute("user");%>
   
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
		<link rel="stylesheet" type="text/css" href="../styling/stylenavbar.css">
        <div class="menu-bar">
          <a href="img.html"><img class="logo" src="./assets/logo.jpg" alt="Logo"></a>
          <ul>
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
                    <%if (user!=null) { %>
                        <li><a href="mesInformations.jsp"><i class="fa fa-info-circle"></i>Mes informations</a></li>
                        <li><a href="mesCommandes.jsp"><i class="fa fa-shopping-bag"></i>Mes commandes</a></li>
                        <li><a href="mesLocations.jsp"><i class="fa fa-shopping-cart"></i>Mes locations</a></li>
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
                  <% } else { %>
                  		<li><a href="login.jsp">Connexion</a></li>
                  		<%} %>
                    </ul>
                </div>
            </li>
            <li class="aboutus"><a href="aproposdenous.html"><i class="fa fa-user"></i>A propos de nous</a>
          </ul>
        </div>

        <!-- End barre de navigation-->