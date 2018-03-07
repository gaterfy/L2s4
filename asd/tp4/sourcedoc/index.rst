---------------
 tp-bloom
---------------


.. toctree::
   :maxdepth: 1

   bloomfilter.rst

~~~~~~~~~~
Etat du TP
~~~~~~~~~~

Tout a été fait.


Question 4.1.1
--------------

.. autofunction:: test.code_of_string


Question 4.2.1
--------------

.. autofunction:: bloomfilter.create
  :noindex:

.. autofunction:: bloomfilter.add
  :noindex:

.. autofunction:: bloomfilter.contains
  :noindex:

Question 4.2.3
--------------

Pour des tableaux de tailles inférieures à :math:`2^n` :math:`\forall n \leq 2`, nous obtenons souvent des faux positifs

Question 4.3.1
--------------

.. autofunction:: test.analyse_test


Question 4.3.2
--------------

On se place dans le dossier ``src``, on commente les tests, on lance la fonction ``analyse_test`` et on exécute cette commande :

.. code-block:: none

  python3 test.py > res.txt

Le résultat se trouve dans le fichier ``res.txt`` (qui est dans le dossier ``src``)


Question 4.3.3
--------------

Voir fichier ``tp4.png``


Question 4.3.4
--------------

D'après le graphique, nous en déduisons que le nombre de fonctions de hachage influe sur ce pourcentage de faux positifs.

On remarque que quand la taille du filtre est comprise entre 10 et 12 (2^10, 2^12) avoir un nombre de fonctions hachage petit est plus effcace.
En effet, avec un petit nombre de cases, la probabilité que plusieurs fonctions d'hachage donne la même adresse est élevé. De ce fait la chance d'avoir un faux positif augmente aussi.

Quand la taille est supérieure a 12 (2^12) on observe que le taux de faux positifs diminue proportionellement avec le nombre de fonctions.

Quand on a un nombre de cases assez grand, plus on a de fonctions d'hachage plus c'est bénéfique, car si on fixe une probabilite p qui représente la situation où plusieurs fonctions d'hachage donnent la même adresse, alors le fait d'avoir une seule fonction d'hachage veut dire qu'on a p chance de se tromper.

 Si on a deux fonctions d'hachage alors la chance qu'on se trompe devient approximativement p^2 , et comme 0 < p < 1 => p^2 < p.

 Par conséquent, plus il y a de fonctions d'hachages, moins il y a de chances de se tromper comme la probabilité d'avoir un faux positif diminue avec l'augmentation de la puissance de la probabilité.
