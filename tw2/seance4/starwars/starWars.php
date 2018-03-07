<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr" lang="fr">
<head>
 <meta charset="UTF-8" />
 <title>club des fans de Star Wars</title>
 <style type="text/css">
   body {
     font-family : Helvetica ;
     margin-left : 10mm;
     margin-right : 10mm ;
   }
   h1 {
     color : blue ;
   }
   fieldset {
     border : 1px solid blue ;
     margin : 10px ;
   }
   #errorMessage {
     padding:10px;
     background-color:rgba(255,0,0,0.5);
     border:1px solid black;
   }
   #cp:invalid {
     border: 1px solid red;
   }
   #cp:valid {
     border: 1px solid green;
   }
 </style>
</head>
<body>
  <h1>Club des fans de StarWars</h1>

  <p>Sur cette page, vous pouvez commander les figurines de vos personnages
  préférés, et adhérer à notre club. </p>

  <?php
  if (isset($error)) {
    echo '<p id=\'errorMessage\' >'.$error.'</p>';
  }
  ?>
  <form action="factureStarWars.php" method = "get">
    <fieldset>
      <legend>Commande</legend>
      <!--
      <input name="fig[]" type="checkbox" value="Maître Yoda"/>Maître Yoda<br/>
      <input name="fig[]" type="checkbox" value="Luke Skywalker"/>Luke Skywalker<br/>
      <input name="fig[]" type="checkbox" value="Anakin Skywalker"/>Anakin Skywalker<br/>
      <input name="fig[]" type="checkbox" value="Dark Vador"/>Dark Vador<br/>
      <input name="fig[]" type="checkbox" value="Obi-Wan Kenobi"/>Obi-Wan Kenobi<br/>
      <input name="fig[]" type="checkbox" value="Han Solo"/>Han Solo<br/>
      <input name="fig[]" type="checkbox" value="Princesse Leia"/>Princesse Leia<br/>
      <input name="fig[]" type="checkbox" value="Padmée Amidala"/>Padmée Amidala<br/>
      <input name="fig[]" type="checkbox" value="Empereur Palpatine"/>Empereur Palpatine<br/>
      <input name="fig[]" type="checkbox" value="R2D2"/>R2D2<br/>
      <input name="fig[]" type="checkbox" value="C3PO"/>C3PO<br/>
      <input name="fig[]" type="checkbox" value="Chewbacca"/>Chewbacca<br/>
      <input name="fig[]" type="checkbox" value="Rey"/>Rey<br/>
      <input name="fig[]" type="checkbox" value="Finn"/>Finn<br/>
      <input name="fig[]" type="checkbox" value="Poe Dameron"/>Poe Dameron<br/>
      <input name="fig[]" type="checkbox" value="Kylo Ren"/>Kylo Ren<br/>
      -->
      <select multiple="multiple" size="16" name="fig[]">
        <option value="Maître Yoda">Maître Yoda</option>
        <option value="Luke Skywalker">Luke Skywalker</option>
        <option value="Anakin Skywalker">Anakin Skywalker</option>
        <option value="Dark Vador">Dark Vador</option>
        <option value="Obi-Wan Kenobi">Obi-Wan Kenobi</option>
        <option value="Han Solo">Han Solo</option>
        <option value="Princesse Leia">Princesse Leia</option>
        <option value="Padmée Amidala">Padmée Amidala</option>
        <option value="Empereur Palpatine">Empereur Palpatine</option>
        <option value="R2D2">R2D2</option>
        <option value="C3PO">C3PO</option>
        <option value="Chewbacca">Chewbacca</option>
        <option value="Rey">Rey</option>
        <option value="Finn">Finn</option>
        <option value="Poe Dameron">Poe Dameron</option>
        <option value="Kylo Ren">Kylo Ren</option>
      </select>
    </fieldset>
    <fieldset>
      <legend>Adhésion</legend>
      <p>Si vous êtes ou si vous devenez membre du club, vous bénéficiez d'une réduction de 10% sur votre commande de figurines</p>
      <select name="adhesion">
        <option value="dejaMembre">Je suis déjà membre</option>
        <option value="oui">J'adhère au club (tarif 5 euros)</option>
        <option value="non">Non, je n'adhère pas au club</option>
      </select>
    </fieldset>
    <fieldset>
      <legend>Vos coordonnées</legend>
      <select name="civilite">
        <option value="Mr">Monsieur</option>
        <option value="Mme">Madame</option>
      </select>
      <label for="nom">Nom : </label><input type="text" id="nom" name="nom" size="25" maxlength="100" required/>
      <label for="prenom">Prénom : </label><input type="text" id="prenom" name="prenom" size="25" maxlength="100" required/><br />
      <label for="voie">Numéro et voie : </label><input type="text" id="voie" name="voie" size="60" maxlength="256" required/><br />
      <label for="complement">Complément d'adresse : </label><input type="text" id="compl" name="compl" size="50" maxlength="256" /><br />
      <label for="cp">Code postal</label><input type="text"  id="cp" name="cp" size="5" maxlength="5" pattern="^[0-9]{5}$" required/>
      <label for="commune">Ville</label><input type="text"  id="commune" name="commune" size="25" maxlength="100" required/><br />
      <label for="consignes"> Indications pour le livreur (digicode, etc ...) </label>
      <textarea id="consignes" name="consignes" cols="90" rows="5">
      </textarea>
    </fieldset>
    <fieldset>
      <button type="reset">Effacer</button>
      <button type="submit" name="valid" value="envoyer">Envoyer</button>
    </fieldset>
  </form>
</body>