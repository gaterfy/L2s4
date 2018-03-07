<?php
require_once('lib/connection.php');
global $connection;

if (isset($_GET['interest'])) {
  $query = "SELECT password.login, password.nom, password.prenom FROM password JOIN interets ON password.login = interets.login WHERE interets.sujet = '{$_GET['interest']}'";
} else {
  $query = "SELECT login, nom, prenom FROM password";
}
$dataToEncodeInJSON = array();
$stmt = $connection->prepare($query);
$stmt->execute();
// We push every user found (based on the query) in the array
while ($line = $stmt->fetch()) {
  array_push($dataToEncodeInJSON, array("login" => $line['login'], "nom" => $line['nom'], "prenom" => $line['prenom']));
}
echo json_encode($dataToEncodeInJSON);
?>
