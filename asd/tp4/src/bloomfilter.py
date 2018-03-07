# -*- coding: utf-8 -*-

""":mod:`bloomfilter` module : Implements a bloomfilter.

:author: `FIL - IEEA - Univ. Lille1.fr <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""

def create (n,f,m):
    """
    Creates a new empty Bloom filter of size :math:`2^n`

    :param n: the log of the size of the filter
    :type n: int
    :param f: the hash function whose should take as input two
              parameters: the value to be hashed and the number
              of the subfunction used
    :type f: function(any,int)
    :param m: the number of functions provided by *f*
    :return: the new Bloom filter
    :rtype: dict
    """
    return {'filter': [False for i in range(2**n)], 'hash': f, 'nb_hash_functions' : m ,'length': 2**n}

def add (bf, e):
    """
    Adds *e* to *bf*.

    :param bf: A Bloom filter
    :type bf: dict
    :param e: The element to be added
    :type e: Any
    """
    for i in range(bf['nb_hash_functions']):
        bf['filter'][bf['hash'](e, i)%bf['length']] = True

def contains (bf, e):
    """
    Returns True if *e* is in *bf*.

    :param bf: A Bloom filter
    :type bf: dict
    :param e: The element to be tested
    :type e: Any
    """
    return  all(bf['filter'][bf['hash'](e, i)%bf['length']] for i in range(bf['nb_hash_functions']))
