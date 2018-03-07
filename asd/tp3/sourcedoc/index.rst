---------------
 tp-iterateurs
---------------


.. toctree::
   :maxdepth: 1

   listiterator.rst

~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~

* Pour toutes les questions demandant de réaliser une fonction, veuillez cliquez sur ``[source]`` afin d'y voir le code coresspondant.

* Pour toutes les questions se référant à l'écriture des tests, référez-vous au fichier ``test.py`` se trouvant dans le dossier ``src``

3.1 : Première phase : la liste doublement chaînée
--------------------------------------------------

**Question 1.**

.. autofunction:: listiterator.__print_without_iterator_reversed
  :noindex:

3.2 : Deuxième phase : ajout des itérateurs
-------------------------------------------

**Question 1.**

Fonctions de ``listiterator`` :

.. autofunction:: listiterator.get_listiterator
  :noindex:
.. autofunction:: listiterator.hasNext
  :noindex:
.. autofunction:: listiterator.next
  :noindex:
.. autofunction:: listiterator.hasPrevious
  :noindex:
.. autofunction:: listiterator.previous
  :noindex:

Fonctions d'affichage:

.. autofunction:: test.print_with_iterator
.. autofunction:: test.print_with_iterator_reverse


3.2.1 : Insertion avec des itérateurs
-------------------------------------

**Question 1.**

.. autofunction:: listiterator.add
  :noindex:


3.2.2 : Itérateurs à partir de la queue
---------------------------------------

**Question 1.**

.. autofunction:: listiterator.get_listiterator
  :noindex:

**Question 2.**

Notre programme marchant bien dès le début pour la fonction ``print_with_iterator_reverse``, nous n'avons donc pas réalisé la seconde version.

**Question 4.**

Nous n'avons pas eu à modifier la fonction ``add`` pour cela.

**Question 6.**

.. autofunction:: test.ordering_insert

3.2.3 : Suppression avec des itérateurs
---------------------------------------

**Question 1.**

La structure de donnée initiale (un dictionnaire contenant 2 clés, ``successor`` et ``predecessor``) ne convient pas.

En effet si l'on essaye de supprimer le premier ou dernier élément de notre liste, on ne pourra pas par la suite imprimer la liste correctement car notre structure n'a pas accès a la `tête` (ou respectivement a la `queue`) de la liste.

Par conséquent, nous devons rajouter une nouvelle clé dans notre structure de donnée qui va représenter la liste elle même.

Cela résoudra donc ce problème de tête et de queue de liste puisque nous pourrons les modifier depuis l'itérateur.

Cela résoud aussi le problème de la fonction ``add`` (qui était un peu "bricolée") qui va donc être modfiée en conséquence.

**Question 2.**

.. autofunction:: listiterator.remove
  :noindex:

**Question 3.**

Lors de plusieurs appels successifs à ``remove``, l'itérateur supprime tout le temps l'élément suivant

3.2.4 : Gestion de plusieurs itérateurs
---------------------------------------

**Question 1.**

.. code-block:: python
   :emphasize-lines: 7,9,10,12

   l = list.empty_list ()
   for i in reversed(range(1,6)):
     list.cons(l,i)
   it = list.get_listiterator(l)
   it2 = list.get_listiterator(l)
   list.next(it)
   list.next(it)
   list.next(it2)
   list.next(it2)
   list.remove(it)
   print_with_iterator(l)
   list.remove(it2)
   print_with_iterator(l)

Ce code ci-dessus pose un problème. Si l'on a supprimé avec le premier itérateur un élément sur lequel pointait le deuxième itérateur, alors la fonction `remove` ne marchera pas sur le deuxième itérateur.

On peut s'en rendre dans le compte en remarquant que l'affichage des listes n'est pas modifiée malgré la "suppression" avec le deuxième itérateur.

**Question 2.**

Nous pourrions pour cela, peut-être, implémenter une variable globale qui tient compte de tous les itérateurs et qui met à jour chaque itérateur (un sorte de repositionnement) dès qu'il y a une suppression.
