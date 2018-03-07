#include <stdio.h>
#include "amb.h"

#define BLOC_END -1
#define NBLOCS 2048

static int first_free_blocs;
static union bloc_u membloc[NBLOCS];

void *amb_newbloc(unsigned int nbloc) {
  int ind = first_free_blocs,prev_ind = 0;
  int nb_blocs = membloc[ind].bloc_free.nb_free_bloc;
  while (ind != BLOC_END && nb_blocs <= nbloc) {
    prev_ind = ind;
    ind = membloc[ind].bloc_free.next_free_bloc;
    nb_blocs = membloc[ind].bloc_free.nb_free_bloc;
  }
  if (ind != BLOC_END) {
    //...Nous avons trouvez un bloc qui a une taille assez grande
    membloc[ind].bloc_0 = nbloc;

    if (nb_blocs != nbloc+1) {
      //...pas best fit
      membloc[ind+nbloc+1].bloc_free.next_free_bloc = membloc[ind].bloc_free.next_free_bloc;
      membloc[ind+nbloc+1].bloc_free.nb_free_bloc = nb_blocs - nbloc - 1;
      if (ind == first_free_blocs)
	first_free_blocs = ind+nbloc+1;
      else
	membloc[prev_ind].bloc_free.next_free_bloc = ind+nbloc+1;
      return membloc[ind+1].bloc;
    }
    else {
      //...best fit
      if (ind == first_free_blocs)
	first_free_blocs = membloc[ind].bloc_free.next_free_bloc;
      else
	membloc[prev_ind].bloc_free.next_free_bloc = membloc[ind].bloc_free.next_free_bloc;
      return membloc[ind+1].bloc;
    }
  }
  else {
    //...Il n'existe pas de tel bloc
    return NULL;
  }
}

/*Renvoie quoi?*/
int amb_freebloc(void *bloc) {
  /* On recupere l'indice de notre bloc dans membloc */
  union bloc_u *bloc_p = bloc;
  int i = bloc_p-membloc-1;
  int nalloue = ++membloc[i].bloc_0;
  int ffb = first_free_blocs;
  int c = ffb;
  if (ffb != BLOC_END) {
    /* Il faut trouver la place de ce bloc dans la liste chainee */
    while (membloc[c].bloc_free.next_free_bloc != BLOC_END && membloc[c].bloc_free.next_free_bloc < i)
      c = membloc[c].bloc_free.next_free_bloc;
    /* Nous avons trouve la ou le bloc doit ce situe dans la liste */
    if (c > i) {
      /* Le bloc est avant le first free bloc */
      /* Verifier si on peut coller suivant */
      first_free_blocs = i;
      membloc[i].bloc_free.next_free_bloc = c;
      membloc[i].bloc_free.nb_free_bloc = nalloue;
    } else {
      /* Cas normal, cad le bloc est apres le first free bloc */
      /* Il faut verifier si on peut coller le precedent ou le suivant ou les deux */
      membloc[i].bloc_free.next_free_bloc = membloc[c].bloc_free.next_free_bloc;
      membloc[i].bloc_free.nb_free_bloc = nalloue;
      membloc[c].bloc_free.next_free_bloc = i;
    }
    return 1;
  }
  else {
    /* Aucun bloc libre */
    /* Ici il y a rien a recoller */
    membloc[i].bloc_free.next_free_bloc = BLOC_END;
    membloc[i].bloc_free.nb_free_bloc = nalloue;
    first_free_blocs = i;
    return 0;
  }
}

int amb_init() {
  first_free_blocs = 0;
  membloc[0].bloc_free.nb_free_bloc = NBLOCS;
  membloc[0].bloc_free.next_free_bloc = BLOC_END;
  return 0;
}
