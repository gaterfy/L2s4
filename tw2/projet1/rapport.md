### Projet TW2 : V'LiVe

##### LOMBART Thomas - VASILEV Martin
##### L2 Informatique, Semestre 4 - Groupe 5

[URL Projet](http://webtp.fil.univ-lille1.fr/~lombart/projet1/)

---
### Table des matières

1. [Fonctionnalités](#fonctions)
  1. [Descriptif](#descriptif)
  2. [Détail](#detail)
2. [Arborescence complète](#arborescence)
3. [Structuration du projet](#structuration)
---

#### <a name="fonctions">1 Fonctionnalités</a>

##### <a name="descriptif">1.1 Descriptif</a>

Le projet implante toutes les fonctionnalités demandées, c'est à dire :

* Obtenir sur la page d'accueil la liste des stations ayant chacune un court descriptif
* Ajouter une carte géographique reprenant la liste des stations et y associant des marqueurs visuels
* Présentation détaillée de chaque station
* Formulaire permettant de filtrer la liste des stations

##### <a name="detail">1.2 Détail</a>

* Lorsque vous arrivez sur la page d'accueil, vous avez une carte géographique qui prend la quasi-entiéreté de votre écran. Un bloc se trouve sur la droite, il y a un header avec deux icônes, une en forme de vélo et l'autre en forme de loupe.
* En cliquant sur l'icône du vélo, vous obtenez la liste des stations (Cela est fait par défaut au chargement de la page) :
  * Chaque station comporte un descriptif : nom de la station, commune, nombre de vélos et de bornes d'attaches disponibles
  * Cliquez sur *voir le détail*, cela redirige vers une autre page donnant des informations plus avancées sur la station
  * Cliquez sur *voir sur la carte*, cela centre la carte sur la station sélectionnée, et une présentation plus détaillée de la carte s'active. Vous pouvez revenir à la liste des stations en cliquant sur *Liste des stations* mais aussi voir le détail de la station
* Afin de rechercher votre station, cliquez sur la loupe, la carte est alors floutée pour mieux mettre en valeur ce formulaire, plusieurs options s'offrent à vous :
  * Rechercher par nom de station e.g Triolo, V2, ...
  * Rechercher par commune e.g Lille, Villeneuve D'Ascq
  * Rechercher par nombre minimum de vélos disponibles
  * Rechercher par nombre minimum de borne d'attaches disponibles
* Sur cette carte, vous trouverez de nombreux marqueurs visuels associés à chaque station. Cliquez sur ce marqueur visuel et vous aurez un court descriptif de la station :
  * Le nom de la station
  * Le nombre de vélos disponibles
  * Le nombre de places disponibles
  * Cliquez sur *mettre en tête de liste* et ceci vous placera, évidemment, la station en tête de la liste
* Vous avez la possibilité d'aller voir l'entièreté du code source sur GitHub en cliquant sur l'icône de GitHub en bas au centre

#### <a name="arborescence">2 Arborescence complète</a>

* `css/`
  * `detail.css`
  * `homepage.css`
* `js/`
  * `homepage.js`
  * `scriptDetail.js`
* `lib/`
  * `detail.php`
  * `lectureArguments.php`
  * `Station.class.php`
  * `buildList.php`
* `index.php`
* `proxyConfig.php`
* `rapport.pdf`
* `README.txt`


#### <a name="structuration">3 Structuration du projet</a>

Le projet s'est structuré en 3 dossiers :

* Un dossier `css/` contenant tout les fichiers **CSS** :
  * `detail.css` : Règles CSS permettant de styliser la page de détail de la station. Cette page présente deux blocs, le bloc de gauche contenant les infos et le bloc de droite contenant la carte
  * `homepage.css` : Règles CSS permettant de styliser la page d'accueil, elle est composée de la carte en arrière plan et d'un bloc à droite permettant de visualiser la liste des stations ou de rechercher sa station
* Un dossier `js/` contenant tout les fichiers **JavaScript** :
  * `homepage.js` : Fichier JavaScript associé à la page d'accueil. Il permet en outre de générer la carte au chargement de la page et d'y placer les marqueurs, de construire le formulaire de recherche mais également de "switcher" entre liste des stations et formulaire (en jouant avec les propriétés CSS `display`)
  * `scriptDetail.js` : permet de créer une carte contenant la station sélectionnée centrée mais également à mettre en valeur une station en service lors de la présentation détaillée
* Un dossier `lib/` contenant toutes les fonctions utiles au projet :
  * `detail.php` : permet de récupérer les données via `JSON` et d'afficher le détail de la station sélectionnée
  * `lectureArguments.php` : permet de vérifier si les arguments donnés lors de la recherche de station sont corrects. Ce fichier permet également de construire la requête qui sera envoyé au serveur de la MEL en fonction des paramètres rentrés dans le formulaire.
  * `Station.class.php` : classe représentant une station, elle contient deux méthodes utiles, l'une retourne le code HTML correspondant au court descriptif de la station, l'autre retourne celui du long descriptif.
  * `buildList.php` : permet de construire la liste des stations avec court descriptif ou avec long descriptif
* `index.php` : correspond à la page d'accueil, utilise tous les fichiers ci-dessus afin de remplir les fonctionnalités.
* `proxyConfig.php` : permet de configurer le proxy pour le serveur webtp
* `rapport.pdf` : Ce que vous lisez actuellement
* `README.txt` : Contient les informations générales de ce projet
