--------------------------------------
NOMS : LOMBART Thomas - VASILEV Martin
GROUPE : 5

TD Technologies du Web
Bases de données - SQL - PHP
Semaine 8
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

Q1.1

- Clé primaire communes : code_commune
- Clé primaire voies : code_commune, code_voie
- Clé primaire adresses : code_commune, code_voie, numero

Q1.2

- Clé étrangère voies : code_commune
- Clé étrangère adresses : code_commune, code_voie

Q1.3

1. SELECT code_voie, nom_voie FROM voies WHERE code_commune = '59009'
2. SELECT code_voie, numero FROM adresses WHERE code_commune = '59009' AND code_voie = '2120'
3. SELECT nom_voie, numero FROM adresses WHERE code_commune = '59009' AND code_voie = '2120'
4. SELECT COUNT(*) FROM adresses WHERE code_commune = '59009' AND code_voie = '2120'
5. SELECT code_voie, COUNT(numero) AS nb_adresses FROM adresses WHERE code_commune = '59009' GROUP BY code_voie;
6. SELECT code_voie, nom_voie FROM communes JOIN voies ON voies.code_commune = communes.code_commune WHERE communes.nom_commune = 'Lille'
7. SELECT nom_commune FROM communes JOIN voies ON voies.code_commune = communes.code_commune WHERE nom_voie = 'Avenue Paul Langevin'
8. SELECT communes.nom_commune FROM communes JOIN adresses ON adresses.code_commune = communes.code_commune WHERE adresses.numero = '12' AND adresses.nom_voie = 'Avenue Paul Langevin';

==========
Exercice 2
==========

Q2.1

Voir lib/fonctionsAdresses.php

Q2.2

Voir lib/fonctionsAdresses.php

Q2.3

Voir reponseAdresses.php
