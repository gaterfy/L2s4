<?php
header("Content-type: text/plain;charset=UTF-8");
require_once("lib/fonctionsLivre.php");

$file = fopen('data/livres.txt','r');
$library = loadBiblio($file);
print_r($library);

$HTMLCode = biblioToHTML($library);
echo $HTMLCode;

?>
