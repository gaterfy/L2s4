<!--
index.php

Projet : V'LiVe
Noms : LOMBART Thomas- VASILEV Martin
Date : 20 Mars 2017
-->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
    <head>
        <meta charset="UTF-8" />
        <title>V'liVe</title>
        <link rel="stylesheet" href="css/homepage.css" type="text/css" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.0.3/dist/leaflet.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300" />
    </head>
    <body>

      <header id="title">
        V'liVe
      </header>

      <div id="carteCampus"></div>

      <div id="float">
        <p><button class='btn'>Réinitialiser <i class="fa fa-arrows" aria-hidden="true"></i></button> la <i>carte</i> à son état original</p>
      </div>

      <div id="container">

        <div id="container-menu">
          <button id="stations">
            <i class="fa fa-2x fa-bicycle" aria-hidden="true"></i>
          </button>
          <button id="search">
            <i class="fa fa-2x fa-search" aria-hidden="true"></i>
          </button>
        </div>

        <div id="form-div">
            <form class="filter" action="index.php" method="post">
                <input type="text" name="name" placeholder="Nom de la station">
                <select name="city">
                  <option value="">Tout communes (*)</option>
                  <option value="LILLE">Lille (59000)</option>
                  <option value="ROUBAIX">Roubaix (59100)</option>
                  <option value="TOURCOING">Tourcoing (59200)</option>
                  <option value="VILLENEUVE D'ASCQ">Villeneuve d'Ascq (59009)</option>
                  <option value="MONS EN BAROEUL">Mons En Baroeul (59370)</option>
                  <option value="LA MADELEINE">La Madeleine (59110)</option>
                  <option value="LILLE HELLEMMES">Lille hellemmes (59260)</option>
                  <option value="LAMBERSART">Lambersart (59130)</option>
                  <option value="MARCQ EN BAROEUL">Marcq En Baroeul (59700)</option>
                  <option value="RONCHIN">Ronchin (59790)</option>
                  <option value="WATTRELOS">Wattrelos (59150)</option>
                  <option value="CROIX">Croix (59170)</option>
                  <option value="HELLEMMES">Hellemmes (59260)</option>
                  <option value="LOMME">Lomme (59160)</option>
                  <option value="SAINT ANDRE LEZ LILLE">Saint Andre Lez Lille (59350)</option>
                  <option value="FACHES-THUMNESNIL">Faches-Thumnesnil (59155)</option>
                </select>
                <input type="name" name="bicycle" placeholder="Nombre de vélos (>):" />
                <input type="name" name="places" placeholder="Nombre de places (>):" />
                <button type="submit" class="btn">Filtrer</button>
            </form>
          </div>

          <div id="stations-div">
              <?php
                require_once('proxyConfig.php');
                require_once('lib/lectureArguments.php');
                $allStations = buildList($query_decode);
                if (empty($allStations)) {
                    echo '<div class=\'not-found\'><i class="fa fa-3x fa-frown-o" aria-hidden="true"></i><p>Aucune station trouvée!</p></div>';
                } else {
                    echo $allStations;
                }
               ?>
          </div>

          <div id="focus">
            <!-- Sera rempli avec l'information pour la station en `focus` -->
          </div>

        <!-- End of container -->
        </div>

        <footer>
          <p><i class="fa fa-code" aria-hidden="true"></i> by Lombart Thomas &amp; Vasilev Martin</p>
          <a href="https://github.com/thomlom/l2s4/tree/master/tw2/projet1" target="_blank"><i class="fa fa-2x fa-github" aria-hidden="true"></i></a>
          <p>Données de la <a href="http://www.lillemetropole.fr/mel.html" target="_blank">MEL</a> sous licence <a href="https://www.etalab.gouv.fr" target="_blank">ETALAB</a></p>
          <p>Font Awesome by Dave Gandy - http://fontawesome.io</p>
        </footer>

        <script text="text/javascript" src="js/homepage.js"></script>
        <script src="https://use.fontawesome.com/7cf9e4dadf.js"></script>
	      <script type="text/javascript" src="js/VliveImage.js"></script>
        <script src="https://unpkg.com/leaflet@1.0.3/dist/leaflet.js"></script>

    </body>
</html>
