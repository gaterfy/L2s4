<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Premier exercice PHP</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="iniPHP.css" />
    </head>
    <body>
        <header>
            <h1>Premier exercice PHP</h1>
            <h2>Réalisé par <span class="nom">Thomas Lombart</span></h2>
        </header>
        <section>
            <h2>Question 1</h2>
            <?php
            date_default_timezone_set("Europe/Paris");
            echo "Nous sommes le ", date('d/m/Y') ;
            ?>
        </section>
        <section>
            <h2>Question 2</h2>
            <?php
            echo "PHP Version ", constant("PHP_VERSION"), "<br>";
            echo "PHP OS ", constant("PHP_OS");
            ?>
        </section>
        <section>
            <h2>Question 3</h2>
            <?php
            $n = 10;
            $texte = "Hello world !";
            printf("\$n vaut %d et \$texte vaut %s", $n, $texte);
            ?>
        </section>
        <section>
            <h2>Question 4</h2>
            <?php
            for ($i=0; $i < $n; $i++) {
              echo "<p>$texte</p>";
            }
            ?>
        </section>
        <section>
            <h2>Question 5</h2>
            <?php
            for ($i=0; $i < strlen($texte); $i++) {
              echo "<p>", substr($texte, 0, strlen($texte)-$i);
            }
            ?>
        </section>
        <section>
            <h2>Question 6</h2>
            <?php
            echo "<ul>";
            for ($i=0; $i < strlen($texte); $i++) {
              echo "<li>", substr($texte, 0, strlen($texte)-$i), "</li>\n";
            }
            echo "</ul>";
            ?>
        </section>
        <section>
            <h2>Question 7</h2>
            <?php
            echo "<ul>";
            for ($i=1; $i < 10; $i++) {
              echo "<li>2 * $i = ", 2*$i, "</li>";
            }
            echo "</ul>";
            ?>
        </section>
        <section>
            <h2>Question 8</h2>
            <?php
            for ($i=2; $i < 10; $i++) {
              echo "<ul>";
              for ($j=2; $j < 10; $j++) {
                echo "<li>$i * $j = ", $i*$j, "</li>";
              }
              echo "</ul>";
            }
            ?>
        </section>
        <section>
            <h2>Question 9</h2>
            <?php
            echo "<table>";
            echo "<tr><td>*</td>";
            for ($i=2; $i < 10; $i++) {
              echo "<td>$i</td>";
            }
            echo "</tr>";
            for ($i=2; $i < 10; $i++) {
              echo "<tr>";
              for ($j=1; $j < 10; $j++) {
                echo "<td>", $i*$j, "</td>";
              }
              echo "</tr>";
            }
            echo "</table>";
            ?>
        </section>
    </body>

</html>
