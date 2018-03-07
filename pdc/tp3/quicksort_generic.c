#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "quicksort_generic.h"

/**
 * Swap two elements
 * @param a the first element
 * @param b the second element
 * @param size number of bytes on which the element is coded
 */
void swap(void *a, void *b, int size) {
  /*On va echanger les donnees octet par octet, pour cela on va caster char * sur les arguments
   qui sont void *, de cette maniere ils pointerons sur un seul octet, on pourra echanger les
  donnees octet par octet*/
  char *a_c = a;
  char *b_c = b;
  char tmp;
  int i=0;
  /* Tant qu'on a pas echanger tous les octets */
  for (i=0; i<size; i++) {
    /* On echange un octet avec cette procedure */
    tmp = *(a_c+i);
    *(a_c+i) = *(b_c+i);
    *(b_c+i) = tmp;
  }
}


/**
 * Generic partition of an array following the quicksort algorithm
 * @param base the array to partition
 * @param size number of bytes on which an element is coded
 * @param compare function that compare two elements
 * @return the index of the pivot after partitioning
 */
int partition(void *base, int size, int (*compare)(const void *, const void *), int low, int high) {
  /* On cree une nouvelle case pour contenir notre pivot */
  void *pivot = malloc(size);
  /* On range notre pivot octet par octet, car on ne connait pas le type */
  int i;
  for (i=0; i<size; i++)
    *((char *) pivot + i) = *((char *) base + low*size + i);
  /* Maintenant pivot contient la valeur du pivot */
  low--;
  high++;
  while (1) {
    //
    do {
      low++;
      /* Procedure d\'affichage de test */
      /* printf("%d <=> %d = %d\n", */
      /* 	     *((int *)pivot), */
      /* 	     *((int *)((char *)base + low*size)), */
      /* 	     compare(((char *) base) + low*size, pivot)); */
    }
    while (compare(((char *) base) + low*size, pivot) < 0);
    do {
      high--;
      /* Procedure d\'affichage de test */
      /* printf("%d <=> %d = %d\n", */
      /* 	     *((int *) pivot), */
      /* 	     *((int *)((char *)base + high*size)), */
      /* 	     compare(((char *) base) + high*size, pivot)); */
    }
    while (compare(((char *) base) + high*size, pivot) > 0);
    if (low < high) {
      swap(((char *) base) + low*size, ((char *) base) + high*size, size);
    } else return high;
  }
  free(pivot);
}

/**
 * Generic sort of an array following the quicksort algorithm
 * @param base the array to sort
 * @param size number of bytes on which an element is coded
 * @param compare function that compare two elements
 */
void quicksort(void *base, int size, int (*compare)(const void *, const void *),int low, int high) {
  if (low >= high) return;
  else {
    int i = partition(base, size, compare, low, high);
    quicksort(base,size,compare,low,i);
    quicksort(base,size,compare,i+1,high);
  }
}
