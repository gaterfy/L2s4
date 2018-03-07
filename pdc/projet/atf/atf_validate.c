#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

#include "atf.h"

int main ()
{
  void *addr[42];		/* memorise naddr appels */
  int naddr = 0;
  void *p;
  int i, status;

  atf_init();

  /* des appels a newbloc(), on en memorise au plus 42 */
  while ((p=atf_newbloc())) {
    if (naddr < 42 && (rand()%4 == 0))
      addr[naddr++] = p;
  }

  /* libere les naddr */
  for(i=0; i<naddr; i++) {
    status = atf_freebloc(addr[i]);
    assert(status==0);
  }
}
