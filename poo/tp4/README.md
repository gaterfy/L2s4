# TP4 POO : Manipulation

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Le travail a porté sur l'organisation d'un projet *java*, la création d'archives, d'exécutables et l'écriture de tests unitaires.

> Le TP a été réalisé dans son intégralité, rien de plus n'a été ajouté.

## Auteurs

##### LOMBART Thomas - VASILEV Martin
##### L2S4 - Gr.5

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Compilation et documentation](#compile)
  1. [Makefile](#makefile)
  2. [Manuellement](#manual)

---
### <a name="organisation">1 Organisation du répertoire</a>

Ce répertoire est organisé comme ceci:

- `classes/` : contient les classes du projet
- `docs/` : contient la documentation
- `lib/` : contient les librairies
- `src/` : contient les fichier sources
- `test/` : contient les fichiers permettant de réaliser les tests unitaires
- `appli.jar` : programme exécutable représentant le projet
- `Makefile` pour automatiser les taches
- `manifest-ex` : permet de choisir le `main` a exécuter pour les fichiers `.jar`
- `README.md` : Description du projet, informations et instructions
- `test-1.7.jar` : permet de disposer de la fenêtre graphique des résultats des tests unitaires

### <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce repository, exécutez la commande suivante

```
git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/poo-l2s4.git
```

Sinon, récupérer la dernière version de ce *repository* par `git pull`

### <a name="compile">3 Compilation et documentation</a>

#### <a name="makefile">3.1 Makefile</a>

##### Prérequis

- Une machine *UNIX*
- Les outils *java (javadoc, javac, ...)*

##### Utiliser la commande `make`

Si vous voulez éviter de tout compiler manuellement nous avons créé un `Makefile` pour cela.

**IMPORTANT** En premier lieu, exécutez la commande suivante depuis la racine du projet :

```
make folders
```

Voici les différentes commandes à exécuter:

- Créer les dossiers `classes`, `lib`, `docs` : `make folders`
- Générer la documentation : `make doc`
- Compiler les classes du projet : `make compile`
- Compiler et lancer les tests : `make test`
- Créer un fichier `.jar` non-exécutable : `make jar`
- Créer un fichier `jar` exécutable : `make jar-exec`
- Exécuter le programme : `make launch`
- Nettoyer le répertoire : `make clean`

**Remarque** : ces commandes ne s'exécutent qu'à la racine du projet !
**Attention** : N'exécutez `make compile` qu'une seule fois. Si vous voulez, pour une quelconque raison, re-compiler, effectuer un `make clean` d'abord.

#### <a name="manual">3.2 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`.

**IMPORTANT** En premier lieu, exécutez la commande suivante depuis la racine du projet :

```
mkdir classes lib docs
```

##### Générer et consulter la documentation

Placez vous dans le répertoire *src/* et exécutez la commandes suivante:

```
javadoc example example.util -d ../docs
```

Placez vous ensuite dans `docs` et lancer le fichier `index.html` avec un navigateur web pour consulter la documentation

##### Compiler les classes du projet

Placez vous dans le répertoire *src/* et exécutez la commande suivante:

```
javac example/Robot.java -d ../classes
```

Pour  les étapes suivantes, assurez vous de bien avoir compilé les classes du projet (cf. ci-dessus ou `make compile`)

##### Compiler et exécuter les tests

Placez vous à la racine du projet et exécutez les commande suivantes:

```
javac -classpath test-1.7.jar test/*.java
java -jar test-1.7.jar BoxTest
java -jar test-1.7.jar RobotTest
```

##### Générer le fichier `.jar`</a>

###### `jar` non-exécutable

Placez vous dans le dossier *classes/* et exécutez la commande suivante :

```
jar cvf ../appli.jar example
```

Exécutez ensuite le fichier avec la commande suivante :

```
java -classpath appli.jar example.Robot
```

###### `jar` exécutable

```
cd classes
jar cvf ../appli.jar example
jar cvfm ../appli.jar ../manifest-ex example
```

Exécutez ensuite le fichier avec la commande suivante :

```
java -jar appli.jar
```
