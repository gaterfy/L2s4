all: cbl

cbl: cbl.c
	gcc -o cbl cbl.c

cbl_validate: cbl.o cbl_validate.c
	gcc -o cbl_validate cbl_validate.c cbl.o

clean:
	rm -f cbl cbl_validate *~ *.o *#
