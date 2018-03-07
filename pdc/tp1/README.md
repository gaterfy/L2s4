# LOMBART Thomas - VASILEV Martin - L2S4 - Gr. 5

## Exercice 4.

**Question 1.**
Le fichier premierprogramme.c comporte 17 lignes, le fichier premierprogramme.i comporte 397 lignes<

**Question 2.**
La directive au préprocesseur `#include <stdio.h>` est remplacée par le contenu du fichier `<stdio.h>`.

**Question 3.**
Les commentaires ont été supprimés.

**Question 4.**
Ce traitement a été réalisé sur la ligne du code source:
```
variable_de_classe_externe = 2 ;
```
La variable VAL a été remplacé par 2 dans tout le code source.

## Exercice 6.

**Question 1.**
`.rodata` correspond à read-only data, ce qui signifie qu'il contient des constantes statiques au lieu de variables, `.text` correspond au code.

**Question 2.**
L'identificateur exporté globale de ce code est `main`, `variable_de_classe_externe`, `je_ne_suis_pas_defini`.

## Exercice 7.

L'étiquette dans le code source correspondant est main.

## Exercice 8.

**Question 1.**
Ce fichier commence par les lettres ELF.

**Question 2.**
Les chaînes de caractères discernables dans ce code octal sont les chaînes de caractères.

**Question 3.**

*Instructions assembleurs:*

```
   0:	55                   	push   %rbp
   1:	48 89 e5             	mov    %rsp,%rbp
   4:	c7 45 fc 03 00 00 00 	movl   $0x3,-0x4(%rbp)
   b:	c7 05 00 00 00 00 02 	movl   $0x2,0x0(%rip)        # 15 <main+0x15>
  12:	00 00 00
  15:	8b 05 00 00 00 00    	mov    0x0(%rip),%eax        # 1b <main+0x1b>
  1b:	01 45 fc             	add    %eax,-0x4(%rbp)
  1e:	8b 05 00 00 00 00    	mov    0x0(%rip),%eax        # 24 <main+0x24>
  24:	8b 55 fc             	mov    -0x4(%rbp),%edx
  27:	29 c2                	sub    %eax,%edx
  29:	89 d0                	mov    %edx,%eax
  2b:	5d                   	pop    %rbp
  2c:	c3                   	retq
```

*Différents segments:*

```
premierprogramme.o:     format de fichier elf64-x86-64

Contenu de la section .text :
 0000 554889e5 c745fc03 000000c7 05000000  UH...E..........
 0010 00020000 008b0500 00000001 45fc8b05  ............E...
 0020 00000000 8b55fc29 c289d05d c3        .....U.)...].   
Contenu de la section .comment :
 0000 00474343 3a202855 62756e74 7520352e  .GCC: (Ubuntu 5.
 0010 342e302d 36756275 6e747531 7e31362e  4.0-6ubuntu1~16.
 0020 30342e34 2920352e 342e3020 32303136  04.4) 5.4.0 2016
 0030 30363039 00                          0609.           
Contenu de la section .eh_frame :
 0000 14000000 00000000 017a5200 01781001  .........zR..x..
 0010 1b0c0708 90010000 1c000000 1c000000  ................
 0020 00000000 2d000000 00410e10 8602430d  ....-....A....C.
 0030 06680c07 08000000                    .h......
```

## Exercice 9.
```
premierprogramme.o:     format de fichier elf64-x86-64

SYMBOL TABLE:
0000000000000000 l    df *ABS*	0000000000000000 premierprogramme.c
0000000000000000 l    d  .text	0000000000000000 .text
0000000000000000 l    d  .data	0000000000000000 .data
0000000000000000 l    d  .bss	0000000000000000 .bss
0000000000000000 l    d  .note.GNU-stack	0000000000000000 .note.GNU-stack
0000000000000000 l    d  .eh_frame	0000000000000000 .eh_frame
0000000000000000 l    d  .comment	0000000000000000 .comment
0000000000000004       O *COM*	0000000000000004 variable_de_classe_externe
0000000000000000 g     F .text	000000000000002d main
0000000000000000         *UND*	0000000000000000 je_ne_suis_pas_defini
```

`je_ne_suis_pas_defini` est dans la table des symboles mais n'est pas défini.
