<?php
require_once('lib/Facture.class.php');
require_once('lib/lectureArguments.php');
// We create a new bill
$facture = new Facture($nom, $prenom, $civilite, $voie, $compl, $cp ,$commune);
// Verify adhesion status
if ($_GET['adhesion'] === 'dejaMembre') {
  $facture->setAdherent();
}
if ($_GET['adhesion'] === 'oui') {
  $facture->ajouterAdhesion();
}
// Add all figures
foreach ($fig as $f) {
  $facture->ajouterFigurine($f);
}
?>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
 <meta charset="UTF-8" />
 <title>Facture du club des fans de Star Wars</title>
 <link rel="stylesheet" type="text/css" href="factureStarWars.css" />
 <style type="text/css">

 </style>
</head>
<body>
  <?php
  echo $facture->toHTML();
  ?>
</body>
<html>
