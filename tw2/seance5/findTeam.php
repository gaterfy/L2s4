<?php
require_once('connection.php');
$team = $_POST['name'];
$query = "SELECT directeur, couleur from equipes WHERE nom='$team'";
$stmt = $connection->prepare($query);
$stmt->execute();
$count = $stmt->rowCount();
if ($count > 0) {
	while ($line = $stmt->fetch()) {
		echo "Directeur : " . $line['directeur'] . "<br/>";
		echo "Couleur : " . $line['couleur'] . "<br/>";
		echo "Liste des coureurs : " ;
	}
} else {
	echo "no data for the director and the color of the team<br/>";
}

$query = "SELECT nom from coureurs WHERE equipe='$team'";
$stmt = $connection->prepare($query);
$stmt->execute();
$count = $stmt->rowCount();
if ($count > 0) {
	echo "<ul>";
	while ($line = $stmt->fetch()) {
		echo "<li>{$line['nom']}</li>";
	}
	echo "</ul>";
} else {
	echo "no data for the runners of this team";
}
?>