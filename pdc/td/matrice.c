typedef struct ligne_s {
  int nligne;
  element_t *first_element
  ligne_t *next;
} ligne_t;

typedef struct element_s {
  unsigned int indice_colonne;
  int coeff;
  element_t *next;
} element_t;

typedef ligne_t *matrice_creuse_t;

/* ? */
void free_matrice(matrice_creuse_t *m) {
  while (m->next != NULL) {
    matrice_creuse_t matrice_to_free = m;
    element_t *element = m->first_element;
    while (element->next != NULL) {
      element_t element_to_free = element;
      element = element->next;
      free(element_to_free);
    }
    m = m->next;
    free(matrice_to_free);
  }
}

void free_element_recursif(element_t *elt) {
  if (elt == NULL) {
    return;
  }
  free_element_recursif(elt->next);
  free(elt);
}

void free_matrice_recursif(matrice_creuse_t *m) {
  if (m == NULL || *m == NULL) {
    return;
  }
  free_matrice_recursif(&((*m)->next));
  free_element_recursif((*m)->first_element);
  free(*m);
  *m = NULL;
}

void multscal(int a, matrice_creuse_t m) {
  while (m != NULL) {
    element_t *element = m->first_element;
    while (e != NULL) {
      element->coeff = a*element->coeff;
      element = element->next;
    }
    m = m->next;
  }
}

int multvect(matrice_creuse_t m, int *v) {
  ligne_t v_res = malloc(sizeof(v));
}

int main (void) {
  return 0;
}
