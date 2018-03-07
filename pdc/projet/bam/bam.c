#include <unistd.h>
#include <string.h>
#include <stdio.h>



#include "bam.h"

#define BLOC_END -1


/* We need to keep track of the list */
struct header_t *head = NULL;
struct header_t *tail = NULL;


struct header_t *get_free_block(size_t size)
{
  /* We place ourselves at the beginning of the list */
  struct header_t *curr = head;
  while (curr) {
    /* if the header of our block is free and has a size greater than the one requested, this is our free block */
    if (curr->is_free && curr->size >= size) {
      if (curr->size != size && curr->size-size>sizeof(struct header_t)) { /* If curr->size - size is big enough to fit a header */
	struct header_t *new = (struct header_t *)((char *)curr + sizeof(struct header_t) + size); /* We move the pointer to where we will write our new values */
	new->size = curr->size - size - sizeof(struct header_t); 
	new->next = curr->next;
	new->is_free = 1;
	curr->next = new; /* Link the new element onto the list */
	curr->is_free = 0;
      }
      /* otherwise if curr->size == size or not enough space to fit a header just give the whole piece of memory */
      return curr;
    }
    /* We keep on searching */
    curr = curr->next;
  }
  /* We haven't found any blocks */
  return NULL;
}


void *my_own_malloc(size_t size) {
  size_t total_size;
  void *block;
  struct header_t *header;
  // We handle the case where the user request 0 blocks
  if (!size)
    return NULL;
  header = get_free_block(size);
  // if one header has been found
  if (header) {
    // the block is no longer free
    header->is_free = 0;
    // We return header + 1 because it points to the byte right after the end of the header
    return (void *)(header+1);
  }
  // We haven't found a sufficient large free block, so we have to extend the heap with sbrk()
  struct header_t *leftover;
  total_size = 2*sizeof(struct header_t) + size + 4096;
  block = sbrk(total_size);
  if (block == (void *) BLOC_END)
    return NULL;
  header = block;
  header->size = size;
  header->is_free = 0;
  leftover = (struct header_t *)((char *)block+sizeof(struct header_t)+size);
  leftover->size = 4096;
  leftover->next = NULL;
  leftover->is_free = 1;
  header->next = leftover;
  // We update the state of our list
  if (!head)
    head = header;
  // if a tail already exists, append the header at the end of our linked list
  if (tail)
    tail->next = header;
  // otherwise, our header is the tail of the list
  tail = header;
  return (void*)(header + 1);
}


void my_own_free(void *block)
{
  struct header_t *header;
  // If nothing was given
  if (!block)
    return;
  /* we want the header of the block (because it contains metadata), so we cast the block
     to a header type be able to move back one block of size sizeof(struct header_t) */
  header = (struct header_t*)block - 1;

  // mark the block as free
  header->is_free = 1;
}
