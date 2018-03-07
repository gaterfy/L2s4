**Question 1**
```java
int x = 4;
int y = 5;
int tmp;
tmp = x;
x = y;
y = tmp;
System.out.println(x);
System.out.println(y);
```

**Question 2**
```java
int res;
res = x > y ? x : y;
System.out.println(res);
```

**Question 3**
```java
int z = 2;
int max;
if (x > y && x > z) max = x;
else if (y > x && y > z) max = y;
else max = z;
System.out.println(max);
```

**Question 4**
```java
while (y != 0) {
  tmp2 = x;
  x = y;
  y = tmp2 % y;
}
System.out.println(y);
```

**Question 6**
```java
int[] tabn;
int n = 10;
tabn = new int[n];
for (int i = 0; i < tabn.length; i++) {
  tabn[i] = i+1;
}
```

**Question 7**
```java
int[][] matrice = {{1,2,3}, {4,5,6}, {7,8,9}};
int somme = 0;
for (int i = 0; i < matrice.length; i++) {
  somme += matrice[i][i];
}
System.out.println(somme);
```

**Question 8**
```java
int[] tab = {2,5,3,6,7,9,1,3};
int max = tab[0];
for (int i = 1; i < tab.length; i++) {
  if (tab[i] > max) {
    max = tab[i];
  }
}
System.out.println(max);
```

**Question 9**
```java
int min = tab[0];
int valeur = tab.length;
for (int i = 1; i < tab.length; i++) {
  if (tab[i] < min) {
    valeur = i;
  }
}
System.out.println(valeur);
```

**Question 10**
