all: mcu_wl mcu_wc mcu_ww mcu_uniq mcu_rev mcu_readl_test mcu_xxd

mcu_wl: mcu_wl.o mcu_affiche_entier.o
	gcc -o mcu_wl mcu_wl.o mcu_affiche_entier.o

mcu_wc: mcu_wc.o mcu_affiche_entier.o
	gcc -o mcu_wc mcu_wc.o mcu_affiche_entier.o

mcu_ww: mcu_ww.o mcu_affiche_entier.o
	gcc -o mcu_ww mcu_ww.o mcu_affiche_entier.o

mcu_uniq: mcu_uniq.o mcu_readl.o mcu_fatal.o
	gcc -o mcu_uniq mcu_uniq.o mcu_readl.o mcu_fatal.o

mcu_rev: mcu_rev.o mcu_readl.o mcu_fatal.o
	gcc -o mcu_rev mcu_rev.o mcu_readl.o mcu_fatal.o

mcu_readl_test: mcu_readl.o mcu_readl_test.o mcu_fatal.o
	gcc -o mcu_readl_test mcu_readl_test.o mcu_readl.o mcu_fatal.o

mcu_xxd: mcu_xxd.o
	gcc -o mcu_xxd mcu_xxd.o

clean:
	rm -f *.o mcu_wl mcu_wc mcu_ww mcu_uniq mcu_rev mcu_readl_test mcu_xxd
