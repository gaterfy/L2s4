<?php
 require_once('biblio.php');
 $ident = $_SESSION['ident'];
 try {
     modifyAccount();
 } catch (Exception $e) {
     require_once('formAccount.php');
     exit();
 }
?>
