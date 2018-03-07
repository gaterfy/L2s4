# -*- coding: utf-8 -*-

"""
:mod:`sorting` module : sorting functions module for quicksort assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2017, january
"""

import copy
import random

def merge (t1,t2, cmp):
    """
    Given two sorted list, creates a fresh sorted list.

    :param t1: A list of objects
    :type t1: list
    :param t2: A list of objects
    :type t1: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A fresh list, sorted.
    :rtype: list

    .. note::

       time complexity of merge is :math:`O(n_1+n_2)` with
       :math:`n_1` and :math:`n_2` resp. the length of *t1* and *t2*

    """
    n1 = len(t1)
    n2 = len(t2)
    t = [ 0 for i in range(0,n1+n2)]
    i = j = k = 0
    while i < n1 and j < n2:
        if cmp(t1[i],t2[j]) < 0:
            t[k] = t1[i]
            i = i + 1
        else:
            t[k] = t2[j]
            j = j + 1
        k = k + 1
    while i < n1:
        t[k] = t1[i]
        i = i + 1
        k = k + 1
    while j < n2:
        t[k] = t2[j]
        j = j + 1
        k = k + 1
    return t


def merge_sort (t,cmp):
    """
    A sorting function implementing the merge sort algorithm

    :param t: A list of integers
    :type t: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A fresh list, sorted.
    :rtype: list
    """
    n = len(t)
    if n <= 1:
        # cas de base
        return copy.deepcopy(t)
    else:
        # cas general
        t1 = merge_sort((t[0:((n-1)//2+1)]),cmp)
        t2 = merge_sort((t[((n-1)//2+1):n]),cmp)
        return merge(t1,t2,cmp)


def random_pivot(s):
    """
    Returns a random index of the slice *s*

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of objects and left
              and right bounds of the slice.
    :type s: dict
    :return: a random index of the slice *s*
    :rtype: int
    """
    return random.randint(s['left'], s['right'])

def optimal_pivot(s):
    """
    Returns the index of the median element of the slice *s*

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of objects and left
              and right bounds of the slice.
    :type s: dict
    :return: the index of the median element of the slice *s*
    :rtype: int
    """
    l = s['data'][s['left']:s['right']+1]

    merge_sort(l,lambda x,y: 1 if x>y else (0 if x==y else -1))

    return s['left'] + len(l)//2

def quicksort (t, cmp, pivot):
    """
    A sorting function implementing the quicksort algorithm

    :param t: A list of integers
    :type t: list
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: Nothing

    .. note::
       *t* is modified during the sort process
    """
    quicksort_slice({'left':0,'right':len(t)-1,'data':t}, cmp, pivot)


def quicksort_slice (s, cmp, pivot):
    """
    A sorting function implementing the quicksort algorithm

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of ibjects and left
              and right bounds of the slice.
    :type s: dict
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: Nothing
    """
    if cmp(s['left'], s['right']) < 0:
        index_pivot = pivot(s)
        p1, p2 = partition(s, cmp, index_pivot)
        p2['left']+=1
        quicksort_slice(p1, cmp, pivot)
        quicksort_slice(p2, cmp, pivot)


def partition (s, cmp, index_pivot):
    """
    Creates two slices from *s* by selecting in the first slice all
    elements being less than the pivot and in the second one all other
    elements.

    :param s: A slice of a list, that is a dictionary with 3 fields :
              data, left, right representing resp. a list of objects and left
              and right bounds of the slice.
    :type s: dict
    :param cmp: A comparison function, returning 0 if a == b, -1 is a < b, 1 if a > b
    :type cmp: function
    :return: A couple of slices, the pivot being at the left index of the second slice.
    :rtype: tuple

    >>> import generate
    >>> def cmp (x,y):
    ...    if x == y:
    ...       return 0
    ...    elif x < y:
    ...       return -1
    ...    else:
    ...       return 1
    >>> l = generate.random_list(10)
    >>> pivot = l[0]
    >>> p1,p2 = partition({'left':0,'right':len(l)-1,'data':l},cmp,0)
    >>> l1 = p1['data'][p1['left']:p1['right']+1]
    >>> l2 = p2['data'][p2['left']:p2['right']+1]
    >>> len(l1 + l2) == len(l)
    True
    >>> l1_test = [0 for i in range(len(l1)) if l1[i] > pivot]
    >>> l2_test = [0 for i in range(len(l2)) if l2[i] < pivot]
    >>> ((l1_test == []) and l2_test == [])
    True
    """
    low = s['left']
    high = s['right']
    pivot = s['data'][index_pivot]
    continue_partition = True

    while continue_partition:
        while cmp(s['data'][low], pivot) < 0:
            low += 1
        while cmp(s['data'][high], pivot) > 0:
            high -= 1
        if cmp(low, high) < 0:
            s['data'][low], s['data'][high] = s['data'][high], s['data'][low]
        else:
            continue_partition = False

    left = {'data': s['data'], 'left': s['left'], 'right': high-1}
    right = {'data': s['data'], 'left': high, 'right': s['right']}

    return left, right

#Pour comparaisons_versions
n = 0
import generate

def comparaisons_versions():
    '''
    Fonction qui répond a la question 2.3.1.4, construit des listes dans le but de faire des comparaisons d'efficacité de tris

    :return: renvoie les listes comparées suivant le choix du pivot (premier élément, aléatoire ou médian)
    :rtype: list
    '''
    l1, l2, l3 = [], [], []
    global n

    def cmp(a,b):
        global n
        n += 1
        if a>b:
            return 1
        elif a==b:
            return 0
        else:
            return -1

    for i in range(100):
        lt = generate.random_list(i+1)
        n = 0
        quicksort(lt,cmp,pivot=lambda x:x['left'])
        l1.append(n)
        n = 0
        quicksort(lt,cmp,pivot=random_pivot)
        l2.append(n)
        n=0
        quicksort(lt,cmp,pivot=optimal_pivot)
        l3.append(n)

    return l1, l2, l3


def create_plot_file(l1,l2,l3):
    """
    Procedure qui repond a la question 2.3.2.4, cree le fichier avec lequel on peut
    tracer les courbes d\'evolution du nombre de comparaisons

    :param l1: La liste contenant le nombre de comparaisons pour des listes de longueur de 1 jusqu'a 100 avec la version 1 (premier element)
    :type l1: list
    :param l2: La liste contenant le nombre de comparaisons pour des listes de longueur de 1 jusqu'a 100 avec la versions 2 (le pivot aleatoire)
    :type l2: list
    :param l3: La liste contenant le nombre de comparaisons pour des listes de longueur de 1 jusuq'a 100 avec la verions 3 (pivot optimale)
    :type l3: list
    :effect: crée le plot file
    """
    stream = open("tp2.dat","w")

    for i in range(100):
        stream.write("{:d} {:d} {:d} {:d}\n".format(i+1,
                                              l1[i],
                                              l2[i],
                                              l3[i]))

if __name__ == "__main__":
    import doctest
    doctest.testmod()
