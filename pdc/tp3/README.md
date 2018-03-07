# TP3 PDC : Implementation du tri générique
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

---

**Tout** le travail demandé a été réalisé.

**Remarque** : Nous avons également essayé d'effectuer le travail proposé sur le site, c'est-à-dire la lecture du fichier `nobel.txt`. Les fichiers se trouvent dans le dossier `nobel`.

## Table des matières

1. [Organisation du repertoire](#organisation)
2. [Installation](#install)
3. [Compilation des programmes](#compil)
4. [Exemples](#examples)

---

## <a name="organisation">1 Organisation du répertoire</a>

Ce TP est organise comme ceci:

- Les fichiers sources (`.c`) :
  - `fatal.c` : Termine l'exécution du programme sur une erreur
  - `readl.c` : Lit une ligne sur l'entree standard
  - `sortlines_qsort.c` : Tri des lignes qui seront lues sur l'entrée standard
  - `quicksort_generic.c` : Librairie qui contient la fonction `quicksort_generic`
  - `nobel/nobel.c` : définit des fonctions pour lire le fichier `nobel.txt` (essai)
- Les fichiers headers (`.h`) :
  - `fatal.h` : exporte la fonction `fatal`
  - `macros.h` : contient des macros utiles
  - `readl.h` : exporte la fonction `readl`
  - `quicksort_generic.h` : exporte la fonction `quicksort`
  - `nobel/nobel.h` - exporte les fonctions `CompareNomineParAgeDObtention`, `ConstruireTableaux`
- Le `Makefile` permettant de compiler les programmes
- Le fichier `README.md` que vous lisez actuallement

## <a name="install">2 Installation</a>


Si vous n'avez toujours pas clôné ce dépôt, placez vous dans le répertoire de votre choix et exécuter la commande suivante :

```
$ git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/pdc-l2s4.git
```

Sinon, récupérez-en la dernière version par `git pull`

## <a name="compil">3 Compilation des programmes</a>

Placez vous dans le repertoire *tp3/* et executez cette commande :

```
make
```

Cette commande permet de compiler les programmes et de produire l'exécutable suivant :

- `sortlines`

**Remarque** : Des fichiers `.o` sont générés pour produire ces exécutables

Vous pouvez également utiliser ces commandes :

- Trier des lignes lues sur l'entrée standard : `make sortlines` (a le même effet que `make`)
- Nettoyer le repertoire : `make clean` (a pour effet d'effacer le fichiers exécutable `sortlines` et les fichiers `.o`)

## <a name="examples">4 Exemples</a>

Les commandes ont été exécutées à partir du répertoire *tp3/* :

```
echo '2
3
1' | ./sortlines
128 lignes d'au plus 80 caracteres svp
3 lignes lues
Voici les lignes dans l'ordre:
1
2
3
```

```
echo "C'est etonnant...
Bien sur!
Ah moi ça ne me surprend pas" | ./sortlines
128 lignes d'au plus 80 caracteres svp
3 lignes lues
Voici les lignes dans l'ordre:
Ah moi ça ne me surprend pas
Bien sur!
C'est etonnant...
```
