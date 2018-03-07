---------
Quicksort
---------

.. toctree::
   :maxdepth: 1

   modules.rst

~~~~~~~~~~
Etat du TP
~~~~~~~~~~



~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~

Indiquez ici les réponses aux questions posées dans le TP. Vous
reprendrez le numéro de la section et le numéro de la question. Par
exemple pour répondre à la question 3 de la section 2.4 vous
indiquerez.


Question 2.2.1
--------------

Le tri par insertion ou le tri par sélection sont également des tris sur place.
En effet, ces tris s'effectuent directement sur la structure de donnée initiale.

Question 2.2.2
--------------

.. autofunction:: sorting.partition
    :noindex:

Question 2.2.3
--------------

Les propriétés qui garantissent que le partitionnement est correctement réalisé sont les suivantes:

- Aucun élément de la tranche de gauche n'est strictement supérieur au pivot
- Aucun élément de la tranche de droite n'est strictement inférieur au pivot
- Le pivot est à sa place suite au partitionnement
- La longueur des 2 tranches est égale à la longueur de la liste


Question 2.2.5
--------------

.. autofunction:: sorting.quicksort_slice
    :noindex:

Question 2.2.6
--------------

.. autofunction:: sorting.quicksort
    :noindex:

Question 2.2.8
--------------

L'espace mémoire supplémentaire utilisé lors d'un tri rapide d'un tableau de longueur *n* est son espace initial.
En effet, le tri rapide qui a été codé est un tri *sur place*.

Question 2.3.1.1 à 2.3.1.3
--------------------------

.. autofunction:: sorting.random_pivot
    :noindex:

Question 2.3.1.4
----------------

.. autofunction:: sorting.comparaisons_versions
    :noindex:

Question 2.3.1.5
----------------

La pire valeur pour le pivot serait de prendre l'élément le plus grand dans la tranche à partitioner.
(Notre fonction partition est en :math:`\theta (n)`

L'equation de recurrence est alors dans ce cas la:

.. math::
  \forall n<2, c(n) = 0

  c(n) = c(n-1) + n

Par conséquent, on a:

.. math::
  c(n) = \sum\limits_{i=0}^{\frac{n(n+1)}{2}} i

Question 2.3.2.1
----------------

Le `pivot optimal théorique` serait la valeur *médiane*. Par exemple pour la liste ``[1, 2, 3, 4, 5]``, ce serait 3

Question 2.3.2.2
----------------

.. autofunction:: sorting.optimal_pivot
    :noindex:

Question 2.3.2.3
----------------

.. autofunction:: sorting.comparaisons_versions
    :noindex:

Question 2.3.2.4
----------------

A partir de l'image obtenu on en déduit que la version 3 est plus efficace que la version 2, elle même plus efficace que la version 1.

Le choix du pivot est donc important pour optimiser la complexité de l'algorithme.
(L'image se trouve dans le répertoire `src/`)

Question 2.3.2.5
----------------

(L'algorithme utilisé pour la partition est en :math:`\theta (n)`, (dans le meilleur
des cas il faut `n+2` comparaisons d'éléments )

On suppose que `n` est un nombre pair pour faciliter les calculs.

L'équation de recurrence est:

.. math::
  c(n) = 2\times c(\frac{n}{2}) + n

On va utiliser le théorème général avec `a=2`, `b=2`, `f(n) = n`

Or :

.. math::
  n^{\log_2 2} = \theta (f(n))

Donc:

.. math::
  c(n) = \theta(n \times log_2 n)


Question 2.3.2.1.1 et 2.3.2.1.2
-------------------------------

Utiliser le mergesort pour trouver l'element median?
