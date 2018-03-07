<?php
/*header("Content-Type: text/plain;charset=UTF-8");*/
require_once("lib/fonctionsLivre.php");    // inclusion de fichier

/* Test question 1.1
 */
/*
$ligneOK = " nom_de_prop : machin chose ";
$ligneKO = " nom_de_prop  machin chose ";
echo '|'.propertyName($ligneOK).'|';
echo "\n";
echo '|'.propertyValue($ligneOK).'|';
echo "\n";
echo '|'.propertyValue($ligneKO).'|';
*/

/* Test question 1.2
 */
/*
$file = fopen('data/exempleLivre.txt','r');
$livre = readBook($file);
print_r($livre);
*/

/* Test question 1.3.1 */
/*
echo elementBuilder('titre','h2','La marque du diable');
*/

/* Test question 1.3.2 */
/*
echo authorsToHTML('Marini - Desberge');
*/

/*Test question 1.3.3 */
//echo coverToHTML('scorpion.jpg');

/* Test question 1.3.4 */
/*
echo propertyToHTML('couverture','scorpion.jpg');
echo propertyToHTML('auteurs','Marini - Desberge');
*/

/* Test question 1.3.5 */
/*
$file = fopen('data/exempleLivre.txt','r');
$livre = readBook($file);
print_r($livre);
echo "<br/>";
*/


/* Test question 2.2 */
/*
$file = fopen('data/livres.txt','r');
$library = readBook($file);
print_r($library);
echo "<br/>";
*/

?>
