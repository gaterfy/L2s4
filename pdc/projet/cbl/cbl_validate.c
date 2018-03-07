#include <stdio.h>
#include <assert.h>

#include "cbl.h"

int main (void)
{
  int status;

  cbl_init();
  void *s1 = cbl_newbloc();
  void *s2 = cbl_newbloc();
  void *s3 = cbl_newbloc();
  status = cbl_freebloc(s3);
  assert(status == 1);
  void *s4 = cbl_newbloc();
  void *s5 = cbl_newbloc();
  void *s6 = cbl_newbloc();
  // No memory is going to be allocated to the seven block because all blocks have been taken
  void *s7 = cbl_newbloc();
  status = cbl_freebloc(s7);
  assert(status == 0);
  printf("%p\n%p\n%p\n%p\n%p\n%p\n",s1,s2,s3,s4,s5,s6);
  printf("%p\n",s7);
}
