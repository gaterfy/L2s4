OPTION=-ansi -pedantic -Wall

.PHONY: clean decompression.test

decompression: decompression.c amb.o amb.h
	gcc $(OPTION) -o decompression amb.o decompression.c -g

decompression.test: decompression
	./decompression < decompression.input > madecompression.output

clean:
	- rm decompression madecompression.output amb.o amb
