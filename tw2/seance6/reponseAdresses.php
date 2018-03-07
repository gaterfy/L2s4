<?php
require_once('lib/fonctionsAdresses.php');
$cCommuneFilter = filter_input(INPUT_GET, 'cCommune', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]{5}$/')));
$cVoieFilter = filter_input(INPUT_GET, 'cVoie', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]{4}$/')));

$paramsAreSet = (isset($_GET['cCommune']) && isset($_GET['cVoie']));
$paramsAreValid = ($cCommuneFilter && $cVoieFilter);
if ($paramsAreSet && $paramsAreValid) {
  echo listeAdresses($_GET['cCommune'], $_GET['cVoie']);
} else {
  echo "Invalid parameters";
  exit();
}
?>
