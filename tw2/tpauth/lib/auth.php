<?php
require_once('biblio.php');
try {
    controleAuthentification();
} catch (Exception $e) {
    require('formuLogin.php');
    exit();
}
