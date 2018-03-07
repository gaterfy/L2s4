<?php
require_once('connection.php');

function __autoload($className)
{
    require_once('lib/'.$className . '.class.php');
}


/**
 * Gets the user that is stored in the file
 * @param $file the file in which we find the users
 * @return null if there is not 4 informations or if file is empty, the user otherwise
 */
function getUser($file)
{
    $ligne = fgets($file);
    if (! $ligne) {
        return null;
    }
    $tab = explode(";", $ligne);
    if (count($tab) != 4) {
        return null;
    }
    return $tab;
}


/**
 * Authenticates a user
 * @param $login the login of the user to authenticate
 * @param $password the password of the user to authenticate
 * @return A Identite object describing the user if authentication was successfull, null otherwise
 */
function authentifier($login, $password)
{
    global $connection;
    $stmt = $connection->prepare('SELECT * from password');
    $stmt->execute();
    while ($user = $stmt->fetch()) {
        if ($login===$user['login'] && crypt($password, $user['password']) === $user['password']) {
            return new Identite($user['login'], $user['nom'], $user['prenom']);
        }
    }
    return null;
}


/**
 * Checks the authentication
 * This function ends normally if authentications was already successfull
 * Or if the login and password given were correct
 * If authentication was successfull, we store the identity of the user in $_SESSION
 * Otherwize, an exception is triggered
 */
function controleAuthentification()
{
    if (isset($_SESSION['ident'])) {
        return;
    }
    $login = inputFilterString('login');
    $password = inputFilterString('password');
    $ident = authentifier($login, $password);
    if (! $ident) {
        $_SESSION['echec']=true;
        throw new Exception('login/password incorrects');
    }
    $_SESSION['ident'] = $ident;
    unset($_SESSION['echec']);
}


/**
 * Filters the given string
 * @param $name the string to filter
 * @param $requis precises if $name is required or not
 * @return the string if successfull, an exception otherwise
 */
function inputFilterString($name, $requis=true)
{
    $v = filter_input(INPUT_POST, $name, FILTER_SANITIZE_STRING);
    if ($requis && $v == null) {
        throw new Exception("argument $name est requis");
    }
    return $v;
}


/**
 * Generates a random string
 * @param $length the length of the random string (22 by default)
 * @return the random string
 */
function generateRandomString($length = 22)
{
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $charactersLength = strlen($characters);
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, $charactersLength - 1)];
    }
    return $randomString;
}


/**
 * Generates the salt
 * @return the salt
 */
function generateSalt()
{
    return '$2a$10$' . generateRandomString();
}


/**
 * Creates a user and insert it in the database
 * Four informations are stored :
 * - login
 * - password
 * - name
 * - first name
 */
function createUser()
{
    $login = inputFilterString('login');
    $password = inputFilterString('password');
    $nom = inputFilterString('nom');
    $prenom = inputFilterString('prenom');
    global $connection;
    $stmt = $connection->prepare('INSERT INTO password values (:login, :password, :nom, :prenom)');
    $stmt->bindValue(':login', $login);
    $stmt->bindValue(':nom', $nom);
    $stmt->bindValue(':prenom', $prenom);
    $password = crypt($password, generateSalt());
    $stmt->bindValue(':password', $password);
    $stmt->execute();
}


/**
 * Allows the user to modify its account, that is to say :
 * - Modify its password
 * - Add his interests
 */
function modifyAccount()
{
    global $ident;
    global $connection;
    $login = $ident->getLogin();

    // If user wants to modify its password
    if (isset($_REQUEST['validate_password'])) {
        $password = inputFilterString('password');
        $password = crypt($password, generateSalt());
        $stmt = $connection->prepare('UPDATE password SET password=:password WHERE login=:login');
        $stmt->bindValue(':password', $password);
        $stmt->bindValue(':login', $login);
        $stmt->execute();
        echo "Votre mot de passe a été modifié";
    }

    // If the user wants to add its interests
    if (isset($_REQUEST['validate_interests'])) {
        $interests = explode(',', inputFilterString('interets'));
        foreach ($interests as $interest) {
            $interest = trim($interest);
            $stmt = $connection->prepare('INSERT INTO interets(login, sujet) VALUES (:login, :interest)');
            $stmt->bindValue(':login', $login);
            $stmt->bindValue(':interest', $interest);
            $stmt->execute();
        }
        echo "Vos intérêts ont été ajoutés";
    }

    // If the user wants to add its avatar
    if (isset($_REQUEST['validate_avatar'])) {
        $type = $_FILES['avatar']['type'];
        $image = fopen($_FILES['avatar']['tmp_name'],'r');
        $stmt = $connection->prepare('INSERT INTO avatars (login, image, type) VALUES (:login, :image, :type)');
        $stmt->bindValue(':login', $login);
        $stmt->bindValue(':image', $image, PDO::PARAM_LOB);
        $stmt->bindValue(':type', $type);
        try {
          $stmt->execute();
        }
        catch (PDOException $e) {
          $stmt = $connection->prepare("UPDATE avatars SET image = :image, type = :type WHERE login = :login");
          rewind($image);
          $stmt->bindValue(':login', $login);
          $stmt->bindValue(':image', $image, PDO::PARAM_LOB);
          $stmt->bindValue(':type', $type);
          $stmt->execute();
        }
        echo "Votre avatar a été ajouté";
    }

    // If the variables above haven't been set, we give to the user the form
    if (!isset($_REQUEST['validate_password']) && !isset($_REQUEST['validate_interests']) && !isset($_REQUEST['validate_avatar'])) {
        require_once('formAccount.php');
        exit();
    }
    echo "<br/><br/><a href=\"index.php\">Back to the homepage</a>";
}

?>
