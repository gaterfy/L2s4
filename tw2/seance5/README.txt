LOMBART Thomas
VASILEV Martin
L2S4 - Gr. 5

Q1.1

a. select dossard, nom from coureurs;
b. select dossard, nom from coureurs order by dossard;
c. select dossard, nom from coureurs order by equipe, nom;
d. select dossard, nom, taille from coureurs order by taille;
e. select dossard, nom from coureurs where equipe = 'LavePlusBlanc';
f. select "dossard", "nom" from coureurs where coureurs."equipe" = 'LavePlusBlanc';
g. select nom, taille, equipe from coureurs where taille <= 180;
h. select nom, taille, equipe from coureurs where taille <= 180 order by taille;
i. select couleur from equipes;

Q1.2

a. select nom || ' appartient à l''équipe ' || equipe from coureurs;
b. select nom || ' appartient à l''équipe ' || equipe as appartenance from coureurs;
c. select upper(nom) as "nom maj", char_length(nom) as "lg" from coureurs;
d. select upper(nom) as "nom maj", char_length(nom) as "lg" from coureurs order by lg;
e. select dossard, initcap(nom) as "nom maj",
   upper(substring(equipe from 0 for 4))
   || substring(equipe from  4 for char_length(equipe))
   as equipe from coureurs;

Q1.3

a. select nom from coureurs where nom like 'a%';
b. select nom from coureurs where nom like '%er%';
c. select nom from coureurs where nom like '_____';
d. select nom from coureurs where nom like 'a__';
e. select nom from coureurs where nom like 'a__%';

Q1.4

a. select taille / 100  as taille from coureurs;
b. select taille / 100.0  as taille from coureurs;

Ce n'est pas le résultat souhaité car il y a plus de deux chiffres après la virgule.

c. select cast((taille/100.0) as float(2)) as taille from coureurs;

Q1.5

a. select * from coureurs, equipes;
b. select * from coureurs, equipes where equipes.nom = coureurs.equipe;
c. select coureurs.dossard, coureurs.nom, equipes.nom, equipes.couleur from coureurs, equipes where equipes.nom = coureurs.equipe;
d. select coureurs.nom, equipes.directeur from coureurs, equipes where equipes.nom = coureurs.equipe;
e. select coureurs.dossard, coureurs.nom from coureurs, equipes where coureurs.equipe = equipes.nom and equipes.directeur = 'Ralph';
f. select equipes.directeur from coureurs, equipes where coureurs.equipe = equipes.nom and coureurs.nom = 'alphonse';

Q1.6

a. INSERT INTO equipes (couleur, directeur, nom) values ('bleu', 'Timoleon', 'CafeBanane');
b. INSERT INTO coureurs VALUES (8, 'martin', 'CafeBanane', 180);
INSERT INTO coureurs VALUES (9, 'thomas', 'CafeBanane', 174);

Q1.7

a. select * from equipes where directeur IS NULL;
b. select * from equipes where directeur IS NOT NULL;

Q1.8

a. update coureurs set taille = taille - 1 where equipe = 'PicsouBank';
b. update equipes set directeur = 'Claude' where directeur IS NULL;

Q1.9

CREATE TABLE etape (dossard int, arrivee time, PRIMARY KEY (dossard), FOREIGN KEY (dossard) REFERENCES coureurs(dossard));
INSERT INTO etape VALUES (1, '17:32:30');
INSERT INTO etape VALUES (2, '17:44:30');
INSERT INTO etape VALUES (8, '17:41:47');
INSERT INTO etape VALUES (5, '17:29:11');

Q1.10

a. select coureurs.dossard, coureurs.nom, etape.arrivee from coureurs, etape
   where etape.dossard = coureurs.dossard order by arrivee;
b. select coureurs.dossard, coureurs.nom, etape.arrivee from coureurs, etape
   where etape.dossard = coureurs.dossard
   and etape.arrivee < time '17:39:32'
   order by arrivee;
c. select coureurs.dossard, coureurs.nom, equipes.nom as equipe, equipes.couleur, etape.arrivee
   from coureurs, equipes, etape
   where coureurs.equipe = equipes.nom
   and etape.dossard = coureurs.dossard
   order by arrivee;

Q1.11

Voir fichier table.php

Q1.12

Voir fichier team.php et findTeam.php

Q1.13

Voir fichier time.php et addTime.php
