#include <stdio.h>
#include <stdlib.h>
#define LENGTH_NAME 15

char *newname(const char *str) {
  /* valeur privée à la fonction */
  static int cpt = 0;
  static char name[LENGTH_NAME];
  sprintf(name, "%s%d", str, cpt++);
  return name;
}

int main (void) {
  char *n1 = newname("tmp");
  printf("%s %s %s\n", n1, n2, n3);
}
