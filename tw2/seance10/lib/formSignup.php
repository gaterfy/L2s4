<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Inscription</title>
  </head>
  <body>
    <h2> Page d'inscription </h2>
    <form method="POST" action="">
      <fieldset>
        <label for="login">Login :</label>
        <input type="text" name="login" id="login" required></input>
        <br/>
        <label for="password">Password :</label>
        <input type="password" name="password" id="password" required></input>
        <br/>
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" required></input>
        <br/>
        <label for="prenom">Prenom :</label>
        <input type="text" name="prenom" id="prenom" required></input>
        <br/>
        <button type="submit" name="valid">Valider</button>
      </fieldset>
    </form>
    <a href="../index.php">Revenir à la page d'accueil</a>
  </body>
</html>
