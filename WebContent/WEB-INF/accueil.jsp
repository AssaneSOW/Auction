<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Accueil Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/accueil.css" rel="stylesheet">
</head>
<body class="bg-light">
	<header>
		<div class="row bg-light my-2">
			<span class="container titreEtLogo align-top col-sm-4 text-left">
				<c:if test="${!empty userConnected}">
					<a href="accueil" class="mx-5"> <img
						src="images/gavel-3577255_640.jpg" class="logo"
						alt="logo du site représentant le marteau du juge"></a>
				</c:if> Enchères
			</span> <span
				class="container align-middle col-sm-4 col-offset-4 text-right">
				<c:if test="${!empty userConnected}">
					<a href="vente" class="mx-2">Mettre en enchères</a>
					<a href="monProfil" class="mx-2">Mon profil</a>
					<a href="logout" class="mx-2">Déconnexion</a>
				</c:if> <c:choose>
					<c:when test="${!empty userConnected}">
						<a href="login" hidden="hidden">S'inscrire - Se connecter</a>
					</c:when>
					<c:otherwise>
						<a href="login">S'inscrire - Se connecter</a>
					</c:otherwise>
				</c:choose>
			</span>
		</div>
	</header>

	<div class="jumbotron text-center">
		<h1>Liste des enchères</h1>
		<div class="row justify-content-around">
			<form class="form my-3" action="/rechercher">
				<div class="row">
					<div class="col form-group mx-2">
						<label for="categorie" class="mx-2">Catégorie :</label><select
							id="categorie">
							<option>Toutes</option>
							<option>Ameublement</option>
							<option>Informatique</option>
							<option>Sport et Loisirs</option>
							<option>Vêtements</option>
						</select>
					</div>
					<div class="col form-group mx-2">
						<input type="text" size="40" placeholder="mot-clés article" name="rechercher">
					</div>
				</div>


				<c:if test="${!empty userConnected}">
					<div class="row my-2">
						<div class="col form-group text-left">
							<input type="radio" class="troc" id="achats" name="troc"
								data-toggle="collapse" data-target=".achats" value="achats">
							<label for="achats" class="troc">Mes achats</label>
							
								<div class="col form-group text-left ml-5 collapse achats">
								<input type="checkbox" id="encheresOuvertes"
									name="encheresOuvertes" value="encheresOuvertes">
									<label for="encheresOuvertes" class="trocMenuAchat">Enchères
									ouvertes</label><br>
									<input type="checkbox" id="encheresEnCours"
									name="encheresEnCours" value="encheresEnCours">
									<label for="encheresEnCours" class="trocMenuAchat ">Enchères
									en cours</label><br>
									<input type="checkbox" id="encheresGagnees"
									name="encheresGagnees" value="encheresGagnees">
									<label for="encheresGagnees" class="trocMenuAchat">Enchères
									gagnées</label>
								</div>
						</div>
						<div class="col form-group text-left">
								<input type="radio" class="troc" id="ventes" name="troc"
									data-toggle="collapse" data-target=".ventes" value="ventes">
								<label for="ventes" class="troc">Mes ventes</label>
								
								<div class="col form-group text-left ml-5 collapse ventes">
									<input type="checkbox" id="ventesEnAttente"
										name="ventesEnAttente" value="ventesEnAttente">
										<label for="ventesEnAttente" class="trocMenuVente">Ventes en
										attente</label><br>
										<input type="checkbox" id="ventesEnCours"
										name="ventesEnCours" value="ventesEnCours">
										<label for="ventesEnCours" class="trocMenuVente">Ventes en
										cours</label><br>
										<input type="checkbox" id="ventesRealisees"
										name="ventesRealisees" value="ventesRealisees">
										<label for="ventesRealisees" class="trocMenuVente">Ventes
										réalisées</label>
								</div>
							</div>
					</div>
				</c:if>

				<button type="button" class="btn btn-info btn-lg btn-block">Rechercher</button>
			</form>
		</div>
	</div>

<%-- 			<c:forEach var="a" items="${articles}"> --%>
				<div class="container justify-content-center">
					<div class="row">
						<div class="col text-left">
							<div class="media-left media-middle">
								<img src="${photo}">
							</div>
							<div class="media-body">
								<input type="hidden" name="id" value="${articleId}">
								<p>Nom de l'article : <a href="article">${articleNom}</a></p>
								<p>Prix : ${prix}</p>
								<p>Fin de l'enchère : ${dateFinEnchere}</p>
								<p>Vendeur : <a href="vendeur">${vendeur}</a></p>
							</div>
						</div>		
					</div>
				</div>
<%-- 			</c:forEach> --%>

	<div class="container justify-content-center">
		<div class="row">
			<div class="media col text-center">
				<div class="media-middle">
					<img src="images/workplace-5517762_640.jpg"
						alt="image d'un ordinateur sur un bureau" class="media-object"
						style="width: 200px; height: 200px">
				</div>
				<div class="media-body text-left ml-5">
					<h4 class="media-heading">Laptop</h4>
					<p>Prix : 1200</p>
					<p>Fin de l'enchère : soon</p>
					<p>Vendeur : John Smith</p>
				</div>
			</div>
			<div class="media col text-center">
				<div class="media-middle">
					<img src="images/raspberries-5163812_640.jpg"
						alt="image de framboises et myrtilles dans un bol"
						class="media-object" style="width: 200px; height: 200px">
				</div>
				<div class="media-body text-left ml-5">
					<h4 class="media-heading">Berries</h4>
					<p>Prix : 10</p>
					<p>Fin de l'enchère : pending</p>
					<p>Vendeur : John Doe</p>
				</div>
			</div>
		</div>
	</div>

	<footer class="py-5">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; - Assane - 2020</p>
		</div>
	</footer>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>