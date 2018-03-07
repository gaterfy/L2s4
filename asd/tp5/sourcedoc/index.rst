-----------------
tp-arbresbinaires
-----------------

~~~~~~~~~~
Etat du TP
~~~~~~~~~~

Tout a été fait.

~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~

Question 5.3.2
--------------

Nous pouvons nous assurer que les arbres construits sont bien des arbres binaires de recherche en les traversant de manière infixe. En effet, les nombres seront donc imprimées dans l'ordre croissant.

**Remarque**: Pour tester cela nous avons rajouter des procedures de test (avec les fonctions `parcour_infix` et `is_sorted`) pour tester que un
*parcour infix* sur l'arbre produit bien une liste qui est *triee* et affiche un petit message pour informer du resultat au niveau des fonctions
`testABR` et `testArbreBinaire`

Question 5.3.6
--------------

Il y a moins de comparaisons sur l'arbre de recherche `abr3` car le noeud le **plus a gauche** de l'arbre est a profondeur **2**.
Cependant, les noeuds les plus à gauches des arbres `abr1` et `abr2` sont à profondeur **4**.


Question 5.3.7
--------------

- L'élément **minimal** se trouve dans le noeud le **plus a gauche**.
- L'élément **maximal** se trouve dans le noeud le **plus a droite**.
