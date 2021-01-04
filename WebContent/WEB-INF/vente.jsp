<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vente Enchères</title>
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/vente.css" rel="stylesheet">
<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1;
var yyyy = today.getFullYear();
 if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 

today = dd+'-'+mm+'-'+yyyy;
document.getElementById("debutEnchere").setAttribute("min", today);
document.getElementById("debutEnchere").setAttribute("value", today);
todayWeekLater = today.getDate()+7;
document.getElementById("finEnchere").setAttribute("min", todayWeekLater);
document.getElementById("finEnchere").setAttribute("value", todayWeekLater);
</script>
</head>
<body class="bg-light">
	<header>
		<div class="row bg-light my-2">
		<span class="titreEtLogo align-top col ml-3 text-left">
		<c:if test="${!empty userConnected}">
					<a href="accueil" class="mx-5">
					<img src="images/gavel-3577255_640.jpg" class="logo" alt="logo du site représentant le marteau du juge"></a>
				</c:if>
				Enchères
			</span>
			<span class="titrePage align-middle col text-center">
				Nouvelle vente
			</span>
			<span class="col">
			</span>
		</div>
	</header>

	<form method="post" action="vente" class="form" enctype="multipart/form-data">
		<div class="row justify-content-center">
			<div class="col-auto">
				<table>
					<tr>
						<td><label for="article">Article :</label></td>
						<td><input type="text" name="article"
						class="form-control" id="article" value="${param.article}"></td>
					</tr>
					<tr>
						<td><label for="description">Description :</label></td>
						<td><textarea name="description"
						class="form-control" rows="3" id="tel" placeholder="Courte description de votre article"></textarea></td>
					</tr>
					<tr>
						<td><label for="categorie">Catégorie :</label></td>
						<td><select
						id="categorie" name="categorie">
						<option value="Toutes">Toutes</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Informatique">Informatique</option>
						<option value="SportEtLoisirs">Sport et Loisirs</option>
						<option value="Vetements">Vêtements</option>
					</select></td>
					</tr>
					<tr>
						<td><label for="photo">Photo de l'article :</label></td>
						<td><input type="file" name="photo"
						class="form-control" id="photo" value="Charger une image"></td>
						<c:if test="${!empty photo }">
							<p class="em">Photo chargée avec succès !</p>
						</c:if>
					</tr>
					<tr>
						<td><label for="prix">Mise à prix :</label></td>
						<td><input type="number" name="prix"
						class="form-control" id="prix" min="0" step="10" value="${param.prix}"></td>
					</tr>
					<tr>
						<td><label for="debutEnchere">Début de l'enchère :</label></td>
						<td><input type="datetime-local" name="debutEnchere"
						class="form-control" id="debutEnchere"></td>
					</tr>
					<tr>
						<td><label for="finEnchere">Fin de l'enchère :</label></td>
						<td><input type="datetime-local" name="finEnchere"
						class="form-control" id="finEnchere"></td>
					</tr>
				</table>
				<fieldset class="border p-2">
					  	<legend class="w-25">Retrait</legend>
				<table>
					<tr>
						<td><label for="rue">Rue :</label></td>
						<td><input type="text" id="rue" name="rue" value="${rue}"></td>
					</tr>
					<tr>
						<td><label for="cdp">Code Postal :</label></td>
						<td><input type="text" id="cdp" name="cdp" value="${cdp}"></td>
					</tr>
					<tr>
						<td><label for="ville">Ville :</label><br></td>
						<td><input type="text" id="ville" name="ville" value="${ville}"></td>
					</tr>
				</table>
				</fieldset>
			</div>
		</div>
		<br>
		<div class="row justify-content-around">
			<div class="col-auto">
				<a href="enregistrerVente"><button type="submit" name="btn-enregistrer"
						value="enregistrer" class="btn btn-success btn-lg">Enregistrer</button></a>
						<a href="accueil"><button type="submit" name="btn-retour"
						value="retour" class="btn btn-dark btn-lg">Retour</button></a>
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