<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
  <head>
    <meta charset="utf-8">
    <title>Mon compte</title>
    <style>
      fieldset {
        margin-top: 5px;
        margin-bottom: 5px;
      }
    </style>
  </head>
  <body>
    <h2>Mon compte</h2>
    <form method="POST" enctype="multipart/form-data" action="">
      <fieldset>
        <label for="password">Modifier mon mot de passe : </label>
        <input type="password" name="password" id="password"></input>
        <br/>
        <input type="submit" name="validate_password" value="Valider"></input>
      </fieldset>
      <fieldset>
        <label for="interets">Ajouter mes intérêts : </label>
        <input type="text" name="interets" id="interets"></input>
        <br/>
        <input type="submit" name="validate_interests" value="Valider"></input>
      </fieldset>
      <fieldset>
        <label for="avatar">Ajouter mon avatar :</label>
        <input type="file" name="avatar" id="avatar"></input>
        <br/>
        <input type="submit" name="validate_avatar" value="Valider"></input>
      </fieldset>
    </form>

    <form id="search_interest" action="">
      <fieldset>
        <label for="interest">Rechercher un utilisateur par centre d'intérêt : </label>
        <input type="text" name="interest" id="interest" required>
        <br/>
        <button type="submit">Valider</button>
      </fieldset>
    </form>

    <script type="text/javascript">
    function searchUser(e) {
      var listUser = document.getElementById('listUser');
      if (listUser) {
        listUser.innerHTML = '';
      } else {
        listUser = document.createElement('ul');
        listUser.id = 'listUser';
      }
      e.preventDefault();
      const req = new XMLHttpRequest();
      var interest = document.getElementById('interest').value;
      req.open('GET', 'find_user.php?interest=' + encodeURIComponent(interest), false);
      req.send(null);
      var data = JSON.parse(req.responseText);
      for (var i = 0; i < data.length; i++) {
        var user = document.createElement('li');
        user.innerHTML = "Nom : " + data[i].nom + ", Prénom : " + data[i].prenom + ", Login : " + data[i].login;
        listUser.appendChild(user);
      }
      document.body.appendChild(listUser);
    }
    document.getElementById('search_interest').addEventListener('submit', searchUser);
    </script>
  </body>
</html>
