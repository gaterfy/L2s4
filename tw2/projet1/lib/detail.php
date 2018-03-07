<!--
detail.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
-->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/detail.css" />
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300" />
    <title>Présentaiton détaillée</title>
  </head>
  <body>
    <?php
      require_once('../proxyConfig.php');
      require_once('buildList.php');
      $filter = filter_input(INPUT_GET, 'id', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]+$/')));
      if (isset($_GET['id']) && !empty($_GET['id']) && $filter) {
        $id = $_GET['id'];
        $query = "https://opendata.lillemetropole.fr/api/records/1.0/search/?dataset=vlille-realtime&format=json&q=libelle:{$id}";
        $query_json = file_get_contents($query, "r");
        $query_decode = json_decode($query_json);
        $Station = buildFullDescription($query_decode);
        if (empty($Station)) {
          echo 'Cet id ne correspond à aucune station!';
        }
        else {
          echo $Station;
        }
      }
      else {
        echo "<script>window.addEventListener('load',function() {document.body.innerHTML = '<span class=\'error\'>Something went wrong </span>';});</script>";
      }
    ?>
  <div id='carteStation'></div>
    <script src="../js/scriptDetail.js" charset="utf-8"></script>
    <script src="https://use.fontawesome.com/7cf9e4dadf.js"></script>
    <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>
  </body>
</html>
