<!DOCTYPE htm
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="UTF-8" />
    <title>Liste des coureurs</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>
    <form action="addTime.php" method="post">
      <div>
        <label for="dossard">Dossard : </label>
        <input type="number" name="dossard" required>
      </div>
      <div>
        <label for="usr_time">Temps d'arrivée : </label>
        <input type="time" name="usr_time" required>
      </div>
      <button type="submit">Ajouter</button>
    </form>
  </body>
</html>