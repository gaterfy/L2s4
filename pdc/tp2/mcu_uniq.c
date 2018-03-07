#include <stdio.h>
#include <string.h>
#include "mcu_macros.h"
#include "mcu_readl.h"

int main(void) {
  int nb_chars;
  char line[MAXLINE];
  char last_line[MAXLINE];
  
  /* Initialization  */
  nb_chars = readl(line);
  strcpy(last_line, line);
  
  while ((nb_chars=readl(line))!=EOF) {
    if (strcmp(line,last_line)!=0) {
      printf("%s\n",last_line);
      strcpy(last_line,line);
    }
  }
  printf("%s\n",last_line);
}
