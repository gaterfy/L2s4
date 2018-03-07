OPTION=-ansi -pedantic -Wall

.PHONY: clean jeu.test

jeu: jeu.c atf.o gestionpile.h gestionpile.o
	gcc $(OPTION) -o jeu atf.o gestionpile.o jeu.c

jeu.test: jeu
	./jeu dure doux

atf_validate: atf.o atf_validate.c
	gcc -o atf_validate atf_validate.c atf.o

clean:
	rm -f jeu atf_validate *.o
