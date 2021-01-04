<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
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
		<h1>Connexion</h1>
	</div>

	<form method="post" action="login"
		class="col-sm-6 offset-sm-3 justify-content-center">
		<div class="form-group">
			<label for="identifiant">Identifiant :</label> <input type="text"
				class="form-control" id="identifiant" name="pseudo" 
				<c:if test="${!empty userConnected}">
					value="${u.pseudo}"
				</c:if>
				>
		</div>
		<div class="form-group">
			<label for="pwd">Mot de passe:</label> <input type="password"
				class="form-control" id="pwd" name="mdp">
		</div>
		<div class="row">
			<div class="col-6">
				<button type="submit" class="btn btn-info btn-lg">Connexion</button>
			</div>
			<div class="col-6">
				<div class="checkbox">
					<label><input type="checkbox" class="mx-2">Se souvenir de moi</label>
				</div>
				<div>
					<a href="" class="mx-2">Mot de passe oublié</a>
				</div>
			</div>
		</div>
	</form>
	<h4 class="text-danger font-weight-bold text-center">${erreur}</h4>
	<br>
	<div class="container my-4 col-sm-6 offset-sm-3 justify-content-center">
		<a href="creation" id="btn-creation"><button type="submit" class="btn btn-info btn-lg btn-block">Créer un compte</button></a>
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