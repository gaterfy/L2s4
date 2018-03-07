# TP6 POO : Manipulation d'images
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Le travail a porté sur de la manipulation d'images, mais également sur les interfaces en Java.

> Le TP a été réalisé dans son intégralité, rien de plus n'a été ajouté.

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Compilation et documentation](#compile)
  1. [Makefile](#makefile)
  2. [Manuellement](#manual)
4. [Exécution du programme et exemples](#execute)
  1. [Exemple](#example)
  2. [Exécuter le programme](#main)

---
## <a name="organisation">1 Organisation du répertoire</a>

Ce répertoire est organisé comme ceci:

- `classes/` : contient les classes du projet
- `docs/` : contient la documentation
- `images` : contient les images à analyser
- `lib/` : contient les librairies
- `src/` : contient les fichier sources
- `test/` : contient les fichiers permettant de réaliser les tests unitaires
- `image.jar` : programme exécutable représentant le projet
- `Makefile` pour automatiser les taches
- `manifest-ex` : permet de choisir le `main` a exécuter pour les fichiers `.jar`
- `README.md` : Description du projet, informations et instructions
- `test-1.7.jar` : permet de disposer de la fenêtre graphique des résultats des tests unitaires

## <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce *repository*, exécutez la commande suivante

```
git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/poo-l2s4.git
```

Sinon, récupérer la dernière version de ce *repository* par `git pull`

## <a name="compile">3 Compilation et documentation</a>

### <a name="makefile">3.1 Makefile</a>

#### Prérequis

- Une machine *UNIX*
- Les outils *java (javadoc, javac, ...)*

#### Utiliser la commande `make`

Voici les différentes commandes à exécuter:

- Générer la documentation : `make doc`
- Compiler les classes du projet : `make compile`
- Compiler et lancer les tests : `make test`
- Créer un fichier `jar` exécutable exemple : `make jar-example`
- Créer un fichier `jar` exécutable afin d'utiliser le programme : `make jar-main`
- Nettoyer le répertoire : `make clean`

**Remarque** : Ces commandes ne s'exécutent qu'à la racine du projet !

### <a name="manual">3.2 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`.

#### Générer et consulter la documentation

Placez vous dans le répertoire `src/` et exécutez la commandes suivante:

```
javadoc -d ../docs -subpackages image
```

Placez vous ensuite dans `docs/` et lancer le fichier `index.html` avec un navigateur web pour consulter la documentation

#### Compiler les classes du projet

Placez vous dans le répertoire `src/` et exécutez la commande suivante:

```
javac image/*.java -d ../classes
```

**Remarque** : Pour les étapes suivantes, assurez vous de bien avoir compilé les classes du projet (cf. ci-dessus ou `make compile`)

#### Compiler et exécuter les tests

Placez vous à la racine du projet et exécutez les commande suivantes:

```
javac -classpath test-1.7.jar test/*.java
java -jar test-1.7.jar GrayColorTest
java -jar test-1.7.jar PixelTest
java -jar test-1.7.jar ImageTest
```

#### Générer le fichier `jar` exemple

Placez-vous dans le répertoire `classes/` et exécuter la commande suivante :

```
jar cvf ../imageExample.jar image
```

#### Générer le fichier `jar` principal

Assurez vous d'avoir généré la documentation (Sinon faites un `make doc`) et exécutez la commande suivante :

```
jar cvfm image.jar manifest-ex docs images test -C classes image
```

## <a name="execute">4 Exécution du programme et exemples</a>

**Remarque** : Pour les étapes suivantes, assurez vous de bien avoir généré les 2 fichiers `jar` exécutables (Sinon, effectuer un `make jar-example` et `make jar-main`)

### <a name="example">4.1 Exécuter le fichier `jar` exemple</a>

A la racine du projet, exécuter cette commande :

```
java -classpath imageExample.jar image.ImageExample
```

Cela produit deux images, une comportant 3 rectangles de niveaux de gris différents et la version "contour" de cette image

### <a name="main">4.2 Exécuter le fichier `jar` principal</a>

```
java -jar image.jar <pathToFile> <threshold> <nbGrayLevel>
```

**Précision** :

* `<pathToFile>` : le fichier `pgm` que vous souhaitez utiliser
* `<threshold>` : le seuil utilisé pour l'extraction des contours. Plus le seuil est grand, plus l'image aura des contours moins marqués
* `<nbGrayLevel>` : le niveau de gris utilisé pour produire une image avec des niveaux de gris limité

**Remarque** : Vous pouvez utiliser des images prédéfinies qui se trouvent dans le dossier `images` (celles-ci sont déjà inclues à la racine de l'archive)

#### Exemples

```
java -jar image.jar /images/lamp.pgm 10 8
```

```
java -jar image.jar /images/body.pgm 15 16
```
