typedef struct monome_t {
  int coefficient;
  int degre;
} monome_t;

typedef struct polynome_t * polynome_t {
  monome_t monome;
  polynome_t poly;
};
