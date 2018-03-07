#include <stdio.h>
#include "mcu_affiche_entier.h"

int main (void) {
    int cpt_lignes;
    char c;
    while ((c = getchar()) != EOF) {
       if (c == '\n') {
          cpt_lignes++;
       }
    }
    affiche_entier(cpt_lignes);
}
