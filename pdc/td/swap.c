#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Swap two arrays of integers
 * @param arr1 the first array
 * @param arr2 the second array
 * @param nb_elements the number of elements in both arrays
 */
void swap_int(int *arr1, int *arr2, int nb_elements) {
  int i, tmp;
  for(i = 0; i < nb_elements; i++) {
    tmp = arr1[i];
    arr1[i] = arr2[i];
    arr2[i] = tmp;
  }
}

/**
 * Swap two arrays of integers
 * @param arr1 the first array
 * @param arr2 the second array
 * @param nb_elements the number of elements in both arrays
 */
void swap_int2(int *arr1, int *arr2, int nb_elements) {
  int i, *arr;
  arr = malloc(nb_elements * sizeof(int));
  memcpy(arr, arr1, nb_elements*sizeof(int));
  memcpy(arr1, arr2, nb_elements*sizeof(int));
  memcpy(arr2, arr, nb_elements*sizeof(int));
  free(arr);
}

/**
 * Prints an array
 * @param arr the array to print
 * @param nb_elements the number of elements in the array
 */
void print_array(int *arr, int nb_elements) {
  int i;
  for(i = 0; i < nb_elements; i++) {
    printf("%d ", arr[i]);
  }
  printf("\n");
}

/**
 * Swaps two arrays
 * @param p the first array
 * @param q the second array
 * @param nb_elements the number of elements in both arrays
 * @param size the size of one cell
 */
void swap_arr(void * p, void * q, int nb_elements, int size) {
  char *pp = (char *) p;
  char *qq = (char *) q;
  void *e;
  int i;
  e = malloc(size);
  for (i = 0; i < nb_elements; i++) {
    memcpy(e, pp + i*size, size);
    memcpy(pp + i*size, qq + i*size, size);
    memcpy(qq + i*size, e, size);
  }
  free(e);
}

/**
 * Search if a key is present in the array
 * @param key the key to search
 * @param arr the array in which we search
 * @param nb_elements the number of elements of the array
 * @param size the size of one cell
 * @param compare a function that compares two elements
 * @return the pointer of the element ?
 */
void * binary_search(void * key, void * arr, int nb_elements, int size, int (* compare) (const void *, const void *)) {
  char *p = (char *) arr;
  void * milieu;
  milieu = p + (nb_elements/2) * size;
  if (nb_elements == 0)
    return NULL;
  else if (nb_elements == 1)
    if(compare(key, milieu) == 0) {
      return arr;
    } else {
      return NULL;
    }
  else {
    switch (compare(key, milieu)) {
      case 0:
        return milieu;
      case -1:
        return binary_search(key, arr, (nb_elements/2)-1, size, compare);
      case 1:
        return binary_search(key, ((char *) milieu) + size, nb_elements - (nb_elements/2)-1, compare);
    }
  }
}

/**
 * Tests the swap_int function
 */
void swap_int_test() {
  int arr1[5] = {1,2,3,4,5};
  int arr2[5] = {6,7,8,9,10};
  swap_int(arr1, arr2, 5);
  print_array(arr1, 5);
  print_array(arr2, 5);
  swap_int2(arr1, arr2, 5);
  print_array(arr1, 5);
  print_array(arr2, 5);
}

/**
 * Tests the swap_arr function
 */
void swap_arr_test() {
  int arr1[5] = {1,2,3,4,5};
  int arr2[5] = {6,7,8,9,10};
  swap_arr(arr1, arr2, 5, sizeof(int));
  print_array(arr1, 5);
  print_array(arr2, 5);
}

int main (void) {
  swap_int_test();
  swap_arr_test();
}
