all: sortlines

fatal.o:
	gcc -c fatal.c

readl.o:
	gcc -c readl.c

quicksort_generic.o:
	gcc -c quicksort_generic.c

sortlines: readl.o fatal.o quicksort_generic.o
	gcc -o sortlines quicksort_generic.o readl.o fatal.o sortlines_qsort.c

clean:
	rm -rf *~ *.o sortlines
