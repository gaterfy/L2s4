#include <stdio.h>
#include <stdlib.h>

#define max(a,b) (((a) > (b)) ? (a) : (b))

typedef int data_t;
typedef struct cellule_s cellule_t;

struct cellule_s {
  data_t data;
  cellule_t *fils_gauche;
  cellule_t *fils_droit;
};

cellule_t *CreerCellule(data_t data) {
  cellule_t *cellule = malloc(sizeof(cellule_t));
  if (cellule) {
    cellule->data = data;
    cellule->fils_gauche = NULL;
    cellule->fils_droit = NULL;
    return cellule;
  } else {
    return NULL;
  }
}

void DetruireCellule(cellule_t **cellule) {
  if (cellule == NULL || *cellule == NULL) {
    return;
  }
  free(*cellule);
  *cellule = NULL;
}

int DetruireArbre(cellule_t **cellule) {
  if (cellule == NULL || *cellule == NULL) {
    return 0;
  }
  int fg = DetruireArbre(&((*cellule)->fils_gauche));
  int fd = DetruireArbre(&((*cellule)->fils_droit));
  DetruireCellule(&(*cellule));
  return 1 + fg + fd;
}

int hauteur (cellule_t *cellule) {
  if (cellule == NULL) {
    return 0;
  } else {
    return 1 + max(hauteur(cellule->fils_gauche), hauteur(cellule->fils_droit));
  }
}

int compare(cellule_t *a, cellule_t *b) {
  if (!a && !b) {
    return 1;
  } else if ((a && !b) || (!a && b)) {
    return 0;
  } else {
    if (a->data != b->data) {
      return 0;
    } else {
      return compare(a->fils_gauche, b->fils_gauche) && compare(a->fils_droit, b->fils_droit);
    }
  }
}

int main () {
  cellule_t *a = CreerCellule(5);
  a->fils_gauche = CreerCellule(3);
  a->fils_droit = CreerCellule(4);
  a->fils_droit->fils_droit = CreerCellule(7);
  a->fils_gauche->fils_gauche = CreerCellule(293);
  a->fils_droit->fils_droit->fils_droit = CreerCellule(9);

  cellule_t *b = CreerCellule(5);
  b->fils_gauche = CreerCellule(3);
  b->fils_droit = CreerCellule(4);
  b->fils_droit->fils_droit = CreerCellule(7);
  b->fils_gauche->fils_gauche = CreerCellule(293);
  b->fils_droit->fils_droit->fils_droit = CreerCellule(9);
  printf("%d\n", hauteur(a));
  printf("%d\n", compare(a, b));
  printf("%d\n", DetruireArbre(&a));
}
