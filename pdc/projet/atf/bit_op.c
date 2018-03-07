#include <stdio.h>

#include "bit_op.h"

void flip_bit(void *p,int i) {
  char *tab = (char *) p;
  *(tab + i/8) = (*(tab+i/8)) ^ (1 << i%8);
}

int get_bit(void *p, int i) {
  char *tab = (char *)p;
  char octet = *(tab + i/8);
  return (octet >> i%8) & 1;
}
