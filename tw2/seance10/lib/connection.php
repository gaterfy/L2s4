<?php
try {
    $connection = new PDO("pgsql:host=webtp.fil.univ-lille1.fr;dbname=lombart", "lombart", "helloworld");
    $connection->setAttribute(
        PDO::ATTR_ERRMODE,
        PDO::ERRMODE_EXCEPTION
    );
} catch (PDOException $e) {
    echo "Connection error : ", $e->getMessage();
    exit();
}
?>
