# TP2 PDC : Premières commandes UNIX

> Ce TP permet d'avoir une première approche des programmes en C et sur la compilation

> Le travail a porté sur des commandes UNIX basiques et la construction d'un `Makefile` pour la compilation de ces programmes

## Auteurs

#### LOMBART Thomas - VASILEV Martin
#### L2S4 - Gr.5

---

**Tout** le travail demandé a été réalisé. Nous avons réalisé la commande `mcu_xxd` en plus.

## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Compilation des programmes](#compil)
4. [Exemples](#examples)

---

### <a name="organisation">1 Organisation du répertoire</a>

Ce TP est organisé comme ceci:

- Les fichiers sources (`.c`) :
  - `mcu_ww.c` : Compte des mots
  - `mcu_wl.c` : Compte des lignes
  - `mcu_wc.c` : Compte des caractères
  - `mcu_affiche_entier.c` - Affiche un entier sur la sortie standard
  - `mcu_fatal.c` - Termine l'exécution du programme sur une erreur fatale
  - `mcu_readl.c` - Stocke une ligne et retourne le nombre de caractères
  - `mcu_readl_test.c` - Teste la fonction `mcu_readl.c`
  - `mcu_rev.c` - Inverse chaque ligne lue sur l'entrée standard
  - `mcu_uniq.c` - Supprime les lignes doublons
  - `mcu_xxd.c` - Visualise un fichier en hexadécimal
- Les fichiers headers (`.h`) :
  - `mcu_affiche_entier.h`
  - `mcu_fatal.h`
  - `mcu_macros.h`
  - `mcu_readl.h`
- Le `Makefile` permettant de compiler les programmes
- Le fichier `README.md` que vous lisez actuellement

**Remarque** : Les commandes permettent d'effectuer ces opérations sur l'entrée standard.

### <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce dépôt, placez vous dans le répertoire de votre choix et exécuter la commande suivante :

```
$ git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/pdc-l2s4.git
```

Sinon, récupérez-en la dernière version par `git pull`

### <a name="compil">3 Compilation des programmes</a>


Placez vous dans le répertoire *tp2/* et exécutez cette commande :

```
make
```

Cette commande permet de compiler les programmes et de produire les exécutables suivants :
- `mcu_ww`
- `mcu_wl`
- `mcu_wc`
- `mcu_readl_test`
- `mcu_uniq`
- `mcu_rev`
- `mcu_xxd`

**Remarque** : Des fichiers `.o` sont aussi générés pour produire ces exécutables.

Vous pouvez également compiler séparément les programmes et nettoyer le répertoire:

- Compter les mots : `make mcu_ww`
- Compter les lignes : `make mcu_wl`
- Compter les caractères : `make mcu_wc`
- Tester la fonction `readl` : `make mcu_readl_test`
- Supprimer les lignes doublons : `make mcu_uniq`
- Inverser chaque ligne : `make mcu_rev`
- Visualise le fichier en hexadécimal : `make mcu_xxd`
- Nettoyer le répertoire : `make clean` (a pour effet d'effacer les fichiers exécutables et les fichiers `.o`)

### <a name="examples">4 Exemples</a>

Les commandes exécutées se sont faites à partir du répertoire *tp2/* :

```
echo 'helloworld' | ./mcu_wc
10
```

```
echo 'hello world how are you ?' | ./mcu_ww
5
```

```
echo 'Ceci est
> un test
> sur
> plusieurs
> lignes ' | ./mcu_wl
5
```

```
echo 'Hello world' | ./mcu_readl_test
11 Hello world
```

```
echo 'Ceci est une ligne qui va être malheureusement trop longue et qui va produire une erreur' | ./mcu_readl_test
La ligne est > MAXLINE (voir mcu_macros.h)
```

```
echo 'Bien le bonjour !' | ./mcu_rev
! ruojnob el neiB
```

```
echo 'Bonjour                       
Bonjour
Encore bonjour
Encore bonjour
Une phrase unique
test
test
banane
banane
banane' | ./mcu_uniq
Bonjour
Encore bonjour
Une phrase unique
test
banane
```

```
echo 'La vie est belle.' | ./mcu_xxd
00000000 : 4C61 2076 6965 2065 7374 2062 656C 6C65 La vie est belle
00000010 : 2E0A   
```
