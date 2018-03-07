    # -*- coding: utf-8 -*-

import listiterator as list

def print_with_iterator (l):
    """
    Print elements of a list using an iterator.

    :param l: The list to be printed
    :type l: dict
    """
    it = list.get_listiterator(l)

    while list.hasNext(it):
        print(list.next(it)['value'], end=" ")

    print()

def print_with_iterator_reverse (l):
    """
    Print elements of a list using an iterator in reverse order.

    :param l: The list to be printed
    :type l: dict
    """
    it = list.get_listiterator(l,from_the_end=True)

    while list.hasPrevious(it):
        print(list.previous(it)['value'], end=" ")

    print()

def print_with_iterator_reverse_bis (l):
    """
    Print elements of a list using an iterator in reverse order.

    :param l: The list to be printed
    :type l: dict
    """
    pass

def ordering_insert (l, v):
    """
    Add *v* to list *l* such that *l* is kept ordered.

    :param l: An ordered list.
    :type l: dict
    :param v: The value to be inserted.
    :type v: same as elements of *l*
    """
    it = list.get_listiterator(l)

    while list.hasNext(it) and it['successor']['value'] < v:
        list.next(it)

    list.add(it, v)

if __name__ == "__main__":
    l = list.empty_list ()
    for i in reversed(range(1,5)):
        list.cons(l,i)

    list.print_list(l);

    # test 0 : impression renversee
    list.print_list(l,reverse=True)

    # test 1 : impression avec iterateurs
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 2 : insertion avant le 3eme element
    it = list.get_listiterator (l)
    print(list.next(it))
    print(list.next(it))
    list.add(it,23)
    assert(list.previous(it)["value"] == 23)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 3 : insertion apres le dernier element
    it = list.get_listiterator (l)
    while (list.hasNext(it)):
        list.next(it)
    list.add(it,45)
    assert(list.previous(it)['value'] == 45)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 4 : insertion avant le premier element
    it = list.get_listiterator (l)
    list.add(it,0)
    assert(list.previous(it)['value'] == 0)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 5 : insertion avant le dernier element avec l'iterateur placé en fin
    it = list.get_listiterator (l,True)
    list.previous(it)
    list.add(it,445)
    assert(list.previous(it)['value'] == 445)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 6 : affichage à l'envers avec l'itérateur placé en fin
    print_with_iterator_reverse_bis(l)

    # test 7 : ajout après le dernier élément
    it = list.get_listiterator (l,True)
    list.add(it,5)
    assert(list.previous(it)['value'] == 5)
    print_with_iterator(l)
    print_with_iterator_reverse(l)

    # test 8 : inserer trié, à vous d'écrire ce test
    l2 = list.empty_list ()
    for i in reversed([1,2,4,5]):
        list.cons(l2,i)
    ordering_insert(l2,3)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)
    ordering_insert(l2,6)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)
    ordering_insert(l2,0)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)


    # test 9 et 10 : suppression en tête et queue de liste
    it = list.get_listiterator(l2,True)
    # Suppression en queue
    list.remove(it)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)
    list.previous(it)
    list.remove(it)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)
    list.previous(it)
    list.previous(it)
    list.previous(it)
    # Suppression en tête
    list.remove(it)
    print_with_iterator(l2)
    print_with_iterator_reverse(l2)
    try:
        list.remove(it)
    except:
        print("L'exception est levée car il n'y a pas de prédecesseur")

    l = list.empty_list ()
    for i in reversed(range(1,6)):
        list.cons(l,i)
    it = list.get_listiterator(l)
    it2 = list.get_listiterator(l)
    list.next(it)
    list.next(it)
    list.next(it2)
    list.next(it2)
    list.remove(it)
    print_with_iterator(l)
    list.remove(it2)
    print_with_iterator(l)
