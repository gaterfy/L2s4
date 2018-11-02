<?php
/*
 * connection.php
 *
 * authors : Thomas Lombart - Martin Vasilev
 *
 * Enables the connection with the postgresql database hosted on webtp
 * If an error occured during the process, a message is printed out and the code stops running
 */

try {
    $connection = new PDO("pgsql:host=webtp.fil.univ-lille1.fr;dbname=lombart", "", "");
} catch (PDOException $e) {
    echo "Connection error : ", $e->getMessage();
    exit();
}
?>
