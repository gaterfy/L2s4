<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="UTF-8"/>
    <title>Authentifiez-vous</title>
    <style>
    input:invalid {background-color:lightred;}
    input:valid {background-color:lightblue;}
    </style>
  </head>
<body>
<?php
 if (isset($_SESSION['echec'])) {
     echo "<p>Les login et mot de passe précédemment fournis étaient incorrects</p>";
 }
?>
<h2>Authentifiez-vous</h2>

<form method="POST" action="">
 <fieldset>
  <label for="login">Login :</label>
  <input type="text" name="login" id="login" required="required" autofocus="autofocus"/>
  <label for="password">Mot de passe :</label>
  <input type="password" name="password" id="password" required="required" />
  <button type="submit" name="valid">Valider</button>
 </fieldset>
</form>

<p>Pas de compte ? Cliquez <a href="welcome.php">ici</a></p>
</body>
</html>
