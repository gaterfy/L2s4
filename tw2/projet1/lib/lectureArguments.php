<?php
/*
lectureArguments.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
*/

require_once('buildList.php');
// URL used to get the data
$query = "https://opendata.lillemetropole.fr/api/records/1.0/search/?rows=250&dataset=vlille-realtime&format=json&q=";
// Filter used for the number of places
$nbpFilter = filter_input(INPUT_POST, 'places', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]+$/')));
// Filter used for the number of bicycles
$nbbFilter = filter_input(INPUT_POST, 'bicycle', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]+$/')));
// Prevent the user from changing the city
$cityTable = array_fill_keys(array("LILLE", "ROUBAIX", "TOURCOING", "VILLENEUVE D'ASCQ", "MONS EN BAROEUL", "LA MADELEINE", "LILLE HELLEMMES", "LAMBERSART", "MARCQ EN BAROEUL", "RONCHIN", "WATTRELOS", "CROIX", "HELLEMMES", "LOMME", "SAINT ANDRE LEZ LILLE", "FACHES-THUMNESNIL"), TRUE);
$hasPrevious = false;

// Check the name
if (isset($_POST['name']) && !empty($_POST['name'])) {
  $name = $_POST['name'];
  $query .= "nom:{$name}";
  $hasPrevious = true;
}

// Check the city
if (isset($_POST['city']) && !empty($_POST['city']) && isset($cityTable[$_POST['city']])) {
  $city = $_POST['city'];
  if ($hasPrevious) {
    $query = " AND ";
  }
  $query .= urlencode("commune:{$city}");
  $hasPrevious = true;
}

// Check the number of bicycles
if (isset($_POST['bicycle']) && !empty($_POST['bicycle']) && ($nbbFilter!=NULL && $nbbFilter!=FALSE)) {
  $nbBicycles = $_POST['bicycle'];
  if ($hasPrevious) {
    $query .= " AND ";
  }
  $query .= "nbVelosDispo>{$nbBicycles}";
  $hasPrevious = true;
}

// Check the number of places
if (isset($_POST['places']) && !empty($_POST['places']) && ($nbpFilter!=NULL && $nbpFilter!=FALSE)) {
  $nbPlaces = $_POST['places'];
  if ($hasPrevious) {
    $query .= " AND ";
  }
  $query .= "nbPlacesDispo>{$nbPlaces}";
}

$query_json = file_get_contents($query, "r");
$query_decode = json_decode($query_json);
?>
