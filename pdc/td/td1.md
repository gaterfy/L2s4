## Exercice 1

* `foo-1` : non valide
* `_foo_bar` : valide
* `3cavaliers` : non valide
* `foo.` : non valide, `.` est un opérateur
* `tête` : non valide, il ne faut pas d'accents
* `___A_` : valide
* `_` : valide
* `a` : valide
* `goto` : non valide : mot-clé

## Exercice 2

1. 67
2. L'expression est invalide : `A == (B = 5)`
3. `A = 34`
4. Non fait
5. `A = 0` (*Attention pour D++* : La valeur de `D` est retournée puis incrémentée!)
6. `A = 2`
8. `A = 5`
9. Non fait
10. Non fait
11. Impossible
12. Les deux nombres sont différents

## Exercice 3

On suppose faites les déclarations :
```c
long int A = 15;
char B = 'A';
short int C = 10;
```

* `B+1` : 66
* `B+A` : 80
* `B+C` : 75

**A retenir** :
- Un `int` est de la taille de la machine
- Un `char` = un octet

## Exercice 4

* `getchar()` lit un caractère sur stdin

```c
#include <stdio.h>
#include <stdlib.h>

int ouvertes = 0;
int c;
while ((c = getchar()) != EOF) {
  if (c == '(') {
    ouvertes++;
  }
  if (c == ')') {
    ouvertes--;
    if (ouvertes < 0) {
      printf("L'expression est mal parenthésée.\n");
      exit(EXIT_FAILURE);
    }
  }
}

if (ouvertes == 0) {
  printf("L'expression est bien parenthésée.");
  exit(EXIT_SUCCESS);
} else {
  printf("L'expression est mal parenthésée.");
  exit(EXIT_FAILURE);
}
```

## Exercice 5

```c
#include <stdio.h>

int sizeofInt() {
  unsigned int x = 1;
  int taille = 0;

  while (x != 0) {
    x = x << 1;
    taille++;
  }
  return taille;
}

int main (void) {
  printf("%d\n", sizeofInt());
}
```

## Exercice 6

```c
#include <stdio.h>
#include <ctype.h>

int readint() {
  int c;
  int res = 0;
  int chiffre;
  while ((c = getchar()) != EOF) {
    if (isdigit(c)) {
      int chiffre = c - '0';
      res = 10*res + chiffre;
    } else {
      return res;
    }
  }
  return res;
}

int main (void) {
  printf("%d\n", readint());
}
```

## Exercice 7

```c
#include <stdio.h>

int racine (int n) {
  int p = 0;
  while (p*p < n) {
    p++;
  }
  return p-1;
}

int main (void) {
  printf("%d\n", racine(10));
}
```
