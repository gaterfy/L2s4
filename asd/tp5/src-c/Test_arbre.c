#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#include "ArbreBinaire.h"
#include "Affichage.h"

#define max(a,b) ((a)>(b)?(a):(b))

/* Variable that counts the number of comparisons (will be used in the function `appartient`) */
static int cmp = 0;
/* Variable that defines if we should print the number of comparisons (will be used in the function `appartient`) */
static int print_cmp = 0;

/* Manipulation d'arbres binaires */

/**
 * Constructs the first tree
 * @return the first tree
 */
Noeud_t arbre1 (void) {
  Noeud_t racine = CreerNoeud(12);
  AjouterFilsGauche(racine,CreerNoeud(9));
  AjouterFilsDroit(racine,CreerNoeud(8));
  return racine;
}

/**
 * Constructs the second tree
 * @return the second tree
 */
Noeud_t arbre2 (void) {
  Noeud_t racine = CreerNoeud(12);
  Noeud_t fils_gauche;
  Noeud_t fils_droit;
  AjouterFilsGauche(racine,CreerNoeud(9));
  fils_gauche = FilsGauche(racine);
  AjouterFilsDroit(fils_gauche,CreerNoeud(5));
  fils_droit = FilsDroit(fils_gauche);
  AjouterFilsGauche(fils_droit,CreerNoeud(7));
  return racine;
}

/**
 * Constructs the third tree
 * @return the third tree
 */
Noeud_t arbre3 (void) {
  Noeud_t racine = CreerNoeud(12);
  Noeud_t fils_gauche;
  Noeud_t fils_droit;
  AjouterFilsGauche(racine,CreerNoeud(9));
  AjouterFilsDroit(racine,CreerNoeud(8));
  fils_gauche = FilsGauche(racine);
  fils_droit = FilsDroit(racine);
  AjouterFilsGauche(fils_gauche,CreerNoeud(1));
  AjouterFilsDroit(fils_gauche,CreerNoeud(5));
  AjouterFilsDroit(fils_droit,CreerNoeud(4));
  fils_droit = FilsDroit(fils_droit);
  AjouterFilsGauche(fils_droit,CreerNoeud(7));
  AjouterFilsDroit(fils_droit,CreerNoeud(6));
  return racine;
}

/**
 * Infix traversal of a tree
 * @param a the tree
 */
 void imprimer (Noeud_t a) {
   if (EstVide(a))
     return;
   else {
     imprimer(FilsGauche(a));
     printf("%d ", (int) ValeurDuNoeud(a));
     imprimer(FilsDroit(a));
   }
 }

/**
 * Calculates the size of a tree (number of nodes)
 * @param a the tree
 * @return the size of the tree
 */
int taille (Noeud_t a) {
  if (EstVide(a))
    return 0;
  else
    return 1 + taille(FilsGauche(a)) + taille(FilsDroit(a));
}

/**
 * Calculates the maximal depth of a tree
 * @param a the tree
 * @return the maximal depth of the tree
 */
int hauteur (Noeud_t a) {
  if (EstVide(a))
    return 0;
  else
    return 1 + max(hauteur(FilsGauche(a)), hauteur(FilsDroit(a)));
}

/**
 * Calculates the number of leaves in a tree
 * @param a the tree
 * @return the number of leaves in the tree
 */
int nbFeuilles(Noeud_t a) {
  if (EstVide(a))
    return 0;
  else if (EstFeuille(a))
    return 1;
  else
    return nbFeuilles(FilsGauche(a)) + nbFeuilles(FilsDroit(a));
}

/**
 * Counts recursively the number of possible trees for a given integer
 * @param n the size of a tree
 * @return the number of possible trees for a given integer
 */
int nbArbres(int n) {
  if (n==0)
    return 1;
  else {
    int k, res=0;
    for (k=0; k<n; k++)
      res += nbArbres(k)*nbArbres((n-1)-k);
    return res;
  }
}

/**
 * Counts iteratively the number of possible trees for a given integer
 * @param n the size of a tree
 * @return the number of possible trees for a given integer
 */
int nbArbresEfficace(int n) {
  int i, k, res;
  int *tab = malloc((n+1)*sizeof(int));
  /* On initialise les deux premières valeurs du tableau */
  tab[0] = tab[1] = 1;
  for (i=2; i<n+1; i++) {
    /* On initialise la cellule courante à 0 */
    tab[i] = 0;
    for (k=0; k<i; k++) {
      tab[i] += (tab[k]*tab[(i-1)-k]);
    }
  }
  res = tab[n];
  free(tab);
  return res;
}

/* Manipulation d'arbres binaires de recherche */

/**
 * Constructs the first binary search tree
 * @return the first binary search tree
 */
