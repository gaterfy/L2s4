# TP7 POO : Pierre-Papier-Ciseaux
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Le travail a porté sur le jeu Pierre-Papier-Ciseaux

> Le TP a été réalisé dans son intégralité, nous avons ajouté deux modes de jeux possibles

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Compilation et documentation](#compile)
  1. [Makefile](#makefile)
  2. [Manuellement](#manual)
4. [Exécution du programme et exemples](#execute)

---
## <a name="organisation">1 Organisation du répertoire</a>

Ce répertoire est organisé comme ceci:

- `classes/` : contient les classes du projet
- `docs/` : contient la documentation
- `lib/` : contient les librairies
- `src/` : contient les fichier sources
- `test/` : contient les fichiers permettant de réaliser les tests unitaires
- `rps.jar` : programme exécutable permettant de jouer au jeu
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
- Les outils *java* (`javadoc`, `javac`, ...)

#### Utiliser la commande `make`

Voici les différentes commandes à exécuter:

- Générer la documentation : `make doc`
- Compiler les classes du projet : `make compile`
- Compiler et lancer les tests : `make test`
- Créer un fichier `jar` exécutable afin d'utiliser le programme : `make jar`
- Jouer au jeu : `make launch`
- Nettoyer le répertoire : `make clean`

**Remarque** : Ces commandes ne s'exécutent qu'à la racine du projet !

### <a name="manual">3.2 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`.

#### Générer et consulter la documentation

Placez vous dans le répertoire `src/` et exécutez la commandes suivante:

```
javadoc rps rps.strategy util -d ../docs
```

Placez vous ensuite dans `docs/` et lancer le fichier `index.html` avec un navigateur web pour consulter la documentation.

#### Compiler les classes du projet

Placez vous dans le répertoire `src/` et exécutez la commande suivante:

```
javac util/*.java rps/*.java rps/strategy/*.java -d ../classes
```

**Remarque** : Pour les étapes suivantes, assurez vous de bien avoir compilé les classes du projet (cf. ci-dessus ou `make compile`)

#### Compiler et exécuter les tests

Placez vous à la racine du projet et exécutez les commande suivantes:

```
javac -classpath test-1.7.jar test/*.java
java -jar test-1.7.jar PlayerTest
java -jar test-1.7.jar ShapeTest
java -jar test-1.7.jar PermuteStrategyTest
```

#### Générer l'exécutable `jar`

Assurez vous d'avoir généré la documentation (Sinon faites un `make doc`) et exécutez la commande suivante :

```
jar cvfm rps.jar manifest-ex docs test -C classes rps -C classes util
```

## <a name="execute">4 Exécution du programme</a>

**Remarque** : Pour cela, assurez vous de bien avoir généré le fichier `jar` exécutable (Sinon, effectuer un `make jar`)

```
java -jar rps.jar
```
