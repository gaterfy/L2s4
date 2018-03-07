<?php
require('lib/auth.php');

echo $_SESSION['ident']->getName() . "<br>" . $_SESSION['ident']->getFirstName();
?>