Noeud_t abr1 (void) {
  Noeud_t racine = CreerNoeud(6);
  Noeud_t fils_gauche;
  AjouterFilsGauche(racine, CreerNoeud(4));
  AjouterFilsDroit(racine, CreerNoeud(7));
  fils_gauche = FilsGauche(racine);
  AjouterFilsGauche(fils_gauche, CreerNoeud(2));
  AjouterFilsDroit(fils_gauche, CreerNoeud(5));
  fils_gauche = FilsGauche(fils_gauche);
  AjouterFilsGauche(fils_gauche, CreerNoeud(1));
  return racine;
}

/**
 * Adds a node in a BST (binary search tree)
 * @param v the value of the node to add
 * @param a the tree
 * @return the node inserted
 */
Noeud_t ajouter (value_t v, Noeud_t a) {
  if (EstVide(a)) {
    return CreerNoeud(v);
  }
  else {
    if (v>ValeurDuNoeud(a)) {
      if (EstVide(FilsDroit(a))) {
        Noeud_t new = CreerNoeud(v);
	      AjouterFilsDroit(a,new);
	      return new;
      } else {
        return ajouter(v,FilsDroit(a));
      }
    } else {
      if (EstVide(FilsGauche(a))) {
        Noeud_t new = CreerNoeud(v);
        AjouterFilsGauche(a,new);
        return new;
      } else {
        return ajouter(v,FilsGauche(a));
      }
    }
  }
}

/**
 * Constructs the second binary search tree
 * @return the second binary search tree
 */
Noeud_t abr2 (void) {
  Noeud_t racine = ajouter(5,CreerArbreVide());
  ajouter(4,racine);
  ajouter(2,racine);
  ajouter(7,racine);
  ajouter(6,racine);
  ajouter(1,racine);
  return racine;
}

/**
 * Constructs the third binary search tree
 * @return the third binary search tree
 */
Noeud_t abr3 (void) {
  Noeud_t racine = ajouter(7,CreerArbreVide());
  ajouter(1,racine);
  ajouter(4,racine);
  ajouter(5,racine);
  ajouter(6,racine);
  ajouter(2,racine);
  return racine;
}

/* Deux fonctions pour tester la validite d'un ABR (utlilser dans testABR) */

int parcour_infix(Noeud_t a,long int **tab) {
  
  if (EstVide(a))
    return 0;
  else {
    parcour_infix(FilsGauche(a),tab);
    **tab = ValeurDuNoeud(a);
    (*tab)++;
    parcour_infix(FilsDroit(a),tab);
    return 0;
  }
}

int is_sorted(long int *tab,int n) {
  int i;
  for (i=0; i<n-1;i++)
    if (tab[i]>tab[i+1])
      return 0;
  return 1;
}

/* Fin the fonctions supplementaires */

/**
 * Tells if a value is in a BST
 * @param v the value to search
 * @param a the tree
 * @return 1 if the value is in the BST, 0 otherwise
 */
int appartient (value_t v, Noeud_t a) {
  if (EstVide(a)) {
    if (print_cmp)
      printf("Nb de comparaisons : %d\n",cmp);
    return 0;
  }
  else {
    if (ValeurDuNoeud(a)==v) {
      if (print_cmp)
        printf("Nb de comparaisons : %d\n",++cmp);
      return 1;
    }
    /* Deux comparaisons sont effectuées : au dessus et en dessous */
    cmp+=2;
    return (v>ValeurDuNoeud(a)) ? appartient(v,FilsDroit(a)) : appartient(v,FilsGauche(a));
  }
}

/**
 * Returns the minimum value of a BST
 * @param a the tree
 * @return -1 if the tree is empty, the minimum value of the BST otherwise
 */
int valeur_minimale (Noeud_t a) {
  return EstVide(a) ? -1 : (EstVide(FilsGauche(a)) ? ValeurDuNoeud(a) : valeur_minimale(FilsGauche(a)));
}

/**
 * Returns the maximmu value of a BST
 * @param a the tree
 * @return -1 if the tree is empty, the maximum value of the BST otherwise
 */
int valeur_maximale (Noeud_t a) {
  return EstVide(a) ? -1 : (EstVide(FilsDroit(a)) ? ValeurDuNoeud(a) : valeur_maximale(FilsDroit(a)));
}

/* Entier mysterieux */

/**
 * Constructs a balanced BST
 * @param i the start number
 * @param j the end number
 * @return a balanced BST
 */
