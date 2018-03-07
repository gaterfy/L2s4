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
            $file = fopen('data/exempleLivre.txt', 'r');
            libraryToHTML($file);
          ?>
        </section>
    </body>

</html>
