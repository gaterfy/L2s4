# TP3 POO : Manipulation sur des mots

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Ce TP permet d'avoir une première approche des classes, des tests unitaires et de la documentation en *java*.

> Le travail a porté sur une classe *Word*, permettant d'effectuer des manipulations avancées sur des mots.

## Auteurs

#### LOMBART Thomas - VASILEV Martin
#### L2S4 - Gr.5

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Compilation et documentation](#compile)
  1. [Makefile](#makefile)
  2. [Manuellement](#manual)
4. [Exécution du programme](#execute)
5. [Exemples](#examples)

---

### <a name="organisation">1 Organisation du répertoire</a>

Ce TP est organisé comme ceci:

- Un dossier `travail-preliminaire` contenant le fichier `Stock.java` et les réponses aux questions posées dans le tp dans un fichier appelé `answers.md`
- Un dossier `mot` contenant le travail principal, ceci inclut:
  - Les fichiers `.java` (= *Code source*)
  - Le fichier `test-1.7.jar` permettant d'exécuter les tests
  - Un `Makefile` pour automatiser les taches
- Le fichier `README.md` que vous lisez actuellement

### <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce repository, placez vous dans un répertoire (*Documents* par exemple) et exécuter la commande suivante :

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

Voici les différentes commandes à exécuter:

- Générer la documentation : `make doc`
- Compiler les classes du projet : `make compile`
- Lancer les tests : `make test`
- Nettoyer le répertoire : `make clean`

---
#### <a name="manual">3.2 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`

##### Générer et consulter la documentation

Placez vous dans le répertoire *mot/* et exécutez les commandes suivantes:

```
$ mkdir docs
$ javadoc Word.java -d docs
```

Placez vous ensuite dans `docs` et exécutez le fichier `index.html` avec un navigateur web pour consulter la documentation

##### Compiler les classes du projet

Placez vous dans le répertoire *mot/* et exécutez les commandes suivantes:

```
$ javac Word.java
$ javac WordMain.java
$ javac WordTest.java
```

##### Compiler et exécuter les tests

Pour cette étape, assurez vous de bien avoir compilé les classes `Word` et `WordTest`

Placez vous dans le répertoire *mot/* et exécutez les commandes suivantes:

```
$ java -jar test-1.7.jar WordTest
```

### <a name="execute">4 Exécuter le programme</a>

Pour cette étape, assurez vous de bien avoir compilé les classes `Word` et `WordMain` (= `make compile`)

Placez vous dans le répertoire *mot/* et exécutez la commande suivante en lui donnant un unique argument (= un mot):

```
$ java WordMain myWord
```

**Remarque :** ne recopiez pas `myWord`, à vous de trouver votre mot.

### <a name="examples">5 Exemples</a>

Les commandes exécutées se sont faites à partir du répertoire *mot/* :

```
$ java WordMain helloworld
Your word is : helloworld
Number of characters : 10
Your reversed word is : dlrowolleh
Your word is a palindrome : false
Your word is a proper noun : false

```

```
$ java WordMain hannah
Your word is : hannah
Number of characters : 6
Your reversed word is : hannah
Your word is a palindrome : true
Your word is a proper noun : false
```

```
$ java WordMain thisisalongword
Your word is : thisisalongword
Number of characters : 15
Your reversed word is : drowgnolasisiht
Your word is a palindrome : false
Your word is a proper noun : false
```

```
$ java WordMain
usage: java WordMain <myWord>
```

```
$ java WordMain je ne peux pas faire ça
usage: java WordMain <myWord>
```
