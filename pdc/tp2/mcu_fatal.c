#include <stdio.h>
#include <stdlib.h>
#include "mcu_fatal.h"

void fatal(int assert, const char message[], int status) {
  if (assert) {
    printf("%s\n", message);
    exit(status);
  }
}
