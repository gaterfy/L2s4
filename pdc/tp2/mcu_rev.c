#include <stdio.h>
#include "mcu_macros.h"
#include "mcu_readl.h"

int
main
(void)
{
  int n;
  char line[MAXLINE];
  int i;
  while ((n = readl(line)) != EOF) {
    for(i = 0; i < n/2; i++) {
      char c = line[i];
      line[i] = line[n-i-1];
      line[n-i-1] = c;
    }
    printf("%s\n", line);
  }
}
