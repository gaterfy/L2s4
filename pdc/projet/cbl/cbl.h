#define CBL_BLOCSIZE 32
#define NBLOCS 5

/**
 * Allocates a new block
 * @return the address of the block to use
 */
void *cbl_newbloc(void);

/**
 * Frees an allocated block
 * @param block the memory block's address to free
 * @return 1 if success, 0 otherwise
 */
int cbl_freebloc(void *);

/**
 * Initializes the membloc
 */
int cbl_init(void);
