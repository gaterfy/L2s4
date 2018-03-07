# TP9 POO : Jeu de l'oie
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Le travail a porté sur la modélisation du jeu de l'oie. Cela a permis de découvrir notamment les classes abstraites.

#### Bonne lecture !

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Makefile](#makefile)
4. [Compiler manuellement](#manual)
5. [Exécution du programme](#execute)

---
## <a name="organisation">1 Organisation du répertoire</a>

Ce répertoire est organisé comme ceci:

- `classes/` : classes du projet
- `docs/` : documentation des fichiers sources
- `lib/` : librairies
- `src/` : fichier sources
- `test/` : fichiers réalisant les tests unitaires
- `goosegame.jar` : programme exécutable
- `Makefile` : pour automatiser les taches
- `manifest-ex` : permet de choisir le `main` a exécuter pour les fichiers `.jar`
- `README.md` : description du projet, informations et instructions
- `test-1.7.jar` : permet de disposer de la fenêtre graphique des résultats des tests unitaires

## <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce *repository*, exécutez la commande suivante

```
git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/poo-l2s4.git
```

Sinon, récupérer la dernière version de ce *repository* par `git pull`.

Le code source de ce TP se trouve dans le sous-dossier `tp9`.

## <a name="makefile">3 Makefile</a>

Cette partie vous permet de compiler le code et effectuer bien d'autres tâches en vous évitant l'étape "manuelle".

### Prérequis

- Une machine *UNIX*
- Les outils *java* (`javadoc`, `javac`, ...)

### Utiliser la commande `make`

Voici les différentes commandes à exécuter:

- Générer la documentation : `make doc`
- Compiler les classes du projet : `make compile`
- Compiler et lancer les tests : `make test`
- Créer le fichier `jar` exécutable : `make jar`
- Générer le fichier `jar` et l'exécuter : `make launch`
- Nettoyer le répertoire : `make clean`

**Remarque** : Ces commandes ne s'exécutent qu'à la racine du projet !

## <a name="manual">4 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`.

### Générer et consulter la documentation

Placez vous dans le répertoire `src/` et exécutez la commande suivante:

```
javadoc -d ../docs -subpackages goosegame
```

Placez vous ensuite dans `docs/` et lancer le fichier `index.html` avec un navigateur web pour consulter la documentation.

### Compiler les classes du projet

Placez vous dans le répertoire `src/` et exécutez la commande suivante:

```
javac goosegame/*.java -d ../classes
```

**Important** : Pour les étapes suivantes, assurez vous de bien avoir compilé les classes du projet (cf. ci-dessus ou `make compile`)

### Compiler et exécuter les tests

Placez vous à la racine du projet et exécutez les commande suivantes:

```
javac -classpath test-1.7.jar test/goosegame/*.java
java -jar test-1.7.jar goosegame.BasicCellTest
java -jar test-1.7.jar goosegame.GooseCellTest
java -jar test-1.7.jar goosegame.GoosegameBoardTest
java -jar test-1.7.jar goosegame.PlayerTest
java -jar test-1.7.jar goosegame.StartCellTest
java -jar test-1.7.jar goosegame.TeleportCellTest
java -jar test-1.7.jar goosegame.TrapCellTest
java -jar test-1.7.jar goosegame.WaitingCellTest
```

### Générer l'exécutable `jar`

Assurez vous d'avoir généré la documentation (Sinon faites un `make doc`) et exécutez la commande suivante :

```
jar cvfm goosegame.jar manifest-ex docs test -C classes goosegame
```

## <a name="execute">5 Exécution du programme</a>

**Important** : Pour cela, assurez vous de bien avoir généré le fichier `jar` exécutable (Sinon, effectuer un `make jar`)

```
java -jar goosegame.jar
```

Vous obtiendrez un résultat semblable à la trace suivante :

```
=========
GOOSEGAME
=========

Soldat 76 is in cell 0, Soldat 76 throws 6 and reaches cell 6 (teleport to 12) and jumps to cell 12 (basic cell)
Winston is in cell 0, Winston throws 6 and reaches cell 6 (teleport to 12) and jumps to cell 12 (basic cell) cell is busy, Soldat 76 is sent to 0 (start cell)
Mei is in cell 0, Mei throws 8 and reaches cell 8 (basic cell)
Soldat 76 is in cell 0, Soldat 76 throws 4 and reaches cell 4 (basic cell)
Winston is in cell 12, Winston throws 6 and reaches cell 18 (goose) and jumps to cell 24 (basic cell)
Mei is in cell 8, Mei throws 8 and reaches cell 16 (basic cell)
Soldat 76 is in cell 4, Soldat 76 throws 9 and reaches cell 13 (basic cell)
Winston is in cell 24, Winston throws 5 and reaches cell 29 (basic cell)
Mei is in cell 16, Mei throws 7 and reaches cell 23 (basic cell)
Soldat 76 is in cell 13, Soldat 76 throws 2 and reaches cell 15 (basic cell)
Winston is in cell 29, Winston throws 8 and reaches cell 37 (basic cell)
Mei is in cell 23, Mei throws 9 and reaches cell 32 (basic cell)
Soldat 76 is in cell 15, Soldat 76 throws 9 and reaches cell 24 (basic cell)
Winston is in cell 37, Winston throws 7 and reaches cell 44 (basic cell)
Mei is in cell 32, Mei throws 3 and reaches cell 35 (basic cell)
Soldat 76 is in cell 24, Soldat 76 throws 6 and reaches cell 30 (basic cell)
Winston is in cell 44, Winston throws 5 and reaches cell 49 (basic cell)
Mei is in cell 35, Mei throws 10 and reaches cell 45 (goose) and jumps to cell 55 (basic cell)
Soldat 76 is in cell 30, Soldat 76 throws 9 and reaches cell 39 (basic cell)
Winston is in cell 49, Winston throws 6 and reaches cell 55 (basic cell) cell is busy, Mei is sent to 49 (basic cell)
Mei is in cell 49, Mei throws 7 and reaches cell 56 (basic cell)
Soldat 76 is in cell 39, Soldat 76 throws 6 and reaches cell 45 (goose) and jumps to cell 51 (basic cell)
Winston is in cell 55, Winston throws 6 and reaches cell 61 (basic cell)
Mei is in cell 56, Mei throws 10 and reaches cell 60 (basic cell)
Soldat 76 is in cell 51, Soldat 76 throws 5 and reaches cell 56 (basic cell)
Winston is in cell 61, Winston throws 9 and reaches cell 56 (basic cell) cell is busy, Soldat 76 is sent to 61 (basic cell)
Mei is in cell 60, Mei throws 6 and reaches cell 60 (basic cell)
Soldat 76 is in cell 61, Soldat 76 throws 6 and reaches cell 59 (basic cell)
Winston is in cell 56, Winston throws 9 and reaches cell 61 (basic cell)
Mei is in cell 60, Mei throws 7 and reaches cell 59 (basic cell) cell is busy, Soldat 76 is sent to 60 (basic cell)
Soldat 76 is in cell 60, Soldat 76 throws 11 and reaches cell 55 (basic cell)
Winston is in cell 61, Winston throws 12 and reaches cell 53 (basic cell)
Mei is in cell 59, Mei throws 10 and reaches cell 57 (basic cell)
Soldat 76 is in cell 55, Soldat 76 throws 8 and reaches cell 63 (basic cell)
Soldat 76 has won
```
