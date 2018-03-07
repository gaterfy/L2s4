#include <stdio.h>

#define NBLOCS 10

//Version 0
static char memstatus[NBLOCS];

//Version 1
static char memstatus_b[NBLOCS/8];

//Version 2
enum memstatus_e {MEM_FREE=0, MEM_USED};
static enum memstatus_e memstatus_s[NBLOCS];

int
main
(void)
{
  printf("memstatus =>%d\nmemstatus_b => %d\nmemstatus_s => %d\n",
	 (int) sizeof(memstatus),
	 (int) sizeof(memstatus_b),
	 (int) sizeof(memstatus_s));
}
