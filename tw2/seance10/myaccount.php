<?php
// We check first if user is authenticated and then sets the identity
require_once('lib/auth.php');
$ident = $_SESSION['ident'];
require_once('lib/account.php');
?>
