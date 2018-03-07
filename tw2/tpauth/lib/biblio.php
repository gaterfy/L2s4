<?php
require_once("Identite.class.php");

/**
 * Authentify a user based on its login
 * @param string $login the login of the user
 * @param string $password the password to check
 * @return
 */
function authentifier($login, $password)
{
    $file = fopen("lib/password.txt", "r");
    $line = fgets($file);
    while ($line !== false) {
        $data_user = explode(";", $line);
        $login_to_check = $data_user[0];
        $password_to_check = $data_user[1];
        $nom = $data_user[2];
        $prenom = $data_user[3];
        if ($login === $login_to_check && $password === $password_to_check) {
            return new Identite($login, $nom, $prenom);
        }
        $line = fgets($file);
    }
    return null;
}

function controleAuthentification()
{
    if (isset($_SESSION['ident'])) {
      return;
    } elseif (isset($_REQUEST['login']) && isset($_REQUEST['password'])) {
        $id = authentifier($_REQUEST['login'], $_REQUEST['password']);
        if ($id) {
            $_SESSION['ident'] = $id;
        }
    } else {
        throw new Exception("Error");
    }
}
