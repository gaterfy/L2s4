#include <stdio.h>
#include "mcu_readl.h"
#include "mcu_macros.h"

int main (void) {
  char line[MAXLINE];
  int nbChars;
  while ((nbChars = readl(line)) != EOF) {
    printf("%d %s\n", nbChars, line);
  }
}
