#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "readl.h"
#include "macros.h"
#include "fatal.h"
#include "quicksort_generic.h"

static char lines[NMAXLINE][MAXLINE];

int
main
(void)
{
  int i;
  int nl = 0; /* nombre de lignes */

  fprintf(stderr, "%d lignes d'au plus de %d caracteres svp\n", NMAXLINE, MAXLINE-1);

  while (readl(lines[nl]) != EOF)
    fatal (nl++ > NMAXLINE, "trop de lignes", 2);

  fprintf(stderr, "%d lignes lues\n", nl);
  
  quicksort(lines,MAXLINE,(int(*)(const void*,const void*))strcmp, 0, nl-1);
  
  for (i=0,printf("Voici les lignes dans l'ordre:\n");i<nl;i++)
    printf("%s\n",lines[i]);

  exit(EXIT_SUCCESS);
}
