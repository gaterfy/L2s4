<?php
require_once("connection.php");
$login = $_GET['login'];
$stmt = $connection->prepare("SELECT type, image FROM avatars WHERE login=:login");
$stmt->bindValue(':login', $login);
$stmt->execute();
$stmt->bindColumn('type', $type);
$stmt->bindColumn('image', $image, PDO::PARAM_LOB);
$stmt->fetch();
//Set the header
header("Content-Type: $type");
//Creation de fichier temporaire
$tmpHandle = tmpfile();
stream_copy_to_stream($image,$tmpHandle);
$metaDatas = stream_get_meta_data($tmpHandle);
$tmpFilename = $metaDatas['uri'];
list($w,$h) = getimagesize($tmpFilename);
//Verification de la taille
if ($w > 70 || $h > 70 ) {
  //Creation de la nouvelle image a remplir
  $image_p = imagecreatetruecolor(70,70);
  //Verification du type
  if ($type == "image/jpeg") {
    $image = imagecreatefromjpeg($tmpFilename);
  }
  else if ($type == "image/png") {
    $image = imagecreatefrompng($tmpFilename);
  }
  //Modifications associes a la taille
  if ($w > 70) {
    $w_n = ($w-70)/2;
  }
  if ($h > 70) {
    $h_n = ($h-70)/2;
  }
  imagecopyresampled($image_p,$image,0,0,$w_n,$h_n,70,70,70,70);
  fclose($tmpHandle);
  imagepng($image_p);
} else {
  rewind($image);
  fpassthru($image);
}
?>