Noeud_t construitArbreEntierMysterieux (value_t i, value_t j) {
  Noeud_t abr;
  int milieu;
  if (i > j) {
    return NULL;
  }
  milieu = ((i+j)/2);
  abr = CreerNoeud(milieu);
  AjouterFilsGauche(abr, construitArbreEntierMysterieux(i, milieu-1));
  AjouterFilsDroit(abr, construitArbreEntierMysterieux(milieu+1, j));
  return abr;
}

/**
 * Mystery number game
 * @param n The end number
 */
void jouer (int n) {
  Noeud_t abr = construitArbreEntierMysterieux(0, n);
  int not_found = 1;
  int incorrect_answer = 1;
  char more_or_less;
  value_t number = ValeurDuNoeud(abr);
  printf("I am ready to play, think of a number and I will try to guess it!\n");
  printf("I bet I can guess your number in less than %d shots.\n", (int) floor(log(n)/log(2)));
  while (not_found) {
    printf("Is it %d ? (answer 'y' for 'yes', 'm' for 'more' and 'l' for 'less'\n", (int) number);
    incorrect_answer = 1;
    while (incorrect_answer) {
      scanf("%c", &more_or_less);
      if (more_or_less == 'y') {
        printf("I knew it since the beginning, I was just trying to waste your time.\n");
        not_found = incorrect_answer = 0;
      }
      if (more_or_less == 'm') {
        if (EstVide(FilsDroit(abr))) {
          printf("This is impossible! I can't lose this game.\n");
          exit(1);
        }
        abr = FilsDroit(abr);
        number = ValeurDuNoeud(abr);
        incorrect_answer = 0;
      }
      if (more_or_less == 'l') {
        if (EstVide(FilsGauche(abr))) {
          printf("This is impossible! I can't lose this game.\n");
          exit(1);
        }
        abr = FilsGauche(abr);
        number = ValeurDuNoeud(abr);
        incorrect_answer = 0;
      }
    }
  }
}

/* Tests sur les arbres binaires */
void testArbreBinaire(Noeud_t a) {
  long int *tab;
  long int *tab2;
  int t;
  imprimer(a); printf("\n");
  printf("Taille     = %d\n",(t=taille(a)));
  printf("Hauteur    = %d\n",(hauteur(a)));
  printf("nbFeuilles = %d\n",(nbFeuilles(a)));
  tab = malloc(t*sizeof(*tab));
  tab2 = tab;
  parcour_infix(a,&tab);
  tab = tab2;
  if (is_sorted(tab,t)) 
    printf("L'arbre est bien un ABR car un parcour infix donne une liste triee! (voir index.rst)\n");
  else
    printf("L'arbre n'est pas un ABR! (voir index.rst)\n");
  free(tab);
}

/* Tests sur les arbres binaires de recherche */
void testABR (Noeud_t a) {
  long int *tab;
  long int *tab2;
  int i,t;
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(t=taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   printf("Valeurs présentes dans l'arbre : ");
   for (i = 1; i <= 10; i++) {
     if (appartient(i,a)) {
         printf("%d ",i);
      }
   }
   printf("\n");
   tab = malloc(t*sizeof(*tab));
   tab2 = tab;
   parcour_infix(a,&tab);
   tab = tab2;
   if (is_sorted(tab,t)) 
     printf("L'arbre est bien un ABR car un parcour infix donne une liste triee! (voir index.rst)\n");
   else
     printf("L'arbre n'est pas un ABR! (voir index.rst)\n");
   free(tab);
}

/* Programme principal */
int main (int argc, char **argv) {

   int i;
   /* Test the functions imprimer, taille, hauteur, nbFeuilles */
   testArbreBinaire(arbre1());
   testArbreBinaire(arbre2());
   testArbreBinaire(arbre3());
   /* Test the functions nbArbresEfficace */
   for (i = 0; i <= 19; i++) {
      printf("Le nombre d'arbres à %d noeuds est %d\n",i,(nbArbresEfficace(i)));
   }

   testABR(abr1());
   testABR(abr2());
   testABR(abr3());

   /* Nombre de comparaisons sur appartient */
   print_cmp = 1;
   printf("Nombre de comparaisons effectuées dans chaque arbre en recherchant la valeur 0 :\n");
   cmp=0;
   appartient(0, abr1());
   cmp=0;
   appartient(0, abr2());
   cmp=0;
   appartient(0, abr3());

   /* Le prgramme ne doit pas imprimer le nombre de comparaisons pour les tests de valeur minimal et maximal */
   print_cmp = 0;
   printf("min : %d, max : %d\n",valeur_minimale(abr1()), valeur_maximale(abr1()));

   /* Arbre mysterieux */
   printf("Arbre mysterieux entre 12 et 24:\n");
   imprimer(construitArbreEntierMysterieux(12,24));
   printf("\n");

   jouer(100);

   return 0;
}
