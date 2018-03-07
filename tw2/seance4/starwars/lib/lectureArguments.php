<?php
  // Validity tables
  $figuresTable = array_fill_keys(array('Maître Yoda', 'Luke Skywalker', 'Anakin Skywalker', 'Dark Vador', 'Obi-Wan Kenobi', 'Han Solo', 'Princesse Leia', 'Padmée Amidala', 'Empereur Palpatine', 'R2D2', 'C3PO', 'Chewbacca', 'Rey', 'Finn', 'Poe Dameron', 'Kylo Ren'), TRUE);
  $civilityTable = array_fill_keys(array('Mr', 'Mme'), TRUE);
  $adhesionTable = array_fill_keys(array('oui','non','dejaMembre'), TRUE);
  $cpFilter = filter_input(INPUT_GET, 'cp', FILTER_VALIDATE_REGEXP, array('options'=>array('regexp'=>'/^[0-9]{5}$/')));

  /*
  * Returns to the starWars form page and prints the error message (if there is one)
  */
  function exit_to_error($msg) {
    $error = $msg;
    require('starWars.php');
    exit();
  }

  // We check for civility, adhesion, figures and postal code if this property is set and if parameters haven't been modified
  if (!isset($_GET['civilite']) || !isset($civilityTable[$_GET['civilite']])) {
    exit_to_error('Invalid civility');
  }
  else if (!isset($_GET['adhesion']) || !isset($adhesionTable[$_GET['adhesion']])) {
    exit_to_error('Invalid adhesion');
  }
  else if (!isset($_GET['fig'])) {
    exit_to_error('Invalid figures');
  }
  else if (($cpFilter == FALSE) || ($cpFilter == NULL)) {
    exit_to_error('Invalid postal code');
  }
  // We consider that the name, first name, street, town are required. We check first if they are all set
  else if (!isset($_GET['nom']) || !isset($_GET['prenom']) || !isset($_GET['commune']) || !isset($_GET['voie'])) {
    exit_to_error('Invalid credentials');
  }
  // We check then if they are not empty
  else if (empty($_GET['nom']) || empty($_GET['prenom']) || empty($_GET['commune']) || empty($_GET['voie'])) {
    exit_to_error('Invalid credentials');
  }
  // All tests passed, we can set the values
  else {
    // We check every figure if it is a valid one
    foreach ($_GET['fig'] as $figure) {
      if (!isset($figuresTable[$figure])) {
        exit_to_error('Invalid figure');
      }
    }
    $civilite = $_GET['civilite'];
    $adhesion = $_GET['adhesion'];
    $nom = $_GET['nom'];
    $prenom = $_GET['prenom'];
    $voie = $_GET['voie'];
    $commune = $_GET['commune'];
    $compl = $_GET['compl'];
    $cp = $_GET['cp'];
    $fig = $_GET['fig'];
  }
?>
