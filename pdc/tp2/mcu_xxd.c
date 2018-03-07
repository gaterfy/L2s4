#include <stdio.h>
#include <string.h>

void print_offset(int offset) {
  printf("%08X :", offset*16);
}

int readl_16(char *line) {
  int i=0;
  while (i<16 && (line[i]=getchar())!=EOF )
    i++;
  if (i!=0) {
    line[i]='\0';
    return i;
  }
  else return EOF;
}

int main (void) {
  int nbchars;
  char line[17];
  int offset = 0;
  int i;

  while ((nbchars=readl_16(line))!=EOF) {
    print_offset(offset++);
    for (i=0; i<nbchars; i++) {
      if (!(i%2))
	putchar(' ');
      printf("%02X",line[i]);
    }
    while (i < 16) {
      if (!(i%2)) 
	putchar(' ');
      printf("  ");
      i++;
    }
    printf(" %s\n",line);
  }
}
