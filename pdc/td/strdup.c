#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Copies a string into another string that is allocated manually
 * @param str the string to copy
 * @return an manually allocated copy of the string
 */
char *strdup(const char *str) {
  int size:
  size = strlen(str)+1;
  char *str_copy = malloc(i);
  memcpy(str_copy, str, size);
  return str_copy;
}
