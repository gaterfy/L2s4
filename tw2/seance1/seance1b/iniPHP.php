<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Premier exercice PHP</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="iniPHP.css" />
    </head>
    <body>
        <header>
            <h1>Seance 1b PHP</h1>
            <h2>Réalisé par <span class="nom">Martin Vasilev - Thomas Lombart</span></h2>
        </header>
        <section>
            <h2>Exercice1</h2>
            <?php
              echo '<ul>';
              $file = fopen('liste_noms.txt','r');
              $ligne = fgets($file);
              $i = 0;
              while ($ligne !== FALSE) {
                echo '<li>',$ligne,'</li>';
                $ligne = fgets($file);
                $i++;
              }
              echo '</ul>';
            ?>
        </section>
        <section>
            <h2>Exercice2</h2>
            <?php
              $table = "<table id='terrain'>";
              $file = fopen('terrain.txt','r');
              $ligne = fgets($file);
              $linelength = strlen($ligne);
              $error = FALSE;
              $cpt = 0;
              while (($ligne !== FALSE) && ($cpt < (strlen($ligne)-2)) && !$error) {
                $len = strlen($ligne);
                $table = $table.'<tr>';
                for ($i = 0; $i < $len; $i++) {
                  if ($ligne{$i} == 'B') {
                    $table = $table . "<td class='blanc'><span>B</span></td>";
                  }
                  elseif ($ligne{$i} == 'N') {
                    $table = $table . "<td class='noir'><span>N</span></td>";
                  }
                  else {
                    if ($ligne{$i} == '-') {
                      $table = $table . "<td></td>";
                    }
                  }
                }
                if ($len !== $linelength) {
                  $error = TRUE;
                }
                $table = $table . '</tr>';
                $ligne = fgets($file);
                $cpt++;
              }
              if (($ligne == FALSE) && !$error) {
                echo $table,'</table>';
              }
              else {
                echo 'Incorrect terrain!';
              }
            ?>
        </section>
        <section>
            <h2>Exercice3.1</h2>
            <?php
              $s = "Et qu'on sorte+  Vistement : +Car Clement + Le vous mande.";
              $list = explode('+',$s);
              foreach ($list as $i) {
                echo '<p>',trim($i),'</p>';
              }
            ?>
        </section>
        <section>
            <h2>Exercice3.2</h2>
            <?php
              $s = 'MARTIN - VASILEV - LOMBART - THOMAS';
              $list = explode('-',$s);
              foreach ($list as $i) {
                echo '<span>',trim($i),'</span>';
              }
            ?>
        </section>
        <section>
            <h2>Exercice3.3</h2>
            <?php
              function enSpan($s) {
                $list = explode('-',$s);
                foreach ($list as $i) {
                  echo '<span>',trim($i),'</span>';
                }
              }
              enSpan('MARTIN - THOMAS - JULES - ALEXANDRE')
            ?>
        </section>
        <script type="text/javascript" src="iniPHP.js"></script>
    </body>

</html>
