#include <stdio.h>
#include <ctype.h>
#include "mcu_affiche_entier.h"

#define DANSMOT 1
#define HORSMOT 2


int main (void) {
  int etat = HORSMOT;
  int nmots = 0;
  int c;
  while ((c = getchar()) != EOF) {
    if (etat == HORSMOT) {
      if (isalnum(c)) {
        etat = DANSMOT;
        nmots++;
      }
    } else if (etat == DANSMOT) {
      if (!isalnum(c)) {
        etat = HORSMOT;
      }
    }
  }
  affiche_entier(nmots);
}
