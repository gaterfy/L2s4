#include <stdio.h>
#include <stdlib.h>
#include "mcu_readl.h"
#include "mcu_fatal.h"
#include "mcu_macros.h"

int readl(char *line) {
  char c;
  int i=0;
  while ((c=getchar())!=EOF) {
    if (c=='\n') {
      line[i] = '\0';
      return i;
    }
    else if (i >= MAXLINE) {
      fatal(i>=MAXLINE,"La ligne est > MAXLINE (voir mcu_macros.h)",2);
    }
    else {
      line[i++] = c;
    }
  }
  line[i] = '\0';
  return ( i == 0 ? EOF : i);
}
