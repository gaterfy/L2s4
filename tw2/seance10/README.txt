--------------------------------------
NOMS : LOMBART Thomas - VASILEV Martin
GROUPE : 5

TD Technologies du Web
Bases de données - SQL - PHP
Séance 10
--------------------------------------

Organisation du répertoire :

- lib :
  - fonctionsAdresses.php : contient les fonctions reliées aux adresses
- connection.php : se connecte à notre base de données et crée un nouvel objet PDO
- index.php : page permettant de sélectionner le nom de notre ville
- reponseAdresses.php : script permettant de récupérer des données HTTP et afficher une liste d'adresses


==========
Exercice 1
==========

Q1.1 - Q1.2

CREATE TABLE password (login VARCHAR PRIMARY KEY, password VARCHAR(200), nom VARCHAR, prenom VARCHAR);

Q1.3

Voir lib/signup.php et lib/biblio.php

Q1.4

Voir lib/account.php, myaccount.php et formAccount.php

Q1.5

CREATE TABLE interets (index SERIAL PRIMARY KEY, login VARCHAR, sujet VARCHAR);

Voir lib/account.php, myaccount.php, formAccount.php et lib/biblio.php

Q1.6

Voir find_user.php

Q1.7

Voir lib/avatar.php, bibilio.php, formAccount.php

Q1.8

Voir lib/avatar.php

Q1.9

Voir formAccount.php

Q1.10

CREATE TABLE still_alive (stamp TIMESTAMP default(now()), login VARCHAR);

Voir lib/je_suis_vivant.php et index.php
