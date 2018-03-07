<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Bibliothèque</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <header>
            <h1>Bibliothèque</h1>
        </header>
        <section>
          <?php
            require_once('lib/fonctionsLivre.php');
            require_once('lib/fonctionsComparaison.php');
            $file = fopen('data/livres.txt', 'r');
            $library = loadBiblio($file);
            if (isset($_GET['ordre'])) {
              $ordre = $_GET['ordre'];
              switch ($ordre) {
                case 'titres':
                  echo biblioToHTML($library, "titles");
                  break;
                case 'aucun':
                  echo biblioToHTML($library);
                  break;
                case 'categories':
                  echo biblioToHTML($library, 'categories');
                  break;
              }
            }
            else {
              echo biblioToHTML($library);
            }
          ?>
        </section>
    </body>

</html>
