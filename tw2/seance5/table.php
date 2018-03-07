<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="UTF-8" />
    <title>Liste des coureurs</title>
    <link rel="stylesheet" type="text/css" href="style.css">
  </head>
  <body>
    <?php
    require_once('connection.php');
    $query = "SELECT coureurs.nom as coureur, equipes.nom as equipe, equipes.directeur FROM coureurs, equipes where coureurs.equipe = equipes.nom";
    $stmt = $connection->prepare($query);
    $stmt->execute();
    echo "<table>";
      while ($line = $stmt->fetch()) {
      echo "<tr><td>{$line['coureur']}</td>".
      "<td>{$line['equipe']}</td>".
      "<td>{$line['directeur']}</td></tr>";
      }
    echo"</table>";
    ?>
  </body>
</html>