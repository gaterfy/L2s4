#define AMB_BLOCSIZE 30

struct free_bloc_s {
  int nb_free_bloc;
  int next_free_bloc;
};

union bloc_u {
  struct free_bloc_s bloc_free;
  int bloc_0;
  char bloc[AMB_BLOCSIZE];
};

void *amb_newbloc(unsigned int nbloc);
int amb_freebloc(void *bloc);
int amb_init();
