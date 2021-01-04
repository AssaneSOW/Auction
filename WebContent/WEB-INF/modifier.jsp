<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modification profil Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/modifier.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="row my-2">
		<c:if test="${!empty userConnected}">
					<a href="accueil" class="mx-5">
					<img src="images/gavel-3577255_640.jpg" class="logo" alt="logo du site représentant le marteau du juge"></a>
				</c:if>
			<span class="container titreEtLogo text-left">
				Enchères
			</span>
		</div>
	</header>

	<div class="jumbotron text-center">
		<h1>Mon nouveau profil</h1>
	</div>

	<form method="post" action="modifier">

		<div class="row justify-content-center">
			<div class="col-auto">
			<input type="hidden" name="id" value="${id}">
				<table class="table table-responsive">
					<tr>
						<td>Pseudo :</td>
						<td><input type="text" name="pseudo" placeholder="${pseudo}"
							value="${param.pseudo}"></td>
					</tr>
					<tr>
						<td>Nom :</td>
						<td><input type="text" name="nom" placeholder="${nom}"
							value="${param.nom}"></td>
					</tr>
					<tr>
						<td>Prénom :</td>
						<td><input type="text" name="prenom" placeholder="${prenom}"
							value="${param.prenom}"></td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="text" name="email" placeholder="${email}"
							value="${param.email}"></td>
					</tr>
					<tr>
						<td>Téléphone</td>
						<td><input type="tel" name="tel" placeholder="${tel}"
							value="${param.tel}"></td>
					</tr>
					<tr>
						<td>Rue :</td>
						<td><input type="text" name="rue" placeholder="${rue}"
							value="${param.rue}"></td>
					</tr>
					<tr>
						<td>Code Postal :</td>
						<td><input type="text" name="cdp" placeholder="${cdp}"
							value="${param.cdp}"></td>
					</tr>
					<tr>
						<td>Ville</td>
						<td><input type="text" name="ville" placeholder="${ville}"
							value="${param.ville}"></td>
					</tr>
					<tr>
						<td>Ancien mot de passe :</td>
						<td><input type="password" name="mdp" value="${param.mdp}"></td>
					</tr>
					<tr>
						<td>Nouveau mot de passe :</td>
						<td><input type="password" name="nvMdp"></td>
					</tr>
					<tr>
						<td>Confirmation du nouveau mot de passe :</td>
						<td><input type="password" name="confNvMdp"></td>
					</tr>
				</table>
				<p class="text-center">Crédit : ${credit}</p>
			</div>
		</div>
		<br>
		<div class="row justify-content-around">
			<div class="col-auto">
				<a href="modifier"><button type="submit" name="btn-enregistrer"
						value="enregistrer" class="btn btn-success btn-lg">Enregistrer</button></a> <a
					href="monProfil"><button type="submit" name="btn-annuler"
						value="annuler" class="btn btn-danger btn-lg">Annuler</button></a>
			</div>
		</div>
	</form>
	<h4 class="text-danger font-weight-bold text-center">${erreurConfAncienMdp}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurConfNvMdp}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurMdpUnicite}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurEmail}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurPseudo}</h4>
	<h4 class="text-danger font-weight-bold text-center">${erreurPseudoUnique}</h4>

	<footer class="py-5">
		<div class="container">
			<p class="m-0 text-center">Copyright &copy; - Assane - 2020</p>
		</div>
	</footer>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>