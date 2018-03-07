    # -*- coding: utf-8 -*-

"""
:mod:`test` module : test module for experiences assignment

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2015, december
"""

import sys
import experience
import sorting

OP = 0

def compare (m1,m2):
    global OP
    OP += 1
    return experience.compare(m1,m2)


# STRATEGY 1
def negative_markers1(markers,positive, give_cmp = False):
    """
    Computes the list of negative markers from the list of markers and
    the list of positive markers.

    :param markers: The list of markers
    :type markers: List of String
    :param positive: The list of positive markers
    :type positive: List of String
    :param give_cmp: if set to true, return the number of comparisons and the negative markers
    :type give_cmp: bool
    :return: The list of negative markers
    :rtype: List of String
    """
    global OP
    OP = 0

    negative = []
    POS_LEN = len(positive)
    for marker in markers:
        i = 0
        while i<POS_LEN and not compare(positive[i],marker)==0 :
            i = i + 1
        if i==POS_LEN:
            negative.append(marker)

    if give_cmp:
        return OP,negative
    else:
        return negative


# STRATEGY 2
def negative_markers2(markers,positive, give_cmp = False):
    '''
    The second strategy that computes the list of negative markers

    :param markers: The list of all the markers
    :type markers: A experience.markers list
    :param positive: The list of the positive markers
    :type positive: A experience.experience list
    :param give_cmp: if set to true, return the number of comparisons and the negative markers
    :type give_cmp: bool
    :return: List of negative markers
    :rtype: list
    '''
    global OP
    OP = 0

    negative = []
    positive = sorting.merge_sort(positive, compare)

    for marker in markers:
        if dicho_search(marker, positive) == -1:
            negative.append(marker)

    if give_cmp:
        return OP,negative
    else:
        return negative


def dicho_search(e, l):
    '''
    Dichotomic search of the element e in the sorted list l

    :param e: the element to search
    :type e: int
    :param l: the list in which we search
    :type l: List
    :return: -1 if the element is not in the list and m otherwise
    :rtype: int
    '''
    a, b = 0, len(l)
    m = (a+b)//2

    while a<b and l[m]!=e:
        if compare(l[m],e) == -1:
            a, b = m+1, b
        else:
            a, b = a, m
        m = (a+b)//2

    if a>=b:
        return -1
    else:
        return m


# STRATEGY 3
def negative_markers3(markers,positive,give_cmp = False):
    '''
    Third strategy that computes the list of negative markers

    :param markers: The list of all the markers
    :type markers: A experience.markers list
    :param positive: The list of the positive markers
    :type positive: A experience.experience list
    :param give_cmp: if set to true, return the number of comparisons and the negative markers
    :type give_cmp: bool
    :return: List of negative markers
    :rtype: list
    '''
    global OP
    OP = 0

    negative = []
    markers = sorting.merge_sort(markers, compare)
    positive = sorting.merge_sort(positive, compare)
    
    i = 0
    for marker in positive:
        while compare(markers[i],marker)!=0:
            negative.append(markers[i])
            i += 1
        i += 1
    while i != len(markers):
        negative.append(markers[i])
        i += 1

    if give_cmp:
        return OP,negative
    else:
        return negative


def create_plot_file(n):
    '''
    Function that creates the plot file for a given number of markers

    :param n: The number of markers
    :type n: int
    :effect: creates a file containing plot info
    '''
    stream = open('tp1-{:d}.dat'.format(n),'w')

    for i in range(1,n+1):
        mar = experience.markers(n)
        pos = experience.experience(i,mar)

        stream.write('{:d} {:d} {:d} {:d} {:d}'.format(
        n,
        i,
        negative_markers1(mar,pos, give_cmp=True)[0],
        negative_markers2(mar,pos, give_cmp=True)[0],
        negative_markers3(mar,pos, give_cmp=True)[0]
        )
                     )
        stream.write('\n')

    stream.close()


if __name__ == "__main__":
    p = int(sys.argv[1])
    m = int(sys.argv[2])

    markers = experience.markers(m)
    positive = experience.experience(p,markers)

    print("Markers: %s" % (markers))
    print("Positive markers: %s" % (positive))

    # test stategy 1
    OP = 0
    print("Negative markers: %s" % (negative_markers1(markers,positive)))
    print("Nb. comparisons: %d" % (OP))

    # test stategy 2
    OP = 0
    print("Negative markers: %s" % (negative_markers2(markers,positive)))
    print("Nb. comparisons: %d" % (OP))

    # test stategy 3
    OP = 0
    print("Negative markers: %s" % (negative_markers3(markers,positive)))
    print("Nb. comparisons: %d" % (OP))
