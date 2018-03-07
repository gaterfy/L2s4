# TP8 POO : Agence de location
### LOMBART Thomas - VASILEV Martin
### L2S4 - Gr.5

![Java Logo](http://d3gnp09177mxuh.cloudfront.net/tech-page-images/java.png)

> Le travail a porté sur la modélisation d'une agence de voiture

---
## Table des matières

1. [Organisation du répertoire](#organisation)
2. [Installation](#install)
3. [Makefile](#makefile)
4. [Compiler manuellement](#manual)
5. [Exécution du programme](#execute)
6. [Réponses aux questions](#reponses)

---
## <a name="organisation">1 Organisation du répertoire</a>

Ce répertoire est organisé comme ceci:

- `classes/` : classes du projet
- `docs/` : documentation des fichiers sources
- `lib/` : librairies
- `src/` : fichier sources
- `test/` : fichiers réalisant les tests unitaires
- `rental.jar` : programme exécutable
- `Makefile` : pour automatiser les taches
- `manifest-ex` : permet de choisir le `main` a exécuter pour les fichiers `.jar`
- `README.md` : description du projet, informations et instructions
- `test-1.7.jar` : permet de disposer de la fenêtre graphique des résultats des tests unitaires

## <a name="install">2 Installation</a>

Si vous n'avez toujours pas clôné ce *repository*, exécutez la commande suivante

```
git clone https://gitlab-etu.fil.univ-lille1.fr/lombart/poo-l2s4.git
```

Sinon, récupérer la dernière version de ce *repository* par `git pull`

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
- Exécuter le fichier : `make launch`
- Nettoyer le répertoire : `make clean`

**Remarque** : Ces commandes ne s'exécutent qu'à la racine du projet !

## <a name="manual">4 Compilation manuelle</a>

Cette partie permet de tout générer manuellement, elle vous est réservée si vous n'avez pas utilisé la commande `make`.

### Générer et consulter la documentation

Placez vous dans le répertoire `src/` et exécutez la commandes suivante:

```
javadoc -d ../docs -subpackages rental
```

Placez vous ensuite dans `docs/` et lancer le fichier `index.html` avec un navigateur web pour consulter la documentation.

### Compiler les classes du projet

Placez vous dans le répertoire `src/` et exécutez la commande suivante:

```
javac rental/*.java -d ../classes
```

**Important** : Pour les étapes suivantes, assurez vous de bien avoir compilé les classes du projet (cf. ci-dessus ou `make compile`)

### Compiler et exécuter les tests

Placez vous à la racine du projet et exécutez les commande suivantes:

```
javac -classpath test-1.7.jar test/rental/*.java
java -jar test-1.7.jar rental.BrandCriterionTest
java -jar test-1.7.jar rental.ClientTest
java -jar test-1.7.jar rental.InterCriterionTest
java -jar test-1.7.jar rental.PriceCriterionTest
java -jar test-1.7.jar rental.VehicleTest
java -jar test-1.7.jar rental.CarTest
java -jar test-1.7.jar rental.MotorbikeTest
```

### Générer l'exécutable `jar`

Assurez vous d'avoir généré la documentation (Sinon faites un `make doc`) et exécutez la commande suivante :

```
jar cvfm rental.jar manifest-ex docs test -C classes rental
```

## <a name="execute">5 Exécution du programme</a>

**Important** : Pour cela, assurez vous de bien avoir généré le fichier `jar` exécutable (Sinon, effectuer un `make jar`)

```
java -jar rental.jar
```


### Exécuter d'autres *main*

Remplacez dans le fichier `manifest-ex` la classe qui est par défaut `RentalAgencyMain` par l'une d'entre elles :

* MainQ2
* SuspiciousRentalAgencyMain

Enfin, effectuez un `make launch` depuis le terminal


## <a name="reponses">6 Réponses aux questions</a>

### Q2.1.

La valeur que nous devrions obtenir est `true`

### Q2.2.

Nous avons obtenu dans un premier temps `false` qui n'est évidemment pas le résultat attendu. En effet, puisque nous utilisons une table de hachage, il est nécessaire de redéfinir les méthodes `hashCode()` et `equals()` pour éviter les collisions

### Q6.

Pour gérer au mieux ce surcoût, il faut hériter de la classe `RentalAgency` et redéfinir la méthode `rentVehicle` en introduisant une condition lorsque l'on souhaite retourner le prix journalier. Nous avons utilisé une condition ternaire pour cela.

Bonne lecture !

---
