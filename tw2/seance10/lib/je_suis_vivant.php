<?php
require_once('connection.php');
require_once('Identite.class.php');
session_start();
$ident = $_SESSION['ident'];
$login = $ident->getLogin();
$stmt = $connection->prepare('SELECT now()');
$stmt->execute();
$now = new DateTime($stmt->fetch()[0]);
$stmt = $connection->prepare('SELECT * FROM still_alive');
$stmt->execute();

while ($line = $stmt->fetch()) {
  $date = new DateTime($line['stamp']);
  if (($now->getTimestamp()-$date->getTimestamp() >= 30) || ($line['login'] == $login)) {
    $delete = $connection->prepare('DELETE FROM still_alive WHERE login=:login');
    $delete->bindValue(':login', $line['login']);
    $delete->execute();
  };
}

$stmt = $connection->prepare('INSERT INTO still_alive(login) VALUES(:login)');
$stmt->bindValue(':login', $login);
$stmt->execute();

$dataToEncodeInJSON = array();
$stmt = $connection->prepare('SELECT login FROM still_alive');
$stmt->execute();

while ($line = $stmt->fetch()) {
  array_push($dataToEncodeInJSON, array("login" => $line['login']));
}
echo json_encode($dataToEncodeInJSON);
?>
