<?php
require_once('connection.php');

/**
 * Construct a form that allows the user to choose a street among a list of streets
 * @param string $cc the name of the town
 * @param string $url the url that will receive the parameters
 * @return string the HTML code of the form
 */
function formVoies($cc, $url) {
  global $connection;

  // Get the list of the streets
  $select = "<select name='cVoie'>";
  $query = "SELECT voies.nom_voie, voies.code_voie FROM voies JOIN communes on voies.code_commune = communes.code_commune WHERE nom_commune='$cc';";
  $stmt = $connection->prepare($query);
  $stmt->execute();
  while ($line = $stmt->fetch()) {
    $code = $line['code_voie'];
    $name = $line['nom_voie'];
    $select .= "<option value='$code'>$name</option>";
  }
  $select .= "</select>";

  // Get the code of the city
  $query = "SELECT code_commune FROM communes WHERE nom_commune='$cc';";
  $stmt = $connection->prepare($query);
  $stmt->execute();
  $code_commune = $stmt->fetch()[0];

  // Construct the form and return
  $city = "<input type='hidden' name='cCommune' value='$code_commune'/>";
  $button = "<button>Valider</button>";
  return "<form action='$url' method='get'>$select $button $city</form>";
}

/**
 * Gets the list of the adresses
 * @param int $cc the code of the town
 * @param int $cv the code of the street
 * @return string the HTML code corresponding to the list of adresses
 */
function listeAdresses($cc, $cv) {
  global $connection;
  $list = "<ul>\n";
  $query = "SELECT numero, nom_voie FROM adresses WHERE code_commune='$cc' AND code_voie='$cv'";
  $stmt = $connection->prepare($query);
  $stmt->execute();
  while ($line = $stmt->fetch()) {
    $list .= "\t<li>{$line['numero']} {$line['nom_voie']}\n";
  }
  $list .= "</ul>\n";
  return $list;
}
?>
