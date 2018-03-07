#define ATF_BLOCSIZE 32
#define NBLOCS 2000

/**
 * Allocates a new block if possible
 * @return the address of a memory block if possible, NULL otherwise
 */
void *atf_newbloc();

/**
 * Frees an allocated block
 * @param block the memory block's address to free
 * @return 0 if success, 1 otherwise
 */
int atf_freebloc(void *bloc);

/**
 * Initializes the memstatus array by putting 0 in all cells
 */
int atf_init();
