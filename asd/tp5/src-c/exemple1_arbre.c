#include "ArbreBinaire.h"
#include "Affichage.h"

int
main
(void)
{
	Noeud_t racine,tmp  ;

	racine = CreerNoeud(12) ;
	tmp = CreerNoeud(9) ;
	AjouterFilsGauche(racine,tmp);
	tmp = CreerNoeud(8) ;
	AjouterFilsDroit(racine,tmp);
	SauverArbreDansFichier(racine,"exemple1");

	return 0;
}
