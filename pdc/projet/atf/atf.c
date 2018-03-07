#include <stdio.h>
#include <stdlib.h>

#include "atf.h"

static char membloc[NBLOCS][ATF_BLOCSIZE];
static char memstatus[NBLOCS];

void *atf_newbloc() {
  int i;
  for (i=0; i<NBLOCS; i++) {
    if (memstatus[i]==0) {
      memstatus[i] = 1;
      return membloc+i;
    }
  }
  return NULL;
}

int atf_freebloc(void *bloc) {
  int i;
  for (i=0; i<NBLOCS; i++)
    if (bloc == membloc+i) {
      memstatus[i] = 0;
      return 0;
    }
  return 1;
}

int atf_init() {
  int i;
  for (i=0; i<NBLOCS; i++)
    memstatus[i] = 0;
  return 0;
}
