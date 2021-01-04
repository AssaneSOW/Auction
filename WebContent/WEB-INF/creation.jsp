<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Création de compte Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/creation.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="row my-2">
			<span class="container titreEtLogo text-left">
				Enchères
			</span>
		</div>
	</header>

	<div class="jumbotron text-center">
		<h1>Mon compte</h1>
	</div>

	<form method="post" action="creation">
		<div class="row justify-content-center">
			<div class="col-5">
				<div class="form-group">
					<label for="identifiant">Pseudo :</label> <input type="text" name="pseudo"
						class="form-control" id="pseudo" value="${param.pseudo}">
				</div>
				<div class="form-group">
					<label for="prenom">Prénom :</label> <input type="text" name="prenom"
						class="form-control" id="prenom" value="${param.prenom}">
				</div>
				<div class="form-group">
					<label for="tel">Téléphone :</label> <input type="tel" name="tel"
						class="form-control" id="tel" value="${param.tel}">
				</div>
				<div class="form-group">
					<label for="cdp">Code Postal :</label> <input type="text" name="cdp"
						class="form-control" id="cdp" value="${param.cdp}">
				</div>
				<div class="form-group">
					<label for="pwd">Mot de passe:</label> <input type="password" name="mdp"
						class="form-control" id="pwd" value="${param.mdp}">
				</div>
			</div>

			<div class="col-5">
				<div class="form-group">
					<label for="identifiant">Nom :</label> <input type="text" name="nom"
						class="form-control" id="nom" value="${param.nom}">
				</div>
				<div class="form-group">
					<label for="identifiant">Email :</label> <input type="email" name="email"
						class="form-control" id="email" value="${param.email}">
				</div>
				<div class="form-group">
					<label for="identifiant">Rue :</label> <input type="text" name="rue"
						class="form-control" id="rue" value="${param.rue}">
				</div>
				<div class="form-group">
					<label for="identifiant">Ville :</label> <input type="text" name="ville"
						class="form-control" id="ville" value="${param.ville}">
				</div>
				<div class="form-group">
					<label for="identifiant">Confirmation Mot de passe :</label> <input type="password" name="confMdp"
						class="form-control" id="confMdp" value="${param.confMdp}">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row justify-content-around">
					<a href="accueil"><button type="submit" name="btn-creer" value="creer" class="btn btn-success btn-lg">Créer</button></a>
					<a href="login"><button type="submit" name="btn-annuler" value="annuler" class="btn btn-danger btn-lg">Annuler</button></a>
			</div>
		</div>
	</form>
	<h4 class="text-danger font-weight-bold text-center">${erreurMdpConf}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurMdpUnicite}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurEmail}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurPseudo}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurPseudoUnique}</h4>

	<footer class="py-5">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; - Assane -
				2020</p>
		</div>
	</footer>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>