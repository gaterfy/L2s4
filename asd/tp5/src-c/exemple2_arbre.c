#include "ArbreBinaire.h"
#include "Affichage.h"

int
main
(void)
{
  Noeud_t racine, tmp;

  racine = CreerNoeud(12);
  AjouterFilsGauche(racine, CreerNoeud(9));
  tmp = FilsGauche(racine);
  AjouterFilsDroit(tmp, CreerNoeud(5));
  tmp = FilsDroit(tmp);
  AjouterFilsGauche(tmp, CreerNoeud(7));
  SauverArbreDansFichier(racine, "exemple2");

  return 0;
}
