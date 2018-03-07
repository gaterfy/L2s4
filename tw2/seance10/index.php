<?php
require_once('lib/auth.php');
$ident = $_SESSION['ident'];
?>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="UTF-8"/>
    <title>Page à accès contrôlé</title>
  </head>
<body>
  <h1>
    <?php
    echo "Bienvenue ". $ident->getPrenom() . " " .$ident->getNom();
    $login = $ident->getLogin();
    echo "<img src=\"lib/avatar.php?login={$login}\" alt=\"avatar\" />";
     ?>
  </h1>
  <a href="myaccount.php">Mon compte</a>
  <br/>
  <a href="logout.php">Se déconnecter</a>
  <h3> Voici les autres utilisateurs connectes ! </h3>  
  <script type="text/javascript">
  function setup() {
    var req = new XMLHttpRequest();
    req.open('GET', 'lib/je_suis_vivant.php', true);
    req.addEventListener("load",traiteResponse);
    req.addEventListener("error",error);
    req.send(null);
  }

  function traiteResponse(e) {
    try {
      var data = JSON.parse(this.responseText);
    } catch (e) {
      alert('something went wrong');
    }
    var users = document.createElement('ul');
    for (var i = 0; i < data.length; i++) {
      var user = document.createElement('li');
      user.innerHTML = data[i].login;
      users.appendChild(user);
    }
    document.body.appendChild(users);
  }

  function error(e) {
  }

  window.addEventListener("load",setup)
  </script>
</body>
</html>
