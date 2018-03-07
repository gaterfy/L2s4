/* each memory block has a header that contains metadata which is the size and whether the bloc is free or not
therefore, when we will make the call to sbrk we will have to take account of the size of the header */
struct header_t {
	size_t size;
	unsigned is_free;
  struct header_t *next;
};

struct header_t *get_free_block(size_t size);
void *my_own_malloc(size_t size);
void my_own_free(void *block);
