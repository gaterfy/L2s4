# Unix Command Line Memento

- `pwd` : affiche le chemin absolu du dossier actuel.
- `which` : connaitre le chemin absolu d'une commande.
- `ls` : liste les fichiers et les dossiers.

  - `-a` : affiche tous les fichiers et dossiers cachés.
  - `-l` : donne plus de détails sur chaque élément.
  - `-h`: affiche la taille (Ko, Mo, Go)
  - `-t` : trie par date de dernière modification.

- `cd` : change de dossier.

  - `..` : accède au dossier parent.

- `du` : taille occupée par les dossiers.

  - `-h` : taille en K, M, G
  - `-s` : avoir le total.

- `cat` : affiche un fichier.
- `less` : affiche un fichier page par page.

  - `Espace` : affiche la page suivante.
  - `Entrée` : affiche la ligne suivante.

- `head` : affiche le début d'un fichier.

  - `-n 3` : affiche les 3 premières lignes.

- `tail` : affiche la fin d'un fichier.

  - `-n 7` : affiche les 7 dernières lignes.
  - `-f` : affiche le fichier au fur et à mesure de son évolution.

- `touch` : crée un fichier (possibilité de créer plusieurs fichier en même temps).
- `mkdir` : crée un dossier (possibilité de créer plusieurs dossiers en même temps).

  - `-p` : crée tous les dossiers intermédiaires.

- `cp` : copie un fichier.

  - `-R` : copie l'ensemble d'un dossier et ses sous dossiers.
  - `*` : permet de sélectionner certains types de fichiers.
  - _Exemples_ :

    - `cp fichier copie`
    - `cp fichier dossier/`
    - `cp fichier dossier/copie`
    - `cp *.py dossier/`

- `mv` : déplace un fichier, quasi-similaire à `cp`. Permet de renommer des fichiers.

  - _Exemples_ :

    - `mv *.jpg photos/`
    - `mv fichier nvNomFichier`

- `rm` : supprime un fichier (possibilité de supprimer plusieurs fichiers).

  - `-i` : demande confirmation avant la suppression.
  - `-r` : supprime un dossier et son contenu.
  - `-f` : force la suppression.
  - `-v` : la commande dit ce qu'elle fait.

- `ln` : lie des fichiers entre eux.

  - `-s` : crée un lien symbolique.

- `sudo` : devient **root** pour une commande

  - `-su` : devient **root** et le reste.

- `adduser` : ajouter un utilisateur.
- `passwd` : change le mot de passe (possibilité de changer le mot de passe des utilisateurs).
- `deluser` : supprime un utilisateur.

  - `--remove-home` : supprime tous les fichiers personnels de l'utilisateur supprimé.

- `addgroup` : ajoute un groupe.
- `usermod` : modifie un utilisateur

  - `-l` : renomme l'utilisateur.
  - `-g` : change de groupe.
  - _Exemples_ :

    - `usermod -g groupe utilisateur`

- `delgroup` : supprime un groupe.
- `chown` : change le propriétaire d'un fichier.

  - `-R` : change le propriétaire d'un dossier et tout son contenu.
  - _Exemples_ :

    - `chown utilisateur fichier`
    - `chown utlisateur:groupe fichier`

- `chmod` : modifie les droits d'accès.

  - `r` : droit de lecture.
  - `w` : droit d'écriture.
  - `x`: rendre un fichier exécutable.
  - `u`: utilisateur.
  - `g` : groupe.
  - `o` : autres.
  - `+` : ajouter le droit.
  - `-` : supprimer le droit.
  - `=` : affecter le droit.

