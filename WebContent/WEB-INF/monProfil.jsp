<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mon profil Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/monProfil.css" rel="stylesheet">
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
		<h1>Mon profil</h1>
	</div>
	
	<div class="row justify-content-center">
		<div class="col-auto">
			<table class="table table-responsive">

				<tr>
					<td>Pseudo :</td>
					<td>${pseudo}</td>
				</tr>
				<tr>
					<td>Nom :</td>
					<td>${nom}</td>
				</tr>
				<tr>
					<td>Prénom :</td>
					<td>${prenom}</td>
				</tr>
				<tr>
					<td>Email :</td>
					<td>${email}</td>
				</tr>
				<tr>
					<td>Téléphone</td>
					<td>${tel}</td>
				</tr>
				<tr>
					<td>Rue :</td>
					<td>${rue}</td>
				</tr>
				<tr>
					<td>Code Postal :</td>
					<td>${cdp}</td>
				</tr>
				<tr>
					<td>Ville</td>
					<td>${ville}</td>
				</tr>
			</table>
		</div>
	</div>
	
	
	
	
	<div class="row justify-content-around">
		<div class="col-auto">
			<a href="modifier"><button type="submit" name="btn-modifier" value="modifier"
			class="btn btn-info btn-lg">Modifier</button></a>
			<a href="supprimer"><button type="submit" name="btn-supprimer" value="supprimer"
			class="btn btn-danger btn-lg">Supprimer</button></a>
		</div>
	</div>


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