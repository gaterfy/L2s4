#include <stdio.h>

#include "cbl.h"

#define BLOC_END -1
#define BLOC_TAKEN -2


/*
 * Structure of a free_bloc
 * Such a struct contains the number of free blocks after that block
 * The index of the next free blocks
 */
struct free_bloc_s {
  int nb_free_bloc;
  int next_free_bloc;
};

/*
 * Union of a bloc
 * It is either a bloc of a given size or the structure of a free bloc
 */
union bloc_u {
  struct free_bloc_s bloc_free;
  char bloc[CBL_BLOCSIZE];
};


static int first_free_blocs;
static union bloc_u membloc[NBLOCS];


void *cbl_newbloc() {
  if (first_free_blocs != BLOC_END) {
    // We found a block so we keep track of the index of that block
    int ffb = first_free_blocs;
    // The free block after the allocated one has the same number of free blocs minus one because we are going to allocate a block
    membloc[first_free_blocs+1].bloc_free.nb_free_bloc = membloc[first_free_blocs].bloc_free.nb_free_bloc - 1;
    // The next free block is the same of the one who is going to be allocated
    membloc[first_free_blocs+1].bloc_free.next_free_bloc = membloc[first_free_blocs].bloc_free.next_free_bloc;
    // If the block is the only one to be free, the next free bloc is the next of the free bloc to allocate
    // Otherwise, we increment the first_free_bloc variable
    first_free_blocs = (membloc[first_free_blocs].bloc_free.nb_free_bloc == 1) ? membloc[first_free_blocs].bloc_free.next_free_bloc : first_free_blocs + 1;
    /* To identify allocated blocks */
    membloc[ffb].bloc_free.next_free_bloc = BLOC_TAKEN;
    return membloc[ffb].bloc;
  }
  return NULL;
}


int cbl_freebloc(void *bloc) {
  int i;
  // We traverse the list of bloc
  for (i=0; i<NBLOCS; i++)
    if (bloc == membloc + i) {
      /* We verify that the block is allocated to avoid conflicts */
      if (membloc[i].bloc_free.next_free_bloc != BLOC_TAKEN)
        return 0;
      // We mark this block as a serie of one free block
      membloc[i].bloc_free.nb_free_bloc = 1;
      // If we're not at the end of the bloc,
      if (first_free_blocs != BLOC_END) {
        // the next free block of the block freed is the next free block of first_free_blocs
        membloc[i].bloc_free.next_free_bloc = membloc[first_free_blocs].bloc_free.next_free_bloc;
        // the next free block is the one who has been freed
        membloc[first_free_blocs].bloc_free.next_free_bloc = i;
      } else {
        membloc[i].bloc_free.next_free_bloc = BLOC_END;
        first_free_blocs = i;
      }
      /* Return 1 if all happened correctly */
      return 1;
    }
  /* If we haven't found the bloc we return 0 */
  return 0;
}


int cbl_init() {
  first_free_blocs = 0;
  membloc[0].bloc_free.nb_free_bloc = NBLOCS;
  membloc[0].bloc_free.next_free_bloc = BLOC_END;
  return 0;
}
