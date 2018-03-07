#include <stdio.h>
#include <assert.h>
#include <stdlib.h>

#include "bam.h"

#define EMPTY_STACK -1

struct stack_s {
  int val;
  struct stack_s *next;
};

typedef struct stack_s *pile_t;

int is_empty(pile_t *stack) {
  return (*stack) == NULL;
}

void push(pile_t *stack, int x) {
  pile_t element = my_own_malloc(sizeof(pile_t));
  assert(element != NULL);
  element->val = x;
  element->next = *stack;
  *stack = element;
}

int top(pile_t *stack) {
  return is_empty(stack) ? EMPTY_STACK : (*stack)->val;
}

int pop(pile_t *stack) {
  if (!is_empty(stack)) {
    int element = (*stack)->val;
    void *address_to_free = (*stack);
    (*stack) = (*stack)->next;
    my_own_free(address_to_free);
    return element;
  }
  exit(EMPTY_STACK);
}

int main ()
{
  pile_t pile = NULL;
  push(&pile, 5);
  push(&pile, 47);
  printf("%d\n", pop(&pile));
  push(&pile, 903);
  printf("%d\n", is_empty(&pile));

  pile_t pile2 = NULL;
  push(&pile2, 3);
  push(&pile2, 23);
  printf("%d\n", pop(&pile2));
  printf("%d\n", pop(&pile2));
  printf("%d\n", is_empty(&pile2));
  return 0;
}
