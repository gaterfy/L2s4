#include <stdio.h>
#include <stdlib.h>

#include "atf.h"
#include "bit_op.h"

static char membloc[NBLOCS][ATF_BLOCKSIZE];
/* On suppose que NBLOCS est un multiple de 8 */
static char memstatus[NBLOCS/8];

void *atf_new_bloc() {
  int i;
  for (i=0; i<NBLOCS; i++) {
    if (get_bit(memstatus,i)==0) {
      /* memstatus[i] = 1; */
      flip_bit(memstatus,i);
      return membloc+i;
    }
  }
  return NULL;
}

int atf_freebloc(void *bloc) {
  int i;
  for (i=0; i<NBLOCS; i++)
    if (bloc == membloc+i) {
      if (get_bit(memstatus,i)==1)
	flip_bit(memstatus,i);
      return 0;
    }
  return 1;
}

void atf_init(void) {
  int i;
  for (i=0; i<NBLOCS; i++)
    memstatus[i] = 0;
}
