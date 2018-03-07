# Projet PdC : Allocateurs mémoire
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

---
## Table des matières

1. [Organisation du repertoire](#organisation)
2. [Installation](#install)
3. [Compilation des programmes](#compil)

---

## <a name="organisation">1 Organisation du répertoire</a>

Ce TP est organisé comme ceci:

- `atf` : allocateur de blocs de taille fixe
  - `atf_bit.h`
  - `atf_validate.c`
  - `atf.c`
  - `atf.h`
  - `bit_op.c`
  - `bit_op.h`
  - `dico4lettres.h`
  - `gestionpile.c`
  - `gestionpile.h`
  - `jeu.c`
  - `Makefile`
  - `test_taille.c`
- `cbl` : chaînage des blocs libres
  - `cbl_validate.c`
  - `cbl.c`
  - `cbl.h`
  - `Makefile`
- `amb` : allocation de multiples blocs
  - `amb.c`
  - `amb.h`
  - `decompression.c`
  - `Makefile`
- `bam` : bibliothèque d'allocation mémoire
  - `bam.c`
  - `bam.h`
  - `Makefile`
  - `pile.c`

## <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce dépôt, placez vous dans le répertoire de votre choix et exécuter la commande suivante :

```
$ git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/pdc-l2s4.git
```

Sinon, récupérez-en la dernière version par `git pull`.

Le code source est dans le sous-dossier `projet`.

## <a name="compil">3 Compilation des programmes</a>

Pour chaque sous-partie (atf, cbl, amb et bam), suivez les instructions du Makefile afin de compiler les programmes voulus.
