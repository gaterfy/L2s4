# -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january
"""

import sorting
import generate
import copy

global cpt


def cmp(a,b):
    """
    A comparison function

    :param a: First element
    :param b: Second element
    :return: 0 if a == b, 1 if a > b, -1 if a < b
    :rtype: int

    >>> cmp(10,5)
    -1
    >>> cmp(5,5)
    0
    >>> cmp(5,10)
    1
    """
    global cpt
    cpt = cpt + 1
    if a == b:
        return 0
    elif a < b:
        return -1
    else:
        return 1

if __name__ == "__main__":
    cpt = 0
    t = generate.random_list(1000)
    tt = sorting.merge_sort(t,cmp)
    print (tt)
    if generate.is_sorted (tt):
        print("Yes !!")
    else:
        raise Exception("List has not been correctly sorted by merge sort")
    print(cpt)

    print (t)
    sorting.quicksort(t, cmp)
    print(cpt)
    if generate.is_sorted (t):
        print("Yes !!")
    else:
        raise Exception("List has not been correctly sorted by quicksort")
