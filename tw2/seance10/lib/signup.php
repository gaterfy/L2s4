<?php
 require('lib/biblio.php');
 try {
     createUser();
 } catch (Exception $e) {
     require('lib/formSignup.php');
     exit();
 }
