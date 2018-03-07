<?php
  // We verify the parameters
  if (isset($_GET['fig']) && isset($_GET['cx']) && !empty($_GET['cx']) && !empty($_GET['cy']) && !empty($_GET['r']) && isset($_GET['cy']) && isset($_GET['r'])) {
    require('figures.php');
  }
  else {
    require('page_erreur.html');
    exit();
  }
?>