- `man` : afficher le manuel d'une commande.
- `apropos` : trouve une commande.
- `whatis` : similaire à `man` mais allégé.
- `locate` : rechercher un fichier.
- `find` : recherche un fichier... De façon plus puissante.

  - 1er argument: où chercher.
  - 2ème argument: que chercher.
  - 3ème argument: que faire avec.
  - _Exemples_ :

    - `find -name "index.js"`
    - `find ~/Documents/photos/ -name "*.jpg"`
    - `find ~/Musique -size +10M` (k, M, G ou -)
    - `find ~/Documents/code/ -name "*.js" -atime -4` (= - de 4 jours)
    - `find /usr/ name "bin" -type d` (d = directory, f = file)
    - `find ~/Documents/travail/ -type f -atime +10 -delete`
    - `find ~/Documents/ -name "*.py* -exec cp {} ~/code \;` ({} désigne le fichier)

- `grep` : recherche des données dans un fichier.

  - `-i` : ne tient pas compte de la casse.
  - `-n` : connaître le numéro des lignes.
  - `-v` : ignore le mot.
  - `-r` : rechercher dans tous les fichiers et sous-dossiers.
  - `-E` : utilise une expression régulière.
  - _Exemples_ :

    - `grep -ni test ~/Documents/test.txt`
    - `grep -nE .+@.+ test.txt`

- `sort` : trier les lignes

  - `-o` : écrire le résultat dans un fichier.

    - `sort -no nb_tries.txt nb.txt`

  - `-r` : trier en ordre inverse.
  - `-R` : trier de façon aléatoire.
  - `-n` : trier des nombres.

- `wc` : compter des mots.

  - `-l` : compter le nombre de lignes.
  - `-w` : compter le nombre de mots.
  - `-m` : compter le nombre de caractères.
  - `-c` : compter le nombre d'octets.

- `uniq` : supprime des doublons.

  - `-c` : compte le nombre d'occurrences.
  - `-d` : affiche seulement les lignes en doubles.

- `cut` : couper une partie d'un fichier.

  - `-d` : indique le délimiteur.
  - `-f` : indique le numéro des champs à couper.

    - `cut -d , -f 1,2 notes.csv`

- `>` : redirige dans un nouveau fichier (écrase le fichier s'il existait).
- `>>` : redirige à la fin d'un fichier.
- `2>` :  redirige les erreurs (possibilité d'utiliser `2>>`).
- `2>&1` : rediriger dans un même fichier (que ce soit une erreur ou un résulat).
- `<<` : envoie un contenu à un commande.
  - `sort -n << END`
- `|` : chaîne des commandes.
  - `grep -ri rock ~/Musique | sort > rock 2>&1`
- `date` : affiche la date.
- `cal` : affiche le calendrier.
- `uptime` : affiche depuis quand l'ordinateur est en marche.
- `who` : savoir qui est connecté.
- `ps` : affiche la liste des processus.
  - `-ef` : liste tous les processus.
  - `u` : processus lancés par un utilisateur.
- `top` : liste dynamique des processus.
- `kill` : tue un processus (à l'aide du **PID**).
- `killall` : tue plusieurs processus.
- `halt` : arrête l'ordinateur.
- `reboot` : redémarre l'ordinateur.
- `&` : lance un processus en arrière-plan.
- `Ctrl + Z` : met en pause l'exécution d'une commande.
- `jobs` : affiche les processus tournant en arrière plan.
- `at` : exécuter une commande à une heure spécifique.
  - `at 15:36`
  - `at now +2 minutes`
- `crontab -l` : affiche la crontab actuelle.
- `crontab -e` : éditer la crontab.

## apt-get

- `apt-cache search paquet` : rechercher un paquet.
- `apt-get install` : installer un paquet.
- `apt-get update` : met à jour le cache des paquets.
- `apt-get upgrade` : met à jour tous les paquets.
- `apt-get remove` : supprime un paquet.
- `apt-get autoremove` : supprime les dépendances de paquets inutiles.

## Alias et variables d'environnement

Les alias sont des raccourcis qui permettent d'exécuter des commandes plus vite. Les variables d'environnement sont des variables dynamiques utilisées par les différents processus d'un système d'exploitation.

Modifier le ficher `.bashrc` et ajouter une ligne semblable à la suivante :

```sh
# ALIAS
alias maj='sudo apt-get update && sudo apt-get upgrade'
# VARIABLES D'ENVIRONNEMENT
export variable='valeur'
```
