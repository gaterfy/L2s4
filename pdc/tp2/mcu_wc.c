#include <stdio.h>
#include "mcu_affiche_entier.h"

int main (void) {
    int cpt_char;
    char c;
    while ((c = getchar()) != EOF) {
        cpt_char++;
    }
    affiche_entier(cpt_char-1);
}
