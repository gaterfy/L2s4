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
	tmp = FilsGauche(racine);
	AjouterFilsGauche(tmp,CreerNoeud(1));
	AjouterFilsDroit(tmp,CreerNoeud(5));
	tmp = FilsDroit(racine);
	AjouterFilsDroit(tmp,CreerNoeud(4));
	tmp = FilsDroit(tmp) ;
	AjouterFilsDroit(tmp,CreerNoeud(6));
	AjouterFilsGauche(tmp,CreerNoeud(7));
	SauverArbreDansFichier(racine, "exemple3");

	return 0;
}
